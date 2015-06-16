package prog3.lista.simple.test;
import prog3.lista.simple.*;

public class ListaDeEnterosEnlazadaTestBasico {

	public static void main(String[]args){
		ListaDeEnterosEnlazada lista=new ListaDeEnterosEnlazada();
		for(String i:args){
			lista.agregarFinal(Integer.parseInt(i));
		}
		System.out.println(lista.toString());
	}
}
