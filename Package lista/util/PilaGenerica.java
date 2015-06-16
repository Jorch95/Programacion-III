package prog3.util;
import prog3.lista.ListaEnlazadaGenerica;

public class PilaGenerica<T> {
	private ListaEnlazadaGenerica<T> datos;
	
	public PilaGenerica(){
		this.datos=new ListaEnlazadaGenerica<T>();
	}
	public void apilar(T elem){
		datos.agregarFinal(elem);
	}
	public T desapilar(){
		T aux = this.datos.elemento(this.datos.tamanio());
		this.datos.eliminarEn(this.datos.tamanio());
		return aux;
	}
	public boolean esVacia(){
		return(this.datos.tamanio()==0);
	}
	public T tope(){
		return this.datos.elemento(this.datos.tamanio());
	}

}
