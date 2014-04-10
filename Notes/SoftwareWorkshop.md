---
layout: default
Title: Software Workshop
---

# Software Workshop

* * *
* TOC
{:toc}
* * *

## Java Programming Language
- Strictly typed
- Object oriented
- Platform independent

## Types of Numbers

### Integers Numbers
- `byte`
	- -128 to 127
	- -2^7 to 2^7-1
- `short`
	- -32,768 to 32,767
	- -2^15 to 2^15-1
- `int`
	- -2,147,483,648 to 2,147,483,647
	- -2^31 to 2^31-1
- `long`
	- -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
	- -2^63 to 2^63-1

### Real Numbers
- Cannot represent all decimal real numbers exactly using binary representation 
  (see Intro to Compsci).
- Use approximations to get close as possible to the real numbers.
- `float`
	- for floating point numbers, numbers with fractional part
	- represented by 4 bytes
		- 6-7 significant decimal digits
		- Float.MAX_VALUE = 3.4028235e38
		- Float.MIN_VALUE = 1.4e-45
- `double`
	- represented by 8 bytes
		- 15 significant decimal digits
		- Double.MAX_VALUE = 1.7976931e308
		- Double.MIN_VALUE = 4.9e-324

## Other Primitive Types
- `char`
	- Single character
	- `'a'`, `'b'`
- `boolean`
	- Boolean true or false value

## Programming Constructs

### Loop Invariant

- Property that holds before and after each repetition of a code loop.

~~~
	int j = 9
	for (int i=0; i<10; i++) {
    	j--;
	}
~~~

- A loop invariant is the fact that `i + j = 9`
- Also `i >= 0 && i < 10`
	- because of the termination condition of the loop

### Arrays

~~~
int[] array = new int[100];
~~~

- Smallest index is 0
- Largest index is `(n=100)-1`

## Classes
- Can be thought of as generalised types
- Objects are elements of classes
- Each class in a separate file
- Can contain any number of variables and any number of methods that perform 
  actions on and/or using those variables.
- Keep classes simple and extensible
- Only one class declaration in a particular file can be public
	- This must orrespond to the filename
- Classes can be nested
	- Inner classes are invisible from the outside
	- Corresponding methods cannot be called from the outside.

### Variable Modifiers
- `static`
	- For variables that are the same for all instances of a class.
	- Can be accessed when there is no instance of the class instantiated
- `final`
	- For variables which are initialized once and then not changed again
	- Do not need to be known at compile time
		- unlike `const`.
	- Although a final variable, once initialized, cannot be changed, if the 
	  variable is an instance of a class, any variables within that class are 
	  free to be altered in any way.

#### Access Modifiers

- `public`
	- The variable is available to be accessed and changed by any method
	- Accessible from all classes
- `private`
	- The variable is only accessible from the class in which it was 
	  initialized.
	- Can be read and changed using getters ans setters.
- `protected`
	- The variable is accessible from any classes in the same package and from 
	  subclasses of the class that the variable is initialized in.
- default
	- The variable is accessible from the class it was initialized in and from 
	  any subclasses, but not by any other classes.

|---
| Modifier | Class | Package | Subclass | World |
| :------- | :---: | :-----: | :------: | :---: |
| public        | Y | Y | Y | Y |
| protected     | Y | Y | Y | N |
| *no modifier* | Y | Y | N | N |
| private       | Y | N | N | N |

## Exceptions
- Three types of exceptions:
	- Checked Exception
		- Unusual conditions that a well written program should anticipate and 
		  recover from.
		- eg, user inputs a filename for reading, but the file does not exist
		- Cannot be checked at compile time since they depend on some condition 
		  that could change depending on the run situations.
		- Checked exceptions must be managed by a `try-catch`.
	- Error
		- Conditions that are external to the application and that the 
		  application is not able to anticipate or recover from
		- eg, a file to be read exists, but when the application attempts to 
		  read from it, a harware malfunction prevents it from succeeding
		- Errors do not have to be managed by a `try-catch`.
	- Runtime Exception
		- Conditions that are internal to the application, but which cannot 
		  usually be anticipated or recovered from.
		- Usually programming or algorithmic bugs introduced by the programmer, 
		  or improper use of an API.

### `Try-Catch` Handling
- Used to manage and recover from errors that could occur
	- eg, user input the wrong sort of data
	- eg, a connection was lost
- Works for non-checked exceptions that are not found at compile time.

~~~
try {
    // do some code which might cause an exeption
} catch (ExeptionType1 e1) {
    // what to do if the exeption happened
} catch (ExeptionType2 e2) {
    // what to do if a different exeption happened
} finally {
    // what to do whatever happens
}
~~~

## Inheritance
- A subclass inherits from its *unique* superclass.
- Each superclass can have many subclasses
- Each subclass has an most one superclass.
- Inheritance levels can be represented as a tree.
- All methods not explicitly overridden in the subclass are inherited from the 
  superclass.
	- Overridden methods from the superclass are accessible via `super`
		- eg, `super.toString()`
- Variable private to the superclass are *not available* in the subclass.

### Abstract Classes
- Do not have immediate objects
- Only instantiated via subclasses.

#### Abstract Methods
- Abstract classes can have abstract methods.
- Methods which have no body, just a declaration
- These must be written in the corresponding (concrete) subclasses

#### Interfaces
- Allows methods to be defined such that they have to be implemented in any 
  classes which `implements` the interface.
- Gives a means by which all classes which are related in some way have to have 
  one or several methods with the same name and the same arguements so that the 
  particular way that the method was written does not matter, but it can be 
  guaranteed that they will behave in the same way.
- Have to specify
	- return type
	- name of the method
	- arguements.

#### Abstract Classes vs Interfaces
- Abstract Classes = **AC**
- Interfaces = **If**
- AC's can contain fields that are not static and final and they can contain 
  implemented methods.
- These AB's are similar to interfaces, but they also provide a partial 
  implementation, it is the job of the subclasses to complete the 
  implementation
- If an AC only contains abstract methds, it should be an If
- Multiple interfaces can be implemented by classes anywhere in the class 
  hierarchy, whether or not they are related to one another.

### Packages
- Collection of java classes that are related and so belong together.
- `import` statements make packages available to a program

## Polymorphism
- Allows writing multiple methods with the same name but with different types 
  of invocation.
	- eg `multiply(3, 20)` and `multiply(3, 5, 4)`
	- method overriding
- "Collections"
	- `Car` is a `Motorised` is a `Vehical`

## Recursion
- A method that calls itself
- Make some computations easier
- Can be a more elegant solution
- Allows the creation of recursive data structures which can be manipulated 
  with far less code.

### Lists
- Simple data structure to store information in a row.
- Terminology
	- First element (x0) is *head* of the list
	- Remaining elements (x1, x2, ..., xn-1) is the *tail* of the list.
	- The *empty list* contains no elements.

## Graphical User Interfaces
- `java.awt` 
	- Original GUi toolkit in JDK 1.1
	- Implemented using native GUI libraries of the operating system
	- Not portable
- `javax.swing`
	- Portable GUI toolkit added in Java 2
	- Extends `java.awt`
	- Platform independant
	- Slower

### `ActionListner`s
- Must import `java.awt.event.*;`
- Allows a class to handle events
- A class that `implements ActionListener` is added to a button or other 
  component to define that that class handles the event from that button etc.
