package threadsProject;

public class Main {
	public static void main(String[] args) {
		Mesa novaMesa = new Mesa();
		Garfos iniciaGarfos = new Garfos(novaMesa);
		Filosofo umFilosofo = new Filosofo("Sócrates",novaMesa, false);  
		Filosofo doisFilosofo = new Filosofo("Aristoteles",novaMesa, false);  
		Filosofo tresFilosofo = new Filosofo("Euclides",novaMesa, true);  
		Filosofo quatroFilosofo = new Filosofo("Arquimedes",novaMesa, true);  
		Filosofo cincoFilosofo = new Filosofo("Nitzche",novaMesa, true);  

		iniciaGarfos.start();
		umFilosofo.start();
		doisFilosofo.start();
		tresFilosofo.start();
		quatroFilosofo.start();
		cincoFilosofo.start();

	}
}
