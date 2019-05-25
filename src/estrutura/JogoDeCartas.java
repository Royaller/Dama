package estrutura;

public class JogoDeCartas {
	
	private Object elemento;
	private int banido;
	private JogoDeCartas anterior;
	private JogoDeCartas proximo;
	
	
	public int getBanido() {
		return banido;
	}


	public void setBanido(int banido) {
		this.banido = banido;
	}


	public Object getElemento() {
		return elemento;
	}
	

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}




	public JogoDeCartas getAnterior() {
		return anterior;
	}




	public void setAnterior(JogoDeCartas anterior) {
		this.anterior = anterior;
	}




	public JogoDeCartas getProximo() {
		return proximo;
	}




	public void setProximo(JogoDeCartas proximo) {
		this.proximo = proximo;
	}



	
	

}


