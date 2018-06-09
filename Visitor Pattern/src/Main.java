
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guest ana = new Guest();
		Guest ricardo = new Guest();
		NightKeeper theActor = new NightKeeper();
		NightKeeper ceu = new NightKeeper();
		Elevator e1 = new Elevator();
		Elevator e2 = new Elevator();
		Kitchen k1 = new Kitchen();
		Room r1 = new Room();
		
		ana.Visit(e1);
		ricardo.Visit(e2);
		ricardo.Visit(k1);
		ana.Visit(r1);
		ceu.Visit(k1);
		theActor.Visit(r1);
		System.out.println("Mau");
		ricardo.Visit(r1);
		System.out.println("What a hell is going on here?");
		theActor.Sleep();
		theActor.LeaveRoom();
		theActor.Sleep();
	}

}
