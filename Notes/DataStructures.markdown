---
layout: default
title: Data Structures Notes
---

# Data Structures

## Arrays, Lists, Stacks and Queues

### Array
- Simplest data structure
- Set size
- a[i]
- Very fast read
- Very slow to add element mid array

### Linked List
- Each element made of two "cells"
	- First contains the value to be stored
	- Second has a pointer to the next element in the list
- i → j → k → X
- Ends with a null pointer to indicate that the list is finished

### Stack
- Used for **FIFO** and **LIFO**
- Only the first (for FIFO) element that was added, or the last element (LIFO) 
  is availible for access.

### Queue
- Similar to a linked list with a pointer that keeps track of the front and the 
  end of the list so that adding an element at the end and the start of the 
  queue can be performed with equal effor.

### Doubly Linked List
- Same as a linked list but as well as the pointer from each element to the 
  next, there is also a pointer from each element to the previous.
- List can be traversed in either direction
- X ← i ←→ j ←→ k → X

#### Circularly Doubly Linked List
- Simple extension that simply links the last value in the list to the first
- No null pointers are used
- Useful for application such as buffering a video that only need the current 
  part
	- Once that has been used, it can be overwritten.

## Efficiency and Complexity

### Time vs. Space Complexity
- Often need to balance the space taken to implement algorithm with the speed 
  that the algorithm provides.
- More space often means less time.
- Less time often means less space.
- Space usually refers to memory
	- How many objects must the computer hold which it will need to refer back 
	  to at a later stage.

### Avergae vs. Worst Case Complexity
- Some inputs to an algorithm might mean that it takes an extremely long time 
  to compute, longer than most others.
- This longest case can be very important, or it can not matter that once in a 
  while it takes longer.
	- System critical applications
	- If the worst case complexity of something in an autopilot is very bad, 
	  then the whole aircraft would be at danger, even if it only occured every 
	  10,000 times the algorithm is run.
- Average case is the time that a normal input, or averaged over many different 
  inputs, takes to complete.

|--
| Name           | Strategy  | Worst Case | Average Case |
| :---           | :-------  | :--------: | :----------: |
| Bubble sort    | Exchange  | O(n²)      | O(n²)        |
| Select sort    | Selection | O(n²)      | O(n²)        |
| Insertion sort | Insertion | O(n²)      | O(n²)        |
| Tree sort      | Insertion | O(n²)      | O(n log n)   |
| Heap sort      | Selection | O(n log n) | O(n log n)   |
| Quick sort     | D & C     | O(n²)      | O(n log n)   |
| Merge sort     | D & C     | O(n log n) | O(n log n)   |
