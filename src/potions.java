import java.io.*;

public class potions {
	public void buryItem(int item, int slot, int ID) {
		boolean used = true;
		client c = (client) server.playerHandler.players[ID];
		if (item != c.playerItems[slot] - 1){
			return;
		}

		if (c.playerHasItem(item)) {
			switch (item) {

			case 199: case 201: case 203: case 205: case 207: case 209: case 211: case 213: case 215:
			case 217: case 219: case 2485: case 3049: case 3051:
				c.herblore.identify(item);
				break;
				
        		
			default:
				used = false;
				break;
			}
		}
	}

}//closes potion hand