package gof.ch3;

public class Facade {
	
	public void generate(){
		
		new Presentation().generate();
		
		new Business().generate();
		
		new DAO().generate();
	}

}
