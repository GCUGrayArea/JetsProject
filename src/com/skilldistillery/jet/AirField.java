package com.skilldistillery.jet ;

import java.io.BufferedReader ;
import java.io.FileNotFoundException ;
import java.io.FileReader ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

public class AirField {
	
	//User Story #2: Jets are found at an AirField. Create the AirField class, which has an empty List of Jets.

	private List < Jet > planes ;

	public AirField( String fileName ) {

		planes = new ArrayList < Jet >() ;
		FileReader fr ;

		try {
			
			/*
			 * User Story #3 On program startup, populate the AirField with at least 5 Jets
			 * of different types.
			 * 
			 * These jets must be read from a text file, where each line in the file
			 * contains data for a single Jet object.
			 * 
			 * This file exists at the root of your Eclipse project. It can be comma- or
			 * tab-separated; either implementation is acceptable. The method to parse a
			 * file into Jet objects should return a List<Jet>. Its parameter can be a
			 * String file name. Remember to use String.split(regex) to break each line in
			 * the file into data to create an individual jet.
			 */
			
			fr = new FileReader( fileName ) ;
			BufferedReader br = new BufferedReader( fr ) ;
			String line ;
			String[] data ;
			while ( ( line = br.readLine() ) != null ) {
				data = line.split( "," ) ;
				switch ( data[ 0 ] ) {
					case "bomb" :
						// String model , int speed , int range , int price, int bombLoad
						this.planes.add(
							new Bomber(
								data[ 1 ] ,
								Integer.parseInt( data[ 2 ] ) ,
								Integer.parseInt( data[ 3 ] ) ,
								Integer.parseInt( data[ 4 ] ) ,
								Integer.parseInt( data[ 5 ] ) ) ) ;
								break ;
					case "fight" :
						// String model , int speed , int range , int price
						this.planes.add(
							new Fighter( data[ 1 ] ,
								Integer.parseInt( data[ 2 ] ) ,
								Integer.parseInt( data[ 3 ] ) ,
								Integer.parseInt( data[ 4 ] ) ) ) ;
								break ;
					case "cargo" :
						// String model , int speed , int range , int price , int cargoCapacity
						this.planes.add(
							new CargoHauler(
								data[ 1 ] ,
								Integer.parseInt( data[ 2 ] ) ,
								Integer.parseInt( data[ 3 ] ) ,
								Integer.parseInt( data[ 4 ] ) ,
								Integer.parseInt( data[ 5 ] ) ) ) ;
								break ;
					case "people" :
						this.planes.add( 
							new AirLiner(
								data[ 1 ] ,
								Integer.parseInt( data[ 2 ] ) ,
								Integer.parseInt( data[ 3 ] ) ,
								Integer.parseInt( data[ 4 ] ) ,
								Integer.parseInt( data[ 5 ] ) ) ) ;
								break ;
				}
			}

			br.close() ;
		} catch ( FileNotFoundException e ) {
			System.err.println( "Invalid filename: " + e.getMessage() ) ;
		} catch ( IOException e ) {
			System.err.println( "Problem while reading " + fileName + " : " + e.getMessage() ) ;
		}

	}

	
	public List < Jet > getPlanes() {
	
		return this.planes ;
	
	}
	
	public void addJet( java.util.Scanner kb ) {
		
		/*
		 * User Story #9: A user can add custom jets to the fleet.
		 * 
		 * This can be a JetImpl. (It goes straight to one of the subtypes of Jet I
		 * implemented based on the submenu input)
		 * 
		 * Stretch Goal: This leads to a sub-menu where the user chooses the type of Jet.
		 * (Accomplished)
		 * 
		 * Users then enter information for the Jet, and it is added to the AirField.
		 */
		
		int planeType;
		String model;
		int speed;
		int range;
		int cost;
		int typeSpecific;
		
		System.out.println( "Is this new plane a: \n" ) ;
		System.out.println( "1. Fighter" ) ;
		System.out.println( "2. Bomber" ) ;
		System.out.println( "3. Cargo plane" ) ;
		System.out.println( "4. Airliner" ) ;
		System.out.print( "Enter your selection: " );
		planeType = kb.nextInt();
		kb.nextLine(); //clear buffer
		
		System.out.print( "Enter the model name: " ) ;
		model = kb.nextLine();
		System.out.print( "Enter its speed in MPH: " ) ;
		speed = kb.nextInt();
		kb.nextLine();
		System.out.print( "Enter its range in miles: " ) ;
		range = kb.nextInt();
		kb.nextLine();
		System.out.print( "Enter its cost in whole dollars: " ) ;
		cost = kb.nextInt();
		kb.nextLine();
		
		switch ( planeType ) {
			case 1:
				this.planes.add( new Fighter( model, speed, range, cost ) );
				break;
			case 2:
				System.out.print( "What is its max bomb load? " );
				typeSpecific = kb.nextInt();
				kb.nextLine();
				this.planes.add( new Bomber( model, speed, range, cost, typeSpecific ) );
				break;
			case 3:
				System.out.print( "What is its maximum cargo weight? " );
				typeSpecific = kb.nextInt();
				kb.nextLine();
				this.planes.add( new CargoHauler( model, speed, range, cost, typeSpecific ) );
				break;
			case 4:
				System.out.print( "What is its passenger capacity? " );
				typeSpecific = kb.nextInt();
				kb.nextLine();
				this.planes.add( new AirLiner( model, speed, range, cost , typeSpecific ) );
				break;
		}
		
		System.out.printf( "Added: %s%n",
				this.planes.get( this.planes.size() - 1 ).toString() ) ;
		//this will always be the plane we just added
	
	}
	
	public void removeJet( java.util.Scanner kb ) {
		
		/* User Story #10:
		 * A user can remove a jet from the fleet.
		 * 
		 * The user is presented with a sub-menu to select a jet to delete by number.
		 * Stretch Goal: a user can remove a jet (or jets) by name.
		 */
		
		String input;
		boolean gotValidInput = false;
		
		/*
		 * Duplicates some effort to do the following instead of printJets() in the
		 * app, but doing it this way makes the class more usable by other programs.
		 * If we usedJetsApplication.printJets() nobody using AirField somewhere
		 * else would be able to see the list of planes before choosing which one to
		 * delete.
		 */
		
		System.out.println("The planes currently at this airfield are: ");
		for ( Jet i : this.getPlanes() ) {
			System.out.printf(
					"%d: %s%n" ,
					this.planes.indexOf( i ) + 1 ,
					i.toString()) ;
		}
		
		System.out.print( "Which one would you like to remove? Enter its numerical position or model name: ");
		input = kb.nextLine();
		
		while ( !gotValidInput ) {
			try {
				this.planes.remove( Integer.parseInt( input ) - 1 );
				gotValidInput = true;
			}
			catch ( NumberFormatException e ) {
				//nothing will happen if user enters a non-integer number as that
				//exception is handled here and assumes the user was trying to enter
				//a model. I'm comfortable with this.
				
				for ( int i = 0; i < this.getPlanes().size(); i++ ) {
					if ( this.getPlanes().get( i ).getModel().equalsIgnoreCase( input ) ) {
						this.planes.remove( i ); //removes ALL planes matching the model
					}
					gotValidInput = true;
				}
			}
			catch (IndexOutOfBoundsException e ) {
				//invoked if an int is entered that's greater than the number of planes present
				System.out.printf(
						"We only have %d planes here. Select one of *those*. " ,
						this.getPlanes().size() );
				input = kb.nextLine();
			}
		}
		
	}

}
