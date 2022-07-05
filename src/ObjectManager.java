import java.util.ArrayList;

public class ObjectManager {

	public ArrayList<Object> objects = new ArrayList<Object>();
	private ArrayList<Object> toRemove = new ArrayList<Object>();

	public void process() {
		for (Object o : objects) {
			if (o.tick > 0)
				o.tick--;
			else {
				updateObject(o);
				toRemove.add(o);
			}
		}
	}

	public void removeObject(int x, int y) {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				client c = (client) PlayerHandler.players[j];
				c.makeGlobalObject(x, y, -1, 0, 10);
			}
		}
	}

	public void updateObject(Object o) {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				client c = (client) PlayerHandler.players[j];
				c.makeGlobalObject(o.objectX, o.objectY, o.newId, o.face, o.type);
			}
		}
	}

	public void placeObject(Object o) {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				client c = (client) PlayerHandler.players[j];
				if (c.distanceToPoint(o.objectX, o.objectY) <= 60)
					c.makeGlobalObject(o.objectX, o.objectY, o.objectId, o.face,
							o.type);
			}
		}
	}

	public Object getObject(int x, int y, int height) {
		for (Object o : objects) {
			if (o.objectX == x && o.objectY == y && o.height == height)
				return o;
		}
		return null;
	}

	public void loadObjects(client c) {
		if (c == null)
			return;
		for (Object o : objects) {
			if (loadForPlayer(o, c))
				c.makeGlobalObject(o.objectX, o.objectY, o.objectId, o.face,
						o.type);
		}
	}

	public final int IN_USE_ID = 14825;


	public boolean loadForPlayer(Object o, client c) {
		if (o == null || c == null)
			return false;
		return c.distanceToPoint(o.objectX, o.objectY) <= 60
				&& c.heightLevel == o.height;
	}

	public void addObject(Object o) {
		if (getObject(o.objectX, o.objectY, o.height) == null) {
			objects.add(o);
			placeObject(o);
		}
	}

}