import java.io.*;
import java.net.*;


public class Server {
	private ServerSocket socket;
	private PrintWriter out;
	private BufferedReader in;
	private Socket clientSocket;
	private boolean echoModeOn=false;
	
	public Server(int portNumber) throws IOException {
		socket = new ServerSocket(portNumber);
		clientSocket = socket.accept();
	    out =
	        new PrintWriter(clientSocket.getOutputStream(), true);
	    in = new BufferedReader(
	        new InputStreamReader(clientSocket.getInputStream()));
	}
	
	public void EchoMode() throws IOException {
		echoModeOn=true;
		String message;
		while(echoModeOn) {
			message = in.readLine();
			System.out.println("Received: " + message);
			out.println("echo:" + message);
		}
	}
}
