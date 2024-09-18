# <p align="center"> Blockchain Project

![image](https://user-images.githubusercontent.com/110497344/182488937-7910d8e6-95a5-4d4e-8588-d1a3a43f437f.png)

![image](https://user-images.githubusercontent.com/110497344/182489040-96add4fc-1244-4f23-adae-aca041e07a60.png)

## Introduction

This project is a simple, yet effective, implementation of a blockchain-based ledger system designed to demonstrate the key concepts of decentralized block verification, cryptographic security, and peer-to-peer communication. With multiple processes contributing and verifying blocks, this blockchain ledger replicates the foundational principles used in cryptocurrencies like Bitcoin but simplifies the architecture for easier understanding and educational purposes.

Each process in the network cooperates to maintain a shared, immutable ledger, using cryptographic techniques to ensure the integrity and security of the data. The system features a proof-of-work puzzle to verify the authenticity of each block, ensuring that only verified data is added to the blockchain.

## Implementation Details

1. Blockchain Structure
	- Each process contributes to a shared blockchain ledger
	- Blocks are verified using SHA-256 hashes, based on the previous block hash, random seed, and block data
	- The system starts with a dummy first block to establish a known "Proof of Work"
	- Each process maintains its copy of the blockchain, with updates multicast to all other peers

2. Processes and Multicasting
	- Three processes (P0, P1, P2) contribute blocks and communicate via multiple ports
		- Port 4710 + process number: Receives public keys
  		- Port 4820 + process number: Receives unverified blocks
    		- Port 4930 + process number: Receives updated blockchains
	- Process 0 writes the updated blockchain ledger to disk (BlockchainLedger.json)

3. Digital Signatures and Verification
	- Digital signatures ensure secure communication between nodes
	- Each process’s public key is stored with its process ID, and signatures are verified before blocks are accepted
	- A block's signature is verified before its data is processed, ensuring it was not tampered with

4. Proof of Work and Block Verification
	- Processes solve a puzzle by generating a seed and hashing the block data with SHA-256 until a valid hash (with specific characteristics) is found
	- The first process to solve the puzzle verifies the block and appends it to the blockchain
	- Verified blocks are multicast to other processes, which abandon their verification attempts for that block

5. Priority Queue for Block Verification
	- Unverified blocks are placed in a concurrent priority queue, sorted by the timestamp of creation
	- Processes pop the block with the lowest timestamp to attempt verification, creating competition among nodes

6. Coordination and Multithreading
	- The system starts with P0, P1, and P2, with P2 triggering the multicast of public keys and starting blockchain operations
	- Sleep functions are used to coordinate processes and manage concurrency without port conflicts

7. JSON-based Ledger
	- The blockchain ledger is marshaled as JSON for easy distribution among processes
	- Both unverified blocks and verified blockchains are communicated in JSON format, ensuring compatibility and ease of use

## Conclusion

This project provides a practical demonstration of how a blockchain system works in a simplified multi-process environment. By implementing core concepts like cryptographic signatures, proof-of-work puzzles, and a shared ledger, it showcases the mechanics behind decentralized consensus in a blockchain. Though designed for educational purposes, this framework can be extended or adapted to more complex applications like cryptocurrencies, supply chain management, or secure auditing systems.
