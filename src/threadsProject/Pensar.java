package threadsProject;

public class Pensar extends Thread {  
	private String nome;
	private Mesa umaMesa;
	
	public Pensar(String n, Mesa c) {  
		nome =n;
		umaMesa =c;
	}
	
	public void run(){
		for (int i = 1; i <= 5; i++){  
			try {
				sleep((int)(Math.random() *1000));
				umaMesa.pensar(nome, true, i );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}