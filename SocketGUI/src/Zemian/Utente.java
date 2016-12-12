package Zemian;

public class Utente {
	private String name = "Nameless";
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		if(Utilities.isValid(name))
			this.name = name;
		else
			this.name = "Nameless";
	}
}
