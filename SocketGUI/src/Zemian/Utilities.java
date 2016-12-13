package Zemian;

import java.io.IOException;
import java.net.Socket;

public class Utilities {
	public static boolean isValid(String message){
		if(message == "" || message == " ")
			return false;
		//altre eccezioni
		return true;
	}
	
	public static boolean isAvailable(String host){
		try {
			Socket s = new Socket(host, 9080);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
