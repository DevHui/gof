package gof.ch3;


public class Client {

	public static void main(String[] args) {
		
		new Presentation().generate();
		new Business().generate();
		new DAO().generate();
		
		new Facade().generate();
		
	}
}
