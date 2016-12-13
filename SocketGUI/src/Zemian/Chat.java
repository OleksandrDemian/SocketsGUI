package Zemian;

public class Chat implements IMessageReceiver {
	private Client client;
	private String host;
	
	public Chat(String host){
		this.host = host;
		client = new Client();
		client.setPrefix(host);
	}
	
	public Chat(Client client){
		this.client = client;
	}
	
	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receive(String from, String message) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		System.out.println(host);
		return host;
	}

	@Override
	public void receive(String from, String name, String message) {
		// TODO Auto-generated method stub
		
	}

}
