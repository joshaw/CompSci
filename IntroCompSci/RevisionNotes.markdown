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
- EDVAC - **E**lectronic **D**iscrete **V**ariable **A**utomatic **C**omputer;
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

## Trees
- Hierarchical data structure composed of nodes
- Each node contains an element of data and zero or more children
	- ie references to other nodes (child nodes)
- **Root** - the top of the tree
- **Siblings** - nodes that share the same parent
- **Internal nodes** - nodes that have at least one child
- **External nodes** - or leaves, have no children
- **Depth** - the length of the path from a node to the root
- **Height** - the longest path to one of the node's leaves

### Tree Traversal
- A systematic, or algorthmic, way of visiting every node in the tree

#### Pre-Order
- Parents re-order: parents before children

		function preorder(tree T, node v):
			visit(v)
			for each u in children(T,v):
				preorder(u)

#### Post-Order
- Parents *after* children

		function postorder(tree T, node v):
			for each u in children(T,v):
				postorder(u)
			visit(v)

#### Level-Order
- Level by level

		function levelorder(tree T):
			queue Q
			enqueue(Q,root(T))
			while !isEmpty(Q):
				node = dequeue(Q)
				visit(node)
				for each u in children(T,node):
					enqueue(Q,u)

### Binary Tree
- A tree with each node having at most 2 children

#### In-Order Traversal
- For binary trees only
- First left subtree, then current node, then right subtree

		function inorder(tree T, node v):
			if v.left != NULL:
				inorder(T,v.left)
			visit(v)
			if v.right != NULL:
				inorder(T,v.right)

### Ordered Binary Tree
- Or Binary Search Tree
- Used to make searching efficient
- The element of the *left* child is *less* than that of the parent.
- The element of the *right* child is *greather* than that of the parent.

#### Search Ordered Binary Tree
- To find a goal node:
	1. Start at the root node
	1. If the element you want is less than the root, go to the left node
	1. If the element you want if greater than the root, go to the right node
	1. Repeat this process until you find the goal.
- Takes at most the height of the tree
- To keep searching efficient, keep the tree balanced
- Minimum height of tree with n nodes is height = floor(log<sub>2</sub>(n))
	- In worst case should take log<sub>2</sub>(n) operations to find an 
	  element
	- Compare with array or linked list - n operations

##### Find the Smallest Element
- Keep going left until you cannot go left anymore

##### Find the Largest Element
- Keep going right until you cannot go right anymore

#### Add Element
1. Search through three until a leaf node is reached
1. If the new element is less than the leaf node, add the new node to the left, 
else add it to the right.

#### Remove Element
1. If the element to be removed is a leaf, simply delete it
1. If the element has *one* child, connect the child to the old node's parent
1. If the element has two children, we first need to find the successor
	1. The successor should be the smallest element of the right sub-tree
	1. **Or** the largest element of the left sub-tree
	1. Move the successor into the place of the old node
	1. Move the successor's right sub-tree to where the successor was

## Search

### State-Space Graphs
- Select a goal state
- Identify the current state
- Finding a solution is simply a case of finding a path between these two in 
  the space state graph.
- The **solution** or plan, is the sequence of labels on the arcs
- Usually the graphs are too large to be held completely in memory

#### Generating Search Trees
- Generate the search tree by expanding nodes, ie generating its children
- Different search techniques essentially correspond to different ways of 
  selecting the next node.

#### Breadth First Search
- Following steps:
	1. Expand the leaf node with the **lowest** cost path so far,
	1. Add 1 to the path cost for a node to obtain the path cost of each of its 
	children
	1. Stop when you expand a node with is a goal node.
- Guaranteed to find the shortest path
- Memory intensive if the space is large
	- Space Complexity O(b<sup>d</sup>)
	- Time Complexity O(b<sup>d</sup>)
		- d= branching factor
		- b = depth of shallowest goal state.

##### Algorithm
1. Add root node to a queue,
1. Dequeue first element from queue,
1. If it is the goal state, *HALT*.
1. If it isn't. expand the node to show its children and add each to the queue,
1. Dequeue the first element in the queue,
1. **Goto** 3.

###### Pseudocode

		breadth-first-search(Tree):
			get root node r
			create a queue Q
			add r to Q
			while Q is not empty:
				t = Q.dequeue()
				if t is goal:
					return t // goal has been reached
				else:
					for all edges e Tree.adjacentEdges(t)
					V = Tree.adjacentVertices(t, e) //list of child nodes from t
					enqueue V onto Q

#### Depth First Search
- Following steps:
	1. Generate the successors of the leaf node with the **highest** cost path 
	so far.
	1. Add 1 to a node's path cost to obtain the path cost of its children.
	1. Stop when you expand a goal node.
- Use stack as data structure to hold information about the search
	- Instead of adding items to examine to the end of a queue, add them to the 
	  top of the stack.
	- Pop the top item each iteration.
- Not guaranteed to find any path to a goal state.
- Memory efficient
	- Space Complexity O(bm)
	- Time Complexity O(b<sup>m</sup>)
		- m = maximum depth of search tree (can't be &infin;)

###### Pseudocode

		depth-first-search(Tree):
			get root node r
			create a stack S
			push r to S
			while S is not empty:
				t = S.pop()
				if t is goal:
					return t // goal has been reached
				else:
					for all edges e Tree.adjacentEdges(t)
					V = Tree.adjacentVertices

#### Depth-Limited Search
- Put limit on how deep the DFS goes to guarantee that the search will 
  terminate.
- Perform DFS to a depth limit h
- If the depth of the goal is &le; h, then DLS is complete.
- Still not guaranteed to find the shortest path
- Space Complexity O(bd)
- Time Complexity O(b<sup>d</sup>)

#### Depth-First Iterative Deepening
- Extends depth-limited search
- Start by doing DLS with h = 1
- Then reset
	- OPEN = [initial-state]
	- CLOSED = []
	- increase h by 1
	- repeat DLS with new limit
	- iterate, increasing h by 1 each time.
- Always expands many nodes more than once
	- Still spends most of its time at the bottom level
	- Better that BFS and DFS
- Guaranteed to find the goal node.
	- Complete and optimal
- Space Complexity O(bd)
	- same as DFS since only one path is maintained in memory.

### Heuristics
- Quick to compute, approximate rules for guide search and reduce work load.
- Used throughout AI
- Not guaranteed to work

#### Hill Climbing
- Steepest ascent hill climbing
	1. Generate the children of the current state
	1. Calculate the heuristic value of each
	1. Select the path with the "best" heuristic value
	1. Repeat until you can't improve
- Will often reach a point where there are no improvements to be found
	- ie **plateau**
	- No efficient way to cross a large plateau if there is no information (by 
	  definition) to guide the search.

#### Best-First Search
- Remember the complete tree searched so far (as in BFS),
- Use &#292; (evaluation function) to decide which leaf node to expand next
	- instead of path cost.
- &#292; function is declared by the designer, specific to the situation.

#### A\* Search
- To obtain better searching we need to take into account the cose of the path 
  **so far**
- g(A) = cost of the path from the root node to node A
- &#292;(A) = heuristic estimate of the cose of the path from node A to a goal 
  state.
- f(A) is an estimate of the total cost of the path through A that starts at 
  the root node and ends at the goal,
	- f(A) = g(A) + &#292;(A)

### Agenda Based Search
- Combines
	- depth-first (depth-limited, DFID),
	- breadth-first
	- best-first with &#292;
	- best-first with f (A\* search)
- Split the nodes into two lists:
	1. `OPEN` - nodes to expand (leaves)
	1. `CLOSED` -nodes already expanded (internal)
	1. Order nodes in OPEN according to some criteria
		- eg order by depth of node 
			- deepest first (depth-first search)
			- shallowest first (breadth-first search)
	1. Expand the first node in OPEN
	1. Put it in CLOSED
	1. Add it's children to OPEN
	1. Reorder OPEN
		- To obtain depth-first search, also need to delete nodes from CLOSED 
		  when we backtrack.
	1. **Goto** 3

#### Agenda Heuristics
- Reorder OPEN by &#292;
	- Now have best-first search
	- Also called *Greedy-search*
- Best-first search using &#292; to reorder OPEN = greedy search
- Best-first search using g to reorder OPEN = uniform cost search
- Best-first search using f=g(A) + &#292;(A) to reorder OPEN = A\* search

### Search for Games
- States of a game such as chess are easy to represent
	- Actions on the states are restricted to a small number of well defined 
	  actions
	- Simplicity of the rules combined with the programmable states of the 
	  world means that this can be represented as a search problem through a 
	  space of all possible game positions.
	- Representation of the game can be correct in every possible way
		- unlike eg fighting a war.

#### Chess
- Introduction of an opponent bring uncertainty to the search space
	- Oppenent will attempt to make the best possible move.
- Average game of chess
	- branching factor 35
	- roughly 50 moves per player
	- Search tree has ~35<sup>100</sup> nodes
		- Can't search all possible solutions in reasonable time
		- Make guesses based upon past experiences.

#### Decision Making in Two Player Games
- Consider a two player game between players `MAX` and `MIN`
- Define a game as a search problem:
	- **Initial state** - board position and whose move it is
	- **Set of actions** - legal moves a player can make
	- **Terminal test** - check if the game is over
	- **Set of utility functions** - numeric value of the outcome of the game, 
	  +1, 0, -1.

#### Minimax Algorithm
- Steps:
	1. Generate the whole game tree down to the terminal states
	1. Apply the utility function to each terminal state to get its value
	1. Use this utility value of each terminal to determine the utility value of 
	its parent nodes
	1. Continue backing up the values from the leaf nodes towards the root, one 
	layer at a time.
	1. Eventually reach the root of the tree.
		- Now `MAX` must choose the root that maximises the utility value
- Time Complexity O(b<sup>m</sup>)
	- m = maximum depth of the tree
	- b = number of legal moves at each point
	- Impractical for real games
		- Basis for more realistic methods
- Depth-first search algorthmic
- Implementation uses **recursion** instead of a queue

###### Pseudocode
		MiniMax-Decision( game ):
			for each action in actions( game ):
				state = apply( action, game )
				value[ action ] = MiniMax-Value( state, game)
			return action with the highest value[ action ]

		MiniMax-Value( state, game ):
			if state == gameOver: // is a leaf node
				return utility-value( state )
			else if state == maxNode: // MAX's move
				return highest MiniMax-Value of successors( state, game )
			else: // MIN's move
				return lowest MiniMax-Value of successors( state, game )

#### Improvements
- Minimax assumes that a program must search all the way to the terminal states
	- not practical
- Should cut off the search earlier and apply heuristic evaluation function
- Alter:
	1. Utility function replaced by evaluation function `EVAL`
		- Estimates expected utility of the game from given position
	1. Terminal test replaced by cutoff test `CUTOFF-TEST`
- Quality of game playing program dependant on its evaluation function.
	- `EVAL` must agree with utility on terminal states
	- `EVAL` must not take too long
	- `EVAL` must reflect chances of winning

#### Cutting Off Search
- Set a depth limit (depth-limited search)
- Depth is chosen to ensure the game does not take too long
- Iterative deepening is a more reliable approach
- When time runs out, program returns move selected by the deepest completed 
  search
	- Can have negative consequences

##### Alpha-Beta Pruning
- Returns same move as Minimax
- Prunes branches that cannot possibly influence the final decision
- Algorithm:
	- Consider a node n in the tree
	- If a player has a better choice, m, either at the parent node of n or at 
	  any point further up, then n will *never be reached in actual play*.
	- Once enough is known about n to reach this decision, it is pruned.
