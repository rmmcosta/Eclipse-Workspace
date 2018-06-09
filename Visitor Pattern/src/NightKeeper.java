
public class NightKeeper implements IVisitor{
	Room currentRoom;
	Kitchen currentKitchen;
	@Override
	public void Visit(Elevator elevator) {
		System.out.printf("hello I am the NightKeeper %s visiting the Elevator %s\n",
				this.toString(),elevator.toString());
		
	}

	@Override
	public void Visit(Room room) {
		System.out.printf("hello I am the NightKeeper %s visiting the Room %s\n",
				this.toString(),room.toString());
		this.currentRoom = room;
		
	}

	@Override
	public void Visit(Kitchen kitchen) {
		System.out.printf("hello I am the NightKeeper %s visiting the Kitchen %s\n",
				this.toString(),kitchen.toString());
		
	}
	
	public void Sleep() {
		if(currentRoom != null) {
			System.out.printf("%s is Sleeping in the room %S\n", this, currentRoom);
		}
		else {
			System.out.printf("%s is not in a room...\n", this);
		}
	}
	
	public void LeaveRoom() {
		if(currentRoom != null) {
			System.out.printf("%s is leaving the room %s\n", this, currentRoom);
			currentRoom=null;
		}
		else {
			System.out.printf("%s is not in a room...\n", this);
		}
	}

}
