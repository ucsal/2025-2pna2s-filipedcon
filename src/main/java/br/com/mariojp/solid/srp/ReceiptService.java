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

//No código atual, a classe ReceiptService viola o Princípio da Responsabilidade Única (SRP) 
//porque acumula múltiplas funções:
//
//    Calcula o subtotal do pedido
//
//    Aplica a taxa de imposto (fixa em 10%)
//
//    Formata o recibo em texto
//
//Além disso, a taxa de imposto está hardcoded (10%) em vez de ser configurável.
//
//Por isso, os testes configuram System.setProperty("tax.rate", "0.08") (8%) e 
//esperam que o recibo reflita essa taxa. Na implementação inicial, o serviço 
//	ignora essa configuração e os testes falham.

//Seu desafio
//
//Refatore o código de forma que cada classe tenha uma única responsabilidade:
//
//    TaxCalculator → responsável por calcular o imposto a partir de uma taxa configurável
//
//    ReceiptFormatter → responsável apenas por montar o texto do recibo
//
//    ReceiptService → orquestra: calcula subtotal, aplica imposto usando o TaxCalculator 
//    e gera o recibo usando o ReceiptFormatter
