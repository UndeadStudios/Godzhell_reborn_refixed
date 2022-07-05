class Mining {
	
	private boolean AreXItemsInBag(client c, int ItemID, int Amount) {
        int ItemCount = 0;
        for (int i = 0; i < c.playerItems.length; i++) {
            if ((c.playerItems[i] - 1) == ItemID) {
                ItemCount++;
            }
            if (ItemCount == Amount) {
                return true;
            }
        }
        return false;
    }
	
	public int GetPickAni(client c) {
		int PickAni = 0;
		int Pick = c.playerEquipment[c.playerWeapon];
		if (Pick == 1275) {
			PickAni = 624;
		} else if (Pick == 1265) {
			PickAni = 625;
		} else if (Pick == 1267) {
			PickAni = 626;
		} else if (Pick == 1269) {
			PickAni = 627;
		} else if (Pick == 1271) {
			PickAni = 628;
		} else if (Pick == 1273) {
			PickAni = 629;
		} else if (Pick == 1275) {
			PickAni = 624;
		} else if (Pick == 13661) {
			PickAni = 10222;
		}
		if (AreXItemsInBag(c, 1265, 1)) {
			PickAni = 625;
		} else if (AreXItemsInBag(c, 1267, 1)) {
			PickAni = 626;
		} else if (AreXItemsInBag(c, 1269, 1)) {
			PickAni = 627;
		} else if (AreXItemsInBag(c, 1271, 1)) {
			PickAni = 628;
		} else if (AreXItemsInBag(c, 1273, 1)) {
			PickAni = 629;
		} else if (AreXItemsInBag(c, 1275, 1)) {
			PickAni = 624;
		} else if (AreXItemsInBag(c, 13661, 1)) {
			PickAni = 10222;
		}
		
		return PickAni;
	}

	public int CheckPick(client c) {
		int Pick = c.playerEquipment[c.playerWeapon];
		if (Pick == 1265) {
			return 0;
		} else if (Pick == 1267) {
			return 1;
		} else if (Pick == 1269) {
			return 2;
		} else if (Pick == 1271) {
			return 3;
		} else if (Pick == 1273) {
			return 4;
		} else if (Pick == 1275) {
			return 5;
		} else if (Pick == 13661) {
			return 6;
		}
		if (AreXItemsInBag(c, 1265, 1)) {
			return 0;
		} else if (AreXItemsInBag(c, 1267, 1)) {
			return 1;
		} else if (AreXItemsInBag(c, 1269, 1)) {
			return 2;
		} else if (AreXItemsInBag(c, 1271, 1)) {
			return 3;
		} else if (AreXItemsInBag(c, 1273, 1)) {
			return 4;
		} else if (AreXItemsInBag(c, 1275, 1)) {
			return 5;
		} else if (AreXItemsInBag(c, 13661, 1)) {
			return 6;
		}
		return -1;
	}

	public void InitiateMI(client c, int rock, int x, int y) {
		int PickId = CheckPick(c);
		int Minus2Time = 0;
		c.RockId = rock;
		if (PickId == 1265) {
			Minus2Time = 0;
		} else if (PickId == 1267) {
			Minus2Time = 3;
		} else if (PickId == 1269) {
			Minus2Time = 6;
		} else if (PickId == 1271) {
			Minus2Time = 12;
		} else if (PickId == 1373) {
			Minus2Time = 18;
		} else if (PickId == 1375) {
			Minus2Time = 25;
		}
		if (rock == 2491) { //Rune Essence
			c.MineTimer = 4 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 40;
			c.OreId = 1436;
			c.MinedId = 450;
			c.Gone2for = 5 + misc.random(5);
		} else if (rock == 2108 || rock == 2109) { //Clay
			c.MineTimer = 8 + misc.random(4);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 50;
			c.OreId = 434;
			c.MinedId = 450;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 2090 || rock == 2091) { //Copper
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 93;
			c.OreId = 436;
			c.MinedId = 450;
			c.Gone2for = 10 + misc.random(10);
					} else if (rock == 31080) { //Copper
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 93;
			c.OreId = 436;
			c.MinedId = 31059;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 31081) { //Copper
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 93;
			c.OreId = 436;
			c.MinedId = 31060;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 31082) { //Copper
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 93;
			c.OreId = 436;
			c.MinedId = 31061;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 2094 || rock == 2095) { //Tin
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 90;
			c.OreId = 438;
			c.MinedId = 450;
			c.Gone2for = 10 + misc.random(10);
					} else if (rock == 31077) { //Tin
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 90;
			c.OreId = 438;
			c.MinedId = 31059;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 31078) { //Tin
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 90;
			c.OreId = 438;
			c.MinedId = 31060;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 31079) { //Tin
			c.MineTimer = 8 + misc.random(6);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 90;
			c.OreId = 438;
			c.MinedId = 31061;
			c.Gone2for = 10 + misc.random(10);
		} else if (rock == 10583 || rock == 10584 || rock == 2210) { //Blurite
			c.MineTimer = 20 + misc.random(15);
			c.RockLevel = 10;
			c.HowManyOre = 1;
			c.RockXp = 120;
			c.OreId = 668;
			c.MinedId = 450;
			c.Gone2for = 30 + misc.random(50);
		} else if (rock == 4027) { //Limestone
			c.MineTimer = 30 + misc.random(30);
			c.RockLevel = 1;
			c.HowManyOre = 1;
			c.RockXp = 50;
			c.OreId = 3211;
			c.MinedId = 450;
			c.Gone2for = 30 + misc.random(70);
		} else if (rock == 2098 || rock == 2099) { //Gold
			c.MineTimer = 40 + misc.random(30);
			c.RockLevel = 40;
			c.HowManyOre = 1;
			c.RockXp = 600;
			c.OreId = 444;
			c.MinedId = 450;
			c.Gone2for = 30 + misc.random(30);
		} else if (rock == 2100 || rock == 2101) { //Silver
			c.MineTimer = 30 + misc.random(20);
			c.RockLevel = 20;
			c.HowManyOre = 1;
			c.RockXp = 400;
			c.OreId = 442;
			c.MinedId = 450;
			c.Gone2for = 20 + misc.random(20);
		} else if (rock == 14856 || rock == 2092 || rock == 14858 || rock == 2093) { //Iron
			c.MineTimer = 16 + misc.random(30);
			c.RockLevel = 15;
			c.HowManyOre = 1;
			c.RockXp = 350;
			c.OreId = 440;
			c.MinedId = 450;
			c.Gone2for = 10 + misc.random(30);
					} else if (rock == 31071) { //Iron
			c.MineTimer = 16 + misc.random(30);
			c.RockLevel = 15;
			c.HowManyOre = 1;
			c.RockXp = 350;
			c.OreId = 440;
			c.MinedId = 31059;
			c.Gone2for = 10 + misc.random(30);
		} else if (rock == 31072) { //Iron
			c.MineTimer = 16 + misc.random(30);
			c.RockLevel = 15;
			c.HowManyOre = 1;
			c.RockXp = 350;
			c.OreId = 440;
			c.MinedId = 31060;
			c.Gone2for = 10 + misc.random(30);
		} else if (rock == 31073) { //Iron
			c.MineTimer = 16 + misc.random(30);
			c.RockLevel = 15;
			c.HowManyOre = 1;
			c.RockXp = 350;
			c.OreId = 440;
			c.MinedId = 31061;
			c.Gone2for = 10 + misc.random(30);
		} else if (rock == 14850 || rock == 2096 || rock == 14851 || rock == 2097) { //Coal
			c.MineTimer = 20 + misc.random(30);
			c.RockLevel = 30;
			c.HowManyOre = 1;
			c.RockXp = 856;
			c.OreId = 453;
			c.MinedId = 450;
			c.Gone2for = 40 + misc.random(30);
					} else if (rock == 31068) { //Coal
			c.MineTimer = 20 + misc.random(30);
			c.RockLevel = 30;
			c.HowManyOre = 1;
			c.RockXp = 856;
			c.OreId = 453;
			c.MinedId = 31059;
			c.Gone2for = 40 + misc.random(30);
		} else if (rock == 31069) { //Coal
			c.MineTimer = 20 + misc.random(30);
			c.RockLevel = 30;
			c.HowManyOre = 1;
			c.RockXp = 856;
			c.OreId = 453;
			c.MinedId = 31061;
			c.Gone2for = 40 + misc.random(30);
		} else if (rock == 31070) { //Coal
			c.MineTimer = 20 + misc.random(30);
			c.RockLevel = 30;
			c.HowManyOre = 1;
			c.RockXp = 856;
			c.OreId = 453;
			c.MinedId = 31061;
			c.Gone2for = 40 + misc.random(30);
		} else if (rock == 14854 || rock == 2102 || rock == 2103 || rock == 14853) { //Mithril
			c.MineTimer = 30 + misc.random(50);
			c.RockLevel = 55;
			c.HowManyOre = 1;
			c.RockXp = 1527;
			c.OreId = 447;
			c.MinedId = 450;
			c.Gone2for = 60 + misc.random(50);
					} else if (rock == 31086) { //Mithril
			c.MineTimer = 30 + misc.random(50);
			c.RockLevel = 55;
			c.HowManyOre = 1;
			c.RockXp = 1527;
			c.OreId = 447;
			c.MinedId = 31059;
			c.Gone2for = 60 + misc.random(50);
		} else if (rock == 31087) { //Mithril
			c.MineTimer = 30 + misc.random(50);
			c.RockLevel = 55;
			c.HowManyOre = 1;
			c.RockXp = 1527;
			c.OreId = 447;
			c.MinedId = 31060;
			c.Gone2for = 60 + misc.random(50);
		} else if (rock == 31088) { //Mithril
			c.MineTimer = 30 + misc.random(50);
			c.RockLevel = 55;
			c.HowManyOre = 1;
			c.RockXp = 1527;
			c.OreId = 447;
			c.MinedId = 31061;
			c.Gone2for = 60 + misc.random(50);
		} else if (rock == 14863 || rock == 2105 || rock == 2104 || rock == 14862) { //Addy
			c.MineTimer = 45 + misc.random(50);
			c.RockLevel = 70;
			c.HowManyOre = 1;
			c.RockXp = 4739;
			c.OreId = 449;
			c.MinedId = 450;
			c.Gone2for = 80 + misc.random(120);
					} else if (rock == 31083) { //Addy
			c.MineTimer = 45 + misc.random(50);
			c.RockLevel = 70;
			c.HowManyOre = 1;
			c.RockXp = 4739;
			c.OreId = 449;
			c.MinedId = 31059;
			c.Gone2for = 80 + misc.random(120);
		} else if (rock == 31084) { //Addy
			c.MineTimer = 45 + misc.random(50);
			c.RockLevel = 70;
			c.HowManyOre = 1;
			c.RockXp = 4739;
			c.OreId = 449;
			c.MinedId = 31060;
			c.Gone2for = 80 + misc.random(120);
		} else if (rock == 31085) { //Addy
			c.MineTimer = 45 + misc.random(50);
			c.RockLevel = 70;
			c.HowManyOre = 1;
			c.RockXp = 4739;
			c.OreId = 449;
			c.MinedId = 31061;
			c.Gone2for = 80 + misc.random(120);
		} else if (rock == 14860 || rock == 2106 || rock == 2107 || rock == 14859) { //Rune
			c.MineTimer = 70 + misc.random(70);
			c.RockLevel = 85;
			c.HowManyOre = 1;
			c.RockXp = 8318;
			c.OreId = 451;
			c.MinedId = 450;
			c.Gone2for = 2500;
		} else if (rock == 450 || rock == 451 || rock == 452 || rock == 453) { //Empty
			resetMI(c);
			return;
		} else {
			resetMI(c);
			return;
		}
		if (c.freeSlots() == 0) {
			c.sM("You do not have enough inventory space to hold anymore ore!");
			resetMI(c);
			return;
		}
		if (PickId != -1) {
			if (c.getLevelForXP(c.playerXP[14]) < c.RockLevel) {
				c.sM("You are not a high enough level.");
				c.sM("You must atleast get a level of " + c.RockLevel + " to mine this rock.");
				c.txt1("You must atleast get a level of " + c.RockLevel + " to mine this rock.");
				resetMI(c);
				return;
			}
			if (!c.Mining) {
				c.sM("You start to mine the rock.");
			}
			c.RockX = x;
			c.RockY = y;
			c.MineTimer -= (c.playerLevel[14] / 3) + Minus2Time;
			c.Mining = true;
		} else {
			resetMI(c);
			c.sM("You need a pickaxe to mine this rock!");
		}
	}

	public void resetMI(client c) {
		c.Mining = false;
		c.soundTimer = 0;
		c.MineTimer = 0;
		c.RockLevel = 0;
		c.RockId = 0;
		c.RockXp = 0;
		c.OreId = 0;
		c.MinedId = 0;
		c.Gone2for = 0;
		c.HowManyOre = 0;
		c.RockX = 0;
		c.RockY = 0;
		c.repeat2ani = 0;
		c.resetAnimation();
	}

	public void MIprocess(client c) {
		if (c.MineTimer > 0) {
			c.MineTimer--;
		}
		if (c.MineTimer < 0) {
			c.MineTimer = 1;
		}
		if (c.soundTimer > 0) {
			c.soundTimer--;
		} else {
			c.soundTimer = 1;
			c.frame174(432, 025, 000);
		}
		if (c.repeat2ani > 0) {
			c.repeat2ani--;
		} else {
			c.startAnimation(GetPickAni(c));
			c.updateRequired = true;
			c.appearanceUpdateRequired = true;
			c.repeat2ani = 3;
		}
		if (c.MineTimer == 0) {
			if (!Removeore(c)) {
				resetMI(c);
				return;
			} else {
				InitiateMI(c, c.RockId, c.RockX, c.RockY);
			}
		}
	}

	public void SpawnRocks(client c) {
		for (int i = 0; i < server.Rocks; i++) {
			if (server.ROCKSPAWN[i] > 0) {
				c.AddGlobalObj(server.ROCKX[i], server.ROCKY[i],
						server.ROCKSTUMP[i], server.ROCKFACE[i], 10);
			}
		}
	}

	public boolean HasOre(client c) {
		for (int i = 0; i < server.Rocks; i++) {
			if (server.ROCKX[i] == c.RockX && server.ROCKY[i] == c.RockY) {
				if (server.ROCKSPAWN[i] > 0) {
					return false;
				} else if (server.ROCKSPAWN[i] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean Removeore(client c) {
		boolean New = true;
		int Rockid = server.Rocks;
		for (int i = 0; i < server.Rocks; i++) {
			if (server.ROCKX[i] == c.RockX && server.ROCKY[i] == c.RockY && server.ROCKFACE[i] == c.RockFace) {
				if (!HasOre(c)) {
					resetMI(c);
					return false;
				}
				New = false;
				server.ORELEFT[i]--;
				c.addSkillXP(c.RockXp, 14);
				c.addItem(c.OreId, 1);
				if (misc.random(50) == 37) {
					c.addItem(c.gems[misc.random(8)], 1);
					c.sM("You find a gem in this rock.");
				}
				c.sM("You get some " + c.GetItemName(c.OreId) + ".");
				if (server.ORELEFT[i] <= 0) {
					server.ROCKSPAWN[i] = c.Gone2for;
					server.ORE[i] = c.HowManyOre;
					if (server.ORE[i] == 0) {
						server.ORE[i] = 1;
					}
					c.AddGlobalObj(c.RockX, c.RockY, c.MinedId, c.RockFace, 10);
					return false;
				}
				return true;
			}
		}
		if (New) {
			server.ROCKX[Rockid] = c.RockX;
			server.ROCKY[Rockid] = c.RockY;
			server.ROCKFACE[Rockid] = c.RockFace;
			server.ROCKID[Rockid] = c.RockId;
			server.ROCKSTUMP[Rockid] = c.MinedId;
			server.ORELEFT[Rockid] = c.HowManyOre;
			if (server.ORELEFT[Rockid] == 0) {
				server.ORELEFT[Rockid] = 1;
			}
			server.Rocks++;
			return true;
		}
		return false;
	}
}