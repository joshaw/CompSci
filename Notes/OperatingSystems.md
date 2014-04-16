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

### LAN
