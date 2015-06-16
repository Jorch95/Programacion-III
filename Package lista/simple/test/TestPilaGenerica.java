package prog3.lista.simple.test;
import prog3.util.PilaGenerica;
public class TestPilaGenerica {
	
	public static void main(String[]args){
		PilaGenerica<Character> pilaCaracteres=new PilaGenerica<Character>();
		pilaCaracteres.apilar('a');
		pilaCaracteres.apilar('b');
		pilaCaracteres.apilar('c');
		pilaCaracteres.apilar('d');
		pilaCaracteres.apilar('e');
		pilaCaracteres.desapilar();
		pilaCaracteres.desapilar();
		pilaCaracteres.desapilar();
		pilaCaracteres.desapilar();
		System.out.println(pilaCaracteres.desapilar());
	}

}
