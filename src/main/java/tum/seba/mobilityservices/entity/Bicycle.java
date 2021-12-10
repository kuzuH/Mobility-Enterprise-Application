package tum.seba.mobilityservices.entity;

import java.util.Date;

	public class Bicycle extends Vehicle {
	private int numberOfGears;
	private boolean isElectrical;
	
	public Bicycle(String manufacturer, String modelType, Date lastService, boolean isAvailable, int numberOfGears,
			boolean isElectrical) {
		super(manufacturer, modelType, lastService, isAvailable);
		this.numberOfGears = numberOfGears;
		this.isElectrical = isElectrical;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public boolean isElectrical() {
		return isElectrical;
	}

	public void setElectrical(boolean isElectrical) {
		this.isElectrical = isElectrical;
	}

	@Override
	public String toString() {
		return "Bicycle [numberOfGears=" + numberOfGears + ", isElectrical=" + isElectrical + "]";
	}

}
