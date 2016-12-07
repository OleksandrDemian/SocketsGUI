import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket s;
	
	public void Client(){
		try {
			s = new Socket("localhost", 9080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrefix(String prefix){
		try {
			s = new Socket(prefix, 9080);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void invia(String name, String message) {
		PrintWriter out;
		try {
			InetAddress ip = InetAddress.getLocalHost();
			String hostname = ip.getHostName();
			out = new PrintWriter(s.getOutputStream(), true);
			out.println(hostname + ": " + message);
		} catch (IOException e) {
			System.out.println("IOException in Client");
			return;
		}
	}
}
