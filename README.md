# Blockchain

Learning outcomes:

	1	Understand the basic structure of blockchain technology
	2	Become familiar with some basic public key cryptographic techniques
	3	Have a simple running framework for a peer-to-peer shared ledger system based on a blockchain
	4	Understand the basic idea of "work" which is used to guarantee the validity of cryptocurrencies like Bitcoin
	5	Have a collection of code utilities for working with blockchain technology, and cryptography that can be applied to many applications
	6	Have a rudimentary working knowledge of JSON

Checklist:


--------------- THE PROGRAM -----------------

Processes produce a basic blockchain ledger

All three processes contribute blocks to the ledger

Blocks are verified by SHA256 hash of 3 items: previous hash, random seed, data

Reads prescribed data files for initial data

Three processes cooperate

Processes each serve multiple ports

Updated blockchain ledger is distributed to three nodes

Process 0 writes the ledger to disk after each update to it

Ledger is marshaled to other nodes as JSON

Un-verified blocks are sent to all other processes

Un-verified blocks are marshaled to other processes as JSON

Digital Signatures used

Digital Signatures are verified

Public Keys are kept with process IDs for all nodes

A verifying block checks the signature on the data hash before verification

Work has been implemented.

Work method periodically checks to see if the block has already been verified

Nodes compete to verify blocks

A priority queue was implemented


