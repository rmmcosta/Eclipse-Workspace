
public class Guest implements IVisitor{

	@Override
	public void Visit(Elevator elevator) {
		// TODO Auto-generated method stub
		System.out.printf("hello I am the Guest %s visiting the Elevator %s\n",
				this.toString(),elevator.toString());
	}

	@Override
	public void Visit(Room room) {
		// TODO Auto-generated method stub
		System.out.printf("hello I am the Guest %s visiting the Room %s\n",
				this.toString(),room.toString());
	}

	@Override
	public void Visit(Kitchen kitchen) {
		System.out.println("Hello I am the Guest and I am not allowed to visit the Kitchen!\n");
		
	}

}
