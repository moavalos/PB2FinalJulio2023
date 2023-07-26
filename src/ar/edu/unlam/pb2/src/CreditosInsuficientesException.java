package ar.edu.unlam.pb2.src;

public class CreditosInsuficientesException extends Exception {

	public CreditosInsuficientesException() {
		super("Créditos insuficientes para realizar la compra.");
	}

}
