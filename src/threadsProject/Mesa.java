package threadsProject;

import java.util.ArrayList;

public class Mesa extends Thread { 
	private ArrayList<Integer> garfosEmUso = new ArrayList<Integer>();

	private boolean disponivel = false;
	private boolean pensar = true; 
	private int filosofosPassados = 0;
	private ArrayList<String> filosofosEmAcao = new ArrayList<>();
	
	public synchronized void  get(String cons, Integer garfo, boolean pensando) throws InterruptedException {
		while (!disponivel && !pensar){
			try {
				wait();				
			} catch (Exception e) {}
		}
		
		
		if(garfosEmUso.size() < 2) {
			disponivel = false;
			pensar = true;			
			sleep((int)(Math.random() *1000));
			notifyAll();
		}else {
			try {		
				if(!pensando && !filosofosEmAcao.contains(cons)) {
					System.out.println(cons + " está comendo" + garfosEmUso);
					filosofosEmAcao.add(cons);
					sleep((int)(Math.random() *1000));
					garfosEmUso.remove(0);
					garfosEmUso.remove(1);
				}
				notifyAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}
	
	public synchronized void pensar(String cons, boolean pensando, int i) throws InterruptedException {

		if(filosofosEmAcao.size() < 2) {
			get(cons, i, false);
			sleep((int)(Math.random() *100));										
		}
		
		while (disponivel && pensar ){
			try {
				wait();				
			} catch (Exception e) {}
		}
		
		if(!filosofosEmAcao.contains(cons)) {
			System.out.println(cons + " está pensando");
			sleep((int)(Math.random() *1000));
			filosofosPassados = filosofosPassados + 1;		
			filosofosEmAcao.add(cons);
			notifyAll();
		}
				
		if(filosofosPassados == 3) {
			put();
			filosofosPassados = 0;
			filosofosEmAcao.clear();
			notifyAll();
		}
		
	}
	
	public ArrayList<Integer> getGarfosEmUso(){
		return garfosEmUso;
	}
	
	public synchronized void put() { 
		
		while (disponivel && !pensar){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		this.garfosEmUso.clear();
		this.garfosEmUso.add(1);
		this.garfosEmUso.add(2);
		this.garfosEmUso.add(3);
		this.garfosEmUso.add(4);
		this.garfosEmUso.add(5);
		
		disponivel = true; 
		pensar = true;
		
		notifyAll();
		}
}