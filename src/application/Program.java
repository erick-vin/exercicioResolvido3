package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Product;
import entities.enums.OrderStatus;
import entities.OrdemItem;
import entities.Order;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter Cliente Data: ");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client cliente = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		Date dateCurrent = new Date();
		Order order = new Order(dateCurrent, OrderStatus.valueOf(status));
		order.setCliente(cliente);
		
		System.out.println("How many items to this order? ");
		int quantityItens = sc.nextInt();
		
		for(int i=1; i<= quantityItens; i++) {
			System.out.println("Enter #" + i + " item data: " );
			System.out.print("Product name: ");
			String nameProduct = sc.next();
			
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			Product produto = new Product(nameProduct, priceProduct);
			OrdemItem orderItem = new OrdemItem(quantity, produto);
			order.addItens(orderItem);
			
		}
		
		System.out.println(order);
		
		
		sc.close();

	}

}
