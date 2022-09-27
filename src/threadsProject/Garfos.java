package threadsProject;

public class Garfos extends Thread{
	private Mesa umaMesa;
	
	public Garfos( Mesa c) {  
		umaMesa =c;
	}
	
	public void run() {
			
			
			try{
				umaMesa.put();  
			} catch (Exception e) {}
		
			
		
	}
}

