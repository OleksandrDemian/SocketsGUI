package BotIgoraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Bot extends Thread{
	ServerSocket ss;
	Socket socket;
	Main main;
	
	public Bot(Main main){
		this.main = main;
	}
	
	public void run(){
		try {
			ss = new ServerSocket(9080);
			socket = ss.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){
			InputStreamReader iSr;
			try {
				iSr = new InputStreamReader(socket.getInputStream());
				BufferedReader in = new BufferedReader(iSr);
				String message = in.readLine();
				System.out.println("Il server riceve:" + message);
				String s[] = message.split(": ");
				main.putList(s[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
