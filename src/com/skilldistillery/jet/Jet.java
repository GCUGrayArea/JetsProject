package com.skilldistillery.jet;


public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private int price;
	
	private void fly() {
		System.out.printf(
				"This %s can fly for %.1f hours at Mach %.1f." ,
				model ,
				(((double) this.range) / this.speed ) ,
				this.speed / 767.27);
	}

	
	public String getModel() {
	
		return model ;
	
	}

	
	public int getSpeed() {
	
		return speed ;
	
	}
	
	public double getSpeedMach() {
		return this.getSpeed() / 767.27;
	}

	
	public int getRange() {
	
		return range ;
	
	}

	
	public int getPrice() {
	
		return price ;
	
	}

	
	public void setModel( String model ) {
	
		this.model = model ;
	
	}

	
	public void setSpeed( int speed ) {
	
		this.speed = speed ;
	
	}

	
	public void setRange( int range ) {
	
		this.range = range ;
	
	}

	
	public void setPrice( int price ) {
	
		this.price = price ;
	
	}

}
