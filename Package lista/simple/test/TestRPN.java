package prog3.lista.simple.test;
import prog3.util.PilaDeEnteros;

public class TestRPN {
	//suponemos que los operandos son numeros de una sola cifra
	public static int CalculadoraRPN(String expresion){
		PilaDeEnteros pila=new PilaDeEnteros();
		for(int i=0;i<expresion.length();i++){
			int operando2,operando1;
			System.out.println("Analisando= "+expresion.charAt(i));
			switch(expresion.charAt(i)){
			case '-':
				System.out.println("Es -");
				operando2=pila.desapilar();
				operando1=pila.desapilar();
				pila.apilar(operando1-operando2);
				break;
			case '+':
				System.out.println("Es +");
				operando2=pila.desapilar();
				operando1=pila.desapilar();
				pila.apilar(operando1+operando2);
				break;
			case '/':
				System.out.println("Es /");
				operando2=pila.desapilar();
				operando1=pila.desapilar();
				pila.apilar(operando1/operando2);
				break;
			case '*':
				System.out.println("Es *");
				operando2=pila.desapilar();
				operando1=pila.desapilar();
				pila.apilar(operando1*operando2);
				break;
			default:
				System.out.println("Es numero"+expresion.charAt(i));
				pila.apilar(Character.getNumericValue(expresion.charAt(i)));
				break;
			}
			System.out.println("Se apilo= "+pila.tope());
		}
		return pila.desapilar();
	}
	
	public static void main(String[]args){
		System.out.println(TestRPN.CalculadoraRPN("562+*93/-"));//"5*(6+2)-9/3=37
	}

}
