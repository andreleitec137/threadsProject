package threadsProject;

public class Main {
	public static void main(String[] args) {
		Mesa novaMesa = new Mesa();
		Garfos iniciaGarfos = new Garfos(novaMesa);
		Filosofo umFilosofo = new Filosofo("Sócrates",novaMesa);  
		Filosofo doisFilosofo = new Filosofo("Aristoteles",novaMesa);  
		Filosofo tresFilosofo = new Filosofo("Euclides",novaMesa);  
		Filosofo quatroFilosofo = new Filosofo("Arquimedes",novaMesa);  
		Filosofo cincoFilosofo = new Filosofo("Nitzche",novaMesa);  

		iniciaGarfos.start();
		umFilosofo.start();
		doisFilosofo.start();
		tresFilosofo.start();
		quatroFilosofo.start();
		cincoFilosofo.start();

	}
}
