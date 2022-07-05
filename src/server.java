
import java.net.*;
import java.io.*;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import clip.region.ObjectDef;
import clip.region.Region;

public class server implements Runnable {

	public static final TaskScheduler scheduler = new TaskScheduler();

	public static TaskScheduler getTaskScheduler() {
		return scheduler;
	}

	public server() {
		// the current way of controlling the server at runtime and a great debugging/testing tool
		//jserv js = new jserv(this);
		//js.start();

	}
	// TODO: yet to figure out proper value for timing, but 500 seems good
    	BufferedReader reader;
    	BufferedWriter bw = null;
    	String connectingIP = null;
	public static final int cycleTime = 500;
	public static final String ObjectManager = null;
	/*Highscores*/
	/*For more highscores to be recorded, change the #s in [] to the number you want kept, +1*/
	/*For example, if you want the top 20, put 21 in the [] ([21])*/
	public static int[] ranks = new int[11];
	public static String[] rankPpl = new String[11];
	public static boolean updateServer = false;
	public static boolean loginServerConnected = true;
	public static boolean enforceClient = false;
	    	public static int Rocks = 0;
	    	public static DoorHandler doorHandler;
    public static int[] ROCKX = new int[9999];
    public static int[] ROCKY = new int[9999];
	 public static int[] ROCKFACE = new int[9999];
    public static int[] ROCKSPAWN = new int[9999];
    public static int[] ORELEFT = new int[9999];
    public static int[] ORE = new int[9999];
    public static int[] ROCKID = new int[9999];
    public static int[] ROCKSTUMP = new int[9999];
	public static int updateSeconds = 180; //180 because it doesnt make the time jump at the start :P
	public static long startTime;
	private static int waitFails;

	public static void main(java.lang.String args[]) {
		EventManager.initialise();
		clientHandler = new server();
		(new Thread(clientHandler)).start();
		playerHandler = new PlayerHandler();
        ObjectDef.loadConfig();
        Region.load();	
        ConnectionList.getInstance();
		
                textHandler = new TextHandler();
           
		npcHandler = new NPCHandler();
		itemHandler = new ItemHandler();
		crafting = new crafting();
		//WalkingCheck.check();
		doorHandler = new DoorHandler();
		potions = new potions();
		objectManager = new ObjectManager();
		shopHandler = new ShopHandler();
		PickableObjects = new PickableObjects();
		clickingMost = new clickingMost();
                antilag = new antilag();
				Mining = new Mining();
                itemspawnpoints = new itemspawnpoints();
                GraphicsHandler = new GraphicsHandler();
                objectHandler = new ObjectHandler();
		GlobalDrops = new GlobalDrops();
		long lastTicks = System.currentTimeMillis();
		long totalTimeSpentProcessing = 0;
		int cycle = 0;
		try {
			NPCDefinition.init();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scheduler.schedule(new Task() {
			@Override
			protected void execute() {


			// could do game updating stuff in here...
			// maybe do all the major stuff here in a big loop and just do the packet
			// sending/receiving in the client subthreads. The actual packet forming code
			// will reside within here and all created packets are then relayed by the subthreads.
			// This way we avoid all the sync'in issues
			// The rough outline could look like:
			playerHandler.process();			// updates all player related stuff
			npcHandler.process();
			itemHandler.process();
			shopHandler.process();
			objectManager.process();
                        antilag.process();
			//GlobalDrops.process();
                        itemspawnpoints.process();
			objectHandler.process();
			objectHandler.firemaking_process();
                        System.gc();
			// doNpcs()		// all npc related stuff
			// doObjects()
			// doWhatever()
	

			}
		});
	}

	public Socket acceptSocketSafe(ServerSocket x) { // Anti-nuller by Slysoft
        boolean socketFound = false;
        Socket s = null;
        do {
            try {
                s = x.accept();
                connectingIP = s.getInetAddress().toString().replace("/", "");
                int i = s.getInputStream().read();
                if (((i & 0xFF) == 14) && !isIpBanned(connectingIP)) {
                    socketFound = true;
                }
            } catch (Exception e) {}
        } while (!socketFound);
        return s;
}
	public static server clientHandler = null;			// handles all the clients
	public static java.net.ServerSocket clientListener = null;
	public static java.net.ServerSocket clientListener2 = null;
	public static boolean shutdownServer = false;		// set this to true in order to shut down and kill the server
	public static boolean shutdownClientHandler;			// signals ClientHandler to shut down
	public static int serverlistenerPort = 29433; //29432=default
    	//public static int serverlistenerPort2 = 43594; // 5555=default

	public static PlayerHandler playerHandler = null;
public static Mining Mining = null;
public static potions potions = null;
public static clickingMost clickingMost = null;
	public static NPCHandler npcHandler = null;
	public static crafting crafting = null;
	public static PickableObjects PickableObjects = null;
        public static TextHandler textHandler = null;
	public static ItemHandler itemHandler = null;
	public static ObjectManager objectManager = null;
	public static ShopHandler shopHandler = null;
	public static GlobalDrops GlobalDrops = null;
        public static antilag antilag = null;
        public static itemspawnpoints itemspawnpoints = null;
        public static GraphicsHandler GraphicsHandler = null;
        public static ObjectHandler objectHandler = null;

	public static void calcTime() {
		long curTime = System.currentTimeMillis();
		updateSeconds = 180 - ((int)(curTime - startTime) / 1000);
		if(updateSeconds == 0) {
			shutdownServer = true;
		}
	}

	
	public static boolean playerInWorld(String name) {
		File file;
		file = new File("./Data/world/" + name + ".world");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException ioe) { }
			return false;
		}
		return true;
	}
	
	public static void resetWorlds() {
        if (!checkStatus(29433)) {
            File loc = new File("./Data/world/");
            if (loc.exists()) {
                try {
                    File files[] = loc.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        File load = files[i];
                        if (load.getName().endsWith(".world1")) {
                            load.delete();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!checkStatus(29434)) {
            File loc = new File("./data/world/");
            if (loc.exists()) {
                try {
                    File files[] = loc.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        File load = files[i];
                        if (load.getName().endsWith(".world2")) {
                            load.delete();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public static void deleteFromWorld(String name) {
		
		File file = new File("./Data/world/" + name + ".world");
		if(!file.exists()) return;
		
		boolean delete = file.delete();
		
		if(!delete)
			System.out.println("Failed to delete .world file: " + name);
	}

public static boolean checkStatus(int world) {
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(world);
        } catch (IOException e) {
            return true;
        } finally {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return false;
    }

	public void run() {

//new MessageTimer().start(); //will start the thread

		// setup the listener
		try {
			shutdownClientHandler = false;
			clientListener = new java.net.ServerSocket(serverlistenerPort, 1, null);
			//clientListener2 = new java.net.ServerSocket(serverlistenerPort2, 1, null);
		 misc.println("- Godzhell Reborn Old Online at port "+clientListener.getLocalPort());new CP().run();
		misc.println(" ..  Online!");
			while(true) {
               java.net.Socket s = acceptSocketSafe(clientListener);

                s.setTcpNoDelay(true);
                String connectingHost = s.getInetAddress().getHostName();

                if(true) {
                	if(!ConnectionList.getInstance().filter(s.getInetAddress()))	{
                		System.out.println("Conenction blocked");
                		s.close();
                		s = null;
                	} else {					
                		playerHandler.newPlayerClient(s, connectingHost);
                		ConnectionList.getInstance().addConnection(s.getInetAddress());
                	}
                } else {
                	misc.println("ClientHandler: Rejected "+connectingHost+":"+s.getPort());
                	s.close();
                }
			}

        } catch (java.io.IOException ioe) {
            if (!shutdownClientHandler) {
                misc.println(
                        "Error: Unable to startup listener on "
                                + serverlistenerPort + " - port already in use?");
            } else {
                misc.println("ClientHandler was shut down.");
            }
        }
    }
	public static void logError(String message) {
		misc.println(message);
	}
boolean isIpBanned(String ip) {
    String line = null;
    try {
        reader = new BufferedReader(new FileReader("data/bannedips.txt"));
        while ((line = reader.readLine()) != null) {
            if (line.equals(ip)) {
                System.out.println("Client rejected from "+ip);
                return true;
            }
        }
    } catch(Exception e){}
    return false;
}

public static void addUidToFile(String UUID) {
	try {
		BufferedWriter out = new BufferedWriter(new FileWriter("./Data/bans/UUIDBans.txt", true));
	    try {
			out.newLine();
			out.write(UUID);
	    } finally {
			out.close();
	    }
	} catch (IOException e) {
		e.printStackTrace();
	}
}


	public void killServer() {
		try {
			shutdownClientHandler = true;
			if(clientListener != null) clientListener.close();
			clientListener = null;
			EventManager.getSingleton().shutdown();
		} catch(java.lang.Exception __ex) {
			__ex.printStackTrace();
		}
	}

	public static int EnergyRegian = 0;

	public static int MaxConnections = 100000;
	public static String[] Connections = new String[MaxConnections];
	public static int[] ConnectionCount = new int[MaxConnections];
	public static boolean ShutDown = false;
	public static int ShutDownCounter = 0;



}
