import java.io.*;
import java.net.*;

public class Client {

	private Socket client;
	private PrintWriter out;
	private BufferedReader in, stdIn;
	
	public Client(String hostName, int portNumber) throws IOException{
		client = new Socket(hostName, portNumber);
	    out =
	        new PrintWriter(client.getOutputStream(), true);
	    in =
	        new BufferedReader(
	            new InputStreamReader(client.getInputStream()));
	    stdIn =
	        new BufferedReader(
	            new InputStreamReader(System.in));
	}
	
	public void SendMessageReceiveEcho() throws IOException {
		String userInput;
		while ((userInput = stdIn.readLine()) != null) {
		    out.println(userInput);
		    System.out.println(in.readLine());
		}
	}
	
	public void Send(String message) throws IOException {
		out.println(message);
	}
	
	public String ReadMode() throws IOException {
		return in.readLine();
	}
}
