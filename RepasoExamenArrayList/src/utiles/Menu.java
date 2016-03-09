package utiles;

public class Menu {
	String[] menu;
	String titulo;

	public Menu(String[] menu, String titulo) {
		this.menu = menu;
		this.titulo = titulo;
	}

	/**
	 * Metodo que gestiona un menu.
	 * 
	 * @return Devuelve la respuesta del usuario.
	 */
	public int gestionarMenu() {
		int respuesta;
		System.out.println("\n" + getTitulo());
		for (int i = 0; i < menu.length; i++) {
			System.out.println("(" + (i + 1) + ") " + menu[i] + ".");
		}
		System.out.println("(" + (menu.length + 1) + ") Salir.");
		do {
			respuesta = Teclado.leerEntero("\nQue opcion deseas elegir?: ");
		} while (respuesta < 1 || respuesta > menu.length + 1);
		return respuesta;
	}

	private String getTitulo() {
		return titulo;
	}

	private String[] getMenu() {
		return menu;
	}

	private void setMenu(String[] menu) {
		this.menu = menu;
	}

}
