package main;

public class Main {

	public static void main(String[] args) {
		
		/*Pruebas*/
		Producto<?> p1 = new Producto(1,"Queso",2.30);
		Producto<?> p2 = new Producto(2,"Tomate",1.70);
		Producto<?> p3 = new Producto(3,"Chorizo",3d);
		Producto<?> p4 = new Producto(1,"Ram",20d);
		Producto<?> p5 = new Producto(5,"CPU",47d);
		Producto<?> p6 = new Producto(6,"Placa madre",100d);
		Producto<?> p7 = new Producto(7,"GPU",47d);
		
		Producto<?>[] ap = {p7,p2,p3,p1};
		
		Paginable<?> pg = new Paginable(ap);
		System.out.println(p6.compareTo(p7));
		pg.add(p4);

		Producto<?>[] pag2 = pg.getPage(1);
		
		System.out.println("==================");
		System.out.println("Numero de páginas: " + pg.getTotalPages());
		System.out.println("==================");
		
		System.out.println("Pag 1:");
		for (int i = 0; i < pag2.length; i++) {
			System.out.println(pag2[i].getNom());
		}
		System.out.println("==================");
		System.out.println(pg.findPageOf(p7));
		System.out.println(pg.findPageOf(p7, true));
		System.out.println(pg.findPageOf(p1, false));
	}

}
