package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;


public class Order {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client cliente;
	private List<OrdemItem> itens = new ArrayList<>();
	
	
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List<OrdemItem> getItens(){
		return itens;
	}
	
	public Client getCliente() {
		return cliente;
	}
	
	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
	public void addItens(OrdemItem item) {
		itens.add(item);
	}
	
	public void removeItens(OrdemItem item) {
		itens.add(item);
	}
	
	public Double valueTotal() {
		
		Double sum = 0.0;
		
		for(OrdemItem c : itens) {
			sum += c.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		StringBuilder summary = new StringBuilder();
		summary.append("\nOrder Summary: \n");
		summary.append("\nOrder moment: " + sdf.format(moment));
		summary.append("\nOrder status: " + status);
		summary.append("\nClient: " + cliente.getName());
		summary.append("(" + cliente.getBirthDate() + ") - ");
		summary.append(cliente.getEmail());
		summary.append("\n Order items: ");
		for(OrdemItem c : itens) {
			summary.append(c.getName() + ", ");
			summary.append(c.getQuantity() + ", ");
			summary.append("Subtotal: " + c.subTotal() + "\n");
		}
		summary.append("Total price: " + valueTotal());
		return summary.toString();
	}
}
