---
layout: default
title: Cryptography Notes
---

# Cryptography

* * *
* TOC
{:toc}
* * *

## Historical Ciphers

### Transposition ciphers
- Permutes components of a message

#### Rail Fence
- *Key*: Column size
- *Encryption*:
	1. Arrange message in columns of fixed size (the key).
	1. Add dummy text to fill last column. Ciphertext consists of rows.
- *Decryption*:
	1. Calculate row size by diving message length by the key.
	1. Arrange message in rows of this size. Plaintext consists of columns.
- *Secure?*: No
	- Given any ciphertext, attacher tries all possible values for the key.
	- For a message of size n, there are at most n possibilities for the key.
	- Probability of at leat 1/n of winning, protocol insecure.

#### Permutation
- *Key*: Permutation of length n of the alphabet
- *Encryption*:
	1. Split plaintext into blocks of length n.
	1. Apply permutation.
- *Decryption*:
	1. Split plaintext into blocks of length n.
	1. Apply inverse permutation.
- *Security*:
	- 26! permutations
	- But other tools exist
		- eg Frequency analysis.

### Substitution ciphers
- Replaces components of a message
	- *Codes*: algorithms for substitution of entire words (works on meanings)
	- *Ciphers*: algorithms substituting single letters or blocks

#### Shift ciper

#### Caesar cipher

#### Using keys

#### Mono-alphabetic substitution cipher

#### Homophonic substitution ciphers

#### Vigenere Cipher

#### Rotor machines

#### One time pad
- *Key*: Random bitstring as long as message.
- *Encryption*:
	- k1+m1, ..., kn+mn
- *Decryption*:
	- k1+c1, ..., kn+cn
- *Security*: Secure
	- Attacker cannot learn any information by looking only at ciphertexts.

<!-- ## Formalisation of Security of One Time Pad -->

### Symmetric Ciphers

#### Problems with Symmetric Ciphers

#### The Players
- **Alice**: Sender of an encrypted message
- **Bob**: Intended receiver of encrypted message. Assumed to have the key.
- **Eve**: Passive attacker intercepting messages and trying to identify 
  plaintexts or keys.
- **Mallory**: Active attacher intercepting and modifying messages to identify 
  plaintexts and keys.

#### Mathematical Notation

### Block Ciphers
- Symmetric cipher operating on fixed length group of bits, called blocks.

#### Feistel
- Class of ciphers
	- eg Blowfish, DES, 3DES
- Same encryption scheme applied iteratively for several rounds
- Derive key for round from original key via special function called **Feistel 
  function**.
- Each round has steps:
	1. Split input in half
	1. Apply Feistel function to the right half
	1. Compute xor of result with old left half to be new left half
	1. Swap old right and new left half, unless we are in the last round.
- *Decryption*
	- Works same as encryption, but with a reversed order of keys.

#### DES
- Data Encryption Standard
- Keysize too small for todays computers
	- Breakable < 10 hours
- *Block Length*: 64 bits
- *Number of rounds (R)*: 16
- *Key Length*: 56 bits
- *Round key length*: 48 bits for each subkey K0, ..,K15
	- Subkeys are derived from 56 bits key via special key schedule.

##### Operations of DES
- **Cyclic Shift**
	- On bitstring blocks
	- Denoted by `b <<< n`
		- Movement of bits of block b by n to the left
		- Bits that would have fallen out are added to the right.
	- Similarly `b >>> n`
- **Permutations**
	- Might duplicate or drop bits
	- Written as output order of input bits
	- Ex `4 1 2 3` means
		- fourth input becomes first output bit
		- first input becomes second output bit
		- second input becomes third output bit
		- third input becoms fourth output bit.
- **S-Box**
	- An s-box substitution us a table lookup. Input is 6 bits, output is 4 
	  bits.
		1. Strip outer bits of input and join them. This two bit number is the 
		   row index
		1. Four inner bits indicate column number
		1. Output is corresponding entry in the table.

##### DES Feistel Function
- *Expansion Permutation*
	- Expand 32 bit message half block to 48 block by doubling 16 bits and 
	  permuting them.
- *Round Key*
	- Compute xor of this 38 bit block with round key Ki
- *S-Box*
	- Split 48 bit into 8 bit blocks
	- Each of them is given as input to eight substitution boxes which each 
	  substitute 6 bit block by 4 bit block.
- *P-Box*
	- Combine these eight 4 bit blocks to 32 bit block and apply another 
	  permutation.

#### Security of block ciphers

#### AES (Rijndael)
- Advanced Encryption Standard
- Successor to DES
- *Block Sizes*: 128, 192, 256 bits
- *Key Sizes*: 128, 192, 256 bits
- *Rounds*: 10, 12 or 14 rounds of encryption.
- Operations take place in F\_(2^8)

1. Arrange message in 4×4 matrix of 8 bit elements filling it downwards and 
   then right
1. Each round has the operations:
	1. *Substitution*: Operating on every single byte
		- Corresponds to algebraic operations in the field F\_(2^8)
		- Consider byte as polynomial in the field
		- Compute its multiplicative inverse (non-linear step)
		- Compute new bitvector by applying certain linear function to it 
		  (strengthening against algebraic attacks).
	1. *Byte permutation*: ShiftRows
		- Performs cyclic shift on the state matrix.
	1. *Column manipulation*: MixRows
		- Mixing each column separately
		- Achieved by multiplying with matrix

		  ~~~
		  0x02  0x03  0x01  0x01
		  0x01  0x02  0x03  0x01
		  0x01  0x01  0x02  0x03
		  0x03  0x01  0x01  0x02
		  ~~~

	1. *XOR with round key*.
		- Key, including all round keys, is 128 bits so can be represented as 
		  4×4 matrix.
		- Simply add to state matrix.

TODO Lecture 4

#### AACS Advanced Access Content System
 OVERVIEW
 SECURITY ISSUES
 LEGAL AND ETHICAL ISSUES

#### Modes for Block ciphers
 ECB (ELECTRONIC CODE BOOK)
 CBC (CIPHER BLOCK CHAINING)
 CFB (CIPHER FEEDBACK MODE)
 OFB (OURPUT FEEDBACK MODE)
 CTR (COUNTER MODE)
 SECURITY FOR BLOCK CIPHER MODES

#### Cryptomeria

### Stream Ciphers
- Symmetric cipher encrypting plaintext continuously

#### Pseudo-random generators
 GETTING TRUE RANDOMNESS
 PROPERTIES OF PSGS
#### RC4
#### LFSR (Linear Feedback Shift Register)
 PROPERTIES OF LFSRS
 COMBINING MULTIPLE LFSRS
#### CSS
 SECURITY  AND LEGAL ISSUES
 ILLEGAL PRIMES
#### A5/1
### Cryptographic Hash Functions
#### One way functions
#### The birthday paradox
#### Cryptographic hash functions v Hash (table) Functions
#### Merkle-Damgard
#### Message Digest algorithms
 MD4
 MD5
 SHA-1
 SHA-2
#### Building hashes from block ciphers
### Message Authentication Codes (MAC)
#### HMAC
#### CBC-MAC
#### PMAC
## Security Definitions
### Security of hash functions
## Examples
## Attacks on previous versions of TLS
## Combining Encryption and MAC
#### Encrypt-then-MAC
#### MAC-then-encrypt
#### Encryp-and-MAC
### Key Exchange & Management
#### Diffie-Hellman-Merkle
#### Needham-Schroeder
## Asymmetric Ciphers
### Public Key Cryptography
### ElGamal
### Cramer Shoup
### Diffie-Hellman
### RSA
## Digital Signatures
### Schnorr Signatures
### DSA
## Certificates
### VeriSign
### PGP
## Commitment Schemes
## Zero knowledge proofs
## Precise formulation of Security Properties
## Mathematical Principles
### Permutations
### Modular Arithmetic
### Residue classes
### Finite fields
### Matrix arithmetic
### Discrete Logarithm and Subgroup
### Arithmetic modulo a composite
