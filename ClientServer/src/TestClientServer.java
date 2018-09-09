import java.io.IOException;

public class TestClientServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		switch (args[0]) {
		case "client":
			try {
				Client client = new Client(args[1], Integer.parseInt(args[2]));
				client.SendMessageReceiveEcho();
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "server":
			try {
				Server server = new Server(Integer.parseInt(args[1]));
				server.ManageConnections();
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.printf("Invalid Mode:%s", args[0]);
			break;
		}
	}

}
