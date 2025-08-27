package br.com.mariojp.solid.srp;

public class TaxCalculator {
//  TaxCalculator → responsável por calcular o imposto a partir de uma taxa configurável
//	double tax = subtotal * 0.10; //Taxa 10 fixa :(

	public double calcTax(double subtotalRecebido, double taxRecebido) {
		double taxAtual = subtotalRecebido * taxRecebido;
		return taxAtual;
	}
	
}
