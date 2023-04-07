package a_CarDealershipProject.car;

public class CarTechDetails {

	private double horsepower;
	private int engineCC;
	private int cylinders;
	private String engineBrand;
	
	public CarTechDetails(double horsepower, int engineCC, int cylinders, String engineBrand) {
		super();
		this.horsepower = horsepower;
		this.engineCC = engineCC;
		this.cylinders = cylinders;
		this.engineBrand = engineBrand;
	}

	@Override
	public String toString() {
		return "CarTechDetails [horsepower=" + horsepower + ", engineCC=" + engineCC + ", cylinders=" + cylinders
				+ ", engineBrand=" + engineBrand + "]";
	}

	public double getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(double horsepower) {
		this.horsepower = horsepower;
	}

	public int getEngineCC() {
		return engineCC;
	}

	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	public String getEngineBrand() {
		return engineBrand;
	}

	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}
	
	
	
}
