package prog3.lista.simple.test;
import prog3.lista.simple.*;
public class TestOrdenamiento {
	
	public static void main(String[]args){
		ListaDeEnterosEnlazada lista1=new ListaDeEnterosEnlazada();
		lista1.agregarFinal(6);
		lista1.agregarFinal(7);
		lista1.agregarFinal(10);
		lista1.agregarFinal(4);
		lista1.agregarFinal(1);
		lista1.agregarFinal(76);
		lista1.agregarFinal(3);
		lista1.agregarFinal(13);
		ListaDeEnterosEnlazada lista2=lista1.ordenar();
		System.out.println(lista2.toString());
	}

}
