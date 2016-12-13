package BotIgoraz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import Zemian.Client;
import Zemian.IMessageReceiver;
import Zemian.Server;

public class Bot extends Thread implements IMessageReceiver {
	ServerSocket ss;
	Socket socket;
	Server server;
	Main main;
	Client c;
	
	public Bot(Main main){
		this.main = main;
		server = new Server(this);
		c = new Client();
	}

	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receive(String from, String name, String message) {
		// TODO Auto-generated method stub
		main.putList(from+"."+name+": "+message);
		message = message.toLowerCase();
		c.setPrefix(from);
		switch(message){
		case "come ti chiami?":
			c.invia("ZaneaBot", "Sono ZaneaBot!");
			break;
		case "come mi chiamo?":
		case "chi sono io?":
			System.out.println("entrato");
			c.invia("ZaneaBot", "Ti chiami " + name);
			break;
		case "somma":
		case "fammi una somma":
			c.invia("ZaneaBot", "Non ancora");
			break;
		}
	}
}
