/**
 * Paquete examenMarzo.
 */
package examenMarzo;

/**
 * Clase DniInvalidoException.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 *
 */
public class DniInvalidoException extends Exception {
	private String mensaje;
	
	public DniInvalidoException(String mensaje) {
		this.mensaje=mensaje;
	}
	
	String getMensaje(){
		return mensaje;
	}
}
