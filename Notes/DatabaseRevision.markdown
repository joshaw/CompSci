Title: Database Notes.
CSS: css.css

#Databases

* * *
* TOC
{:toc}
* * *

##Tables, Attributes and Entities
###Attribute
- The names of the different information in a table, ie column headers

###Redundancy
- Replicating data in multiple places unnecessarily
- Increases the likelihood of data anomalies and lack of integrity
- A type of inefficiency

###Pointing
- Referring to a non-local location by means of the definitive location
	- Means that if the object being referred to moves, then the link is broken
	- eg linking to chapter X, page Y in an index

###Associative Linking
- Using specific individual name or identifier to refer between two locations 
  where the same information is needed in both, eg tables
	- eg linking to chapter X.Y.Z in an contents
- When used in a database, typically the column names of the shared attribute 
  in each table will be the same or similar, though this is not required

###Referential Integrity
- Relevant when one place in a data repository needs to refer to something in
	another place
- Referential integrity is achieved when every such referring place contains a
	successful reference to another place or place-occupant (or no reference at
	all)
	- Successful there means that the reference succeeds in specifying some
		other place

###Entity Types
- The main defining aspect of the data in a single table that allows that data 
  to be grouped together

###Entities
- Each of the individual elements of the same entity type in a table

###Connectivity
- 1:1
	- One to One
	- Every entity in a table is related to exactly 1 entity in another table.  
	  There cannot be more that one connection and there cannot be no 
	  connections.
	- eg **person <-> ID number**
		- Each person has a single ID and every ID has a single person
- 1:M
	- One to Many
	- Every entity in a table can have many different connections to entity 
	  types in other tables.
	- eg **manager <-> people**
		- Each manager manages sever people, but each person is only managed by 
		  a single manager
- M:N
	- Many to Many
	- Each entity can be connected to many other entities and connection can be 
	  repeated many times
	- eg **person <-> lecture courses**
		- Each person is enrolled on multiple lecture courses, and each lecture 
		  course has many people enrolled on it.

###Cardinality
- The number of other entities that are allowed and/or required to be related 
  to the first for a particular entity
	- Given as a minimum, a maximum or both a min and max

###Optionality
- Also referred to as relationship participation
- A relationship is optional if it does not have to exist for any given entity
	- eg **person -> loaned book**
	- Not every person has to have a book on loan
- A relationship is mandatory if it has to exist for an entity
	- eg **loaned book -> person**
	- Every book on loan must have some person who has taken it out
- Both of these require specification of the direction that the optionality is 
  applied
	- Could be optional in one direction but mandatory in the other

###Functional Dependence
- An attribute, or set of attributes, depends on a separate attribute, or set 
  of attributes, if each value of the first is associated with exactly one in 
  the other.
- Conversely, an attribute determines another if the second is functionally 
  dependant on the first
	- eg Day-number, month and year **determine** day-name
	- eg Day-name **is functionally dependant on** day-number, month and year

###Determinant
- The determining set of attributes
	- eg the determinant day-number, month and year determines day-name

###Business Rule
- A short concise and unique description of a policy, procedure or principle 
  within a particular organisation

###Keys
####Superkey
- Determines all other attributes in the table
- Trivially, the set of all attributes must be a superkey in order to prevent 
  duplicate entries in a table

####Candidate Key
- A minimal superkey
	- Cannot remove any attributes and still have a superkey

####Primary Key
- Chosen candidate key to identify entities in a table
	- The simpler the primary key, the better
	- Not allowed to contain any null values since there could then be two 
	  elements with the same null value causing duplication
- Used to access entities of an entity type as quickly as possible
	- Better to use short, alphanumeric, non-ambiguous keys

####Foreign Key
- A primary key from another table that is included in a table to represent the 
  relationship between those two tables
	- Associative linking
	- For a 1:1 mapping, the foreign key can be used to identify elements in 
	  both directions as long as there are no null values in either side

###Bridging Table
- Also called Linking table
- Splits an M:N relationship into two relationships that are both 1:M
	- eg **Person <-> lecture courses**
		- could be split into 
	- **Person <-> enrollment** *and* **enrollment <-> lecture courses**
	- For each person, there are several enrollments, but for each enrollment 
	  there is just a single lecture course. Similarly, for each lecture 
	  course, there are several enrollments but for each enrollment there is 
	  only one person
- The primary key in the bridging table is the combination of the foreign keys 
  for each of the two separate 1:M tables

###Relationship Strength
- A relationship is strong when the second entity contains the primary key of 
  the first
	- eg **A -> B** is *strong* if B's PK contains A's PK
	- So B's entities are defined in terms of A's entities
	- Includes to case when PK(B) = PK(A)
- When a relationship is not *strong* it is *weak*
	- Most relationships are weak, ie the PK's in most relationships do not 
	  share attributes.
- The strength of a relationship is directional
	- Usually a strong relationship is only strong in one direction
		- To be strong in both directions, PK(A) = PK(B)
	- if **PK(A) &isin; PK(B)** then relationship BA is strong
	- if **PK(B) &isin; PK(A)** then relationship AB is strong
	- if **PK(A) = PK(B)** then both relationship AB and BA are strong

### Entity Type Strength
- An entity type is *weak* if there is a *strong* relationship between it and 
  another type and it is existence dependant on that other type via the strong 
  relationship
	- eg a person could be said to be weak if they are strongly related so 
	  someone else
	- This is the same as saying that the reverse relationship be mandatory
- Usually entity types are *strong*

###Multi-Valued Attributes
- A multi-valued attribute can have on or more values
- Several possible methods for dealing with them
	- Could represent the values as a string with each value concatenated with 
	  the others
	- Or could give each value a separate attribute
		- Requires some maximum number of "sub"-attributes that is allowed to 
		  be represented. For the elements where this maximum is not needed, 
		  the values are left blank, null
		- Need to know the maximum number of attributes in order to create 
		  columns for them
	- Or separate the multi-quality attribute into a separate linked table so 
	  that the PK in the main table is used to identify the appropriate entries 
	  in the new second table

## Generalisation Hierarchy
- Or specialization hierarchy
- A group of relationships each of which is between a higher-level *supertype* 
  entity and a lower-level *subtype* entity.
- Primary key of a subtype is the same as the primary key of its supertype.

###Sub- and Super-Types
- Super-type - contains attributes shared by all its sub-types
- Sub-type - contains special attributes not shared by its sisters
	- A super-type has a 1:1 relationship with each sub-type
		- **Mandatory** in the **sub-to-super** direction
		- **Optional** in the **super-to-sub** direction

###Disjoint
- Each entity in the super-type can appear in at most one of the subtypes
	- **0** or **1**

###Overlapping
- A given entity type can appear in more than one sub-type
	- **0** or **more**

### Exhaustive
- Each entity in the super-type must appear in at least one one of the
  sub-types
	- **1** or **more**

##Types of Relationship
####Unary
- Contains just a single entity
	- eg **subject -> *requires* -> subject** 
	- the subjects have to be different, but they are of the same entity type

####Binary
- Contains two **types** of entity
	- eg **teacher -> *teaches* -> subject**

####Ternary
- Contains three **types** of entity
	- eg **teacher *from* course -> *teaches* -> subject**

####Recursive
- Two or more of the relationships contain more than 1 of the same entity types
	- eg **person -> married to -> person**

####Symmetry
- Symmetric
	- Both entities in a two entity recursive relationship refer to each other
		- eg **person -> married to -> person**
- Anti-symmetric
	- An relationship between two entities of the same type cannot allow the 
	  two type to be related to each other via the same relationship
		- eg **course1 -> requires -> course2**
		- course1 and course2 cannot be the same
- Only makes sense in the 1:1 and M:N cases

## Entity Relationship Models and Diagrams (ERM & ERD)
###ERM
- Just the concept of thinking about a database as consisting of: 
	- Entities
	- Attributes
	- Relationships
- Applying this approach in a particular case gives rise to ER models for that 
  situation

###ERD's
####Chen Model
- Rectangles represent entity types
	- Weak entity types are shown with a double rectangle
- Diamonds represent relationships
	- No information given regarding the direction of the relationship, up to 
	  the designer to make this clear from the names given to the entities 
	  involved and the relationship
- Bridging types are marked clearly with a diamond inside a rectangle
- A marker (1, M) is placed above the junction between entity and relationship 
  to inform regarding the connectivity
- Entities are represented with an oval connected to the relevant entity type
- A marker is placed below this junction to show cardinality
	- eg **(0,3)** means at least 0 and at most 3
	- eg **(4,M)** means more than 4 but no maximum
- Optionality is shown by changing the end of the line where it meets the 
  entity type
	- Normal or mandatory is not changed
	- Optional replaces the end of the line with a circle
- The primary is represented by underlining the relevant entities

![Chen Model example diagram][1]

####Crows Foot Model
- Rectangles represent entity types
	- Information about the entities, and the primary and foreign keys are 
	  shown below the name of the entity type
- Relationships are shown on top of lines connecting entity types
- Connectivity is shown with the end type of the relationship line
	- A line with a crossed vertical line represents a 1 relationship
	- A line which ends in a "crows foot" represents an M relationship
- Optionality is shown using a circle at the end of the line, before the 
  connectivity marker for an optional relationship
	- Normal and mandatory relationships are not changed
- Weak relationships are shown with a dashed line
- There is no specific highlighting of relationship strength

![Crows Foot Model diagram][2]

##Sets
###Membership Relationships
- **a** is a member of **A**
	- a &isin; A
- **a** is not a member of **A**
	- a &notin; A
- **A** is a subset of **B**
	- A &sube; B
- **A** is not a subset of **B**
	- A &nsub; B

###Operations
- *Union* of **A** and **B** (OR)
	- A &cup; B
	- Note: no repetitions created
- *Intersection of* **A** and **B** (AND)
	- A &cap; B
- *Difference* of **A** with **B** (NOT)
	- A - B
	- A ¬ B
	- A \ B
	- Note: set of elements that are in A but not B

####Properties of Operations
- Union and intersection are *commutititve*;
	- A &cup; B = B &cup; A
	- A &cap; B = B &cap; A
- Union and intersection are *associative*
	- A &cup; ( B &cup; C ) = ( A &cup; B ) &cup; C
	- A &cap; ( B &cap; C ) = ( A &cap; B ) &cap; C
- Union *distributes over* intersection
	- A &cup; ( B &cap; C ) = ( A &cup; B ) &cap; ( A &cup; C )
- Intersection *distributes over* union
	- A &cap; ( B &cup; C ) = ( A &cap; B ) &cup; ( A &cap; C )



[1]: http://ce-gmbh.com/images/chen2.JPG
[2]: http://i.stack.imgur.com/V62Rm.jpg
