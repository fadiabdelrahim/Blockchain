/*
 * 1. Precise command-line compilation instructions:
 * > javac -cp "gson-2.8.2.jar" Blockchain.java
 * 
 * 2. Precise instructions to run this program:
 * In separate shell windows:
 * > java -cp ".:gson-2.8.2.jar" Blockchain 0
 * > java -cp ".:gson-2.8.2.jar" Blockchain 1
 * > java -cp ".:gson-2.8.2.jar" Blockchain 2
 */
 
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.StringWriter;
import java.io.StringReader;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import java.security.spec.*;
import java.security.*;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.text.*;
import java.util.Base64;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

class BlockDetail {	// holds the details of each block 
    private String blockID;	// declare variable for blockID
    private String sigBlockID;	// declare variable for sginedBlockID
    private UUID uuid;	// declare variable uuid
    private String VerificationProcessID;	// declare variable for VerificationProcessID
    private String createdProcessID;	// declare variable for createdProcessID
    private String previousHashInfo;	// declare variable for previousHashInfo
    private String blockData;	// declare variable for blockData
    private String hashedData;	// declare variable for hashedData
    private String sigBlockData;	// declare variable for signedBlockData
    private String timeStamp;	// declare variable for timeStamp
    private String verifiedTimeStamp;	// declare variable for verifiedTimeStamp
    private String currentHash;	// declare variable for currentHash
    private String sigCurrentHash;	// declare variable for signedCurrentHash
    private String randomSeed;	// declare variable for randomSeed
    private String Fname;	// declare variable for Fname
    private String Lname;	// declare variable for Lname
    private String SSN;	// declare variable for SSN
    private String DOB;	// declare variable DOB
    private String Diag;	// declare variable for Diag
    private String Treat;	// declare variable for Treat
    private String Rx;	// declare variable for Rx

    public String getBlockID() {return blockID;}	// method to get the value of BlockID
    public void setBlockID(String blockID) {this.blockID = blockID;}	// method to set the value of BlockID
    public String getSigBlockID() {return sigBlockID;}	// method to get the value of SigBlockID
    public void setSigBlockID(String sigBlockID) {this.sigBlockID = sigBlockID;}	// method to set the value of SigBlockID    
    public UUID getUuid() {return uuid;}	// method to get the value of uuid
    public void setUuid(UUID uuid) {this.uuid = uuid;}	// method to set the value of uuid    
    public String getVerificationProcessID() {return VerificationProcessID;}	// method to get the value of VerificationProcessID
    public void setVerificationProcessID(String VID) {this.VerificationProcessID = VID;}	// method to set the value of VerificationProcessID    
    public String getCreatedProcessID() {return createdProcessID;}	// method to get the value of CreatedProcessID
    public void setCreatedProcessID(String createdProcessID) {this.createdProcessID = createdProcessID;}	// method to set the value of CreatedProcessID   
    public String getPreviousHashInfo() {return previousHashInfo;}	// method to get PreviousHashInfo
    public void setPreviousHashInfo(String previousHashInfo) {this.previousHashInfo = previousHashInfo;}	// method to set PreviousHashInfo   
    public String getBlockData() {return blockData;}	// method to get the value of BlockData
    public void setBlockData(String blockData) {this.blockData = blockData;}	// method to set the value of BlockData    
    public String getHashedData() {return hashedData;}	// method to get the value of HashedData
    public void setHashedData(String hashedData) {this.hashedData = hashedData;}	// method to set the value of HashedData    
    public String getSigBlockData() {return sigBlockData;}	// method to get the value of SigBlockData
    public void setSigBlockData(String sigBlockData) {this.sigBlockData = sigBlockData;}	// method to set the value of SigBlockData    
    public String getTimeStamp() {return timeStamp;}	// method to get the value of TimeStamp
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}	// method to set the value of TimeStamp    
    public String getVerifiedTimeStamp() {return verifiedTimeStamp;}	// method to get value of VerifiedTimeStamp
    public void setVerifiedTimeStamp(String verifiedTimeStamp) {this.verifiedTimeStamp = verifiedTimeStamp;}	// method to set value of VerifiedTimeStamp    
    public String getCurrentHash() {return currentHash;}	// method to get the value of CurrentHash
    public void setCurrentHash(String currentHash) {this.currentHash = currentHash;}	// method to set the value of CurrentHash    
    public String getSigCurrentHash() {return sigCurrentHash;}	// method to get the value of SigCurrentHash
    public void setSigCurrentHash(String sigCurrentHash) {this.sigCurrentHash = sigCurrentHash;}	// method to set the value of SigCurrentHash    
    public String getRandomSeed() {return randomSeed;}	// method to get value of RandomSeed
    public void setRandomSeed(String randomSeed) {this.randomSeed = randomSeed;}	// method to set the value of RandomSeed    
    public String getLname() {return Lname;}	// method to get value of Lname
    public void setLname(String LN) {this.Lname = LN;}	// method to set the value of Lname    
    public String getFname() {return Fname;}	// method to get value of Fname
    public void setFname(String FN) {this.Fname = FN;}	// method to set the value of Fname    
    public String getSSN() {return SSN;}	// method to get the value of SSN
    public void setSSN(String SS) {this.SSN = SS;}	// method to set the value of SSN    
    public String getDOB() {return DOB;}	// method to get the value of DOB
    public void setDOB(String RS) {this.DOB = RS;}	// method to set the value of DOB    
    public String getDiag() {return Diag;}	// method to get value of Diag
    public void setDiag(String D) {this.Diag = D;}	// method to set the value of Diag    
    public String getTreat() {return Treat;}	// method to get value of Treat
    public void setTreat(String Tr) {this.Treat = Tr;}	// method to set the value of Treat    
    public String getRx() {return Rx;}	// method to get the value of Rx
    public void setRx(String Rx) {this.Rx = Rx;}	// method to set the value of Rx
}

class Ports { //Start the different Servers for the different ports
	public static int PubKeyServPort;	// declare variable for public key server port to be public to be used outside this class
    public static int UVBlockServPort;	// declare variable for unverified block server port to be public to be used outside this class	
    public static int BlockchainServPort;	// declare variable for blockchain server port to be public to be used outside this class
	
	final static int PubKeyInitPort = 4710;	// start server for public key server port at 4710
    final static int UVBlockInitPort = 4820;	// start server for unverified blocks server port at 4820
    final static int BlockchainInitPort = 4930;	// start server for blockchain server port at 4930

    public void startPorts() {	//Start the ports according to the process number
        PubKeyServPort = PubKeyInitPort + Blockchain.pNum;	// run server at port 4710 and start initially at process 0 and increment as you go
        UVBlockServPort = UVBlockInitPort + Blockchain.pNum;	// run server at port 4820 and start initially at process 0 and increment as you go
        BlockchainServPort = BlockchainInitPort + Blockchain.pNum;	// run server at port 4930 and start initially at process 0 and increment as you go
    }
}

class PubKey { // class to process Public key
    private String pubKey;	// declare variable for public Key
    private int processNumber; // declare variable for process number

    public void setPubKey(String publicKey) {this.pubKey = publicKey;}	// method to set the value of PubKey
    public String getPubKey() {return pubKey;}	// method to get the value of PubKey
    public void setProcessNumber(int processNumber) {this.processNumber = processNumber;}	// method to set the value of ProcessNumber
    public int getProcessNumber() {return processNumber;}	// method to get the value of ProcessNumber
}

class PubKeyHelper extends Thread { // This handles the public keys that are received from the processes	// this uses inheritance to extend the thread
    Socket multiSock; //This is close to the thread
    int process;

    PubKeyHelper(Socket s) {
        multiSock = s;
    } 
    public void run() { // read pub keys and process numbers and store location in mulitcast
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(multiSock.getInputStream())); // this is telling it from where to accept the input
            String output = in.readLine();	// this is telling it the type of input it is expecting which is a string
            Gson gson = new GsonBuilder().setPrettyPrinting().create();	// creating a new Gson object 
            PubKey pair = gson.fromJson(output, PubKey.class);	// sending back all the data to the public key class
            process = pair.getProcessNumber();	// retrieve the process number of public key 
            Blockchain.pubKey[process] = new PubKey();	// create a new public key for each new block
            Blockchain.pubKey[process].setProcessNumber(process);	// set a new process number for each new block
            Blockchain.pubKey[process].setPubKey(pair.getPubKey());	// take the data from public key and process for each new block and set it 
            multiSock.close();	// close the socket 
        } 
        catch (Exception e) {e.printStackTrace();}	// catch any exceptions
    }
}

class PubKeyProcess implements Runnable { // this starts the PubKeyHelper
    public void run() {
        int q_len = 6;	// if there is more than 6 connections to server before can spawn thread it will throw away anything after 6
        Socket multiSocket;	// multiSocket is allocated to socket
        System.out.println("PublicKey Server = " + Integer.toString(Ports.UVBlockServPort));	//type casting the port number int into a string
        try {
            ServerSocket serverSock = new ServerSocket(Ports.PubKeyServPort, q_len);	// create new server socket passing it the public key server port and q_len
            while (true) {	// this means it runs forever
                multiSocket = serverSock.accept();	// accept the connection 
                new PubKeyHelper(multiSocket).start();	// start the PubKeyHelper thread
            }
        } 
        catch (IOException ioe) {System.out.println(ioe);}	// catch any exception
    }
}

class UVBlock extends Thread { // This block handles the unverified blocks
    Socket socket;

    UVBlock(Socket socket) {
        this.socket = socket;
    }   
    public void run() {	// adding unverified blocks to the priority queue 
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	// this is telling it from where to accept the input
            String unverifiedStreamBlocks = in.readLine();	// this is telling it the type of input it is expecting which is a string
            Gson gson = new GsonBuilder().setPrettyPrinting().create();	// creating a new Gson object 
            BlockDetail[] unverifiedBlocks = gson.fromJson(unverifiedStreamBlocks, BlockDetail[].class);  // storing the unverified block in priority queue by converting GSON from JSON         
            for (int i = 0; i < unverifiedBlocks.length; i++) {Blockchain.PriorityQueue.put(unverifiedBlocks[i]);}	// looping thru each unverified block and adding one block at a time to the queue         
        } 
        catch (IOException ioe) {System.out.println(ioe);}	// catch any exception
    }

}

class BlockProcess implements Runnable {// it controls the flow of the blocks by connecting processes to each other
    public void run() {
        int q_len = 6;	// if there is more than 6 connections to server before can spawn thread it will throw away anything after 6
        Socket socket;	// socket is allocated to socket
        System.out.println("UnverifiedBlock Server = " + Integer.toString(Ports.UVBlockServPort));	// type casting the port number int into a string
        try {
            ServerSocket serverSocket = new ServerSocket(Ports.UVBlockServPort, q_len);	// create new server socket passing it the unverified block server port and q_len
            while (true) {	// this means it runs forever
                socket = serverSocket.accept();	// accept the connection
                new UVBlock(socket).start();	// start the UVBlock thread
            }
        } 
        catch (IOException ioe) {System.out.println(ioe);}	// catch any exceptions
    }
}

class BlockChecker implements Runnable { //Thread that takes each unverified block and verifies them
    private boolean Verified = false;	// create a flag variable to use for check and set initial to false
    private ArrayList<BlockDetail> tempBlockList = new ArrayList<>();	// store the verified block data and push to main block once verified
    private PublicKey pubKey;	// declaring the pubKey variable (will hold the original key + encryption) 
    private String pubKeys;	// declaring the pubKeys (will hold the original key)

    public void run() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // GSON object creation
        try {
            while (true) {	// this means it runs forever
                BlockDetail block = Blockchain.PriorityQueue.take(); //gives unverified block based on timestamp
                int process = Integer.parseInt(block.getCreatedProcessID()); //Process Variable stores the  process number of the current block
                pubKeys = Blockchain.pubKey[process].getPubKey();	// get the original public key with no encryption
                byte[] pubKey2 = Base64.getDecoder().decode(pubKeys);// Public key holder
                X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKey2);	// public key encryption
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                pubKey = keyFactory.generatePublic(pubSpec); //public key generation from the decoded byte array (public key with encryption)
                byte[] sigBlockID = Base64.getDecoder().decode(block.getSigBlockID());// Holds the signedBlocksID
                byte[] sigHashData = Base64.getDecoder().decode(block.getSigBlockData());// Holds the hash data               
                if (Blockchain.verifyBlock(block.getBlockID().getBytes(), pubKey,sigBlockID) && Blockchain.verifyBlock(block.getHashedData().getBytes(), pubKey, sigHashData)){	// check if the block is valid
                    Verified = false;// flag for the Verified block
                    tempBlockList = Blockchain.localBlockList;	// push the details to the main block 
                    
                    tempBlockList.forEach((verifiedBlock) -> { //to check whether the blocks being sent from the temp block list have already been sent.  
                        if (verifiedBlock.getBlockID().equals(block.getBlockID())) {
                            Verified = true;
                        }
                    });                    
                    block.setPreviousHashInfo(Blockchain.localBlockList.get(0).getCurrentHash()); // we send the the new block the previousHash info from the previous block so it can use it to hash the new block 
                    if (!Verified) { // Checking if the block is in the chain,if not then proceed. Condition to see is the block is not verified
                        String currentHash = Blockchain.BlockVerification(block); // This line verifies the block                      
                        byte[] byteSigHash = Blockchain.blockSig(currentHash.getBytes(), Blockchain.privKey); //Signing and storing the hash into the block
                        String sigHashString = Base64.getEncoder().encodeToString(byteSigHash);	// encrypting the signed hash
                        block.setSigCurrentHash(sigHashString);	// sending the signedHash into the current hash set
                        block.setVerificationProcessID(String.valueOf(Blockchain.pNum)); // setting the processID for each process 
                        Date date = new Date();	// getting the date
                        String T1 = String.format("%1$s %2$tF.%2$tT", "", date); // String format for date
                        block.setVerifiedTimeStamp(T1); // Attaching the timestamp to compare the verified block
                        Verified = false;	
                        tempBlockList = Blockchain.localBlockList; // pushing the detail to main block 

                        tempBlockList.forEach((verifiedBlock) -> {	// to check whether the blocks being sent from the temp block list have already been sent.  
                            if (verifiedBlock.getBlockID().equals(block.getBlockID())) {
                                Verified = true;
                            }
                        });                        
                        if (!Verified) {	// checking the block to see if it is verified
                            Blockchain.localBlockList.add(0, block); // Adding the present block to the blockhcain
                            System.out.println(block.getBlockData() + " is verified by Process " + block.getVerificationProcessID() + "\n");
                            Blockchain.BlockchainCast(); // multicasting the current blockchain
                            try {Thread.sleep(1000);} // delay to update block with other processes
                            catch (Exception e) {e.printStackTrace();}	// catch any exception
                        } 
                        else {System.out.println("The block has been verified!\n");} //Output line after verification
                    } 
                    //else {System.out.println("The block has been verified!");}	//Output line after verification
                }
            }
        } 
        catch (Exception e) {e.printStackTrace();}	// catch any exception
    }
}

class BlocksControl extends Thread { // handle incoming blockchains
    Socket sock;
    ArrayList<BlockDetail> tempList = new ArrayList<>();	// store the verified block data and push to main block once verified

    BlocksControl(Socket s) {
        sock = s;
    }
    
    public void run() {	// verify the new blockchain with local copy then write to disk in JSON
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));	// this is telling it from where to accept the input
            String multiBlockChain = in.readLine();	// this is telling it the type of input it is expecting which is a string
            Gson gson = new GsonBuilder().setPrettyPrinting().create();	// creating a new Gson object
            BlockDetail[] blocks = gson.fromJson(multiBlockChain, BlockDetail[].class);	// storing the blocks in priority queue by converting GSON from JSON
            // Keeping a local copy
            for (BlockDetail block : blocks) { // for each block 
                tempList.add(block);  // Pushing the data and the blocks to the temporary list
            }
            // Updating the Blockchain with multicast if the condition is satisfied
            if (Blockchain.localBlockList.size() < tempList.size()) {	// we are checking to see if the main list (main ledger) is less than the templist size
                Blockchain.localBlockList.clear();// clearing the blockchain
                Blockchain.localBlockList.addAll(tempList); //Storing the new blockchain
                System.out.println("---NEW BLOCK---" + "\nCurrent Block Data: " + Blockchain.localBlockList.get(0).getBlockData() + "\n" + "Verified by process: " + Blockchain.localBlockList.get(0).getVerificationProcessID() + "\n");// print message to the console
                Blockchain.JSONWriter(); // writing to the disk
            } 
            else if (Blockchain.localBlockList.size() == tempList.size()) {   // we are checking to see if the main list is equal to the temp list size           
                if (String.valueOf(Blockchain.pNum).equals(tempList.get(0).getVerificationProcessID())) { 	// Checking the blockchain multicasted for the equal condition
                    System.out.println("---NEW BLOCK--- " + "\nCurrent Block Data: " + Blockchain.localBlockList.get(0).getBlockData() + "\n" + "Verified by process: " + Blockchain.localBlockList.get(0).getVerificationProcessID() + "\n");
                    Blockchain.JSONWriter();	// Writing to the disk
                } 
                else {
                    for (int i = 0; i < tempList.size(); i++) {	// loop to find the winning hash    
                        if (Blockchain.localBlockList.get(i).getBlockID().equals(tempList.get(i).getBlockID()) && !Blockchain.localBlockList.get(i).getVerificationProcessID().equals(tempList.get(i).getVerificationProcessID())) {	// This part is for if the verified process IDs are different, but same block                            
                            if (Blockchain.localBlockList.get(i).getVerifiedTimeStamp().compareTo(tempList.get(i).getVerifiedTimeStamp()) < 0) {	// Comparing the timestamps and deciding the winning hash for the verified hash
                                System.out.println("---NEW BLOCK--- " + "\nCurrent Block Data: " + Blockchain.localBlockList.get(0).getBlockData() + "\n" + "Verified by process: " + Blockchain.localBlockList.get(0).getVerificationProcessID() + "\n");
                                Blockchain.JSONWriter();	// Writing to the disk
                            } 
                            else if (Blockchain.localBlockList.get(i).getVerifiedTimeStamp().compareTo(tempList.get(i).getVerifiedTimeStamp()) > 0) {	// loop to compare based on timestamp
                                Blockchain.localBlockList.clear();// clearing the blockchain
                                Blockchain.localBlockList.addAll(tempList);// adding the temporary list to the blockchain
                                System.out.println("---NEW BLOCK--- " + "\nCurrent Block Data: " + Blockchain.localBlockList.get(0).getBlockData() + "\n" + "Verified by process: " + Blockchain.localBlockList.get(0).getVerificationProcessID() + "\n");
                                Blockchain.JSONWriter();	// Writing to the disk
                            } 
                            else {     
                                if (Blockchain.localBlockList.get(i).getRandomSeed().compareTo(tempList.get(i).getRandomSeed()) < 0) {	// Winner is decided on basis of random seed if the timestmaps are same
                                    System.out.println("---NEW BLOCK--- " + "\nCurrent Block Data: " + Blockchain.localBlockList.get(0).getBlockData() + "\n" + "Verified by process: " + Blockchain.localBlockList.get(0).getVerificationProcessID() + "\n");
                                    Blockchain.JSONWriter();// Writing to the disk
                                } 
                                else {
                                    Blockchain.localBlockList.clear();	// clearing the blockchain
                                    Blockchain.localBlockList.addAll(tempList);	// adding the temporary list to the blockchain
                                    System.out.println("---NEW BLOCK--- " + "\nCurrent Block Data: " + Blockchain.localBlockList.get(0).getBlockData() + "\n" + "Verified by process: " + Blockchain.localBlockList.get(0).getVerificationProcessID() + "\n");
                                    Blockchain.JSONWriter();	// Writing to the disk
                                }
                            }
                        }
                    }
                }
            }
            sock.close();// Closes the socket connection
        } 
        catch (IOException ioe) {ioe.printStackTrace();}	// catch any exception
    }
}

class BlockchainProcess implements Runnable { //This class starts up the blockchain server
    public void run() {
        int q_len = 6;	// if there is more than 6 connections to server before can spawn thread it will throw away anything after 6
        Socket sock;	// sock is allocated to socket
        System.out.println("Blockchain Server = " + Integer.toString(Ports.BlockchainServPort));	// type casting the port number int into a string
        try {
            ServerSocket servsock = new ServerSocket(Ports.BlockchainServPort, q_len);	// create new server socket passing it the blockchain server port and q_len
            while (true) {	// this means it runs forever
                sock = servsock.accept();	// accept the connection
                new BlocksControl(sock).start();	// start the BlocksControl thread
            }
        } 
        catch (IOException ioe) {System.out.println(ioe);}	// catch any exceptions
    }
}

public class Blockchain { // Main class
    private static final String AlphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static int processLength = 3; // max process length
    public static String servHostName = "localhost";
    public static int pNum = 0; // hold the current process number
    public static PubKey[] pubKey = new PubKey[3]; //This array holds the public key
    public static PrivateKey privKey;
    private static final int iFNAME = 0;
    private static final int iLNAME = 1;
    private static final int iDOB = 2;
    private static final int iSSN = 3;
    private static final int iDIAG = 4;
    private static final int iTREAT = 5;
    private static final int iRX = 6;
    private static String FILENAME = "";
    private static String suuid;
    private static UUID uuid;
    private static LinkedList<BlockDetail> blockchainList; // contains the unverified blocks
    public static ArrayList<BlockDetail> localBlockList = new ArrayList<>(); // holds the local Blockchain

    public static Comparator<BlockDetail> BlockComparator = new Comparator<BlockDetail>() {
        @Override
        public int compare(BlockDetail b1, BlockDetail b2) {	// compare the block based on timestamp
            String s1 = b1.getTimeStamp();	// assigni b1 timestamp to s1
            String s2 = b2.getTimeStamp();	// assign b2 timestamp to s2
            if (s1 == s2) {return 0;}	// if they are equal return 0 (true)
            if (s1 == null) {return -1;}	// if s1 is null return -1 (false)
            if (s2 == null) {return 1;}	// if s2 is null return 1 (fasle)
            return s1.compareTo(s2);	// returns the compared value
        }
    };

    static PriorityBlockingQueue<BlockDetail> PriorityQueue = new PriorityBlockingQueue<>(100, BlockComparator);	// create a priority queue for the blocks

    public static void main(String args[]) {// Updating the process number based on the input
        if (args.length < 1) {pNum = 0;} 
        else if (args[0].equals("0")) {pNum = 0;} // if BlockInput 0 is sent then assign it to process 0
        else if (args[0].equals("1")) {pNum = 1;}	// if BlockInput 1 is sent then assign it to process 1
        else if (args[0].equals("2")) {pNum = 2;}	// if BlockInput 2 is sent then assign it to process 2 
        else {pNum = 0;}	// start at process 0
        System.out.println("Process " + String.valueOf(pNum));
        new Ports().startPorts();	// ports are updated to specific process while avoiding any collisions
        new Thread(new PubKeyProcess()).start();	//Starts the PubKey server
        new Thread(new BlockProcess()).start();	//Starts the UVBlock server
        new Thread(new BlockchainProcess()).start();	//Starts the Blockchain Server
        try {Thread.sleep(1000);}	//delay in order to allow the remaining servers to start
        catch(Exception e) {}	// catch any exception
        blockchainList = new LinkedList<>();	// update the original block list       
        if (pNum == 0) {	//creates a dummy block
            String currentHash;	// declare the variable for currentHash
            Gson gson = new GsonBuilder().setPrettyPrinting().create();	// creating a new Gson object 
            BlockDetail block = new BlockDetail();	// create new object for the block details
            Date date = new Date();	// object created for getting the date from the system
            String T = String.format("%1$s %2$tF.%2$tT", "", date);	//format for the date
            String TimeStamp = T + "." + pNum;	// formatting the the timestamp 
            block.setTimeStamp(TimeStamp);	// set timestamp to block
            block.setPreviousHashInfo("0");	// set previous hash info to block
            block.setBlockData("Waiting");	// set block data to block
            uuid = UUID.randomUUID();	// assign a random uuid
            block.setUuid(uuid);	// set the random uuid to block
            suuid = new String(uuid.toString());	// typcast uuid to string format
            block.setBlockID(suuid);	// set the random suuid to block
            currentHash = BlockVerification(block);	// sending the block to block verifier and getting current hash
            block.setCurrentHash(currentHash);	// set the current hash to the block
            block.setVerificationProcessID(String.valueOf(pNum));	// create the process ID for the block using the process number
            String T1 = String.format("%1$s %2$tF.%2$tT", "", date);	// timestamp format to string
            System.out.println(T1);	// printing the timestamp
            block.setVerifiedTimeStamp(T1);	// sending the timestamp to the block
            localBlockList.add(block);	// adding the block to the list
            Blockchain.BlockchainCast();	// we are casting the block to the ledger
        }
        Blockchain.pubKeyCast(); // Multicast the public keys to remaining processes
        try {Thread.sleep(1000);} // a delay to let each process send all the public keys to the other processes
        catch(Exception e) {}	// catch any exception
        switch (pNum) {	// reads the input file depending on the number of the process
        	default:
        		FILENAME = "BlockInput0.txt";
        		break;
            case 1:
                FILENAME = "BlockInput1.txt";
                break;
            case 2:
                FILENAME = "BlockInput2.txt";
                break;
        }       
        try {	// read each line and create a block
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));	// reading the input from the file
            String[] tokens = new String[20];	// array is declared to hold parts of the data
            String InputLineStr;	// declaring the variable to hold the parts
            StringWriter sw = new StringWriter();	// used to write to the file
            while ((InputLineStr = br.readLine()) != null) {	// checking to see if input lines are not null
                BlockDetail bd = new BlockDetail();	// creating an object to hold the block details
                Date date = new Date();	// object created for getting the date from the system 
                tokens = InputLineStr.split(" +");	// splitting the block data based on the split condition 
                String time = String.format("%1$s %2$tF.%2$tT", "", date);	// formating the timestamp to string
                String timeStamp = time + "." + pNum; // which allows the processes not have timestamp collisions
                System.out.println("Timestamp " + tokens[iFNAME] + " " + tokens[iLNAME] + " - " + timeStamp);	// printing the block detail 
                bd.setTimeStamp(timeStamp);	// setting the timestamp for the block detail 
                uuid = UUID.randomUUID();	// assign uuid which is custom to each block
                bd.setUuid(uuid);	// set the custom uuid to block detail 
                suuid = new String(uuid.toString());	// typcast uuid to string format
                bd.setBlockID(suuid);	// set the suuid to block detail 
                byte[] byteSig = blockSig(suuid.getBytes(), privKey); // block Sig process
                String sigString = Base64.getEncoder().encodeToString(byteSig);	// sign the suuid and encrypting the key
                bd.setSigBlockID(sigString);	// set the sign string to the blockID
                bd.setFname(tokens[iFNAME]);	// set the first name to the block iFname
                bd.setLname(tokens[iLNAME]);	// set the last name to the block iLname
                bd.setSSN(tokens[iSSN]);	// set the SSN to the block iSSN
                bd.setDOB(tokens[iDOB]);	// set the DOB to the block iDOB
                bd.setDiag(tokens[iDIAG]);	// set the diagnostic to the block iDIAG
                bd.setTreat(tokens[iTREAT]);	// set the treatment to the block iTREAT
                bd.setRx(tokens[iRX]);	// set the RX to the block iRX
                bd.setBlockData(InputLineStr);	// set the input line string to BlockData
                bd.setCreatedProcessID(String.valueOf(pNum));	// set the process number to CreatedProcessID             
                MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");	// hashing and storing the data - sign the data
                byte[] hashedBytes = msgDigest.digest(InputLineStr.getBytes("UTF-8"));	// encrypt the data
                String hashData = BytetoString(hashedBytes);	// set the data
                bd.setHashedData(hashData);	// add it to the block list               
                byte[] byteDataSig = blockSig(hashData.getBytes(), privKey);	// sign the hash data to be used later 
                String sigDataString = Base64.getEncoder().encodeToString(byteDataSig);	// encrypt the data
                bd.setSigBlockData(String.valueOf(sigDataString));	// set the data
                blockchainList.add(bd);	// add it to the block list
            }
        } 
        catch (Exception e) {e.printStackTrace();}	// catch any exception 
        Blockchain.UVBlockCast();	// we are multicasting the unverified blocks to the ledger
        delay(); // This is a delay to sync the process
        new Thread(new BlockChecker()).start();	// starting the next block
    }

    public static void delay() {	// delay process
        try {
            if(pNum == 0) {Thread.sleep(2000);} 
            else if(pNum == 1) {Thread.sleep(1000);}
        } 
        catch(Exception e) {}	// catch any exceptions
    }
    
    public static KeyPair keyGen(long seed) throws Exception {	// create the key
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");	// create the object for the key generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");	// create the object for secure random
        sr.setSeed(seed);	// we are sending the seed to secure random to sign the key
        keyGenerator.initialize(1024, sr);	// we are initializing the random generator 
        return (keyGenerator.generateKeyPair());	// return the generated key
    }
    
    public static byte[] blockSig(byte[] data, PrivateKey key) throws Exception {	// sign the data
        Signature sig = Signature.getInstance("SHA1withRSA");	// getting the signed key
        sig.initSign(key);	// create the signature for the verification
        sig.update(data);	// update the signature for verification
        return (sig.sign());	// return the signed signature
    }

    public static boolean verifyBlock(byte[] data, PublicKey key, byte[] signer) throws Exception {	// verify block 
        Signature sig = Signature.getInstance("SHA1withRSA");	// getting the signed key 
        sig.initVerify(key);	// verifying the signed key
        sig.update(data);	// update the verified signed key to the block 
        return (sig.verify(signer));	// return the verified block signature
    }

    public static void pubKeyCast() {	// mulitcast the public key
        Socket pSocket;	// declare the socket variable
        PrintStream messageOut;	// declare the message output
        try {
            KeyPair pair = keyGen(new Random().nextInt(999) * pNum);	// generate a new key pair
            Gson gson = new GsonBuilder().create();	// create a new Gson object
            byte[] pubKeyBytes = pair.getPublic().getEncoded();	// encoding the public key
            String pubKeyString = Base64.getEncoder().encodeToString(pubKeyBytes);	// encrypt the public key
            privKey = pair.getPrivate();	// getting the private key
            pubKey[pNum] = new PubKey();	// sending the process number to the public key
            pubKey[pNum].setPubKey(pubKeyString);	// set the process number to the public key
            pubKey[pNum].setProcessNumber(pNum);	// set the process number 
            for (int i = 0; i < processLength; i++) {	// putting the key to the network using casting
                pSocket = new Socket(servHostName, Ports.PubKeyInitPort + i);	// create a new socket passing public key initial port 
                messageOut = new PrintStream(pSocket.getOutputStream());	// printing out the socket data
                messageOut.println(gson.toJson(pubKey[pNum]));	// converting Gson to JSON
                messageOut.flush();	// clear out the buffer
                pSocket.close();	// close the connection
            }
        } 
        catch (Exception e) {e.printStackTrace();}	// catch any exception
    }

    public static void UVBlockCast() {	// mulitcast unverified blocks to all processes to include it in JSON
        Socket pSocket;
        PrintStream UVBlockOut;
        try {
            Gson gson = new GsonBuilder().create();	// creating a new Gson object 
            for (int i = 0; i < processLength; i++) {	// putting the unverified block to the network using casting
                pSocket = new Socket(servHostName, Ports.UVBlockInitPort + i);	// create a new socket passing unverified block initial port
                UVBlockOut = new PrintStream(pSocket.getOutputStream());	// printing out the socket data
                UVBlockOut.println(gson.toJson(blockchainList));	// converting Gson to JSON
                UVBlockOut.flush();	// clear out the buffer
                pSocket.close();	// close the connection
            }
        } 
        catch (Exception e) {e.printStackTrace();}	// catch any exception
    }
  
    public static void BlockchainCast() {	//Multicast the updated blockchain
        Socket pSocket;
        PrintStream blockOut;
        try {
            Gson gson = new GsonBuilder().create();	// creating a new Gson object 
            for (int i = 0; i < processLength; i++) {	// putting the blockchain to the network using casting v
                pSocket = new Socket(servHostName, Ports.BlockchainInitPort + i);	// create a new socket passing blockchain initial port 
                blockOut = new PrintStream(pSocket.getOutputStream());	// printing out the socket data
                blockOut.println(gson.toJson(localBlockList));	// converting Gson to JSON
                blockOut.flush();	// clear out the buffer
                pSocket.close();	// close the connection
            }
        } 
        catch (Exception e) {e.printStackTrace();}	// catch any exception
    }

    // To increase the complexity the number can be increased, which makes the puzzle hard to solve
    public static String BlockVerification(BlockDetail block) {	// function to simulate the work 
        String allBlockInfo;	// declare allblockinfo which holds all the block data in one variable
        byte[] hashedBytes = null;	// declare hashedbytes and set to null
        String currentHash = null;	// declare currentHash and set to null
        int work = 0;	// set work to 0 to start the initial count
        try {
            for (int count = 0; count <= 20; count++) {	// loop to check the count 
                String randomSeed = AlphaRand(16);	// assign random seed the number of characters to be used
                allBlockInfo = block.getPreviousHashInfo() + block.getBlockData() + randomSeed;	// assign previous hash, block data, and random seed to all block info
                System.out.println(block.getBlockData());	// print the block data
                MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");	// encrypting the data
                hashedBytes = msgDigest.digest(allBlockInfo.getBytes("UTF-8"));	// sign the key
                currentHash = BytetoString(hashedBytes);	// hash the key
                work = Integer.parseInt(currentHash.substring(0, 4), 16);	// converting the hash to int
                int complexity = 20000;	// assign the difficulty level
                if (!(work < complexity)) {System.out.format("%d is not less than " + complexity + " - block is NOT verified\n\n", work);}	// check to see if work is not less than difficulty level and print the message and say that its not verified
                if (work < complexity) {	// check to see if work is less than difficulty level 
                    System.out.format("%d is less than " + complexity + " - block is verified!\n", work);	// print the message and say that it is verified
                    System.out.println("Block Verification RandomSeed: " + randomSeed + "\n");	// print out the random seed
                    block.setRandomSeed(randomSeed);	// update the random seed to the ledger
                    try {Thread.sleep(1000);} 	// use sleep to simulate work 
                    catch(Exception e) {e.printStackTrace();}	// catch any exception 
                    return currentHash;	// return current hash
                }
            }
        } 
        catch (Exception e) {System.out.println(e.getMessage());}	// catch any exception
        block.setRandomSeed("");	// set the random seed
        return currentHash;	// return the current hash
    }
    
    public static String AlphaRand(int count) {	// generate the random seed
        StringBuilder builder = new StringBuilder();	
        while (count-- != 0) {	
            int character = (int) (Math.random() * AlphaNum.length());
            builder.append(AlphaNum.charAt(character));
        }
        return builder.toString();
    }
    
    public static String BytetoString(byte[] bs) {	// convert the data to string 
        StringBuilder hex = new StringBuilder(bs.length * 2);	
        for (int i = 0; i < bs.length; i++) {
            hex.append(String.format("%02X", bs[i]));
        }
        return hex.toString();
    }
    
    public static void JSONWriter() {	// write json data to the file
        if (pNum == 0) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();	// creating a new Gson object 
            try (FileWriter writer = new FileWriter("BlockchainLedger.json")) {	// write and name the file 
                gson.toJson(Blockchain.localBlockList, writer);	// this is the conversion form Gson to JSON
            } 
            catch (IOException ioe) {System.out.println("Error: Can not write to the file");}	// catch any exception 
        }
    }
}
