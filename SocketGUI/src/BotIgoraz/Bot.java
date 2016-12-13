package BotIgoraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Zemian.IMessageReceiver;
import Zemian.Server;

public class Bot extends Thread implements IMessageReceiver {
	ServerSocket ss;
	Socket socket;
	Server server;
	Main main;
	
	public Bot(Main main){
		this.main = main;
		server = new Server(this);
	}

	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receive(String from, String message) {
		// TODO Auto-generated method stub
		main.putList(from+": "+message);
		message.toLowerCase();
		switch(message){
		case "come ti chiami?":
			break;
		case "":
			break;
		}
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}
}
