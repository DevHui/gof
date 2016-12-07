package gof.ch2;

public class Client {

	public static void main(String[] args) {
		
		Api api = new Impl();
		
		api.test1("Test Client");
		
		api = Factory.createApi(1);
		api.operation("Test Client by Factory");
		
		Factory.createApi().operation("Test Client by Factory and properties");
	}

}
