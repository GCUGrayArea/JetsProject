package com.skilldistillery.jet;


public class Fighter extends Jet implements ForCombat {
	
	public int missiles;

	public Fighter( String model , int speed , int range , int price ) {

		super( model , speed , range , price ) ;
		this.missiles = 4;

	}
	
	public int getMissiles() {
		
		return this.missiles;
		
	}
	
	public void fight() {
		System.out.printf(
			"I'm a %s fighter! dakka dakka dakka dakka dakka dakka dakka dakka dakka dakka dakka dakka%n" ,
			this.getModel() ) ;
	}
	
	public void fight( Fighter enemy , java.util.Scanner kb ) {
		double odds = this.getSpeedMach() / ( this.getSpeedMach() + enemy.getSpeedMach() );
		int outcome = (Math.random() < odds ) ? 0 : 1;
		//sets a random cutoff for the odds of a successful strike that will always
		//be less than one so it can be compared directly to Math.random()
		//the +1 is added to compensate for the [0,1) range of Math.random()
		
		String[] results = new String[]
				{
						String.format(
							"BOOM!!! It hit!\n%s wins!" ,
							this.getModel() ) ,
						String.format(
							"WHOOOOOOSH... It missed!\nNow it's the %s's turn to shoot back..." ,
							enemy.getModel())
				};
		
		System.out.printf(
				"%s launching a missile at %s...%n" ,
				this.getModel() ,
				enemy.getModel() );

		this.missiles -= 1;
		
		if ( this.missiles == 0 ) {
			System.out.printf(
					"%s is out of missiles. Turn and burn!%n" ,
					this.getModel()) ;
		}
		
		System.out.println( results[outcome] ) ;
		
		if ( outcome != 0 ) {
			if ( this.getMissiles() == 0 && enemy.getMissiles() == 0 ) {
				System.out.printf(
						"But %s is out of missiles too and is going home. Looks like nothing blew up today...%n%n" ,
						enemy.getModel());
				return;
			} else {
					kb.nextLine();
					enemy.fight(this, kb);
				}
			}
		
		
		
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
				"%s Fighter - Speed %d mph, range %d miles. Unit Cost %d dollars" ,
				getModel() ,
				getSpeed() ,
				getRange() ,
				getPrice() ) ;

	}
	
	
	
}
