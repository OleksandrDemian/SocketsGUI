package Zemian;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket s;
	
	public Client(String host) {
		setPrefix(host);
	}

	public Client() {
		/*try {
			s = new Socket("localhost", 9080);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void setPrefix(String prefix){
		System.out.println("Client.setPrefix: Prefix: " + prefix);
		try {
			s = new Socket(prefix, 9080);
		} catch (UnknownHostException e) {
			System.out.println("Client.setPrefix: Host non risponde");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Client.setPrefix: IOException");
		}
	}
	
	public void invia(String name, String message) {
		if(s == null || !Utilities.isValid(message))
			return;
		PrintWriter out;
		try {
			InetAddress ip = InetAddress.getLocalHost();
			String hostname = ip.getHostName();
			out = new PrintWriter(s.getOutputStream(), true);
			out.println(hostname + ": "+ name + ": " + message);
		} catch (IOException e) {
			System.out.println("IOException in Client");
			return;
		}
	}
}
