---
layout: default
title: Data Structures Notes
---

# Data Structures

* * *
* TOC
{:toc}
* * *

## Efficiency and Complexity

### Time vs. Space Complexity
- Often need to balance the space taken to implement algorithm with the speed 
  that the algorithm provides.
- More space often means less time.
- Less time often means less space.
- Space usually refers to memory
	- How many objects must the computer hold which it will need to refer back 
	  to at a later stage.

### Average vs. Worst Case Complexity
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

## Data Structures
- `Average O()`, `worst O()`
- If average=worst, `O()`

|--
| Structure      | Space | Search         | Insert         | Delete         |
| :------------- | :---: | :------------: | :------------: | :------------: |
| Unsorted Array | O(n)  | O(n)           | O(1)           | O(n)           |
| Sorted Array   | O(n)  | O(log n)       | O(n)           | O(n)           |
| Stack          | O(n)  | N/A            | O(1)           | O(1)           |
| Linked List    | O(n)  | O(n)           | O(n)           | O(n)           |
| Search Tree    | O(n)  | O(log n), O(n) | O(log n), O(n) | O(log n), O(n) |
| AVL Tree       | O(n)  | O(log n), O(n) | O(log n), O(n) | O(log n), O(n) |
| Binary Heap    | O(n)  | N/A            | O(1), O(log n) | O(log n)       |
| Hash Table     | O(n)  | O(1), O(n)     | O(1), O(n)     | O(1), O(n)     |

### Array
- Simplest data structure
- Set size
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

### Average vs. Worst Case Complexity
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

## Trees
- Set of nodes with zero or more children.
- Each node can have at most 1 parent.

### Binary Trees
- Special type of trees where nodes have 0, 1 or 2 children.
- Height
	- Number of levels from top to bottom of the tree.
	- Maximum possible is n-1 where n is the number of nodes in the tree
		- Only when the tree is arranged in a line
	- Minimum possible when the tree is perfectly balanced
		- h = log₂(s+1)-1 ≈ log₂s
- Height of a node
	- Number of levels from the bottom of the tree to the current node.
- Depth of a node
	- Number of levels from the root node of the tree to the current node.

### Binary Search Tree
- Same as a search tree but with specified order for children of each node
	- The left element must be smaller than the root
	- Right child must be larger than the root.
- Order of nodes then is

  ~~~
  left child → root node → right child
  ~~~

#### Deleting Nodes
1. If the node to be deleted is a leaf node, just remove it.
1. If only one of the nodes subtrees is non-empty, just "move up" the remaining 
   subtree to take the place of the node that has been removed.
1.  If the node to be deleted has two subtrees, take the largest node from the
	left subtree and use this to overwrite the node that is to be deleted.  
	Replace the left-must node by its right subtree, if this exists, otherwise 
	just delete it.

### Balanced Trees
- Simplest form of balanced tree is the AVL tree
	- Specifies that the heights of the subtrees of any node can differ by at 
	  most 1.
	- Right and left rotations are used to balance an unbalanced tree.

### AVL Tree
- Tree structure with additional constraint that the heights of any children of
  a given node can differ by a maximum of 1, ie
	- Right can be taller than left by 1, or
	- Left can be taller than right by 1, or 
	- Right and left can be same height.

### Maps
- Set of entries consisting of a `key` and a `value`.
- Two entries cannot have the same key
	- Entries are uniquely identified by their key value.
- eg Dictionary.

#### Ordered Maps
- Usually there is some order to the keys so that they can be compared.
- Usually the keys are all integers or all strings

### Hash Maps
- Special sort of map
- Key is the hash of the value.
- Searching and insertion is constant.

### Priority Collections
- Efficient way of storing elements which are sorted by a priority
- Ensure that the highest priority element is accessible with complexity O(1)
- When adding new elements, sortedness is not maintained other than priority.

#### Heap Trees
- Satisfies the following conditions:
	1. The priority of the root is higher than (or equal) to that of its
	   children.
	1. The left and right subtrees of the root are heap trees.
- Priority collection where the priority of every node is higher than (or equal
  to) that of all its decendents.
- The tree is a *complete binary tree*
	- All levels of the tree, except possibly the last, are fully filled, and
	  if the last is not filled, the nodes of that level are filled from right
	  to left.
- Allows trees to be stored in arrays
		- Not efficient to store unbalanced tree in array since space must be
		  left for missing elements which could mean many empty elements.
- For a min-heap tree:
	- All nodes are less than or equal to their parent.
	- Used for priority collections.
	- Smallest number at the top.
- For a max-heap tree:
	- All nodes are greater than or equal to their parent.
	- Biggest number at the top.

##### Adding New Elements
1. Adding new elements is simply appending it to the last position in the tree,
   maintaining completeness.
1. The heap tree is then checked to make sure it is still valid.
1. If valid, the adding is complete.
1. If not, the new item is "bubbled up" until the tree is valid.
	1. Compare its priority with that of its parent
	1. If it has a higher priority, the element and its parent are swapped.
	1. Continue until an element with a higher priority is found as parent.
		- Assumes that the heap tree is valid before starting.

##### Deleting Elements
1. Removing the root will be a common action performed, since this is the
   highest priority element.
1. This can be simply removed and replaced with the element at the "last"
   position.
1. Check that the heap tree is still valid.
1. If not, "bubble down"
	1. Compare with both children.
	1. Exchange with the largest priority child.
	1. Repeat until the new root has found a valid place.

## Sorting Algorithms

### Sorting Methods
Enumeration
: If we know that there are N items that are smaller than the one we are 
currently considering, then its final position will be N+1.

Exchange
: It two items are out of order, exchange them and repeat until all items are 
in order.

Selection
: Find the smallest item and place it in the first position, find smallest item 
of the remaining items and place it in the second position. Continue until all 
items are sorted.

Insertion
: One at a time, place the items into an initially empty data structure so that 
at each stage, the structure remains sorted.

Divide and conquer
: Recursively split the items into smaller sub-sets until only single items 
remain, which are trivial to sort. Put the sorted parts back together so that 
at each level, the sorting is maintained.

## Sorting Algorithms

### Sorting Methods
Enumeration
: If we know that there are N items that are smaller than the one we are 
currently considering, then its final position will be N+1.

Exchange
: It two items are out of order, exchange them and repeat until all items are 
in order.

Selection
: Find the smallest item and place it in the first position, find smallest item 
of the remaining items and place it in the second position. Continue until all 
items are sorted.

Insertion
: One at a time, place the items into an initially empty data structure so that 
at each stage, the structure remains sorted.

Divide and conquer
: Recursively split the items into smaller sub-sets until only single items 
remain, which are trivial to sort. Put the sorted parts back together so that 
at each level, the sorting is maintained.

|--
| Name           | Strategy  | Worst Case | Average Case |
| :------------- | :-------  | :--------: | :----------: |
| Bubble sort    | Exchange  | O(n²)      | O(n²)        |
| Insertion sort | Insertion | O(n²)      | O(n²)        |
| Select sort    | Selection | O(n²)      | O(n²)        |
| Tree sort      | Insertion | O(n²)      | O(n log₂n)   |
| Heap sort      | Selection | O(n log₂n) | O(n log₂n)   |
| Quick sort     | D & C     | O(n²)      | O(n log₂n)   |
| Merge sort     | D & C     | O(n log₂n) | O(n log₂n)   |

### Bubble Sort
1. Compare first pair of elements.
1. If they are in the wrong order, swap them.
1. Repeat with next pair.
1. Stop when a full pass is made with no swaps.

### Insertion Sort
1. Read first element.
1. Place in position 0.
1. Read next element, place in correct position
1. Continue until all elements have been positioned

### Selection Sort
1. Scan through all elements, select smallest element
1. Place in position 0.
1. Scan through remaining elements, select smallest.
1. Place in position 1.
1. Continue until all elements have been positioned.

### Tree Sort
1. Place first element into empty binary tree.
1. Continue until all elements are in the tree.
1. Read elements from the tree "in-order".

### Heap Sort
1. Place first element into heap tree.
1. Continue until all elements have been added.
1. If the heap tree is implemented as an array, then the array is sorted.
1. Otherwise read from the tree into an array.

### Quick Sort
1. Choose an element to be the pivot.
1. Place all elements smaller than the pivot to the left, larger to the right.
	- The pivot is now sorted
1. Repeat recursively for each of the two sub arrays on either side of the 
   pivot.
1. When single elements are encountered, they are sorted.

### Merge Sort
1. Recursively split the elements into smaller sub arrays until all elements 
   exist as single elements.
1. Recombine arrays maintaining sortedness.

## Searching Algorithms

## Data Structure Invarients
- May be **assumed** at the *start* of the operation.
- Might be violated in the middle of the operation
	- Thats acceptable and might be nessessary
- Must be **ensured** at the *end* of the operation.
- Must be **ensured** and so may be **assumed** whenever a new data structure
  is created.
<!--
Created:  Wed 09 Apr 2014 10:04:50 am
Modified: Tue 22 Apr 2014 05:42 pm
-->
