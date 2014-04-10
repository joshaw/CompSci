---
layout: default
title: Introduction to Computer Science Notes.
---

#Introduction to Computer Science

* * *
* TOC
{:toc}
* * *

## Logic

### Propositional Logic

####Atoms
- Propositions are called atoms and can be either **true** or **false**
- Operators combine truth value
	- **AND** &and;
	- **OR** &or;
	- **NOT** &not;
	- **IMPLIES** &rarr;

#### Truth Tables
- Rows give the possible worlds that can exist.
- Columns are the truth functions.
- Give the outcomes of a logic sentence in every possible world.
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
- There exist infinitely many Turing Machines.

#### Halting Problem
- Given a Turing Machine **A**, is there a Turing Machine, **B**, that can tell 
  us (in a finite number of steps) is the Turing Machine **A** will halt or 
  not?
- *No*

#### Universal Turing Machine (UTM)
- Turing machine capable of taking, not just their data, but their program as 
  an input sequence on the tape.
- Capable of simulating any other Turing Machine.
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

#### Binary to Decimal

    24/2 = 12r0
    12/2 = 6r0
    6/2 = 3r0
    3/2 = 1r1
    1/2 = 0r1
* So 24<sub>10</sub> = 11000<sub>2</sub>

### Positive Real Numbers
- Use radix notation
- 3.14 = 3&times;10<sup>0</sup> + 1&times;10<sup>-1</sup> + 4&times;10<sup>-2</sup>
	- eg 101.001<sub>2</sub> = 1&times;2<sup>2</sup> + 1&times;2<sup>0</sup> + 1&times;2<sup>-3</sup>
	- = 5 1/8

## Negative Numbers
- Could use a sign bit to represent negative numbers
- This reduces the number of bits available for storing the numbers
- But gives an easily readable representation.
- However, this makes it more difficult to implement in a computer
	- Need specialised hardware to perform the calculations.

### Two's Complement
- Use the overflow observation.
	- When a number, as large as that number of bits is able to represent, has 
	  1 added to it, the values of all the bits overflow and all give 0.
		- eg 1111 + 1 = 0000
	- As long as the number of bits cannot change, like in a computer.
		- eg 0101101 + 1010010 = 0000000
- To the computer, the numbers look like the negative of each other, since they 
  sum to zero, even though, they actually sum to the value 1 greater that the 
  maximum size of the bits.
- Gives foundation of two's complement.
- To find the two's complement of a number:
	- Positive numbers (and zero) always begin with at least one leading zero 
	  but are otherwise identical to unsigned numbers.
	- Invert all bits.
	- Add 1.
- So all negative numbers start with a leading one.
- Range of -2<sup>n-1</sup>-1 to 2<sup>n-1</sup>-1
- The ranges are then:
	- The *largest positive* integer is 011...11
	- The *smallest positive* integer is 000...01
	- The *smallest negative* integer is 111...11
	- The *largest negative* integer is 100...00.

## Floating Point Numbers
- Fixed point numbers have limited ranges and precisions.
- Floating point numbers have the
	- **Mantisa**, M, and the
	- **Exponent**, E.
	- V = M&times;2<sup>E</sup>.
- Gives much higher range of possible values
- At the cost of lower resolution, so the steps between the possible values are 
  higher.
- The exponent means that the resolution is not linear
	- Larger numbers have a smaller resolution than smaller numbers.
	- Shouldn't use floating point numbers for precise values such as currency.

# Computer Architectures
- All computer programs are made of two components
	- *Data*
	- *Instructions*
	- The instructions allow the computer to perform actions on the data.
	- The data and the instructions both have to be stored in the computer in 
	  binary format.
		- There is no way to distinguish between them by examining them.

## Von Neumann Architecture
![Von Neumann Architecture](http://www.coertvonk.com/wp-content/uploads/architecture-von-Neumann2.png)

### Requirements of a Computing Device
- Basic requirements of the central processing unit:
	- Load the program from some external storage device,
	- Receive further input from external devices,
	- Process instructions correctly and in the correct order,
	- Access and modify pieces of data in accordance with the program's 
	  instrucitons,
	- Take decisions according to the results of the computations,
	- Send the results to some external device or store them for further use,
- This leads to a list of functional units that implement the high-level 
  functionality:
	- Load/Store instructions to/from memory,
	- Store instructions and data locally,
	- Interpret the instructions to do the necessary computations,
	- Send the results to external devices,
	- Take appropriate decisions and control whats happening, and
	- Keep track of program execution.

### Basic Structure
- The basic structure defined in the draft of **E**lectronic **D**iscrete 
  **V**ariable **A**utomatic **C**omputer became known as a Von Neumann 
  Machine.
- *Memory* containing instructions and data,
- *Processing unit* for performing arithmetic calculations, and
- *Control unit* for processing instructions.

### Main Memory
- Referred to RAM
- Instructions and data are stored in separate locations so they can be 
  distinguished.
- Instructions are stored sequentially so that the order of the program is 
  implicit from them.
- Not applicable for long term storage as the contents are lost when there is 
  not power.

### Load/Store Unit
- Interface between the CPU and the outside world.
- Gives and receives instructions to transfer instructions and data between the 
  CPU and memory.

### Registers
- Local, fast storage to hold data currently in use.
- Each register holds one word of data.
- Only hold data, instructions are dealt with separately.

### Instruction Register
- Holds the current instruction.
- Used by the control unit to configure the ALU to perform the desired 
  computation.

### ALU
- Arithmetic and Logic Unit.
- Where all computations are performed.
- Takes data from the registers and updates them with the results of the 
  computations.

### Program Counter
- Special register that holds the location (*address*) of the next instruction 
  to be executed.

### Clock Cycle
- All computer programs are synchronous
- Every activity is coordinated by an external clock signal.
- The speed of this pulse is quoted as a measure of the CPU performance
- Keeps all aspects of the computer synchronised.
- With each cycle of the CPU clock, a new operation is triggered.

## Instruction Cycle

### Fetch-Decode-Execute Cycle

- Triggered by the clock cycle
	- Can have several stages, triggered by successive clock pulse.
- Executing instructions is a very complex process.
- Most follow a similar set of stages
	- **Fetch**
		1. Inspect the program counter to find the address of the next 
		instruction
		1. Load the next instruction from memory into the instruction register.
		1. Update the program counter.
	- **Decode**
		1. Determine the type of instruction fetched
		1. If the instruction requires data from memory, determine its address.
		1. Fetch any required data from memory into one of the CPU registers.
	- **Execute**
		1. Execute the instruction.
		1. Return to step 1 to fetch the next instruction.

### Starting a Program
- The program is loaded into memory from disk
- The instructions and data associated with the program each occupy a block of 
  data
	- Allocated by the operating system.
- Memory address of the first instruction in the program is called the **entry 
  point**.
- When the program is started, the entry point is loaded into the program 
  counter.
	- This becomes the starting point for the cycle.

### Fetch
- The instruction at the location of the entry point of the program must be 
  fetched from memory and placed in the instruction register.
	- Depending on the relative speeds of the clock cycle and the memory, it 
	  could take several cycles before the instruction is ready in the IR.
	- `IR <- memory(PC)`
- The program counter is incremented by one to point to the next instruction.
	- `PC <- PC + 1`
	- Some instructions change the increment value, for example `loop` and 
	  `branch`.

### Decode
- The type of the instruction is determined by the control unit.
- Some typical types of instruction include:
	- move data around
		- `a = b`
	- combine operands
		- `c = a + b`
	- manipulate one operand
		- Bit shift, roation
	- test/comparison to change the program flow
		- branch
	- IO
	- control loops

### Execute
- Data must be fetched from memory
	- Each piece of data will have been allocated a memory address by the 
	  compiler, this will be specified as part of the instruction.
	- The address is extracted from the IR and passed to the load-store unit in 
	  the same way as the instruction was fetched.
	- Data is loaded into one of the registers.
		- The register is specified as part of the instruction.
- Once the data is in one of the registers, it can be acted upon.

## Instruction Set
- Modern computers are *Turing Complete* and so should be able to complete any 
  computation, that can be completed.
- But the exact set of instructions has an impact on the programmer's 
  abilities.
	- The **Instruction Set** is the set of all primitive instructions that the 
	  computer can perform.
- All languages can be decomposed to these instructions.
- Each type of CPU has a different set of instructions.
	- They are essentially incompatible with each other.
	- Low level code is strongly dependant on the machine and is much harder to 
	  read, write and debug.
		- So most programming is done in higher level languages.

# Stored Programs
- A program can be stored as a bit sequence and stored in main memory.
- From there the CPU can extract the instructions and execute them.
- Also, the program can be easily altered and re-run.

## Memory
- k&times;m array of stored bits.
	- k is usually 2<sup>n</sup>
	- **Address** 
		- unique n-bit identifier of location
	- **Contents** 
		- m-bit vlaue stored in that location.
- Basic operations
	- LOAD
	- STORE

### Interface to Memory
- **MAR** - Memory address register
- **MDR** - Memory data register.
- To read from location A,
	1. Write the address A into the MAR,
	1. Send a read signal to the memory,
	1. Read the data from the MDR.
- To write a value X to location A,
	1. Write data X to the MDR,
	1. Write the address A  to the MAR
	1. Send a write signal to the memory.

## Processing Unit
- Functional Units
	- **ALU** - Arithmetic and Logic Unit.
	- could have many functional units for special purpose jobs,
		- eg square root
- Registers
	- Small temporary storage
	- Operands and results of functional units,
- Word size
	- number of bits normally processed by ALU in one instruction
	- also the width of the registers.

## Input and Output
- Input
	- Keyboard,
	- mouse
	- scanner
	- disk
- Output
	- Monitor
	- Printer
	- LED
	- Disk
- Each device has its own interface,
	- usually a set of registers like the MAR and MDR
- Program that controls access to a device is called a *driver*.

## Control Unit (Finite State Machine)
- Orchestrates execution of a program.
	- IR
	- PC
- Reads an instruction from memory
- Interprets the instruction, generating signals that tell the other components 
  what to do.

## Machine Language Philosophies
- **RISC**
	- Reduced Instruction Set Computing
	- Few, simple, efficient, and fast instructions.
- **CISC**
	- Complex Instruction Set Computing
	- Many, convenient and powerful instructions.

# Compilation

## Options
- A program written in a high level language can be:
	- Compiled into the machine's native machine language and then run on the 
	  target machine, or
	- Directly interpreted, so that the execution is simulated by an 
	  interpreter that is run in the machine's native language.
	
## Compilation
- The conceptual process of translating source code into a CPU-executable 
  binary target code.
- Compiler runs on the same hardware as the target machine.
- **Cross Compilation**
	- Compiler runs on hardware Y, code is run on hardware X.
- Compilers try to be as smart as possible
	- Fix decisions that can be made at compile time so that the decision does 
	  not have to be made at run time
		- Type checking
		- Static allocation
		- Static linking
		- Code optimization
- Leads to better performance in general
	- Allocation of variables without variable lookup at runtime
	- Aggressive code optimisations to take advantage of hardware features.

## Interpretation
- The conceptual process of running high level code by an interpreter.
- Facilitates interactive debugging and testing
	- Procedures can be invoked by the user at a command line
	- Variable values can be inspected and changed by a user.

## Bytecode
- Some languages use *bytecode* which is somewhere between compiled and 
  interpreted language.
- Code is compiled into byte code, but then interpreted by a virtual machine.
- A processor (CPU) can be viewed as an implementation in hardware of a virtual 
  machine
- "Compile once, run anywhere"
- Bytecode is independent of the host machine
- The virtual machine is specific to the computer architecture and operating 
  system.
- **Java Bytecode**
	- Stack based virtual machine.
	- Small instruction set
		- 202 instuctions
		- All 1 byte opcode + operands
	- Memory is typed.

### Virtual Machine
- Executes an instruction stream in software.
- Adopted by
	- Pascal
	- Java
	- Smalltalk-80
- Java compilers generate code that can be interpreted by the Java Virtual 
  Machine (**JVM**).
	- The JVM can translate bytecode into machine code by *Just-In-Time* 
	  compilation (**JIT**).
	- This can achieve similar performance as natively compiled code.

### Compilation and Execution on VM
- Compiler generates intermediate program
- VM interprets the intermediate program.
- **Pure Compilation and Static Linking**
	- Library routines are separately linked (merged) with the object code of 
	  the program
- **Compilation, Assembly and Static Linking**
	- Facilitates debugging of the compiler.
- **Compilation, Assembly and Dynamic Linking**
	- Dynamic libraries are linked at runtime by the OS
		- eg DLL, `.so`, `.dylib`.
- **Preprocessing**
	- Preprocessor imports header files and expands macros
		- eg `#define`, `#inlude`.
