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
		setId(codigoCuenta++);
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

	/**
	 * Metodo que incrementa el saldo de una cuenta.
	 * 
	 * @param saldo
	 *            La cantidad de saldo que se va a incrementar.
	 * @throws NumerosRojosException 
	 */
	void incrementarSaldo(double saldo) throws NumerosRojosException {
		if(!comprobarSaldoValido(saldo))
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
	void decrementarSaldo(double saldo) throws NumerosRojosException {
		if (saldo >= getSaldo())
			throw new NumerosRojosException(
					"El reintegro es mayor que el saldo de la cuenta.");
		if(!comprobarSaldoValido(saldo))
			throw new NumerosRojosException("El saldo no puede ser negativo");
		setSaldo(getSaldo() - saldo);
	}
	
	boolean comprobarSaldoValido(double saldo){
		if(saldo<0)
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
		if(!comprobarSaldoValido(saldo))
			throw new NumerosRojosException("El saldo no puede ser negativo");
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
