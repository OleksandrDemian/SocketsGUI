package Zemian;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {
	
	private ServerSocket ss;
	private Socket s;
	private IMessageReceiver receiver;
	private ArrayList<IMessageReceiver> receivers = new ArrayList<IMessageReceiver>();
	
	public Server(IMessageReceiver receiver){
		this.receiver = receiver;
		start();
	}
	
	public Server(){
		start();
	}
	
	public void run(){
		InputStreamReader isr;
		try {
			ss = new ServerSocket(9080);
			s = ss.accept();
		} catch (Exception e) {
			System.out.println("Exception in Server.run()");
		}
		
		while (true) {
			try {
				isr = new InputStreamReader(s.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				String message = in.readLine();
				String s[] = message.split(": ");
				receiver.receive(s[0], s[1], s[2]);
			} catch (IOException e) {
				System.out.println("Server.run: Connesione chiusa");
			}
		}
	}
	
	public void addReceiver(IMessageReceiver receiver){
		
	}
	
	public void stopServer(){
		try {
			//s.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Chiudo is server");
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
