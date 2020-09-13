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


	@Override
	public String toString() {

		return String.format(
			"%s Cargo Plane - Speed %d mph, range %d miles, max. cargo load %s lb. Unit Cost %d dollars" ,
				getModel() ,
				getSpeed() ,
				getRange() ,
				getCargoCapacity() ,
				getPrice() ) ;

	}

}
