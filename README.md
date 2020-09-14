# SD27 Homework, Week 3: Jets

## Jets project

### Overview

This project calls on us to create an abstract class of plane and instantiate it in the form of more specific concrete classes with distinct capabilities. I've accomplished this with four separate types (Bomber, Fighter, AirLiner and CargoHauler) each of which implements an interface for its specific role as an aircraft.

The specific planes are loaded from a text file as specified, instantiated based on the first field of each line ( a different constructor is called depending on the value, and lines whose first field doesn't match any of the specified plane types are ignored.) After these are loaded by the program the user can view the planes altogether or by specific properties, and add or remove planes in the ArrayList that stores them as desired.

### Topics
* Interfaces
  - Each specific subclass of Jet implements an interface for its specific role as an aircraft (a single method for whether it gets loaded with cargo, flies with passengers or fights/drops bombs). Apart from fighter, each subclass also implements a unique field with data relevant to that role.
* I/O Streams
  - The planes for the default array are loaded from `planes.txt` at runtime using `FileReader` and `BufferedReader` instances and the `BufferedReader`'s `readLine()` method inside a loop, as covered in class this week. Modifying the constructor call in `JetsApplication`'s `main()` method will allow other filenames to be specified if desired.
* Exception Handling
  - `try-catch` blocks are used in `AirField`'s `removeJet()` method to distinguish between input types when the user provides keyboard input (via a `NumberFormatException` that indicates whether the attempt to parse the input as an `int` failed, in which case the input is read as a `String`), and to inform the user (with an `OutOfBoundsException`) when they've entered a number that would correspond to an aircraft outside the `ArrayList`. They're also used to handle empty input in the main menu that would otherwise crash the program, and in menus in general to request input again if an invalid option is selected.
* The `List` Interface
  - An `ArrayList` (which implements `List`) is used to store the planes initially read from `planes.txt`, and to add new planes and remove existing ones as the user instructs.
* Custom `equals()` and `hashCode()` methods
  - Implemented for all of the classes that extend `Jet`.
* Primitive-type wrapper classes
  - `Integer.parseInt()` is used in `AirField.removeJet()` to check whether the user's input works as a number, throw an exception if not (which causes the input to be treated as a string) and remove a specified index of the `ArrayList` field `planes` if the parse is successful.
* Tail Calling
  - `Fighter.fight()` is overloaded to account for variations in the number of fighters present. If only one is present it will just print a string identifying the fighter, but if multiple fighters are present when it is called by `JetsProject.dogFight()` a simulated missile will be fired and (if it misses the target), the target's own `fight()` method will be called with the original firing plane as a target (i.e. it has a chance to shoot back). By passing the original calling `Fighter` as the parameter to its target's own `fight()` method repeatedly until one plane is hit, all the code for the dogfight can be squeezed into a single readable method.

### How to Run

1. Compile all `.java` files in the `com.skilldistillery.jet` package with `javac` or load the package in Eclipse or another IDE.
2. Run the file from the command line with `java JetsApplication`, or with your IDE's run tools.
3. Enter the inputs requested by the program.
4. ~~PROFIT!~~ Look at console output for the answers you seek.
