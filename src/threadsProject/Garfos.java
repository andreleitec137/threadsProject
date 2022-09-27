package threadsProject;

public class Garfos extends Thread{
	private String nome;
	private Mesa umaMesa;
	
	public Garfos(String n, Mesa c) {  
		nome =n;
		umaMesa =c;
	}
	
	public void run() {
		for (int i = 1; i <= 5; i++) {  
			umaMesa.put(nome, i, i+1);  
			
			if(i == 5) {
				i = 1;
			}
			
			try{
				sleep((int)(Math.random() *1000));
			} catch (InterruptedException e) {}
		}
	}
}

