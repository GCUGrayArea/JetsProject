package com.skilldistillery.jet;


public class JetsApplication {
	private AirField airfield;
	
	public JetsApplication( String fileName ) {
			this.airfield = new AirField( fileName );
	}

	public static void main( String[] args ) {
		/*
		 * User Story #1: Create a JetsApplication with a main method to launch your program.
		 * Done a few dozen times at this point. Got it working at a minimum.
		 */
		
		boolean inMenu;
		
		java.util.Scanner kb = new java.util.Scanner( System.in );
		JetsApplication app = new JetsApplication("planes.txt");

		do {
			inMenu = app.mainMenu( kb );
		} while ( inMenu ) ;
		
		app = null;
		kb.close();
	}
	
	private void printJets() {
		//Menu option 1: List fleet
		
		/*
		 * User Story #5 List fleet prints out the model, speed, range, and price of
		 * each jet. (There must be at least 5 jets stored when the program starts).
		 */
		
		if ( this.airfield.getPlanes().size() < 5 ) {
			throw new RuntimeException("Not enough planes. The airfield must contain at least 5.");
		}
		
		for ( Jet i : this.airfield.getPlanes() ) {
			System.out.println( i ) ;
		}
	}
	
	private void flyJets() {
		//Menu option 2: Fly all jets
		
		/*
		 * User Story #6:
		 * Fly all Jets calls the fly() method on the entire fleet of jets. fly() prints
		 * out the jet details and the amount of time the jet can fly until it runs out
		 * of fuel (based on speed and range).
		 */	
		
		for ( Jet i : this.airfield.getPlanes() ) {
			i.fly();
		}
	}
	
	private void fastestJet() {
		//Menu option 3: View fastest jet
		
		//	User Story #7:
		//	The view fastest jet and longest range options both print out all of the information about a jet.
		//	Note: these methods must search the collection of jets to find the appropriate jet.
		
		Jet fastest = this.airfield.getPlanes().get( 0 );
		for ( Jet i : this.airfield.getPlanes() ) {
			if ( i.getSpeed() > fastest.getSpeed() ) {
				fastest = i;
			}
		}
		System.out.println( "The fastest jet at this airfield is: " ) ;
		System.out.println( fastest ) ;
	}
	
	private void longestRange() {
		//Menu option 4: View jet with longest range
		
		//	User Story #7:
		//	The view fastest jet and longest range options both print out all of the information about a jet.
		//	Note: these methods must search the collection of jets to find the appropriate jet.

		Jet farthest = this.airfield.getPlanes().get( 0 );
		for ( Jet i : this.airfield.getPlanes() ) {
			if ( i.getRange() > farthest.getRange() ) {
				farthest = i;
			}
		}
		System.out.println( "The longest-range jet at this airfield is: " ) ;
		System.out.println( farthest ) ;
	}
	
	private void loadCargoPlanes() {
		//Menu option 5: load all cargo planes
		for( Jet i : this.airfield.getPlanes() ) {
			try {
				( ( CargoHauler ) i ).loadCargo();
			}
			catch (ClassCastException e) {
				continue;
			}
		}
	}
	
	private void dogFight() {
		//Menu option 6: dogfight!
		for( Jet i : this.airfield.getPlanes() ) {
			try {
				( ( ForCombat ) i ).fight();
			}
			catch (ClassCastException e) {
				continue;
			}
		}
	}
	
	private void printMainMenu() {
		
		System.out.println( "==================================" );
		System.out.println( "* 1. List fleet                  *");
		System.out.println( "* 2. Fly all jets                *");
		System.out.println( "* 3. View fastest jet            *");
		System.out.println( "* 4. View jet with longest range *" );
		System.out.println( "* 5. Load all Cargo Jets         *" );
		System.out.println( "* 6. Dogfight!                   *" );
		System.out.println( "* 7. Add a jet to Fleet          *" );
		System.out.println( "* 8. Remove a jet from Fleet     *" );
		System.out.println( "* 9. Quit                        *" ) ;
		System.out.println( "==================================" );
		
	}
	
	private boolean mainMenu( java.util.Scanner kb ) {
		
		/*
		 * main() calls this in a do-while, so the option to return false is all that
		 * can cause this program to end. return false; means quit, return true will
		 * result in this method being called again by the loop.
		 */
		
		int menuSelection;
		printMainMenu();
		System.out.print( "What would you like to do? " ) ;
		menuSelection = kb.nextInt();
		kb.nextLine();
		
		switch ( menuSelection ) {
			case 9:
				//User story #11: quit exits the program
				System.out.println( "Come back soon!" ) ;
				return false;
			case 1:
				this.printJets();
				break;
			case 2:
				this.flyJets();
				break;
			case 3:
				this.fastestJet();
				break;
			case 4:
				this.longestRange();
				break;
			case 5:
				this.loadCargoPlanes();
				break;
			case 6:
				this.dogFight();
				break;
			case 7:
				this.airfield.addJet( kb );
				break;
			case 8:
				this.airfield.removeJet( kb );
				break;
			default:
				System.out.println( "Input not recognized. Select a valid option." ) ;
		}
			return true;
		
		
		
	}
	
	
	
	

}
