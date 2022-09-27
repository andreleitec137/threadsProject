package threadsProject;

import java.util.ArrayList;

public class Mesa extends Thread { 
	private int garfoDireita;
	private int garfoEsquerda;
	private ArrayList<Integer> garfosEmUso = new ArrayList<Integer>();

	private boolean disponivel = false;
	
	public synchronized void  get(String cons, Integer garfo) {
		
		while (!disponivel && !garfosEmUso.contains(garfo)){
			try {
				wait();
				System.out.println(cons + " está pensando");
			} catch (InterruptedException e) {}
		}
		
		disponivel = false;				
		System.out.println(cons + " está comendo");
		
		try {
			sleep((int)(Math.random() *1000));
			System.out.println(cons + " liberou os garfos:  " + garfosEmUso);
			garfosEmUso.clear();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		notifyAll();
	}
	
	public synchronized void put(String prod, int garfo1, int garfo2) { 
		
		while (disponivel){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		garfoDireita = garfo1;
		this.garfosEmUso.add(garfoDireita);
		garfoEsquerda = garfo2;
		this.garfosEmUso.add(garfoEsquerda);
		
		disponivel = true; 
		
		notifyAll();
		}
}