/**
 * Paquete examenMarzo.
 */
package examenMarzo;

/**
 * Clase Cuenta.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class Cuenta {
	private Persona persona;
	private double saldo;
	private static int codigoCuenta = 1;
	private int id;

	Cuenta(Persona persona, int saldo) throws NumerosRojosException {
		setPersona(persona);
		setSaldo(saldo);
		setId();
	}

	Cuenta(int id) {
		setId(id);
	}

	int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private void setId() {
		this.id = codigoCuenta++;
	}

	/**
	 * Metodo que incrementa el saldo de una cuenta.
	 * 
	 * @param saldo
	 *            La cantidad de saldo que se va a incrementar.
	 * @throws NumerosRojosException
	 */
	void incrementarSaldo(double saldo) throws NumerosRojosException {
		if (!comprobarSaldoPositivo(saldo))
			throw new NumerosRojosException("El saldo no puede ser negativo");
		setSaldo(getSaldo() + saldo);
	}

	/**
	 * Metodo que decrementa el saldo de una cuenta.
	 * 
	 * @param saldo
	 *            La cantidad que se decrementa.
	 * @throws NumerosRojosException
	 */
	void reintegro(double saldo) throws NumerosRojosException {
		if (!comprobarSaldoPositivo(saldo))
			throw new NumerosRojosException("El saldo no puede ser negativo");
		setSaldo(getSaldo() - saldo);
	}

	/**
	 * Metodo que transfiere saldo de una cuenta a otra
	 * 
	 * @param saldo
	 *            Saldo que se transfiere
	 * @param cuenta
	 *            Cuenta a la que se le transfiere el saldo.
	 * @throws NumerosRojosException
	 *             si el saldo es negativo o es mayor que el saldo de la cuenta.
	 */
	void transferencia(double saldo, Cuenta cuenta)
			throws NumerosRojosException {
		reintegro(saldo);
		cuenta.incrementarSaldo(saldo);
	}

	/**
	 * Metodo que comprueba que el saldo no sea negativo.
	 * 
	 * @param saldo
	 *            Saldo que se comprueba.
	 * @return Devuelve true si el saldo es positivo, false en caso contrario.
	 */
	boolean comprobarSaldoPositivo(double saldo) {
		if (saldo < 0)
			return false;
		return true;
	}

	Persona getPersona() {
		return persona;
	}

	private void setPersona(Persona persona) {
		this.persona = persona;
	}

	double getSaldo() {
		return saldo;
	}

	private void setSaldo(double saldo) throws NumerosRojosException {
		if (!comprobarSaldoPositivo(saldo))
			throw new NumerosRojosException(
					"La cuenta no se puede quedar en numeros rojos.");
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [Codigo= " + getId() + " persona=" + persona.getNombre()
				+ ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Cuenta other = (Cuenta) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
