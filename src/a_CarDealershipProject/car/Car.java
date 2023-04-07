package a_CarDealershipProject.car;

import java.io.Serializable;
import java.util.Date;


/*
 * car -> suv, sedan, small, 
 * car -> electric, semi-electric
 */
public abstract class Car implements Cloneable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int carid; //autoincrements
	private String carBrand;
	private String carModel;
	private Date releaseYear;
	private boolean isLuxury;
	private boolean isPetrol;
	private double costPrice;
	private double markedPrice;
	private double sellingPrice;
	private CarSoftDetails carSoftDetails; //aggregation
	private CarTechDetails carTechDetails;
	
	//constructor1
	public Car(String carBrand, String carModel, Date releaseYear, boolean isLuxury, boolean isPetrol, double costPrice, double markedPrice, CarSoftDetails carSoftDetails, CarTechDetails carTechDetails) {
		super();
		this.carid++;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.releaseYear = releaseYear;
		this.isLuxury = isLuxury;
		this.isPetrol = isPetrol;
		this.costPrice = costPrice;
		this.markedPrice = markedPrice;
		this.carSoftDetails = carSoftDetails;
		this.carTechDetails = carTechDetails;
	}
	
	//constructor2
	public Car(String carBrand, String carModel, Date releaseYear, boolean isLuxury, boolean isPetrol, double costPrice, double markedPrice, double sellingPrice, CarSoftDetails carSoftDetails, CarTechDetails carTechDetails) {
		super();
		this.carid++;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.releaseYear = releaseYear;
		this.isLuxury = isLuxury;
		this.isPetrol = isPetrol;
		this.costPrice = costPrice;
		this.markedPrice = markedPrice;
		this.sellingPrice = sellingPrice;
		this.carSoftDetails = carSoftDetails;
		this.carTechDetails = carTechDetails;
	}
	
	//tostring
	public String toString() {
		return ("this is carBrand : " + carBrand + " and carModel :" + carModel + " released in : " + releaseYear + 
				" costed the dealership amount of Rs. " + costPrice + " and is marked at :" + markedPrice + 
				"  and is sold at : " + sellingPrice + " having the following tech details : " + this.carTechDetails + " and following"
				+" soft details : " + this.carSoftDetails);
	}
	
	//getters and setters
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	
	public String getCarBrand() {
		return this.carBrand;
	}
	
	public void setCarModel(String carModel)
	{
		this.carModel = carModel;
	}
	
	public String getCarModel() {
		return this.carModel;
	}
	
	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public boolean isLuxury() {
		return isLuxury;
	}

	public void setLuxury(boolean isLuxury) {
		this.isLuxury = isLuxury;
	}

	public boolean isPetrol() {
		return isPetrol;
	}

	public void setPetrol(boolean isPetrol) {
		this.isPetrol = isPetrol;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(double markedPrice) {
		this.markedPrice = markedPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public CarSoftDetails getCarSoftDetails() {
		return carSoftDetails;
	}

	public void setCarSoftDetails(CarSoftDetails carSoftDetails) {
		this.carSoftDetails = carSoftDetails;
	}

	public CarTechDetails getCarTechDetails() {
		return carTechDetails;
	}

	public void setCarTechDetails(CarTechDetails carTechDetails) {
		this.carTechDetails = carTechDetails;
	}

	
	public double calculateProfit() {
		return this.sellingPrice - this.costPrice;
	}
	
	public double calculateProfitPercentage() {
		return ((this.sellingPrice - this.costPrice )/this.costPrice ) * 100;
	}
	
}
