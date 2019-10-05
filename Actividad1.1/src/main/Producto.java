package main;

public class Producto<E> implements Comparable<Object>{	//implementar comparable

	private Integer id;
	private String nom;
	private Double preu;
	
	Producto(Integer id, String nom, Double preu){
		this.id = id;
		this.nom = nom;
		this.preu = preu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPreu() {
		return preu;
	}

	public void setPreu(Double preu) {
		this.preu = preu;
	}

	/***
	 * Si son iguales devuelve 1, si no -1
	 */
	@Override
	public int compareTo(Object arg0) {
		if(this.equals(arg0)) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
