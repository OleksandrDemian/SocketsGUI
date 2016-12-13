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
	private boolean single = false;
	
	public Server(IMessageReceiver receiver){
		this.receiver = receiver;
		single = true;
		start();
	}
	
	public Server(){
		single = false;
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
				if(single) {
					receiver.receive(s[0], s[1], s[2]);
				} else {
					for(int i = 0; i < receivers.size(); i++){
						if(receivers.get(i).getHost().equals(s[0]))
							receivers.get(i).receive(s[0], s[1], s[2]);
					}
				}
			} catch (IOException e) {
				System.out.println("Server.run: Connesione chiusa");
			}
		}
	}
	
	public void addReceiver(IMessageReceiver receiver){
		receivers.add(receiver);
		System.out.println("New receiver: " + receiver.getHost());
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
}
