package com.skilldistillery.jet;

import java.util.ArrayList ;
import java.util.InputMismatchException ;
import java.util.List ;

public class JetsApplication {
	private AirField airfield;
	private List<Pilot> pilots;
	
	public JetsApplication( String fileName ) {
			this.airfield = new AirField( fileName );
			this.pilots = new ArrayList<Pilot>();
			
			for( int i = 0 ; i < this.airfield.getPlanes().size() ; i++ ) {
				this.pilots.add( new Pilot() );
			}
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
		
		for ( int i = 0; i < this.airfield.getPlanes().size(); i++ ) {
			System.out.printf(
					"%d: %s%nPiloted by: %s%n", 
					i + 1 ,
					this.airfield.getPlanes().get( i ).toString() ,
					this.pilots.get( i ).toString() );
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
	
	private void dogFight( java.util.Scanner kb ) {
		//Menu option 6: dogfight! 
		
		//this first block makes sure there's at least one fighter or bomber.
		//Not much of a fight without those!
		//Other procedures will only happen if 
		ArrayList<ForCombat> warbirds = new ArrayList<ForCombat>();
		for ( Jet i : this.airfield.getPlanes() ) {
			try {
				warbirds.add( (ForCombat) i );
			}
			catch (ClassCastException e) {
				continue;
			}
		}
		
		if ( warbirds.size() == 0 ) { 
			System.out.println( "No fighters or bombers - there's nothing here to fight with!" ) ;
			return;
		}
		
		if ( Math.random() > 0.5 ) {
			//half the time, randomly selects a bomber and prepares it for a bombing run
			ArrayList<Bomber> bombers = new ArrayList<Bomber>();
			for( ForCombat i : warbirds ) {
				try {
					bombers.add( (Bomber) i );
				}
				catch (ClassCastException e) {
					continue;
				}
			}
			if ( bombers.size() > 0 ) {
				bombers.get( (int) (Math.random() * bombers.size() ) ).fight();
				return;
			}
		}
		
			//rest of the time, selects two random Fighters from the Airfield and has them shoot missiles at each other
			ArrayList<Fighter> fighters = new ArrayList<Fighter>();
			for( ForCombat i : warbirds ) {
				try {
					fighters.add( (Fighter) i );
				}
				catch (ClassCastException e) {
					//non-fighters will throw this exception, which is handled by ignoring
					//the corresponding list element and moving on
					continue;
				}
			}
			
			if ( fighters.size() == 1 ) {
				// no fight to be had if there's just one, so he'll have fun on his own
				fighters.get( 0 ).fight();
				return;
			}
			
			
			
			Fighter red = fighters.remove( (int) ( Math.random() * fighters.size() ) );
			Fighter blue = fighters.remove( (int) ( Math.random() * fighters.size() ) );
			
			red.fight(blue, kb);
			
	}
	
	private void printMainMenu() {
		
		System.out.println( " ================================ " );
		System.out.println( "/ 1. List fleet                  \\" );
		System.out.println( "\\ 2. Fly all jets                /" );
		System.out.println( "/ 3. Fly a specific jet          \\" );
		System.out.println( "\\ 4. View fastest jet            /" );
		System.out.println( "/ 5. View jet with longest range \\" );
		System.out.println( "\\ 6. Load all Cargo Jets         /" );
		System.out.println( "/ 7. Dogfight!                   \\" );
		System.out.println( "\\ 8. Add a jet to Fleet          /" );
		System.out.println( "/ 9. Remove a jet from Fleet     \\" );
		System.out.println( "\\ 0. View pilot roster           /" );
		System.out.println( "/ A. Hire a pilot                \\" );
		System.out.println( "\\ B. Quit                        /" );
		System.out.println( " ================================ " );
		
	}
	
	private boolean mainMenu( java.util.Scanner kb ) {
		
		/*
		 * main() calls this in a do-while, so the option to return false is all that
		 * can cause this program to end. return false; means quit, return true will
		 * result in this method being called again by the loop.
		 */
		
		char menuSelection;
		printMainMenu();
		System.out.print( "What would you like to do? " ) ;
		try {
			menuSelection = kb.nextLine().charAt( 0 );
		}
		catch ( StringIndexOutOfBoundsException e ) {
			System.out.println( "No input provided. Please select an option to do something, or enter B to quit" ) ;
			return true;
		}

		switch ( menuSelection ) {
			case 'B':
				//User story #11: quit exits the program
				System.out.println( "Come back soon!" ) ;
				return false;
			case '1':
				this.printJets();
				break;
			case '2':
				this.flyJets();
				break;
			case '3':
				this.flySpecificJet( kb );
				break;
			case '4':
				this.fastestJet();
				break;
			case '5':
				this.longestRange();
				break;
			case '6':
				this.loadCargoPlanes();
				break;
			case '7':
				this.dogFight( kb );
				break;
			case '8':
				this.airfield.addJet( kb );
				break;
			case '9':
				this.airfield.removeJet( kb );
				break;
			case '0':
				this.printPilots();
				break;
			case 'A':
				this.addPilot(kb);
				break;
			default:
				System.out.println( "Input not recognized. Select a valid option." ) ;
		}
			return true;
		
	}

	private void addPilot( java.util.Scanner kb ) {
		int randOrNot = 0;
		String fName = null;
		String lName = null;
		int age = 0;
		
		System.out.println( "Are you hiring :");
		System.out.println( "1. a random pilot, or" );
		System.out.println( "2. Someone specific?" );
		
		try {
			randOrNot = kb.nextInt();
			kb.nextLine(); //clear buffer
			if ( randOrNot < 1 || randOrNot > 2 ) {
				throw new InputMismatchException();
			} //ensures exception is thrown for ANY invalid input, whether non-number or wrong number
		}
		catch ( InputMismatchException e ) {
			System.out.println( "Input not recognized. Please select a valid menu option.");
			this.addPilot( kb );
		}
		switch( randOrNot ) {
			case 1:
				this.pilots.add( new Pilot() );
				break;
			case 2:
				System.out.print( "Please enter the new pilot's first name: " );
				fName = kb.nextLine();
				System.out.print( "Now enter their last name: " );
				lName = kb.nextLine();
				System.out.print( "And what is their current age? " );
				age = kb.nextInt();
				kb.nextLine();
				this.pilots.add( new Pilot( fName , lName , age ) );
				break;	
			}
		System.out.printf(
				"Added pilot: %s%n",
				this.getPilots().get( this.getPilots().size() - 1 ) );
				//this will always be the pilot we just added
	}

	private void printPilots() {
		System.out.println( "Here are the pilots assigned to this airfield: " );
		System.out.println() ;
		System.out.println() ;
		for ( int i = 0 ; i < this.pilots.size() ; i++ ) {
			System.out.printf( 
				"%d: %s%n" ,
				i+1 ,
				this.pilots.get( i ) );
		}
	}
	
	private List<Pilot> getPilots() {
		return this.pilots;
	}

	private void flySpecificJet( java.util.Scanner kb ) {
		int choice;
		
		System.out.println( "Here are the planes we have here:" ) ;
		System.out.println() ;
		this.printJets();
		System.out.print( "Which jet would you like to fly? ");
		try {
			choice = kb.nextInt() - 1;
			kb.nextLine();
			
			this.airfield.getPlanes().get( choice ).fly();
			
		}
		catch ( InputMismatchException e) {
			System.out.println( "Input not recognized. Please enter a *number* for a menu option." );
			System.out.println() ;
			kb.nextLine();
			this.flySpecificJet(kb);
		}
		catch ( IndexOutOfBoundsException e ) {
			System.out.printf(
					"We only have %d planes here. Please select one we actually have.%n%n" ,
					this.airfield.getPlanes().size() ) ;
			this.flySpecificJet(kb);
		}
	}

}
