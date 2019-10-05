package arrayList;

import java.util.ArrayList;

import main.Producto;

public class Paginable <E extends Producto> {

	/*
	 * add
	 * remove
	 * contains
	 * getPage(int index)
	 * int getTotalPages()
	 * size*/
	
	private ArrayList<Object> productos = new ArrayList<Object>();
	private int prodPorPag = 3;
	private int numDePags;
	
	Paginable(ArrayList<Object> productos){
		this.productos = productos;
		numDePags = (int) Math.ceil(productos.size()/prodPorPag);
	}
		
	/***
	 * Solo añade productos en el array
	 * @param p Producto
	 */
	public void add(Producto p){
		productos.add(p);
	}
	
	/***
	 * Elimina el producto del array
	 * @param p Producto
	 */
	public void remove(Producto p) {
		if(contains(p)) {
			productos.remove(p);
		}
	}
	
	/***
	 * Busca si el producto está en el array
	 * @param p Producto
	 * @return True si p está en el array
	 */
	public boolean contains(Producto p) {
		return productos.contains(p);
	}
	
	/***
	 * Calcula que productos hay en la página pasada por parámetro y los devuelve como un array
	 * @param n Número de página
	 * @return Devuelve array de productos
	 */
	public Producto[] getPage(int n) {
		Producto[] resul = null;
		// primer prod = n * numDePags
		
		
		return resul;
	}
	
}
