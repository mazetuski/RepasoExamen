/**
 * Paquete examenMarzo.
 */
package examenMarzo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import utiles.Teclado;

/**
 * Envoltorio CuentaBancaria
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class CuentaBancaria {

	private ArrayList<Cuenta> cuentasBancarias = new ArrayList<Cuenta>();

	/**
	 * Metodo que devuelve una cuenta del arraylist.
	 * 
	 * @return Devuelve una cuenta.
	 * @throws BancoVacioException
	 *             si el banco esta vacio.
	 */
	Cuenta getCuenta() throws BancoVacioException {
		if (cuentasBancarias.isEmpty())
			throw new BancoVacioException("No hay cuentas en el banco.");
		return cuentasBancarias.get(cuentasBancarias.indexOf(new Cuenta(Teclado
				.leerEntero("Cual es el codigo de su cuenta?"))));
	}

	/**
	 * Metodo que a&ntilde;ade una cuenta al ArrayList.
	 * 
	 * @param cuenta
	 *            Cuenta que se a&ntilde;ade
	 * @throws CuentaExisteException
	 *             si la cuenta existe.
	 */
	void annadirCuenta(Cuenta cuenta) throws CuentaExisteException {
		if (cuentasBancarias.contains(cuenta))
			throw new CuentaExisteException("La cuenta ya existe.");
		cuentasBancarias.add(cuenta);
	}

	/**
	 * Metodo que muestra todas las cuentas bancarias.
	 * 
	 * @return Devuelve un mensaje con todas las cuentas.
	 */
	String mostrarCuentasBancarias() {
		String mensaje = "";
		Iterator<Cuenta> iterator = cuentasBancarias.iterator();
		while (iterator.hasNext())
			mensaje += "\n" + iterator.next();
		return mensaje;
	}

	/**
	 * Metodo que elimina todas lascuentas de una persona.
	 * 
	 * @param persona
	 *            Persona que elimina sus cuentas.
	 */
	void eliminarCuentas(Persona persona) {
		ListIterator<Cuenta> it = cuentasBancarias.listIterator();
		int saldoRetirado = 0;
		while (it.hasNext()) {
			Cuenta cuenta = it.next();
			if (cuenta.getPersona().equals(persona)) {
				saldoRetirado += cuenta.getSaldo();
				it.remove();
			}
		}
		System.out.println("El cliente " + persona.getNombre()
				+ "Ha retirado: " + saldoRetirado);
	}

}
