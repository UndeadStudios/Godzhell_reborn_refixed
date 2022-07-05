public class RoomObject {

	private int x;
	private int y;
	private int z;
	private int id;
	private int rot;
	private int type;
	private int face;
	
	public RoomObject(int id, int x, int y, int z, int type, int face) {
		this.type = type;
		this.face = face;
		this.rot = type << 2 | face & 3;
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}

	public int getId() {
		return id;
	}

	public int getRot() {
		return rot;
	}
	
	public int getType() {
		return type;
	}
	
	public int getFace() {
		return face;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRot(int rot) {
		this.rot = rot;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setFace(int face) {
		this.face = face;
	}

	
	enum ObjectData {
		
		WHATEVER(15361, 13405, 10);
		
		private int buildId,
					realId,
					type;
		
		//Build obj id, Real obj id, obj type
		ObjectData(int buildId, int realId, int type) {
			this.buildId = buildId;
			this.realId = realId;
			this.type = type;
		}
		
		public int getBuildId() {
			return buildId;
		}
		
		public int getRealId() {
			return realId;
		}
		
		public int getType() {
			return type;
		}
		
		public static ObjectData get(int realId) {
			for (ObjectData d : ObjectData.values()) {
				if (d.getRealId() == realId) {
					return d;
				}
			}
			return null;
		}
		
	}
	
	public void createObject(Player player, int face) {
		if(player != null) {
			player.objectId = id;
			player.objRot = face;
			new Object(id, y, x, player.playerId*4, player.objRot, ObjectData.get(id).getRealId(), id, 0);
			/*object.id = id;
			object.x = player.objectX;
			object.y = player.objectY;
			player.getOutStream().createFrame(85);
			player.getOutStream().writeByteC(object.y - player.getMapRegionY() * 8);
			player.getOutStream().writeByteC(object.x - player.getMapRegionX() * 8);
			player.getOutStream().createFrame(101);
			player.getOutStream().writeByteC(object.rot);
			player.getOutStream().writeByte(0);
			player.getOutStream().createFrame(151);
			player.getOutStream().writeByteS(0);
			player.getOutStream().writeWordBigEndian(object.id);
			player.getOutStream().writeByteS(object.rot);
			player.flushOutStream();*/
			//player.getHouse().objects.add(this);
			//loadObjects(player);
		}	
	}
	
/*	public static void loadObjects(Player player) {
		//for(RoomObject object : player.getHouse().objects) {
			/*visiter.getOutStream().createFrame(85);
			visiter.getOutStream().writeByteC(object.y - visiter.getMapRegionY() * 8);
			visiter.getOutStream().writeByteC(object.x - visiter.getMapRegionX() * 8);
			visiter.getOutStream().createFrame(101);
			visiter.getOutStream().writeByteC(object.rot);
			visiter.getOutStream().writeByte(0);
			visiter.getOutStream().createFrame(151);
	
		visiter.getOutStream().writeByteS(0);
			visiter.getOutStream().writeWordBigEndian(object.id);
			visiter.getOutStream().writeByteS(object.rot);
			visiter.flushOutStream();
			new Object(object.getId(), object.getY(), object.getX(), player.playerId*4, player.objRot, ObjectData.get(object.id).getRealId(), object.getId(), 0);
			System.out.println(player.objRot);
		}*/
	}
