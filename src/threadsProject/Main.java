package threadsProject;

public class Main {
	public static void main(String[] args) {
		Mesa umEstoque = new Mesa();
		Garfos umProdut = new Garfos("PROD",umEstoque);
		Filosofo umFilosofo = new Filosofo("Sócrates",umEstoque);  
		Filosofo doisFilosofo = new Filosofo("Aristoteles",umEstoque);  
		Filosofo tresFilosofo = new Filosofo("Euclides",umEstoque);  
		Filosofo quatroFilosofo = new Filosofo("Arquimedes",umEstoque);  
		Filosofo cincoFilosofo = new Filosofo("Nitzche",umEstoque);  

		umFilosofo.start(); 
		doisFilosofo.start();
		tresFilosofo.start();
		quatroFilosofo.start();
		cincoFilosofo.start();

		umProdut.start();
	}
}
