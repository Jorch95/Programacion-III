package prog3.lista.simple.test;
import prog3.util.*;
public class TestPila {

	public static void main(String[] args) {
		PilaDeEnteros p1, p2;
		int valor2=0;
		p1=new PilaDeEnteros();
		p1.apilar(1);
		p1.apilar(2);
		p2=p1;
		valor2 = p2.desapilar();
		System.out.println("El valor del tope de la pila p1 es: " +
		p1.desapilar());

	}

}
