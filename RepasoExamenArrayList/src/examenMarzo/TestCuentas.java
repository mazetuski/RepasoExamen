/**
 * Paquete examenMarzo.
 */
package examenMarzo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import utiles.Menu;
import utiles.Teclado;

/**
 * mplementa al menos tres clases: TestCuentas, Persona y Cuenta y añádele los
 * campos y métodos que estimes oportunos según estas instrucciones. Se nos pide
 * implementar el comportamiento de una cuenta corriente. Queremos hacer
 * hincapié en el número de cuenta, que ha de ser único. En este caso el número
 * de cuenta se generará mediante un contador común a todas las cuentas. La
 * primera cuenta deberá tener el código de cuenta con valor 1. La cuenta
 * permitirá al menos las siguientes operaciones:
 * 
 * Ingreso a la cuenta de una cantidad de dinero. Reintegro de la cuenta de una
 * cantidad de dinero. La cuenta no puede llegar a números rojos. En tal caso,
 * el reintegro no puede llevarse a cabo. Transferencia de una cantidad de
 * dinero desde una cuenta a otro. La cuenta origen de la transferencia no puede
 * llegar a números rojos. En tal caso, la transferencia no puede llevarse a
 * cabo. Mostrar el estado de la cuenta, donde aparezcan todos los
 * atributos(toString())
 * 
 * Crea una clase TestCuentas donde estará el método main que lleve a cabo las
 * siguientes operaciones:
 * 
 * Ha de crear dos cuentas con las siguientes características: Primera cuenta:
 * de "Mortadelo", con dni 11223344 y dirección Mikasa. Saldo inicial de la
 * cuenta: 1000 euros Segunda cuenta: de Filemon, con dni 55667788 y dirección
 * Calle del Medio. Saldo inicial: 2000 euros. Una vez creadas las dos cuentas,
 * sobre la cuenta de Mortadelo han de realizarse las siguientes operaciones: Un
 * reintegro de 500 euros Un cambio de domicilio a la nueva dirección 13, Rue
 * del Percebe Una transferencia de la cuenta de Mortadelo a la de Filemón, de
 * una cantidad de 500 euros. Una segunda transferencia de la cuenta de
 * Mortadelo a la de Filemón, de una cantidad de 500 euros Un reintegro de la
 * cuenta de Mortadelo de 7 euros.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 * 
 */
public class TestCuentas {
	private static Menu menu = new Menu(new String[] { "Crear Cuenta",
			"Crear Cliente", "Modificar Direccion", "Mostrar Cliente",
			"Ingresar Dinero", "Reintegro", "Trasferencia", "Mostrar Cuenta",
			"Eliminar Cliente", "Mostrar todas las cuentas" }, "Banco de 1DAW");

	private static CuentaBancaria cuentasBancarias = new CuentaBancaria();
	private static Clientes clientes = new Clientes();

	public static void main(String[] args) {
		while (true) {
			gestionarBanco();
		}
	}

	/**
	 * Metodo que gestiona un banco.
	 */
	static void gestionarBanco() {
		switch (menu.gestionarMenu()) {
		case 1:
			crearCuentaBancaria();
			break;
		case 2:
			crearCliente();
			break;
		case 3:
			modificarDireccion();
			break;
		case 4:
			mostrarCliente();
			break;
		case 5:
			ingresarDinero();
			break;
		case 6:
			reintegro();
			break;
		case 7:
			transferirSaldo();
			break;
		case 8:
			mostrarCuenta();
			break;
		case 9:
			eliminarCliente();
			break;
		case 10:
			mostrarCuentasBancarias();
			break;
		case 11:
			System.exit(0);
		}
	}

	/**
	 * Metodo que muestra un cliente.
	 */
	private static void mostrarCliente() {
		try {
			Persona persona = clientes.getCliente(Teclado
					.leerCadena("Cual es su DNI?"));
			System.out.println(persona);
		} catch (DniInvalidoException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que modifica una direccion de un cliente.
	 */
	private static void modificarDireccion() {
		try {
			Persona persona = clientes.getCliente(Teclado
					.leerCadena("Cual es su DNI?"));
			persona.modificarDireccion(Teclado
					.leerCadena("Cual es su nueva direccion?"));
			System.out.println("La direccion ha sido modificada.");
		} catch (DniInvalidoException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que elimina un cliente y todas sus cuentas, pero antes el cliente
	 * retira su dinero.
	 */
	private static void eliminarCliente() {
		try {
			Persona persona = clientes.getCliente(Teclado
					.leerCadena("Cual es su DNI?"));
			cuentasBancarias.eliminarCuentas(persona);
			clientes.eliminarPersona(persona);
			System.out.println("El cliente ha sido eliminado.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("El cliente no existe.");
		} catch (DniInvalidoException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que transfiere el saldo de una cuenta a otra.
	 */
	private static void transferirSaldo() {
		try {
			Cuenta cuenta = cuentasBancarias.getCuenta();
			cuenta.transferencia(
					Teclado.leerDecimal("Cuanto desea transferir?"),
					cuentasBancarias.getCuenta());
			System.out.println("La transferencia se ha realizado con exito.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("La cuenta no existe.");
		} catch (NumerosRojosException | BancoVacioException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que realiza un reintegro en una cuenta.
	 */
	private static void reintegro() {
		try {
			cuentasBancarias.getCuenta().reintegro(
					Teclado.leerDecimal("De cuanto es el reintegro?"));
			System.out.println("Reintegro realizado.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("La cuenta no existe.");
		} catch (NumerosRojosException | BancoVacioException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que muestra una cuenta.
	 */
	private static void mostrarCuenta() {
		try {
			System.out.println(cuentasBancarias.getCuenta());
		} catch (IndexOutOfBoundsException e) {
			System.err.println("La cuenta no existe.");
		} catch (BancoVacioException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que ingresa dinero en una cuenta.
	 */
	private static void ingresarDinero() {
		try {
			cuentasBancarias.getCuenta().incrementarSaldo(
					Teclado.leerDecimal("Cuanto desea ingresar en su cuenta."));
			System.out.println("Ha sido ingresado con exito");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("La cuenta no existe.");
		} catch (NumerosRojosException | BancoVacioException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que crea una cuenta bancaria.
	 */
	private static void crearCuentaBancaria() {
		try {
			Persona persona = clientes.getCliente(Teclado
					.leerCadena("Cual es su DNI?"));
			Cuenta cuenta = new Cuenta(persona, Teclado.leerEntero("Cuanto saldo desea insertar?"));
			cuentasBancarias.annadirCuenta(cuenta);
			System.out.println("Su codigo de cuenta es: " + cuenta.getId());
		} catch (DniInvalidoException | NumerosRojosException
				| CuentaExisteException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Metodo que crea un cliente.
	 */
	private static void crearCliente() {
		try {
			Persona persona = new Persona(
					Teclado.leerCadena("Introduce tu nombre:"),
					Teclado.leerCadena("Introduce tu direccion: "),
					Teclado.leerCadena("Introduce tu DNI: "));
			clientes.annadirPersona(persona);
			System.out.println("Se ha creado el cliente.");
		} catch (DniInvalidoException | ClienteExisteException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void mostrarCuentasBancarias() {
		System.out.println(cuentasBancarias.mostrarCuentasBancarias());
	}
}
