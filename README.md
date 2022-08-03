# Blockchain

Learning outcomes:

	1	Understand the basic structure of blockchain technology
	2	Become familiar with some basic public key cryptographic techniques
	3	Have a simple running framework for a peer-to-peer shared ledger system based on a blockchain
	4	Understand the basic idea of "work" which is used to guarantee the validity of cryptocurrencies like Bitcoin
	5	Have a collection of code utilities for working with blockchain technology, and cryptography that can be applied to many applications
	6	Have a rudimentary working knowledge of JSON

![image](https://user-images.githubusercontent.com/110497344/182488937-7910d8e6-95a5-4d4e-8588-d1a3a43f437f.png)

![image](https://user-images.githubusercontent.com/110497344/182489040-96add4fc-1244-4f23-adae-aca041e07a60.png)


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


---------------General---------------

Start with a dummy first block zero, with a known "Previous Proof of Work" string. Solve the puzzle in the usual way to produce a Proof-of-Work hash for this first dummy block.

Read input from AT LEAST the three provided data files, one file per process. We will run your program on the provided data files, and then also on our own data files that have the same format, but not necessarily the same number of records.

Each process maintains a copy of the shared ledger implemented as a blockchain. Each time the blockchain is updated it is multicast to all other peers. (Or, you can multicast only the update (new verified block) and add the verified block to each local existing blockchain. Each solution will have its own challenges to address.) Process zero is responsible for writing the updated BlockchainLedger.json file to disk. We will use only three processes, but your system design should—in theory—work for any number of peers with minor modifications.

Each process reads in a data file to create new records. A new record is placed in an unverified block. The block is marshaled as JSON and multicast to all the processes in the blockchain group which begin competing with one another to solve the "work" puzzle. One process solves a puzzle to verify the block, prepends the verified block to the blockchain, and multicasts the new blockchain to all other processes in the group. All other processes abandon the attempt to verify that block.

Every record in the shared ledger is considered canonical. It is ~impossible to insert a counterfeit block (record) into the blockchain.

We will use simple medical records in files, but the data is not really of concern to us. We could use the same system for a complete audit trail of business transactions, to support a digital currency, or to keep track of banking records.

Ordinarily many records would comprise a single block; for simplicity we will use a single record for each block.

Your system must run from some version of the provided run scripts. Adapt as needed for other operating systems. Use the trick that when process 2 starts, it will send a message to start the action on the other procsses as well.

If you have to, you can use sleep() statements arbitrarily inserted to help with process coordination as needed, but don't sleep too long so that we can get your program graded! Be sure to add comments for these coordination statements so we know you understand what is going on.

---------------Ports and servers---------------

Because we will have multiple participating processes running on the same machine we will need flexibility to avoid port conflicts. For each process:

Port 4710+process number receives public keys (4710, 4711, 4712)

Port 4820+process number receives unverified blocks (4820, 4821, 4822)

Port 4930+process number receives updated blockchains (4930, 4931, 4932)


---------------Initialization---------------

Using the start script, start your servers in the order P0, P1, P2

When P2 starts, it also triggers the multicast of public keys, and starts the whole system running.

All processes start with the same initial one-block (dummy entry) form of the blockchain.

After all public keys have been established read the data file for this process.

Create unverified blocks from the data and using JSON as the external data format, multicast each unverified block in turn to all other processes.

---------------Creating a new record and multicasting the unverified block---------------

Any process can accept local input (in our case from a file) which is then put in an unverified block. The block is named—and updated with—a universally unique ID, a version of that UUID signed by the creating process, the ID of the creating process, and the current timestamp [and optionally an SHA-256 hash of the input data is placed in the DataHash field for auditing purposes—see below under DataHash. Not required!].

The completed unverified block is marshaled as JSON and multicast to all processes at the correct unverified block port, including to the creating process itself. In each process that receives them, unmarshal each block back into a java object, and then place each block into a concurrent priority queue, sorted by the timestamp for when the block was created.

Each process then, one by one, pops the unverified blocks from the priority queue, attempts to solve the puzzle and verify the block in competition with the other processes.

---------------Creating the "work" puzzle---------------

There are many ways to create "work" for a process. We give the process a puzzle to solve. It takes some random amount of time within boundaries. Processes compete to see who can solve the puzzle first.

One way to make work is to create a small random seed string that is concatenated to some string of data from the block giving us the new longer string we'll call CAT. Create a 256-bit hash of CAT (using a known algorithm). Examine only the leftmost 16 bits of the hash value, interpreting them as an unsigned 16-bit number (giving us a range of 0-65535). If the number is less than 5000 (or whatever number suits your code) then you have solved the puzzle.

Otherwise, pick a new small random seed string, and repeat the above. Do this until you have solved the puzzle.

If you change the 5000 target to 2500, the puzzle gets twice as hard, and takes twice as long. If you require that the answer to the puzzle be recorded along with the original data, then it is impossible to cheat.

For our purposes we will use real work, but we will make the puzzle easier and use the sleep() method to artificially extend the work time to a second or two. But because we are looking at the value of the hash, we are still doing real work that cannot be faked.

For ease of development, don't make the work take more than a a few seconds on average. In a normal implementation we might want it to take 10 minutes. This can always easily be adjusted dynamically (by making the puzzle easier or harder) so that no matter how fast the computers get, or how many cooperating processes we have, the puzzle always takes about the same amount of time to solve.

---------------Verifying a block and multicasting the new blockchain---------------

[Receive unverified blocks into your unverified-block priority queue.]

Select the highest-priority block (lowest timestamp) block from your priority queue of unverified blocks.

Check that the bockID for this block is not already part of the current blockchain. If it is, discard the unverified block.
Verify the signed blockID using the public key of the creating process.

Verify the creator-process-signed SHA-256 hash of the data.

Note: Depending on how much "work" is required, then while performing the following work, periodically check to see if the block has already been verified. If so, abandon this process's attempt to verify it. That is, after each few attempts at the work, look to see if the blockchain has been updated, and if so whether this block has been included in the new version.

If the blockID does not appear in the current blockchain we proceed, and must gather three data items (a,b,c) concatenated together as input to our puzzle solving work exercise.

Modify the data in the unverified block as follows: (1) insert a sequential blockNum that is one greater than the most recent block in the current blockchain. (2) Insert the verifying process's ID into the unverified block. (3) Concatenate (a) the SHA-256 Proof-of-Work hash from that previous block in the blockchain to (b) the updated blockdata of this unverified block, producing the string "UB". (That is, we include a unique piece of the previous block inside the data that we are hashing for this block.)

Complete the work required to produce a new SHA-256 hash in the appropriate range after hashing the string UB as follows:

Repeatedly produce (c) a random guess at the value of a string (the seed) and further update UB by inserting the seed into the BlockData of UB. This random guess is your attempt to solve the puzzle. (In the sample, we just concatenate the seed onto the existing data, but you'll want to insert it into a slot in the block.)

Produce an SHA-256 hash of the seed-updated UB. If it is in the right range (e.g., when the leftmost 16 bits are interpreted as an unsigned integer, is the number lower than the threshold? [The lower the threshold, the more work it takes to guess an appropriate seed.]) then you have solved the puzzle and completed the necessary work to verify the block.

Repeat until the puzzle is solved.

Insert the the new Proof-of-Work SHA-256 hash into the block header (the seed that solved the puzzle is already in the block). Sign the hash and insert this signature into the block header as well.

If the blockchain has not been modified, then prepend the new verified block to the local blockchain and multicast the new blockchain to all other peers. Otherwise, if the blockchain has been modified, and the blockID of UB is not in the blockchain, then mark UB as unverified and start over again (with a new sequential block number) to verify it.

Process 0 writes out the new version of BlockchainLedger.json every time it gets an updated blockchain (that is, it replaces to old disk version of the current blockchain).

Congratulations! You are done with the basic blockchain.
