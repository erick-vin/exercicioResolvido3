package entities;

public class OrdemItem {
	
	private Integer quantity;
	private Product produto;
	
	public OrdemItem() {
	}
	
	public OrdemItem(Integer quantity, Product produto) {
		this.quantity = quantity;
		this.produto = produto;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getName() {
		return produto.getName();
	}
	
	public double subTotal() {
		return quantity * produto.getPrice();
	}
	
}
