#Introduction to Computer Science

## Stored Programs
- Concept;
	- A program can be encoded as bit patterns and stored in memory,
	- The CPU can then extract the instructions and execute them,
	- The program can be executed and changed easily.

#### Machine Instruction
- An instruction (or command) encoded as a bit pattern recognizable by the CPU.

#### Machine Language
- The set of all defined instructions recognized by a machine.
	- Reduced Instruction Set Computing (RISC);
		- Few, simple, efficient and fast instructions,
		- eg PowerPC from Motorola.
	- Complex Instruction Set Computing (CISC)
		- Many, convenient and powerful instructions,
		- eg Pentium from Intel.

### Von Neumann Model
- EDVAC - **E**lectronic **D**iscrete **V**ariable **A**utomatic 
  **C**omputer;
	- Memory - contains instructions and data,
	- Processing Unit - performs arithmetic and logic operations,
	- Control Unit - interprets instructions.

#### Memory
- *k x m* array of stored bits;
	- Address - unique n-bit id of location,
	- Contents - m-bit value stored in that location.

#### Basic Operations
- LOAD - read a value from memory,
- STORE - write a value to memory.

#### Interfaces to Memory
- Memory address register (MAR)
- Memory data register (MDA)
- eg to read location A:
	1. write the address A to the MAR,
	1. send a *read* signal to the memory,
	1. read the data from the MDA.
- eg write value X to location A:
	1. write the data X to the MDA,
	1. write the address A to the MAR,
	1. send a *write* signal to the memory.

#### Processing Unit
- Functional units:
	- Arithmetic and Logic Unit (ALU),
		- could have many functional units, some of the special purpose,
		- eg multiply, square-root,
	- Temporary registers,
		- holds operands and results of functional units,
- *Word size*
	- number of bits normally processed by ALU in one instruction,
	- also width of registers.

#### Control Unit
- Orchestrates execution of the program.
- Contains: 
	- *Instruction Register* (IR)
		- contains the **current** instruction.
	- *Program Counter* (PC)
		- contains the address of the **next** instruction to be executed.
- Reads an instruction from memory
	- the instruction's address is in the PC
- Interprets the instruction, generating signals that tell the other components 
  what to do
	- a single *instruction* may take many machine cycles to complete.

#### Input and Output
- Each device for getting data into and out of the computer has its own 
  registers,
	- like the memory's MDR and MAR
	- eg **input**: keyboard, mouse,
	- eg **output**: console, frambuffer,
	- eg **both**: disk, network.
- Driver:
	- a program that controls a device 
- Controller:
	- intermediary apparatus that handles communication between the computer 
	  and a device,
	- Specialized controllers for each type of device
	- General purpose controllers (USB, FireWire).
- Port:
	- point at which a device connects to a computer.
- Memory-mapped I/O:
	- CPU communicates with peripheral devices as though they were memory 
	  cells.

### Instruction
- The fundamental unit of work in the computer
- Specifies:
	- **Operands** - data/locations to be used for the operation
	- **Opcode** - operation to be performed
		- stored as a sequence of bits
		- often have fixed length; 16, 32, etc.
		- control unit Interprets Instruction and generates a sequence of 
		  control signals to carry out operation,
		- operation is either executed completely or not at all.
- Basic kinds of Instruction:
	- computational instructions (ADD, AND, ...),
	- data movement instructions (LD, ST, ...),
	- control instructions (JMP, BRnz, ...).

#### Instruction Processing
1. Fetch Instruction from memory
2. Decode Instruction
3. Evaluate address
4. Fetch operands from memory
5. Execute operation
6. Store results
7. *Goto 1*

##### Fetch
- Load next instruction from address in PC from memory into IR;
	- Load contents of PC into MAR,
	- Send read signal to memory,
	- Read contents of MDR and store in IR.
- Increment PC so it points to next instruction in sequence;
	- PC <- PC + 1

##### Decode
- Identify opcode
	- eg first n bits of the instruction
- Depending on the opcode, identify the operands from the remaining bits

##### Evaluate Address
- For instructions that require memory access.
- Compute address used for access.

##### Fetch Operands
- Obtain source Operands needed to perform operation
	- from memory or register or other location

##### Execute
- Perform the operation using the source operands.

##### Store
- Write the results to the destination
	- either a register or memory location

#### System Clock
- Keeps control unit moving
	- at each clock "tick", control unit moves to the next machine cycle
	- may be next Instruction or next phase of current instruction.
- Based on crystal oscillator
- Generates regular sequence of *0* and *1* logic levels
- A clock (or machine) cycle is the time between leading edge to leading edge.

## Compilation and Interpretation
- A program written in a high language can be run by either
	- Compiling it into a program in the native machine language and then run 
	  on the target machine
	- Directly interpreting it so that the execution is simulated within an 
	  interpreter.

### Compilation
- Conceptual process of translating source code into a CPU-executable binary 
  target code
- Compiler runs on the same platform as the target code.
- **Cross compiler**
	- Compiler runs on platform X, target code runs on platform Y.
- Compilers try to be as smart as possible to fix decisions that can be taken 
  at **compile** time.
- Avoids generation of code that would have to make these decisions at **run** 
  time
	- eg type checking, static allocation, static linking, code optimization.
- Leads to better performance in general;
	- Allocation of variables without variable lookup at runtime,
	- Aggressive code optimization to exploit hardware features.

#### Pure Compilation and Static Linking
- Adopted by typical Fortran systems.
- Library routines are separately linked with the object code of the program.
	- Source program **compiled into** incomplete object code,
	- Static library object code and incomplete object code **linked** to a 
	  binary executable.

#### Compilation, Assembly and Static Linking
- Facilitates debugging of the compiler
	- Source program **compiled into** assembly program,
	- Assembly program **assembled** by the assembler
	- Static library code and assembled program **linked** to a binary 
	  executable.

#### Compilation, Assembly and Dynamic Linking
- Dynamic libraries (DLL, .so, .dylib) are linked at runtime by the OS, via 
  stubs in the executable.
	- Source program **compiled into** Assembly program,
	- Assembly program **assembled** by assembler,
	- Shared dynamic libraries **linked** at runtime into the incomplete 
	  executable.

#### Preprocessing
- Most C and C++ compilers use a preprocessor to import header files and expand 
  macros.
	- Source program **processed** by preprocessor into a modified source 
	  program,
	- Modified source program **compiled** by the compiler into assembly or 
	  object code.
- Early C++ compilers used the CPP preprocessor to generate C code for 
  compilation.

### Interpretation
- Conceptual process of running high level code by an interpreter.
- Facilitates interactive debugging and testing,
	- Procedures can be invoked from command line by the user,
	- Variables can be inspected and modified by a user.
- Some languages cannot be purely compiled to machine code alone,
	- need to rewrite/add code to the code base dynamically
	- translate data to code for execution (interpretation).

### Virtual Machine
- Executes an instruction steam in software.
- Adapted by Pascal, Java, Smalltalk-80, C#, functional and logic languages and 
  some scripting languages.
- Compilation generates intermediate program,
- Virtual machine interprets the intermediate program,
	- Virtual machine is written for each different platform, so that the code 
	  should run the same on all different platforms for which a virtual 
	  machine has been implemented.

#### Bytecode
- Sometimes the distinction between interpretation and compilation can be fuzzy
	- Interpreter is similar to a virtual machine that executes higher level 
	  code
	- Java is compiled to bytecode which is Interpreted by the Java Virtual 
	  Machine (JVM)
- Machine independant class file, interpreted by a virtual machine.
- Architecture independant,
	- writing a VM is easier than rewriting a compiler for every architecture
	- VM's can enforce different levels of security automatically
		- eg applets vs applications
	- Just-in-time (JIT) compiling helps acheive similar speed to traditionally 
	  compiled code.

##### Java Bytecode
- Stack-based virtual machine
- Small instruction set
	- 202 instructions, all are 1 byte opcode with operands
	- Compared with Intel x86: ~280 instructions, 1 to **17** bytes long.
- Memory is typed.

## Data Structures
- Abstract Data Structure (ADT)
	- A model or theoretical construct for a collection of data, along with 
	  certain behavior or rules for accessing or manipulating that data.
	- Want to know about how to access and manipulate the data but not worried 
	  about the specific implementation.
	- For the basis of *algorithms* for doing more complex operations with 
	  data.

### Algorithm
- Set of rules for determining a sequence of operations precisely

### Stack
- Ordered collection of elements
- Elements can only be **added** at one end, and **removed** from the *same* 
  end.
- Capacity - maximum number of elements that can be stored
- Index - number of each element
- Top - highest index currently filled
- If
	- stack is **empty**, then top = -1
	- stack is **full**, then top = capacity-1
- Is a *recursive data structure*, it is either empty, or consists of a top and 
  the rest which is a stack.
	- [A, [B, [C, [D, ]]]]
- eg Towers of Hanoi, undo operations in editor, path finding in a maze 
  (backtracking).

#### Operations
- *push(S,x)* - add a new element x to the stack S
- *pop(S)* - remove the most recent addition from the stack S
- *peek(S)* - return the most recent addition without removing it
- *isEmpty(S)* - return true if the stack is empty, else return false!
- *size(S)* - return the number of elements in the stack

### Queue
- Ordered collection of elements
- Elements are **added** at one end and **removed** from the *other* end.
	- Added at back and removed from the front.
	- **F**irst **I**n **F**irst **O**ut, FIFO.
- When the index of the last element reaches the capacity, add new elements to 
  begining
	- *Circular Queue*
		- useful for buffering data streams, in this case dequeuing retreats 
		  the front pointer without removing the element (useful if "rewinding" 
		  some way is wanted).
		- old data is not removed until the buffer becomes full.

#### Operations
- *enqueue(Q,x)* - add a new element x to the queue Q
- *dequeue(Q)* - remove the oldest addition from the queue Q
- *peek(Q)* - return the oldest addition without removing it
- *isEmpty(Q)* - return true if the queue is empty, else return false!
- *size(Q)* - return the number of elements in the queue

### Double Ended Queue (Deque)
- Combines a stack with a queue
- Can add or remove elements from the back or the front

#### Operations
- *pushBack(D,x)* - add element x to the back of the deque D
- *popBack(D)* - remove an element from the back
- *pushFront(D,x)* - add element x to the front
- *popFront(D)* - remove an element from the front
- *peekBack(D)* - return the back element without removing it
- *peekFront(D)* - return the front element without removing it
- *isEmpty(D)* - return true if the deque is empty, else return false!
- *size(D)* - return the number of elements in the deque

### Priority Queue
- Stores  the "values" of each element to be able to search for the highest 
  value elements or sort them appropriately.

### Linked List
- A sequence of nodes
	- A node, in the simplest form, is a piece of data with a *reference*
		- A reference is a link or pointer to a node
	- A &rarr; B &rarr; C &rarr; D &rarr; NULL
- *Head node* - the node at the start of the linked list which has no nodes 
  linked to it.
- *Termination Element* or null reference - a "non"-node which the last real 
  node in the list links to in order to signal the end of the list.
- Inserting an element is easy;
	- just change the reference of the previous node to the new node and link 
	  the new to the next node in the list.
	- computationally cheap compared to array
	- would need to shift all of the elements individually to make room for the 
	  new one.
- Easy to remove node;
	- just remove the node and change the reference of the previous node to the 
	  next node in the list.
- But indexing is slower
	- must traverse the whole list from the head to get to the *n*th node.

### Doubly Linked List
- Linked list with two references associated with each node
	- One to the next element, and one to the previous element.
	- NULL &larr; A &harr; B &harr; C &harr; D &rarr; NULL

### Circularly Linked List
- No termination element is used, instead the last element links back to the 
  head element.
	- Similar to a circular buffer.
