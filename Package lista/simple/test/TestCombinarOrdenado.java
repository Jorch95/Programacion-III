package prog3.lista.simple.test;
import prog3.lista.simple.*;
public class TestCombinarOrdenado {

	public static void main(String[] args) {
		ListaDeEnterosEnlazada lista1=new ListaDeEnterosEnlazada();
		lista1.agregarFinal(1);
		lista1.agregarFinal(5);
		lista1.agregarFinal(7);
		lista1.agregarFinal(8);
		lista1.agregarFinal(9);
		ListaDeEnterosEnlazada lista2=new ListaDeEnterosEnlazada();
		lista2.agregarFinal(2);
		lista2.agregarFinal(4);
		lista2.agregarFinal(28);
		System.out.println(lista1.combinarOrdenado(lista2).toString());
		

	}

}
