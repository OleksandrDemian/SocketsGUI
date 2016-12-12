package Zemian;

public interface IMessageReceiver {
	void setHost(String host);
	void receive(String from, String message);
	String getHost();
}
