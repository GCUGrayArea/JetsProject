package com.skilldistillery.jet;


public class Fighter extends Jet implements ForCombat {

	public Fighter( String model , int speed , int range , int price ) {

		super( model , speed , range , price ) ;

	}
	
	public void fight() {
		System.out.println( "dakka dakka dakka dakka dakka dakka dakka dakka dakka dakka dakka dakka" ) ;
	}

	@Override
	public int hashCode() {

		return super.hashCode() ;

	}

	@Override
	public boolean equals( Object obj ) {

		if ( this == obj )
			return true ;
		if ( !super.equals( obj ) )
			return false ;
		if ( getClass() != obj.getClass() )
			return false ;
		return true ;

	}

	@Override
	public String toString() {

		return String.format( 
				"Fighter [getModel()=%s, getSpeed()=%s, getRange()=%s, getPrice()=%s]" ,
				getModel() ,
				getSpeed() ,
				getRange() ,
				getPrice() ) ;

	}
	
	
	
}
