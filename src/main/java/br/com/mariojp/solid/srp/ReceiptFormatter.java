package br.com.mariojp.solid.srp;

public class ReceiptFormatter {
//  ReceiptFormatter → responsável apenas por montar o texto do recibo
	
	public StringBuilder montaRecibo(Order order, double subtotal, double tax, double total){
		StringBuilder sb = new StringBuilder(); //Formatando o Recibo
		sb.append("=== RECIBO ===\n");
		for (var i : order.getItems()) {
			sb.append(i.getName()).append(" x").append(i.getQuantity()).append(" = ").append(i.getUnitPrice() * i.getQuantity())
					.append("\n");
		}
		sb.append("Subtotal: ").append(subtotal).append("\n");
		sb.append("Tax: ").append(tax).append("\n");
		sb.append("Total: ").append(total).append("\n");
		return sb;
	}
}
//StringBuilder sb = new StringBuilder(); //Formatando o Recibo
//sb.append("=== RECIBO ===\n");
//for (var i : order.getItems()) {
//	sb.append(i.getName()).append(" x").append(i.getQuantity()).append(" = ").append(i.getUnitPrice() * i.getQuantity())
//			.append("\n");
//}