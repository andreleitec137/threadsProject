package threadsProject;

public class Main {
	public static void main(String[] args) {
		Mesa umEstoque = new Mesa();
		Garfos umProdut = new Garfos(umEstoque);
		Filosofo umFilosofo = new Filosofo("Sócrates",umEstoque, false);  
		Filosofo doisFilosofo = new Filosofo("Aristoteles",umEstoque, false);  
		Filosofo tresFilosofo = new Filosofo("Euclides",umEstoque, true);  
		Filosofo quatroFilosofo = new Filosofo("Arquimedes",umEstoque, true);  
		Filosofo cincoFilosofo = new Filosofo("Nitzche",umEstoque, true);  

		umProdut.start();
		umFilosofo.start();
		doisFilosofo.start();
		tresFilosofo.start();
		quatroFilosofo.start();
		cincoFilosofo.start();

	}
}
