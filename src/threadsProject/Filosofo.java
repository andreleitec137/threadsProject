package threadsProject;

public class Filosofo extends Thread {  
	private String nome;
	private Mesa umaMesa;
	private boolean test = true;
	
	public Filosofo(String n, Mesa c) {  
		nome =n;
		umaMesa =c;
	}
	
	public void run(){
		
	while(test) {
		
		for (int i = 1; i <= 5; i++){  

			if(i >= 5) {
				i = 1;
			}
			
			try {
				
				if(i >= 3) {
					umaMesa.pensar(nome, i);
					sleep((int)(Math.random() *100));										
				}else {
					umaMesa.get(nome, i);
					sleep((int)(Math.random() *100));
				}
			
			
				
		
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		}
	
	
	
	}
	}