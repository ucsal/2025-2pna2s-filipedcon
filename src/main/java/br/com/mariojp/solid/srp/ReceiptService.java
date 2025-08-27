package br.com.mariojp.solid.srp;

public class ReceiptService {
	public String generate(Order order) {
		TaxCalculator taxCalcObjeto = new TaxCalculator();
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		double tax = taxCalcObjeto.calcTax(subtotal, 0.38);
		double total = subtotal + tax;
		StringBuilder sb = new StringBuilder(); //Formatando o Recibo
		sb.append("=== RECIBO ===\n");
		for (var i : order.getItems()) {
			sb.append(i.getName()).append(" x").append(i.getQuantity()).append(" = ").append(i.getUnitPrice() * i.getQuantity())
					.append("\n");
		}
		sb.append("Subtotal: ").append(subtotal).append("\n");
		sb.append("Tax: ").append(tax).append("\n");
		sb.append("Total: ").append(total).append("\n");
		return sb.toString();
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
