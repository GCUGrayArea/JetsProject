package com.skilldistillery.jet ;

public class Pilot {

	private static final String[] PILOTFIRSTNAMES ;
	private static final String[] PILOTLASTNAMES ;
	private String firstName ;
	private String lastName ;
	private int age ;

	static {
		PILOTFIRSTNAMES = new String[]
				{
				"Tom" ,
				"Dick" ,
				"Harry" ,
				"John" ,
				"Jane" ,
				"Kate" ,
				"Pat" ,
				"Jenny"
		} ;
		PILOTLASTNAMES = new String[] {
				"Smith" ,
				"LeBlanc" ,
				"Rodriguez" ,
				"Segura" ,
				"Tao" ,
				"Zhu"
		} ;
	}

	public Pilot( ) {
		this.setFirstName( PILOTFIRSTNAMES[ (int) ( Math.random() * PILOTFIRSTNAMES.length ) ] );
		this.setLastName( PILOTLASTNAMES[ (int) ( Math.random() * PILOTLASTNAMES.length ) ] );
		this.setAge( (int) ( Math.random() * 38 + 22 ) );
	}
	
	public Pilot( String firstName, String lastName, int age ) {
		this.setFirstName( firstName );
		this.setLastName( lastName );
		this.setAge( age );
	}

	public String getFirstName() {

		return firstName ;

	}

	public void setFirstName( String firstName ) {

		this.firstName = firstName ;

	}

	public String getLastName() {

		return lastName ;

	}

	public void setLastName( String lastName ) {

		this.lastName = lastName ;

	}

	public int getAge() {

		return age ;

	}

	@Override
	public String toString() {

		return String.format( "%s %s, age %d" , firstName , lastName , age ) ;

	}

	public void setAge( int age ) {

		this.age = age ;

	}

}
