package Zemian;

public interface IMessageReceiver {
	void setHost(String host);
	void receive(String from, String message);
	void receive(String from, String name, String message);
	String getHost();
	
}
