package a_CarDealershipProject.car;

import java.util.Date;

public abstract class SUV extends Car{

	private int[] protectionLevelArray = new int[] {1,3,5,7};
	private int protectionLevel;
	
	public SUV(String carBrand, String carModel, Date releaseYear, boolean isLuxury, boolean isPetrol, double costPrice,
			double markedPrice, CarSoftDetails carSoftDetails, CarTechDetails carTechDetails) {
		super(carBrand, carModel, releaseYear, isLuxury, isPetrol, costPrice, markedPrice, carSoftDetails, carTechDetails);
		// TODO Auto-generated constructor stub
	}
	
	public SUV(String carBrand, String carModel, Date releaseYear, boolean isLuxury, boolean isPetrol, double costPrice,
			double markedPrice, double sellingPrice, CarSoftDetails carSoftDetails, CarTechDetails carTechDetails) {
		super(carBrand, carModel, releaseYear, isLuxury, isPetrol, costPrice, markedPrice, sellingPrice, carSoftDetails, carTechDetails);
		// TODO Auto-generated constructor stub
	}

}
