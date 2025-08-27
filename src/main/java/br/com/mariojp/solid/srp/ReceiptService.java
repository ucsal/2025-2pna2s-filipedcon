package br.com.mariojp.solid.srp;

public class ReceiptService {
	public String generate(Order order) {
		TaxCalculator taxCalcObjeto = new TaxCalculator();
		String taxRateString = System.getProperty("tax.rate");
		double tax = Double.parseDouble(taxRateString);
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		double taxEmValor = taxCalcObjeto.calcTax(subtotal, tax);
		double total = subtotal + taxEmValor;
		ReceiptFormatter montaRecibo = new ReceiptFormatter();
		StringBuilder recibo = montaRecibo.montaRecibo(order, subtotal, taxEmValor, total);
		return recibo.toString();
	}
}
