/**
 * Paquete examenMarzo.
 */
package examenMarzo;

import java.util.ArrayList;

/**
 * Envoltorio Clientes
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 * 
 */
public class Clientes {

	private static ArrayList<Persona> clientes = new ArrayList<Persona>();

	/**
	 * Metodo que devuelve un cliente.
	 * 
	 * @return Devuelve un cliente.
	 * @throws DniInvalidoException
	 *             cuando el dni es invalido.
	 */

	Persona getCliente(String dni) throws DniInvalidoException {
		Persona persona = new Persona(dni);
		if (!clientes.contains(persona))
			throw new DniInvalidoException("No existe una persona con ese DNI.");
		return clientes.get(clientes.indexOf(persona));
	}

	/**
	 * Metodo que inserta una persona.
	 * 
	 * @param persona
	 *            Persona que se a&ntilde;ade.
	 * @throws ClienteExisteException
	 *             si el cliente existe.
	 */
	void annadirPersona(Persona persona) throws ClienteExisteException {
		if (clientes.contains(persona))
			throw new ClienteExisteException("El cliente ya existe.");
		clientes.add(persona);
	}

	/**
	 * Metodo que elimina una persona de clientes.
	 * 
	 * @param persona
	 *            Persona que se elimina.
	 */
	void eliminarPersona(Persona persona) {
		clientes.remove(persona);
	}
}
