package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paginable <E extends Producto> {

	/*
	 * add					V
	 * remove				V
	 * contains				V
	 * getPage(int index)	V
	 * int getTotalPages()	V
	 * size					V
	 * */
	
	private ArrayList<Producto<?>> productos = new ArrayList<Producto<?>>();
	private int prodPorPag = 3;
	private int numDePags = 0;
	
	Paginable(Producto<?>[] prod){
		ArrayList<Producto<?>> lista = new ArrayList<Producto<?>>(Arrays.asList(prod));
		ArrayList<Producto<?>> listaSinRepe = new ArrayList<Producto<?>>();
		for (Producto<?> producto : lista) {
			if(!listaSinRepe.contains(producto)) {
				listaSinRepe.add(producto);
			}
		}
		this.productos = new ArrayList<Producto<?>>(Arrays.asList(prod));
		numDePags = (int) Math.ceil(productos.size()/prodPorPag);
	}
		
	/***
	 * Solo añade productos en el array
	 * @param p Producto
	 */
	public boolean add(Producto<?> p){
		if(!productos.contains(p)) {
			productos.add(p);
			numDePags++;
			return true;
		} else {
			return false;
		}
		
	}
	
	/***
	 * Elimina el producto del array
	 * @param p Producto
	 */
	public boolean remove(Producto<?> p) {
		if(contains(p)) {
			productos.remove(p);
			numDePags--;
			return true;
		} else {
			return false;
		}
		
		
	}
	
	/***
	 * Busca si el producto está en el array
	 * @param p Producto
	 * @return True si p está en el array
	 */
	public boolean contains(Producto<?> producto) {
		boolean resul = false;
		for (Producto<?> p : productos) {
			if(resul) {
				break;
			} else {
				resul = producto.equals(p);
			}
			
		}
		return resul;
	}
	
	/***
	 * Calcula que productos hay en la página pasada por parámetro y los devuelve como un array
	 * @param n Número de página
	 * @return Devuelve array de productos
	 */
	public Producto<?>[] getPage(int n) {
		int tamPag = prodPorPag;
		int primProd = n * prodPorPag;
		int ultProd = primProd + prodPorPag;
		if(ultProd>productos.size()) {
			ultProd = productos.size();
			tamPag = ultProd-primProd;
		}
		Producto<?>[] resul = new Producto<?>[tamPag];
		List pag = productos.subList(primProd, ultProd);
				
		for (int i = 0; i < pag.size(); i++) {
			resul[i] = (Producto<?>) pag.get(i);
		}
//		
//		resul = (Producto<?>[]) pag.toArray();
		
		return resul;
	}
	
	public int getTotalPages() {
		
		return numDePags;
	}
	public int size() {
		return productos.size();
	}
	
}
