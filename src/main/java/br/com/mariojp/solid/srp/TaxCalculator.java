package br.com.mariojp.solid.srp;

public class TaxCalculator {
	public double calcTax(double subtotalRecebido, double taxRecebido) {
		double taxAtual = subtotalRecebido * taxRecebido;
		return taxAtual;
	}
}
