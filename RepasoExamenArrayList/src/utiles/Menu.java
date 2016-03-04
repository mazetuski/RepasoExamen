package utiles;

public class Menu {
	String[] menu;
	String titulo;

	public Menu(String[] menu, String titulo) {
		this.menu = menu;
		this.titulo = titulo;
	}

	public int gestionarMenu() {
		int respuesta;
		System.out.println("\n"+getTitulo());
		for (int i = 0; i < menu.length; i++) {
			System.out.println("(" + (i + 1) + ") " + menu[i]+".");
		}
		System.out.println("("+(menu.length+1)+") Salir.");
		do {
			respuesta = Teclado.leerEntero("\nQue opcion deseas elegir?: ");
		} while (respuesta < 1 || respuesta > menu.length+1);
		return respuesta;
	}

	public String getTitulo() {
		return titulo;
	}

	public String[] getMenu() {
		return menu;
	}

	public void setMenu(String[] menu) {
		this.menu = menu;
	}

}
