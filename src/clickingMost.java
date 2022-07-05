public class clickingMost { 
	
public void clicking(int a){
client c = (client) server.playerHandler.players[a];
		switch(c.actionButtonId) {

		case 58074:
			c.getBankPin().close();
			break;

		case 58025:
		case 58026:
		case 58027:
		case 58028:
		case 58029:
		case 58030:
		case 58031:
		case 58032:
		case 58033:
		case 58034:
			c.getBankPin().pinEnter(c.actionButtonId);
			break;
			
		case 28170:
			c.customCommand("StaffList");
			break;
/*			
		case 33206:
			Prestige.prestigeSkill(c, 0);
			break;
		case 33209:
			Prestige.prestigeSkill(c, 1);
			break;
		case 33212:
			Prestige.prestigeSkill(c, 2);
			break;
		case 33207:
			Prestige.prestigeSkill(c, 3);
			break;
		case 33215:
			Prestige.prestigeSkill(c, 4);
			break;
		case 33218:
			Prestige.prestigeSkill(c, 5);
			break;
		case 33221:
			Prestige.prestigeSkill(c, 6);
			break;
		case 33217:
			Prestige.prestigeSkill(c, 7);
			break;
		case 33223:
			Prestige.prestigeSkill(c, 8);
			break;
		case 33222:
			Prestige.prestigeSkill(c, 9);
			break;
		case 33214:
			Prestige.prestigeSkill(c, 10);
			break;
		case 33220:
			Prestige.prestigeSkill(c, 11);
			break;
		case 33219:
			Prestige.prestigeSkill(c, 12);
			break;
		case 33211:
			Prestige.prestigeSkill(c, 13);
			break;
		case 33208:
			Prestige.prestigeSkill(c, 14);
			break;
		case 34157:
			Prestige.prestigeSkill(c, 15);
			break;
		case 33210:
			Prestige.prestigeSkill(c, 16);
			break;
		case 33216:
			Prestige.prestigeSkill(c, 17);
			break;
		case 47130:
			Prestige.prestigeSkill(c, 18);
			break;
		case 54104:
			Prestige.prestigeSkill(c, 19);
			break;
		case 33224:
			Prestige.prestigeSkill(c, 20);
			break;
		case 105244:
			Prestige.prestigeSkill(c, 21);
			break;
		case 105243:
			Prestige.prestigeSkill(c, 22);
			break;
		case 105245:
			Prestige.prestigeSkill(c, 23);
			break;
		case 105246:
			Prestige.prestigeSkill(c, 24);
			break;*/
			
		case 162:
			if(c.wearingCape(c.playerEquipment[c.playerCape])) {
			c.stopMovement();
			c.gfx100(c.skillcapeGfx(c.playerEquipment[c.playerCape]));
			c.startAnimation(c.skillcapeEmote(c.playerEquipment[c.playerCape]));
			} else {
			c.sendMessage("You must be wearing a Skillcape to do this emote.");
			}
			break;

}
}
}
