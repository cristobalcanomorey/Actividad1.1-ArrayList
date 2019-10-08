package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paginable <E extends Producto> {

	/*
	 * add()					V
	 * remove()					V
	 * contains()				V
	 * getPage(int index)		V
	 * findPageOf(Producto p)	X
	 * int getTotalPages()		V
	 * size()					V
	 * */
	
	private ArrayList<Producto<?>> productos = new ArrayList<Producto<?>>();
	private int prodPorPag = 3;
	private int numDePags = 0;
	
	/***
	 * Crea un paginable transformando un array de productos a un ArrayList sin ids repetidas
	 * @param prod Array de productos
	 */
	Paginable(Producto<?>[] prod){
		ArrayList<Producto<?>> lista = new ArrayList<Producto<?>>(Arrays.asList(prod));
		ArrayList<Producto<?>> listaSinRepe = new ArrayList<Producto<?>>();
		for (Producto<?> producto : lista) {
			if(!listaSinRepe.contains(producto)) {
				listaSinRepe.add(producto);
			}
		}
		this.productos = listaSinRepe;
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
	
	/***
	 * Devuelve el nº de página en la que se encuentra el producto
	 * @param p Producto a buscar
	 * @return -1 si no está o el nº de pag si está
	 */
	public int findPageOf(Producto<?> p) {
		if(!productos.contains(p)) {
			return -1;
		} else {
			return (int) Math.ceil((productos.indexOf(p)+1)/prodPorPag);
		}
		
	}
	
	public int getTotalPages() {
		
		return numDePags;
	}
	public int size() {
		return productos.size();
	}
	
}
