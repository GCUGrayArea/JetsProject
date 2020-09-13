package com.skilldistillery.jet;


public class AirLiner extends Jet implements ForPeople {

	private int passengerCapacity;
	
	public AirLiner( String model , int speed , int range , int price, int passengerCapacity ) {

		super( model , speed , range , price ) ;
		this.setPassengerCapacity( passengerCapacity );

	}

	
	public int getPassengerCapacity() {
	
		return passengerCapacity ;
	
	}

	
	public void setPassengerCapacity( int passengerCapacity ) {
	
		this.passengerCapacity = passengerCapacity ;
	
	}
	
	public void passengerFlight() {
		System.out.printf( "Preparing to fly up to %d passengers a distance of up to %d miles.%n" ,
				this.getPassengerCapacity() ,
				this.getRange() );
	}


	@Override
	public int hashCode() {

		final int prime = 31 ;
		int result = super.hashCode() ;
		result = prime * result + passengerCapacity ;
		return result ;

	}


	@Override
	public boolean equals( Object obj ) {

		if ( this == obj )
			return true ;
		if ( !super.equals( obj ) )
			return false ;
		if ( getClass() != obj.getClass() )
			return false ;
		AirLiner other = ( AirLiner ) obj ;
		if ( passengerCapacity != other.passengerCapacity )
			return false ;
		return true ;

	}


	@Override
	public String toString() {

		return String.format(
				"%s Airliner - Speed %d mph, range %d miles, seats %d passengers. Unit Cost %d dollars" ,
				getModel() , 
				getSpeed() , 
				getRange() ,
				getPassengerCapacity() ,
				getPrice() ) ;

	}
	
}
