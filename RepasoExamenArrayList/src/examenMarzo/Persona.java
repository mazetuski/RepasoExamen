/**
 * Paquete examenMarzo.
 */
package examenMarzo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Persona
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 * 
 */
public class Persona {
	private String dni;
	private String nombre;
	private static final String COMPROBAR_DNI = "^(\\d{8})[- ]?([A-Z&&[^IOU]])$";
	private static Pattern patron = Pattern.compile(COMPROBAR_DNI);
	private String direccion;
	private static final String DNI_LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

	Persona(String nombre, String direccion, String dni)
			throws DniInvalidoException {
		setNombre(nombre);
		setDni(dni);
		setDireccion(direccion);
	}

	Persona(String dni) throws DniInvalidoException {
		setDni(dni);
	}

	String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	String getDni() {
		return dni;
	}

	/**
	 * Metodo set de dni.
	 * 
	 * @param dni
	 *            Dni de la persona.
	 * @throws DniInvalidoException
	 *             si el dni o la letra del dni son invalidos.
	 */
	private void setDni(String dni) throws DniInvalidoException {
		Matcher matcher = patron.matcher(dni);
		if (!matcher.matches())
			throw new DniInvalidoException("El DNI es invalido.");
		if (!comprobarLetraDni(matcher.group(1), matcher.group(2)))
			throw new DniInvalidoException("La letra del dni no es valida.");
		this.dni = dni;
	}

	/**
	 * Metodo que modifica la direccion de la persona.
	 * 
	 * @param direccion
	 *            Direccion que se modifica.
	 */
	void modificarDireccion(String direccion) {
		setDireccion(direccion);
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo que comprueba la letra del dni.
	 * 
	 * @param dni
	 *            Dni que se comprueba.
	 * @return Devuelve true si la letra coincide, false en caso contrario.
	 */
	boolean comprobarLetraDni(String numerosDni, String letra) {
		if (letra.charAt(0) != DNI_LETRAS
				.charAt(Integer.parseInt(numerosDni) % 23))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombre + ":\n DNI: " + dni + " \n Direccion: " + direccion;
	}

}
