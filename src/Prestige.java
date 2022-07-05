
/**
 * @author Karma_K (http://www.rune-server.org/members/karma_k/)
 */

public class Prestige {

	public static boolean wearingItems(client c) {
		for (int j = 0; j < c.playerEquipment.length; j++) {
			if (c.playerEquipment[j] > 0) {
				c.sendMessage("Remove all equipment before prestiging.");
				return true;
			}
		}
		return false;
	}

	public static boolean checkArea(client c) {
		if (!c.nonWild()) {
			c.sendMessage("You can't do this in the area you're standing in.");
			return true;
		}
		return false;
	}

	public static void prestigeSkill(client c, int skillId) {
		if (checkArea(c)) {
			return;
		}
		if(wearingItems(c)) {
			return;
		}
		if (c.playerLevel[skillId] == 99) {
			c.playerXP[skillId] = c.getXPForLevel(1)+5;
			c.playerLevel[skillId] = c.getLevelForXP(c.playerXP[skillId]);
			c.refreshSkill(skillId);
			c.addItem(995, 1000000);
			c.sendMessage("You received 1m!");
			c.sendMessage("You've successfully prestiged !");
			c.RemoveAllWindows();
		} else {
			c.sendMessage("You need to be 99  to prestige.");
		}
	}
}