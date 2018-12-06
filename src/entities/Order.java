package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

	private Date momment = new Date(System.currentTimeMillis());
	private OrderStatus status;

	List<OrderItem> orderItem = new ArrayList<>();

	public void addItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}

	public double total() {
		double sum = 0;
		for (OrderItem o : orderItem) {
			sum += o.subTotal();
		}
		return sum;
	}

	public String getMomment() {
		return sdf2.format(momment);
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Order(OrderStatus status) {
		this.status = status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	Client client;
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nOrder momment: ");
		sb.append(getMomment());
		sb.append("\nOrder Status: ");
		sb.append(status);
		sb.append("\nClient: " + client.getBirthDate() + "- " + client.getEmail());
		sb.append("\nOrder items:");
		for (OrderItem o : orderItem) {
			sb.append("\n" + o.getProduct().getName() + ", " + String.format("$%.2f", o.getProduct().getPrice()) + ", Quantity: " + o.getQuantity() + ", Subtotal: " + String.format("$%.2f", o.subTotal()));
		}
		sb.append("\nTotal price: " + String.format("$%.2f", this.total()));
		return sb.toString();
	}
}
