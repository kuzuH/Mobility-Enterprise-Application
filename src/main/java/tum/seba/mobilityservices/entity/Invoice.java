package tum.seba.mobilityservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double price;
	private boolean isPaid;
	
	public Invoice() {}
	
	public Invoice(double price, boolean isPaid) {
		this.price = price;
		this.isPaid = isPaid;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isPaid() {
		return isPaid;
	}
	
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", price=" + price + ", isPaid=" + isPaid + "]";
	}

}
