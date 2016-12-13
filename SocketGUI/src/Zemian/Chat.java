package Zemian;

import java.util.ArrayList;

public class Chat implements IMessageReceiver {
	private Client client;
	private String host;
	private ArrayList<String> messages = new ArrayList<String>();
	private boolean isActive;
	
	public Chat(String host){
		this.host = host;
		client = new Client();
		client.setPrefix(host);
	}
	
	public Chat(Client client){
		this.client = client;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public void receive(String from, String name, String message) {
		System.out.println("Chat con " + host + " receive -> " + message);
		String temp = name + ": " + message;
		messages.add(temp);
	}

}
