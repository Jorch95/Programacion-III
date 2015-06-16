package prog3.lista;



public class ListaEnlazadaGenerica<T> extends ListaGenerica<T> {
	
	private int tamanio;
	private NodoGenerico<T> actual;
	private NodoGenerico<T> fin;
	private NodoGenerico<T> inicio;
	
	@Override
	public void comenzar(){
		this.actual=this.inicio;	
	}

	@Override
	public T proximo() {
		T elto=this.actual.getDato();
		this.actual=actual.getSiguiente();
		return elto;
	}

	@Override
	public boolean fin() {
		return (this.actual==null);
	}

	@Override
	public T elemento(int pos) {
		if (pos < 1 || pos > this.tamanio){
			return null;
		}
		NodoGenerico<T> aux=this.inicio;
		for(int i=1;i<pos;i++){
			aux=aux.getSiguiente();
		}
		return aux.getDato();
	}

	@Override
	public boolean agregarEn(T elem,int pos){
		if(pos<1 || pos>this.tamanio+1){
			return false;
		}
		NodoGenerico<T> nue=new NodoGenerico<T>();
		nue.setDato(elem);
		if(pos==1){//en el primer lugar
			nue.setSiguiente(this.inicio);
			this.inicio=nue;
		}else{
			NodoGenerico<T> aux=this.inicio;
			int posActual=1;
			while(aux!=null && posActual<(pos-1)){
				aux=aux.getSiguiente();
				posActual++;
			}
			//sale con el nodo anterior a donde hay que agregar el nuevo elemento
			if(aux==this.fin){
				this.fin=nue;
			}
			nue.setSiguiente(aux.getSiguiente());
			aux.setSiguiente(nue);
	
				
		}		
		this.tamanio++;	
		return true;
	}

	@Override
	public boolean agregarInicio(T elem) {
		this.agregarEn(elem,1);
		return true;
	}

	@Override
	public boolean agregarFinal(T elem) {
		this.agregarEn(elem,this.tamanio+1);
		return true;
	}

	@Override
	public boolean eliminar(T elem) {
		if(this.inicio==null)//vacia
			return false;
		NodoGenerico<T> act=this.inicio;
		NodoGenerico<T> ant=null;
		while(act!=null && !act.getDato().equals(elem)){
			ant=act;
			act=act.getSiguiente();
		}
		if(act==null)//no lo encontro
			return false;
		if(ant==null)//es el primer elemento
			inicio=inicio.getSiguiente();
		else{//es desde el 2do al ultimo
			if(act==this.fin){
				this.fin=ant;
			}
			ant.setSiguiente(act.getSiguiente());
		}
		this.tamanio--;
		return true;
	}

	@Override
	public boolean eliminarEn(int pos) {
		if(pos<1 || pos>this.tamanio){
			return false;
		}
		if(pos==1){
			this.inicio=this.inicio.getSiguiente();
		}else{
			NodoGenerico<T> aux=this.inicio;
			int posActual=1;
			while(aux!=null && posActual<(pos-1)){
				aux=aux.getSiguiente();
				posActual++;
			}
			//sale con el nodo anterior al ser eliminado
			aux.setSiguiente(aux.getSiguiente().getSiguiente());
			if(aux.getSiguiente()==null)
				this.fin=aux;
		}
		this.tamanio--;
		return true;
	}

	@Override
	public boolean incluye(T elem) {
		NodoGenerico<T> aux = this.inicio;
		while (!(aux == null) && !(aux.getDato().equals(elem)))
			aux = aux.getSiguiente();
		return !(aux == null);
	}

	@Override
	public boolean esVacia() {	
		return (this.tamanio==0);
	}

	@Override
	public int tamanio() {		
		return this.tamanio;
	}
	
	public String toString(){
		String str="";
		NodoGenerico<T> aux=this.inicio;
		while(aux!=null){
			str=str+aux.getDato().toString()+" ";
			aux=aux.getSiguiente();
		}
		return str;
	}
	
	public ListaEnlazadaGenerica<T> invertir(){
		ListaEnlazadaGenerica<T> resul=new ListaEnlazadaGenerica<T>();
		NodoGenerico<T> aux =this.inicio;
		for(int i=0;i<this.tamanio;i++){
			resul.agregarInicio(aux.getDato());
			aux=aux.getSiguiente();
		}
		return resul;
		
		
	}
}

	