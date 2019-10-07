package main;

public class Main {

	public static void main(String[] args) {
		
		Producto<?> p1 = new Producto(1,"Queso",2.30);
		Producto<?> p2 = new Producto(2,"Tomate",1.70);
		Producto<?> p3 = new Producto(3,"Chorizo",3d);
		Producto<?> p4 = new Producto(4,"Ram",20d);
		Producto<?> p5 = new Producto(5,"CPU",47d);
		Producto<?> p6 = new Producto(6,"Placa madre",100d);
		Producto<?> p7 = new Producto(7,"GPU",47d);
		
		Producto<?>[] ap = {p1,p2,p3};
		
		Paginable pg = new Paginable(ap);
		
		pg.add(p4);

		Producto<?>[] pag = pg.getPage(0);
		
		System.out.println("Pag 1:");
		for (int i = 0; i < pag.length; i++) {
			System.out.println(pag[i].getNom());
		}
		System.out.println("===================");
		System.out.println("Pag 1 después de quitar tomate: ");
		pg.remove(p2);
		Producto<?>[] pagSinTomate = pg.getPage(0);
		for (int i = 0; i < pagSinTomate.length; i++) {
			System.out.println(pagSinTomate[i].getNom());
		}
		System.out.println("==================");
	
		
	}

}
