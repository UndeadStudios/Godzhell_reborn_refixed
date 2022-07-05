public enum Room {
	
	DEFAULT(1864, 5056, 0, 0),
	GARDEN(1859, 5066, 0, 0),
	THRONE(1904, 5096, 0, 0),
	GAME(1864, 5104, 0, 0),
	FLOOR2(1903, 5095, 0, 0),
	PARLOUR(1856, 5112, 0, 0),
	KITCHEN(1872, 5112, 0, 0),
	DINING(1890, 5112, 0, 0),
	WORKSHOP(1856, 5096, 0, 0),
	BEDROOM(1904, 5112, 0, 0),
	SKILLHALL(1880, 5104, 0, 0),
	COMBAT(1880, 5088, 0, 0),
	QUEST_HALL(1912, 5104, 0, 0),
	STUDY(1888, 5096, 0, 0),
	COSTUME_ROOM(1904, 5064, 0, 0),
	CHAPEL(1872, 5096, 0, 0),
	PORTAL_CHAMBER(1864, 5088, 0, 0),
	FORMAL_GARDEN(1872, 5064, 0, 0),
	THRONE_ROOM(1904, 5080, 0, 0),
	OUBILIETTE(1904, 5080, 0, 0),
	CORRIDOR_DUNGEON(1888, 5080, 0, 0),
	JUNCTION_DUNGEON(1856, 5080, 0, 0),
	STAIRS_DUNGEON(1872, 5080, 0, 0),
	TREASURE_ROOM(1912, 5088, 0, 0),
	;
	
	private int locationHash;
	
	private Room(int x, int y, int z, int rot) {
		this.locationHash = x / 8 << 14 | y / 8 << 3 | z % 4 << 24 | rot % 4 << 1;
	}
	
	public int getLocationHash() {
		return locationHash;
	}

}