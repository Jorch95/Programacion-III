package prog3.arbol.general;

import prog3.lista.ListaEnlazadaGenerica;
import prog3.lista.ListaGenerica;
import prog3.util.ColaGenerica;

public class ArbolGeneral<T> {

	private NodoGeneral<T> raiz;

	public ArbolGeneral() {

		this.raiz = null;
	}

	public ArbolGeneral(T dato) {

		this.raiz = new NodoGeneral<T>(dato);

	}
	public void setDatoRaiz(T dato){
		this.raiz.setDato(dato);
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> lista) {

		this(dato);
		ListaGenerica<NodoGeneral<T>> hijos = new ListaEnlazadaGenerica<NodoGeneral<T>>();

		lista.comenzar();
		while (!lista.fin()) {
			ArbolGeneral<T> arbolTemp = lista.proximo();
			hijos.agregarFinal(arbolTemp.getRaiz());

		}

		raiz.setListaHijos(hijos);
	}

	private ArbolGeneral(NodoGeneral<T> nodo) {

		this.raiz = nodo;
	}

	private NodoGeneral<T> getRaiz() {

		return this.raiz;
	}

	public T getDatoRaiz() {

		return this.raiz.getDato();
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {

		ListaGenerica<ArbolGeneral<T>> lista = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ListaGenerica<NodoGeneral<T>> hijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		lista.comenzar();
		hijos.comenzar();

		while (!hijos.fin()) {
			lista.agregarFinal(new ArbolGeneral<T>(hijos.proximo()));

		}

		return lista;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		this.raiz.getHijos().agregarFinal(hijo);
	}

	public void eliminarHijo(ArbolGeneral<T> unHijo) {

		NodoGeneral<T> hijo = unHijo.getRaiz();
		boolean ok = false;

		ListaGenerica<NodoGeneral<T>> listaHijos = (ListaGenerica<NodoGeneral<T>>) this.getRaiz().getHijos();
		listaHijos.comenzar();

		while (!listaHijos.fin() && !ok) {

			NodoGeneral<T> hijoTemp = listaHijos.proximo();
			if (hijoTemp.getDato().equals(hijo.getDato())) {
				ok = listaHijos.eliminar(hijoTemp);

			}
		}

	}

	public boolean esHoja(){
		return(this.raiz.getHijos().esVacia());
	}
	public boolean esVacia(){
		return(this.raiz==null);
	}

	public Integer altura() {
		return recAltura(this);
	}
	
	private Integer recAltura(ArbolGeneral<T> ag){
		if(ag.esHoja()){
			return 0;
		}
		else{
			int maxAltura=0;
			ListaGenerica<ArbolGeneral<T>> hijos=ag.getHijos();
			hijos.comenzar();
			while(!hijos.fin()){
				int altura=recAltura(hijos.proximo());
				if(maxAltura<altura){
					maxAltura=altura;
				}
			}
			return 1+maxAltura;
		}
	}
	// return -1 si no encontro el valor
	public Integer nivel(T dato) {
		if(raiz==null){
			return -1;
		}else{
			if(this.getDatoRaiz()==dato){
				return 0;
			}else{
				ColaGenerica<ArbolGeneral<T>> cola=new ColaGenerica<ArbolGeneral<T>>();
				cola.encolar(this);
				cola.encolar(null);
				boolean encontro=false;
				int nivel=0;
				while(!cola.esVacia() && !encontro){
					ArbolGeneral<T> ag=cola.desencolar();
					if(ag==null){
						nivel++;
						if(!cola.esVacia()){
							cola.encolar(null);
						}
					}else{
						if(ag.getDatoRaiz()==dato){
							encontro=true;
						}
						ListaGenerica<ArbolGeneral<T>> hijos=ag.getHijos();
						hijos.comenzar();
						while(!hijos.fin()){//encola todos los hijos
							cola.encolar(hijos.proximo());
						}
					}
					
				}
				return (encontro)?nivel:-1;
			}
		}
		
	}
	public boolean include(T dato){
		
		return includeRecu(this,dato);
		
	}
	private boolean includeRecu(ArbolGeneral<T> ag,T dato){
		if(ag.getDatoRaiz()==dato){
			return true;
		}else{
			ListaGenerica<ArbolGeneral<T>> hijos=ag.getHijos();
			hijos.comenzar();
			boolean encontro=false;
			while(!hijos.fin() && !encontro){
				encontro=includeRecu(hijos.proximo(),dato);
			}
			return encontro;		
		}
			
	}
	public String imprimirPorNivel(){
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		String s="";
		while(!cola.esVacia()){
			ArbolGeneral<T> ab=cola.desencolar();
			if(ab==null){//fin de nivel
				s+="\n";
				if(!cola.esVacia()){
					cola.encolar(null);
				}				
			}else{
				s+=ab.getDatoRaiz()+" ";
				ListaGenerica<ArbolGeneral<T>> hijos=ab.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}
		}
		return s;
	}
	
	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int anchoMax=0;
		int anchoNivel=0;
		while(!cola.esVacia()){
			ArbolGeneral<T> ab=cola.desencolar();
			if(ab==null){
				anchoMax=(anchoNivel>anchoMax)?anchoNivel:anchoMax;
				anchoNivel=0;
				if(!cola.esVacia()){//si termino el nivel y no es vacia
					cola.encolar(null);
				}
			}else{
				anchoNivel++;
				ListaGenerica<ArbolGeneral<T>> hijos=ab.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}
		}
		return anchoMax;
	}

}
