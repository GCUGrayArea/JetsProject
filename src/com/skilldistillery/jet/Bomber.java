package com.skilldistillery.jet;

public class Bomber extends Jet implements ForCombat {

	private int bombLoad;
	
	public Bomber( String model , int speed , int range , int price, int bombLoad ) {

		super( model , speed , range , price ) ;
		this.setBombLoad( bombLoad );

	}
	
	public int getBombLoad() {
	
		return bombLoad ;
	
	}
	
	public void setBombLoad( int bombLoad ) {
	
		this.bombLoad = bombLoad ;
	
	}
	
	public void fight() {
		
		System.out.printf( "%s bomber preparing for sortie. We have up to %d pounds of bombs to drop.%n" ,
			this.getModel() ,
			this.getBombLoad() );
	}

	@Override
	public int hashCode() {

		final int prime = 31 ;
		int result = super.hashCode() ;
		result = prime * result + bombLoad ;
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
		Bomber other = ( Bomber ) obj ;
		if ( bombLoad != other.bombLoad )
			return false ;
		return true ;

	}

	@Override
	public String toString() {

		return String.format(
				"%s Bomber - Speed %d mph, range %d miles, max. bomb load %s lb. Unit Cost %d dollars" ,
				getModel() ,
				getSpeed() ,
				getRange() ,
				getBombLoad() ,
				getPrice() ) ;
	}

}
