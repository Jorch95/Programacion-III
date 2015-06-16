package prog3.util;

import prog3.lista.simple.*;

public class PilaDeEnteros {

	ListaDeEnteros datos;
	
	public PilaDeEnteros() {
		datos = new ListaDeEnterosEnlazada();
	}
	
	public void apilar(int elem){
		this.datos.agregarFinal(elem);
	}
	public int desapilar(){
		int aux = this.datos.elemento(this.datos.tamanio());
		this.datos.eliminarEn(this.datos.tamanio());
		return aux;
		}
	public int tope(){
		return this.datos.elemento(this.datos.tamanio());
	}
	public boolean esVacia(){
		return(this.datos.tamanio()==0);
	}	

}
