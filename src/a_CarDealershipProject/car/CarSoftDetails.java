package a_CarDealershipProject.car;

public class CarSoftDetails {
	
	private String paintColor;
	private double widht;
	private double height;
	private boolean whiteLamps;
	
	public CarSoftDetails(String paintColor, double width, double height, boolean whiteLamps) {
		super();
		this.paintColor = paintColor;
		this.widht = width;
		this.height = height;
		this.whiteLamps = whiteLamps;
	}
	
	public String toString() {
		return (" car is of " + this.paintColor + " color and has a width and height of " + this.widht + " and " + this.height + " respectively and has" + (this.whiteLamps? "":" no") + " whitelamps");
	}

	public String getPaintColor() {
		return paintColor;
	}

	public void setPaintColor(String paintColor) {
		this.paintColor = paintColor;
	}

	public double getWidht() {
		return widht;
	}

	public void setWidht(double widht) {
		this.widht = widht;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isWhiteLamps() {
		return whiteLamps;
	}

	public void setWhiteLamps(boolean whiteLamps) {
		this.whiteLamps = whiteLamps;
	}
	
	
}
