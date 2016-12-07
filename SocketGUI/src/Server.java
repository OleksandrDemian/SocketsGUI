import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	
	ServerSocket ss;
	Socket s;
	Main main;
	
	public Server(Main main){
		this.main = main;
		start();
	}
	
	public void run(){
		try {
			if(ss == null)
				ss = new ServerSocket(9080);	
			s = ss.accept();
		} catch (Exception e) {
			System.out.println("Exception in Server.run()");
		}
		while (true) {
			InputStreamReader isr;
			try {
				isr = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				String message = in.readLine();
				System.out.println("Il server riceve:" + message);
				main.addFromServer(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean isAvailable(int port){
		try {
			ServerSocket check = new ServerSocket(port);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
}
