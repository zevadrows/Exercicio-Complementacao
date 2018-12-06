package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	private Client client;

	List<OrderItem> orderItem = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

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
		return sdf2.format(moment);
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nOrder moment: ");
		sb.append(getMomment());
		sb.append("\nOrder Status: ");
		sb.append(status);
		sb.append("\nClient: " + client);
		sb.append("\nOrder items:");
		for (OrderItem o : orderItem) {
			sb.append("\n" + o.getProduct().getName() + ", " + String.format("$%.2f", o.getProduct().getPrice()) + ", Quantity: " + o.getQuantity() + ", Subtotal: " + String.format("$%.2f", o.subTotal()));
		}
		sb.append("\nTotal price: " + String.format("$%.2f", this.total()));
		return sb.toString();
	}
}
