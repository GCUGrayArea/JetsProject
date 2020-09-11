package com.skilldistillery.jet;


public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private int price;
	public final double MACH = 767.27;
	
	//only constructible with all fields provided
	public Jet( String model , int speed , int range , int price ) {
		
		this.setModel(model) ;
		this.setSpeed(speed) ;
		this.setRange(range) ;
		this.setPrice(price );

	}

	public void fly() {
		System.out.printf(
				"This %s can fly for %.1f hours at Mach %.1f." ,
				model ,
				(((double) this.range) / this.speed ) ,
				this.speed / MACH);
	}

	
	public String getModel() {
	
		return model ;
	
	}

	
	public int getSpeed() {
	
		return speed ;
	
	}
	
	public double getSpeedMach() {
		return this.getSpeed() / MACH;
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
