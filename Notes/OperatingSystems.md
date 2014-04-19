---
layout: default
title: Operating Systems and Networks
---

# Operating Systems

* * *
* TOC
{:toc}
* * *

## Memory
- Read-Only Memory (**ROM**)
	- Cannot be modified
	- Suitable for bootstrap program or game cartridges
- Electronically Erasable Programmable Read-Only Memory (**EEPROM**)
	- Can be modified, but not frequently
- Random-Access Memory (**RAM**)
	- Memory that allows access at random
	- CPU uses RAM as it needs read and write access.
	- Often implemented in Dynamic Random-Access Memory (DRAM).

## CPU

### CPU Modes
- **Kernel Mode**
	- CPU can execute every instruction in its instruction set
	- Can use every feature of the hardware
	- Complete access to hardware
	- When CPU is in kernel mode we say the OS is also in kernel mode
- **User Mode**
	- User programs run in user mode
	- Permits only a small subset of instructions to be executed
	- Subset of features of the hardware can be accessed
		- Generally disallows all instructions involving I/O and memory 
		  protection
- Program Status Work (**PSW**)
	- Register that keeps the mode of the CPU

### TRAP
- Either caused by system call or by hardware
- Used by hardware to warn of an exceptional situation 
	- eg attempt to divide by 0
	- eg arithmetic underflow
- Operating system gets control and must decide what to do
	- eg OS terminates program when error occurs
	- eg error can be ignored and underflowed number set to 0

### System Call
- To do any operation that required kernel mode, a user program makes a 
  **system call**
- **Traps** into the kernal and invokes the operating system
- `TRAP` instruction switches from user mode to kernel mode
- Control is returned to the user program when the operation is completed.
- Typically written in C, C++ or Assembly
	- Same or similar to the language the kernel is written in.

#### Application Programming Interface
- Application Programming Interface (API)
- Specifies a set of instructions that are availible to an application 
  programmer
	- Includes parameters that are pases to each function and the return values
- Programmer accesses an API via library of code provided by the operating 
  system.
- eg Windows API for Windows Systems
	- eg `CreateProcess()` invokes the `NTCreateProcess()` system call in the 
	  Windows kernel
- eg POSIX API for POSIX-complient systems (UNIX, GNU/Linux, Mac OS X)
- eg Java API for programs the run on the Java Virtual Machine
- When a user program makes a system call:
	1. Caller only needs to know the signature
	1. Method call and parameters are passed into registers
	1. Values saved in memory
	1. Stack is preferred because it does not put a limit on the number of 
	parameters stored.

### System Boot
1. Initializes all aspects of the system
	- CPU
	- Registers
	- Device controllers
	- Memory cards
1. Load operating system and kernel to memory and start them.
- Init system saved to firmware since CPU cannot hold information when it has 
  no power.
	- Saved in hardware chip
	- Either read-only memory (**ROM**)
	- Or electronically erasable programmable read-only memory (**EEPROM**)
- After boot process
	1. Programs started at boot become system daemons/processes
	1. System waits for events to occur
		- eg mouse click, program wanting file access
		- Events known as interrupts
		
### Interrupts
- Hardware may trigger interrupt at any time by sending a singal to the CPU
- Software may trigger an interrupt by executing `system call`.
- When the CPU is interrupted:
	1. Stops current operation immediately
	1. Transfers execution to a fixed location
		- Fixed location usually contains the starting address where the 
		  service routine for the interrupt is located
	1. The interrupt service route executes
	1. When the operation has been completed, CPU resumes the operation that 
	   was interrupted.

## Devices
- Interact via **device controller** connected through a common bus to CPU.
- Small computer-systems interface (**SCSI**)
	- Hardware that allows SCSI storage device to communicate with the 
	  operating system using a SCSI bus

### Device Controller
- Moves data between the peripheral devices that it controls and its local 
  buffer storage
- Device driver exists for each device controller
	- Understands the device controller and provides the rest of the OS with a 
	  uniform interface to the device.
	1. Loads appropriate registers within the device controller
	1. Device controller decides what to do based on contents of registers
	1. Controller starts the transfer of data from the device to its local 
	   buffer
	1. When data transfer is complete, controller informs the device driver via 
	   an interrupt that it has finished its operation
	1. Device driver then returns control to the operating system.
- Works well for small data transfers, mouse, keyboard etc.
- Not good for large data transfer, disk I/O etc.
- For large transfers of data use Direct Memory Access (**DMA**)
	- Removes CPU from the loop
	- After setting up buffers, pointers and counters for the I/O device, the 
	  device controller transfers an entire block of data directly ro or from 
	  its own buffer storage to memory
		- No intervention from the CPU is needed.
	- Only one interrup is generate per block
		- To tell the device driver tyhat the operation has completed
		- Rather than one interrupt per byte generated for low-speed devices.
		- CPU is free for other operations.

## MultiTasking
- Maximising CPU utilisation
- *Time sharing*
	- Switch CPU among processes so that users can interact with several 
	  processes simultaneously
- In reality, only one process can run at a time, the others must wait.

### Time Sharing
- Several jobs are kept simultaneously in memory
- CPU schedule decides which job is brought to memory to be executed
- Reasonable reponse time must be ensured
	- Processes are *swapped* in and out of main memory to the disk
	- Use *virtual memory* 
		- Allows execution of a process that is not completely in memory.
		- Enables users to run programs that are larger than the actual 
		  physical memory of the machine.
		- Further abstracts the main memory into a large, uniform array of 
		  storage
		- Separates logical memory as viewed by the user from the physical 
		  memory implemented in hardware
		- Frees programmers from concern over memory-storage limitations.

### Process Scheduler
- Selects an available process for program execution on the CPU
- **Job Queue**
	- All processes in the system
- **Ready Queue**
	- Processes that are in main memory and are ready and waiting to execute
- **Device Queue**
	- Processes waiting for access to a particular device

### Context Switching
- eg interrupt
	- Causes a *state save* of the current state of the CPU 
	- Then a *state restore* to resume operations
- Kernel saves the context of the old process in PCB and loads saved context of 
  the new process scheduled to run
- Context-switch time is pure overhead
	- Varies from machine to machine (few milliseconds)

### Stopping a Running Program
- Normally
	- `end()`
- Abnormally
	- `abort()`
	- eg division by zero
	- eg file not available

## Processes
- Program is a passive entity
	- Contains the instructions to achieve some goal
	- Stored on disk
- Process is an active entity
	- Program counter specifies the next instruction to execute
	- Set of associated resources
- Program becomes a process when an executable file is loaded into memory
- Process has the following
	- **Text Section** 
		- Program code
	- **Current Activity**
		- Value of the program counter
		- Contents of the processor's registers
	- **Process Stack**
		- Temporary data
			- eg function parameters, return addresses, local variables
	- **Data Section**
		- Global variables
	- **Heap**
		- Dynamically allocated memory
			- Allocated at runtime
		- Manually managed
			- `malloc()`, `calloc()`
		- Variables are essentially global in scope
		- Slightly slower to read and write than stack
			- Uses pointers to access memory
	- **Stack**
		- Contiguous block of memory allocated to each process
		- LIFO
		- Managed memory
			- Efficient
			- Very fast

### Process in Linux
- `fork()` makes a new process
- New process has a copy of the address of the original process
	- Better communication between father and child process
	- Father continues executing and child calls `exec()` system call and 
	  replaces memory space with new program
	- Both processes can create more children
	- Father invokes `wait()` system call to move to ready queue until the 
	  termination of the child
- **Termination**
	- A process terminates when it finishes executing its final statement and 
	  asks the operating system to delete it
		- `exit()` system call
	- Returns *status value* (typically an integer) to parent process
		- via `wait()` system call
	- All resources of the process are deallocated by the operating system
- If parents terminate, all children are terminated
	- *Cascading termination*

### Process Control Block (PCB)
- Information required for context switching
	- Process state
	- Program counter
	- CPU registers
	- CPU-scheduling information
	- Memory-management information
	- Accounting information
	- I/O status information

## Threads
- Threads have
	- thread ID
	- program counter
	- register set
	- stack
- Similar to separate processes but share some resources
	- code section
	- data section
	- OS resources
		- eg open files
- Modern OS are multi-threaded
	- Multiple threads operate in the kernel 
	- Each thread performs a specific task
		- eg managing devices, managing memory, interrupt handling

### Benefits
- Responsiveness
	- Time consuming operation, or lengthy process does not have to block the 
	  whole process.
- Resource sharing
	- Shared memory and message passing
	- Threads share the memory and the resources of the process to which they 
	  belong by default.
- Economy
	- Allocating memory and resources for processes and context switching is 
	  computationally costly.
	- Threads share the resources of the process so easier to create and switch 
	  threads
- Scalability
	- Multicore allows shared processing
	- Multi-threading is much faster than multi-processing

### Multi-Process vs Multicore
- **Mutli-process**
	- Many CPU on the chip
- **Multicore**
	- Single CPU chip has multiple computing core
		- Registers, cache, etc.
		- Faster communication 
			- No inter process communication
		- Significantly less energy consumed
- **Signle Core** 
	- Can emulate multicore by fast switching
	- None of the benafits
	- Tasks cannot run in parallel, instead have to be concurrent.


### User-Kernel Threads
- Dual mode
	- Protects agains harm caused by privileged instructions
	- Without dual mode
		- User can wipe out whole OS
- Kernel level threads are managed by kernel
- User interacts with user level threads
- Many-to-one model
	- Multiple user threads to one kernel thread
	- Thread management must be done in user space
		- Inefficient
	- Not widely used
	- Only one thread can access kernel at a time
	- Multiple threads are unable to run in parallel on multicore systems
		- All processes block if a thread makes a blocking system call
- One-to-one model
	- Each user thread is mapped to a kernel thread
	- Multiple threads can run in multiprocessors
	- Can be resource hungry and burden on performance
	- Upper bound on the number of threads
		
	  ~~~
	  $ cat /proc/sys/kernel/threads-max
	  47363
	  ~~~
- Many-to-many model
	- many user-level threads are handled by multiple kernel threads
	- When one thread performs a blocking system call, the kernel can schedule 
	  another thread for execution

## Inter Process Communication

### Communication Models

#### Message-Passing Model
1. Before message is sent, a connection must be opened
1. Sender creates a connection and askes the reciever to accept
1. Permission is granted by the reciever by accepting the connection
1. Sender can `write_message()` and reciever can `read_message()`
1. The connection must be terminated when not in use
	- `close_connection()`.

#### Shared Memory Model
- Also known as "Shared Black Board Model"
- Processes have read and write access to a shared portion of memory
- Usually the operating system restricts a process from accessing the memory 
  space of another process
	- For shared memory, tow or more processes agree to remove this restriction
	- Ensures two processes do not read and write the same location 
	  simultaneously

#### Pipe
- Temporary file is created on disk
- Command 1 writes to this file
- Command 2 reads from the file

### Communication Accross Network

#### Message Destination
- Given as socket plus port number
	- Sender uses any port
	- Receiver uses agreed port

#### Types of Send Failure
- Benign
	- Omission, stopping, timing, performance
- Arbitrary (called Byzantine)
	- Corrupt message, wrong method called, wrong result

|--
| Failure | Effects | Description |
| :------ | :------ | :---------- |
| Fail stop | Process | Process halts and remains halted. Other processes may detect this state. |
| Crash | Process | Process halts and remains halted. Other processes may not be able to detect this state. |
| Omission | Channel | A message inserted in an outgoing message buffer never arrives at the other end's incoming message buffer. |
| Receive-Omission | Process | A message is put in a process's incoming message buffer, but that process does not receive it. |
| Aribtrary (Byzantine) | Process or Channel | Process/channel exhibits arbitrary behaviour. It may send/transmit arbitrary messages at arbirary times, commit omissions or a process may stop or take an incorrect step. |

### Timing
- Common cause of failure is because of timing
- No global time is possible
- Computer clocks:
	- Have different drift rates
	- Rely on GPS radio signals or *clock synchronisation* algorithms.
- Event ordering
	- Carry timestamps
	- May arrive in wrong order due to transmission delays.

## Network Communication
- Types of networks
	- Personal Area Network (PAN)
		- Wireless Personal Area Network (WPAN)
	- Local Area Network (LAN)
		- Wireless Local Area Netork (WLAN)
	- Wide Area Network (WAN)
		- Wireless Metropolitan Area (WMAN)
	- Metropolitan Area Network (MAN)
		- Wireless Wide Area Network (WWAN)

|--
| Method   | Distance    | Bandwidth | Latency (ms)   | Technology       |
| :-----   | :-------    | :-------- | :------        | :---------       |
| LAN      | 1-2 km      | 10-1000   | Low (1-10)     | Ethernet         |
| WAN      | Worldwide   | 0.01-600  | High (100-500) | Satellite, cable |
| MAN      | 2-50km      | 1-150     | Low (1-10)     | ATM, ethernet    |
| WLAN     | 0.15-1.5 km | 2-11      | Medium (5-20)  | Routers          |
| WWAN     | Worldwide   | 0.01-2    | High (100-500) |                  |
| WPAN     | 0-0.1 km    | 1-5       | Low            | Bluetooth, GSM   |
| Internet | Worldwide   | 0.6-600   | High (100-500) |                  |

### Mode of Transmission
- *Packet Transmission*
	- Messages divided into packets containing binary data
	- Packets queued in buffers berfore sent onto link
	- QoS not guaranteed
- *Data Streaming*
	- Links guarantee QoS
	- Used for multimedia traffic
	- Higher bandwidth

### Switching Schemes
- Broadcasts
	- Ethernet, wireless
	- Send messages to *all* nodes
	- Nodes listen for own messages
		- Carrier sensing
- Circuit switching
	- Phone networks
- Packet switching
	- TCP/IP
	- Store and forward
	- Unpredictable delays
- Frame/cell relay
	- ATM
	- Bandwith and latency guaranteed
		- Virtual path
	- Samll, fixed size packets
		- Padded if necessary
	- Avoids error checking at nodes
		- Use reliable links

### OSI Protocol Summary
- Open Systems Interconnection Model

|--
| Layer | Description | Example |
| :---- | :---------- | :------ |
| Application | Protocols for specific applications | HTTP, FTP, SMTP |
| Presentation | Protocols for independant data representation and encryption if required |CORBA, CDR |
| Session | Protocols for failure detection and recovery | |
| Transport | Message-level communication between ports attached to processes | TCP, UDP |
| Network | Packate-level transmission on a given network. Requires routing in WANs and Internet| IP, ATM |
| Data Link | Packet-level transmission between nodes connected by a physical link | Ethernet MAC, ATM cell transfer |
| Physical | Transmit sequence of binary data using various mediums | Signalling, IDSN |

### IP
- Transmission mechanism used by TCP and UDP
	- Main transport level protocols of IP
- Uses other protocols
	- **ARP** (Address Resolution Protocol)
		- Associates an IP address with the physical address
		- Host makes an ARP packet broadcast to everybody, all ignore except
		  the host that the IP address belongs to.
	- **RARP** (Reverse Address Resolution Protocol)
		- Works in the reverse of ARP
	- **ICMP** (Internet Control Message Protocol)
		- Mechanism to send (by host and routes) notifications about the
		  datagram back to the sender.
- Best effort delivery
- Unreliable and connectionless protocol
- No error checking
- Suscepible to noise and dropped packets
- Must be paired with another protocol to be reliable
- Packets in two parts
	- Header
		1. Version - 4 bytes
		1. Header length
		1. Service type
		1. Total length 
		1. Time to live
		1. Protocol
		1. Header checksum
		1. Source IP address
		1. Desination IP address

### IP Address
- Identifies a computer
- IPv4
	- 32 bits binary number
	- 4 parts (octet) each 0-255
		- 0000 0000 → 1111 1111
	- Used in `ip_src` and `ip_dest` in IP datagram
- Split into two portions
	- Network portion
		- Device address
	- Host ID portion
		- Uniquely identifies the device on its network

#### First Octet 
- Gives the class
- Cannot be 127
	- Kept for troubleshooting and testing localhost
		- `localhost`: `127.0.0.1`

|--
| Class | Range | Highbits | # Networks | # Hosts |
| :---- | :---- | :------- | :--------- | :------ |
| A | 1-126 | 0 | 126 (2⁷-2) | 16,777,214 (2²⁴-2) |
| B | 128-191 | 10 | 16,382 (2¹⁴-2) | 65,534 (2¹⁶-2) |
| C | 192-223 | 110 | 2,097,150 (2²¹-2) | 254 (2⁸-2) |
| D | 224-239 | 1110 | Multicast | |
| E | 240-254 | 1111 | Research |

#### Network Mask
- Known as just Mask
- Identifies the part of the address which is the network address
	- Class A: `255.0.0.0`
	- Class B: `255.255.0.0`
	- Class C: `255.255.255.0`
- Also used by protocols to decide if a packet is for internal machine or not
- Used for working out whether computers are on the same network or not.

#### Private IP Address
- If a packet with a private-reserved address reaches a router at the "edge" of
  an organisation, it will not go out.
	- Class A: `10.0.0.0` to `10.255.255.255`
	- Class B: `172.16.0.0` to `172.31.255.255`
	- Class C: `192.168.0.0` to `192.168.255.255`
- Originally for testing and training
- Some companies assign these reserved addresses for their internal use
	- One the firewall they use *Network Address Translation* (**NAT**) to
	  extend the range of addresses in IPv4.
	
#### Subnet
- Process of dividing a large network into smaller interacting networks to 
  increase efficiency and manageability.
- IP addresses are hierachical
	- Network ID
	- Host ID
	- Allows multiple layers
- Other benefits
	- Security
		- Protect different parts of the network differently
	- Organisation of jobs by departments
	- Political

#### Classless Inter Domain Address
- Suppose a company with 100 machines wants to buy IP addresses. What class 
  should they buy?
	- 5 class C address
		- But then must manage 5 separate address
	- Single class B address
		- Then 64000 addresses are not used and go to waste
- Use Classless Inter-Domain Routing with Variable Length Subnet Mask
	- CIDR with VLSM
- Addresses have the form `xyz.xyz.xyz/N`
	- `N` is the offset, in binary, of the network address
- Ex
	- How many address in the CIDR address `192.168.100.0/22`?
		- `192` = `1100 0000`
		- `168` = `1010 1000`
		- `100` = `0110 0100`
		- So the IP address is
		  
		  ~~~
		  1100 0000.1010.0110 0100.0000 0000
		                       ^   22nd digit
		  ~~~

		- So range is from `00 0000 0000` to `11 1111 1111`
			- Total number of `10 0000 0000`₂ = 1024₁₀
	- Solved the problem of 1000 machines with a single address
	- Routing table (CIDR routers) modified to have the mask

### Transport Layer Protocols
- UDP
	- *User Datagram Protocol*
	- Basic, used for some IP functions
	- Uses IP address plus port number
	- No guarantee of delivery
		- Optional checksum
	- Messages up to 64KB
	- Efficient and easy to implement
	- "Send and Pray" - connectionless
- TCP
	- *Transport Connection Protocol*
	- More sophisticated, used for most IP funtions
	- Data stream abstraction, reliable delivery of all data
	- Messages divided into segments
	- Sliding window acknowledgement and retransmission
	- Buffering, with timeout for interactive applications
	- Checksum, if no match segment dropped
	- Connection oriented

### Routing
- Necessary in non-broadcasting networks (Internet)
- Each node stores a table of state
	- Includes cost information of links to other nodes
	- Determines route taken by packet
- Periodically updates the table and sends to neighbours

#### RIP Routing Algorithm
- **Update**
	- Every 30 seconds, or when the local table changes, send update on each 
	  non-faulty outgoing link
- **Propogation**
	- When router X finds thay router Y has a shorter path to router Z, it will
	  update its local table.
	- Any faster path is quickly propogated to neighbouring routes through the
	  *update* process.
- 3 timers
	- Periodic
	- Expiration
	- Garbage collection
- Slow in convergence
- Most of the time system reaches stability fast.

#### Congestion Control
- Used when load on network is high
	- ~80% capacity
- Strategies
	- Packet dropping
		- Reliability of delivery is reduced
		- Some packets can afford to be dropped more than others (MPEG)
	- Reduce rate of transmission
	- Transmit congestion information to each node
		- QoS guaranteed (ATM)

### Types of Interactions
- **Synchronous** interaction model
	- Known upper and lower bounds on:
		- Execution speeds
		- Message transmission delays
		- Clock drift rates
	- More difficult to build, but conceptually simpler
- **Asynchronous** interaction model
	- Arbitrary process execution speeds, message transmission delays and clock 
	  drift rates
	- Some problems impossible to solve
		- eg agreement
	- If solution valid for asynchronous, then also valid for synchronous

### Group Communication
- **Multicast**
	- Operation that sends a single message from one process to each of the 
	  members of a group of processes
	- Fault tolerance based on replicated servers
	- Better performance through replicated data
	- Propagation of event notifications
- **IP Multicast**
	- Multicast group is specified by a class D internet address
	- Membership is dynamic
		- To join, make a socket

<!--
Created  : Tue 15 Apr 2014 10:04 am
Modified : Sat 19 Apr 2014 11:07 am
-->
