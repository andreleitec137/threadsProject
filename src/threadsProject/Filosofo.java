package threadsProject;

public class Filosofo extends Thread {  
	private String nome;
	private Mesa umaMesa;
	private boolean pensando;
	private boolean test = true;
	
	public Filosofo(String n, Mesa c, boolean p) {  
		nome =n;
		umaMesa =c;
		pensando = p;
	}
	
	public void run(){
		
	while(test) {
		
		for (int i = 1; i <= 5; i++){  

			if(i >= 5) {
				i = 1;
			}
			
			try {
				
				if(i >= 3) {
					umaMesa.pensar(nome, true, i);
					sleep((int)(Math.random() *100));										
				}else {
					umaMesa.get(nome, i, false);
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