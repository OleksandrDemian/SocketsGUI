package Zemian;

public interface IMessageReceiver {
	void receive(String from, String name, String message);
	String getHost();
}
