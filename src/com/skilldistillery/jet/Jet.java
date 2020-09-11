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
				"This %s can fly for %.1f hours at Mach %.1f.%n" ,
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

	@Override
	public int hashCode() {

		final int prime = 31 ;
		int result = 1 ;
		long temp ;
		temp = Double.doubleToLongBits( MACH ) ;
		result = prime * result + ( int ) ( temp ^ ( temp >>> 32 ) ) ;
		result = prime * result + ( ( model == null ) ? 0 : model.hashCode() ) ;
		result = prime * result + price ;
		result = prime * result + range ;
		result = prime * result + speed ;
		return result ;

	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj )
			return true ;
		if ( obj == null )
			return false ;
		if ( getClass() != obj.getClass() )
			return false ;
		Jet other = ( Jet ) obj ;
		if ( Double.doubleToLongBits( MACH ) != Double.doubleToLongBits( other.MACH ) )
			return false ;
		if ( model == null ) {
			if ( other.model != null )
				return false ;
		} else if ( !model.equals( other.model ) )
			return false ;
		if ( price != other.price )
			return false ;
		if ( range != other.range )
			return false ;
		if ( speed != other.speed )
			return false ;
		return true ;

	}

	@Override
	public String toString() {

		return String.format(
				"Jet [getModel()=%s, getSpeed()=%s, getRange()=%s, getPrice()=%s]" ,
				getModel() ,
				getSpeed() ,
				getRange() ,
				getPrice() ) ;

	}
	
	

}
