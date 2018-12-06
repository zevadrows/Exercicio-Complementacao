package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import application.enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYY): ");
		String birth = sc.next();
		Date birthDate = sdf1.parse(birth);
		
		Client client = new Client(clientName, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		Order order = new Order(new Date(System.currentTimeMillis()), OrderStatus.valueOf(orderStatus), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String name = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(name, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("\nORDER SUMMARY: ");
		System.out.println(order);
		
		
		sc.close();
	}

}
