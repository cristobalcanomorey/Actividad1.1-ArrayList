package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Paginable<E extends Producto> {

	private ArrayList<Producto<?>> productos = new ArrayList<Producto<?>>();
	private int prodPorPag = 3;
	private int numDePags = 0;

	/***
	 * Crea un paginable transformando un array de productos a un ArrayList sin
	 * productos repetidos
	 * 
	 * @param prod Array de productos
	 */
	Paginable(Producto<?>[] prod) {
		this.productos = quitaRepetidos(prod);
		Double division = (double) productos.size() / prodPorPag;
		numDePags = (int) Math.ceil(division);
	}

	/***
	 * Devuelve un ArrayList sin productos repetidos
	 * 
	 * @param prod Array de productos que puede contener repetidos
	 * @return ArrayList de productos únicos
	 */
	private ArrayList<Producto<?>> quitaRepetidos(Producto<?>[] prod) {
		ArrayList<Producto<?>> lista = new ArrayList<Producto<?>>(Arrays.asList(prod));
		ArrayList<Producto<?>> listaSinRepe = new ArrayList<Producto<?>>();
		for (Producto<?> producto : lista) {
			if (!listaSinRepe.contains(producto)) {
				listaSinRepe.add(producto);
			}
		}
		return listaSinRepe;
	}

	/***
	 * Añade un producto en el array si no está repetido y actualiza el nº de
	 * páginas buscando la página del último producto añadido
	 * 
	 * @param p Producto que intenta añadir
	 * @return True si ha funcionado, false si no
	 */
	public boolean add(Producto<?> p) {
		if (!productos.contains(p)) {
			productos.add(p);
			numDePags = findPageOf(p, productos);
			return true;
		} else {
			return false;
		}

	}

	/***
	 * Elimina el producto del array si existe y actualiza el nº de páginas buscando
	 * la página del último elemento de la lista
	 * 
	 * @param p Producto que intenta eliminar
	 * @return True si ha funcionado, false si no
	 */
	public boolean remove(Producto<?> p) {
		if (contains(p)) {
			productos.remove(p);
			numDePags = findPageOf(productos.get(productos.size() - 1), productos);
			return true;
		} else {
			return false;
		}

	}

	/***
	 * Busca si el producto está en el array
	 * 
	 * @param p Producto que se quiere encontrar
	 * @return True si está en el array, false si no
	 */
	public boolean contains(Producto<?> producto) {
		boolean resul = false;
		for (Producto<?> p : productos) {
			if (resul) {
				break;
			} else {
				resul = producto.equals(p);
			}
		}
		return resul;
	}

	/***
	 * Calcula que productos hay en la página pasada por parámetro y los devuelve
	 * como un array
	 * 
	 * @param n Número de página
	 * @return Array de productos en esa página
	 */
	public Producto<?>[] getPage(int n) {
		int tamPag = prodPorPag;
		int primProd = n * prodPorPag;
		int ultProd = primProd + prodPorPag;
		if (ultProd > productos.size()) {
			ultProd = productos.size();
			tamPag = ultProd - primProd;
		}
		Producto<?>[] resul = new Producto<?>[tamPag];
		List pag = productos.subList(primProd, ultProd);

		for (int i = 0; i < pag.size(); i++) {
			resul[i] = (Producto<?>) pag.get(i);
		}
		return resul;
	}

	/***
	 * Encuentra la página del producto
	 * 
	 * @param p Producto a buscar
	 * @return -1 si no está, nº de página si está
	 */
	public int findPageOf(Producto<?> p) {
		return findPageOf(p, productos);
	}

	/***
	 * Encuentra la página del producto
	 * 
	 * @param p     Producto a buscar
	 * @param lista ArrayList de productos
	 * @return -1 si no está, nº de página si está
	 */
	private int findPageOf(Producto<?> p, ArrayList<Producto<?>> lista) {
		if (!lista.contains(p)) {
			return -1;
		} else {
			return (int) Math.ceil((double) (lista.indexOf(p) + 1) / prodPorPag);
		}

	}

	/***
	 * Encuentra la página del producto en una lista ordenada de mayór a menor o
	 * viceversa
	 * 
	 * @param p     Producto a buscar
	 * @param orden True = menor a mayor, False = mayor a menor
	 * @return -1 si no está, nº de página si está
	 */
	public int findPageOf(Producto<?> p, boolean orden) {
		ArrayList<Producto<?>> ordenados = ordenar(orden);
		return findPageOf(p, ordenados);
	}

	/***
	 * Ordena un array con los productos
	 * 
	 * @param menAMay True = menor a mayor, False = mayor a menor
	 * @return ArrayList con los productos ordenados
	 */
	public ArrayList<Producto<?>> ordenar(boolean menAMay) {
		
		if (menAMay) {
			Collections.sort(productos);
			return productos;
		} else {
			Collections.reverse(productos);
			return productos;
		}
	}

	public int getTotalPages() {
		return numDePags;
	}

	public int size() {
		return productos.size();
	}

}
