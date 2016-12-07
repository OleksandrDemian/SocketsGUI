import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket s;
	
	public void Client(){
		try {
			s = new Socket("localhost", 9080);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setPrefix(String prefix){
		try {
			s = new Socket("Lab06_" + prefix, 9080);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void invia(String name, String message) {
		// Mi connetto al server
		PrintWriter out;
		try {
			out = new PrintWriter(s.getOutputStream(), true);
			out.println(name + ": " + message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
