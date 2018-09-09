import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	private ServerSocket socket;
	private List<Socket> clientSockets;
	private boolean runServerOn=false;

	public Server(int portNumber) throws IOException {
		socket = new ServerSocket(portNumber);
		clientSockets = new ArrayList<Socket>();
	}

	public void ManageConnections() throws IOException {
		runServerOn = true;
		while (runServerOn) {
			Socket clientSocket = socket.accept();
			clientSockets.add(clientSocket);
			ClientThread client = new ClientThread(clientSocket);
			client.start();
		}
	}
	
	public void StopServer() throws IOException {
		runServerOn= false;
		socket.close();
	}

	public class ClientThread extends Thread {
		private PrintWriter out;
		private BufferedReader in;

		public ClientThread(Socket clientSocket) throws IOException {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}

		public void run() {
			try {
				while (true) {
					String message = in.readLine();
					System.out.println(message);
					for (Socket s : clientSockets) {
						out = new PrintWriter(s.getOutputStream(), true);
						out.println(message);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
