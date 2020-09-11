package com.skilldistillery.jet ;

public class CargoHauler extends Jet implements ForCargo {

	private int cargoCapacity ;

	public CargoHauler( String model , int speed , int range , int price , int cargoCapacity ) {

		super( model , speed , range , price ) ;
		this.setCargoCapacity( cargoCapacity );

	}

	
	public int getCargoCapacity() {
	
		return cargoCapacity ;
	
	}

	
	public void setCargoCapacity( int cargoCapacity ) {
	
		this.cargoCapacity = cargoCapacity ;
	
	}

	public void loadCargo() {

		System.out.printf(
				"Loading up to %d pounds of cargo into the %s.%n" ,
				this.getCargoCapacity() ,
				this.getModel() ) ;

	}

}
