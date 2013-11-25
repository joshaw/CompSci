#Introduction to Computer Science

## Logic

### Propositional Logic

####Atoms
- Propositions are called atoms and can be either **true** or **false**
- Operators combine truth value
	- **AND** &and;
	- **OR** &or;
	- **NOT** ¬
	- **IMPLIES** &rarr;

#### Truth Tables
- Rows give the possible worlds that can exist.
- Columns are the the truth functions.
- Give the outcomes of a logic sentence in evey possible world.
	- ie for every combination of true and false for each of the different 
	  atoms.

#### Valid
- True in all possible worlds.

#### Satisfiable
- True in some possible worlds.

#### Unsatisfiable
- True in none of the possible worlds.
	- False in all worlds.

### Predicate Logic
- Allows us to construct more informative logical statements about the world.
	- Can give information about;
		- Properties of objects,
		- Relations between objects.

## Algorithms
- A set of rules for determining a sequence of operations precisely.

## Turing Machine
- Composed of;
	- Infinitely long tape with symbols.
		- eg **{0,1}**,
		- eg **{A,B,C,D}**.
	- Read/write head can read a symbol from the tape and write a symbol over 
	  another and can move the tape left or right,
	- Finite set of internal states,
		- Exists in one of the states at all times.
	- Set of transition rules that control the internal state change as a 
	  function of the symbols read from the tape.
- The current system state is the entire configuration.
	- Not just the internal state.
- There exist infintely many Turing Machines.

#### Halting Problem
- Given a Turing Machine **A**, is there a Turing Machine, **B**, that can tell 
  us (in a finite number of steps) is the Turing Machine **A** will halt or 
  not?
- *No*

#### Universal Turing Maching (UTM)
- Turing machine capable of taking, not just their data, but their program as 
  an input sequence on the tape.
- Capable of simulatiing any other Turing Machine.
- Not possible to build physically since it would require an infinite memory 
  address.
- Physical computers are an approximation of UTMs.
- Useful for;
	- Mathematics - Universality means machines are general purpose and so 
	  reusable,
	- Physics - Electronics made them small, cheap and powerful,
	- Software - Can be standardised and bootstrapped, amplifying the power of 
	  an existing tool with each step in technology.

#### Tiny Turing Machine
- Has been shown that a Turing Machine with 7 internal states and 4 symbols is 
  a UTM; 
	- a (7,4) machine.
- Also exist (4,6) and (5,5) machines.

## Number Representation Systems

### Positive Integers
- Decimal 
	- 0 - 9
- Binary
	- 0 - 1
- Hexadecimal
	- 0 - F
