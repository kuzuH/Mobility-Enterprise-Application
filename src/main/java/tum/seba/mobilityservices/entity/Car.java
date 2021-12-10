package tum.seba.mobilityservices.entity;

import java.util.Date;

public class Car extends Vehicle {
	
	private int numberOfSeats;
	private int horsePower;
	private String fuelType;
	private int currentMileage;
	
	public Car(String manufacturer, String modelType, Date lastService, boolean isAvailable, int numberOfSeats,
			int horsePower, String fuelType, int currentMileage) {
		super(manufacturer, modelType, lastService, isAvailable);
		this.numberOfSeats = numberOfSeats;
		this.horsePower = horsePower;
		this.fuelType = fuelType;
		this.currentMileage = currentMileage;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getCurrentMileage() {
		return currentMileage;
	}

	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}

	@Override
	public String toString() {
		return "Car [numberOfSeats=" + numberOfSeats + ", horsePower=" + horsePower + ", fuelType=" + fuelType
				+ ", currentMileage=" + currentMileage + "]";
	}

}
