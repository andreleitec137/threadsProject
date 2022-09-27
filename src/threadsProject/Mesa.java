package threadsProject;

import java.util.ArrayList;

public class Mesa extends Thread { 
	private ArrayList<Integer> garfosDisponiveis = new ArrayList<Integer>();

	private boolean disponivel = false;
	private boolean pensar = true; 
	private int filosofosPassados = 0;
	private ArrayList<String> filosofosEmAcao = new ArrayList<>();
	
	public synchronized void  get(String cons, Integer garfo) throws InterruptedException {
		while (!disponivel && !pensar){
			try {
				wait();				
			} catch (Exception e) {}
		}
		
		if(garfosDisponiveis.size() < 2) {
			disponivel = false;
			pensar = true;			
			sleep((int)(Math.random() *1000));
			notifyAll();
		}else {
			try {		
				if(!filosofosEmAcao.contains(cons)) {
					System.out.println(" ");
					System.out.println("***Garfos Disponiveis***: " + garfosDisponiveis.size());
					System.out.println(" --- " + cons + " está comendo");
					System.out.println(" ");

					filosofosEmAcao.add(cons);
					sleep((int)(Math.random() *1000));
					garfosDisponiveis.remove(0);
					garfosDisponiveis.remove(1);
				}
				notifyAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public synchronized void pensar(String cons, int i) throws InterruptedException {

		if(filosofosEmAcao.size() < 2) {
			get(cons, i);
			sleep((int)(Math.random() *100));										
		}
		
		while (disponivel && pensar ){
			try {
				wait();				
			} catch (Exception e) {}
		}
		
		if(!filosofosEmAcao.contains(cons)) {
			System.out.println(" ");
			System.out.println("***Não há mais garfos disponíveis***");
			System.out.println(" --- " + cons + " está pensando");
			System.out.println(" ");
			sleep((int)(Math.random() *1000));
			filosofosPassados = filosofosPassados + 1;		
			filosofosEmAcao.add(cons);
			notifyAll();
		}
				
		if(filosofosPassados == 3) {
			sleep((int)(Math.random() *1000));
			put();
			filosofosPassados = 0;
			filosofosEmAcao.clear();			
			System.out.println("");
			System.out.println("******GARFOS LIBERADOS*****");
			notifyAll();
		}
		
	}
	
	public ArrayList<Integer> getGarfosDisponiveis(){
		return garfosDisponiveis;
	}
	
	public synchronized void put() { 
		
		while (disponivel && !pensar){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		this.garfosDisponiveis.clear();
		this.garfosDisponiveis.add(1);
		this.garfosDisponiveis.add(2);
		this.garfosDisponiveis.add(3);
		this.garfosDisponiveis.add(4);
		this.garfosDisponiveis.add(5);
		
		disponivel = true; 
		pensar = true;
		
		notifyAll();
	}
}