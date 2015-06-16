package prog3.lista;

public abstract class ListaGenerica<T> {
	
	public abstract void comenzar();
	public abstract T proximo();
	public abstract boolean fin();
	
	public abstract T elemento(int pos);
	
	public abstract boolean agregarEn(T elem, int pos);
	public abstract boolean agregarInicio(T elem);
	public abstract boolean agregarFinal(T elem);
	
	public abstract boolean eliminar(T elem);
	public abstract boolean eliminarEn(int pos);
	
	public abstract boolean incluye(T elem);
	public abstract boolean esVacia();
	public abstract int tamanio();
	
	
	

}
