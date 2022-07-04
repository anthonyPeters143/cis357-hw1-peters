// Homework 1: Sales Register Program
// Course: CIS357
// Due date: xxx
// Name: Anthony Peters
// GitHub: xxx
// Instructor: Il-Hyung Cho
// Program description:

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Javadoc comments for CashRegister.java */
public class CashRegister {

    // Global vars
    private static int numberOfInventoryItems = 10;
    private static Items[] itemArray = new Items[10];

    // Constants
    private static final String INVENTORY_FILE = "INVENTORY_FILE",
        WELCOME_MESSAGE = "\nWelcome to Peters cash register system!\n\n",
        BEGINNING_SALE_MESSAGE  = "Beginning a new sale? (Y/N) ",
        INPUT_INCORRECT_MESSAGE = "Input incorrect, should be : ",     // add char to end of message
        BREAK_LINE              = "--------------------",
        ENTER_CODE_MESSAGE      = "Enter product code: ",
        ITEM_NAME_MESSAGE       = "         item name: ",
        ENTER_QUANTITY_MESSAGE  = "Enter quantity:     ",
        ITEM_TOTAL_MESSAGE      = "        item total: ";

    /**
     * Main method
     */
    public static void main(String[] args) {     //DONT FORGET TO ADD EXCEPTION
        // Declare and Initialization Item object array
        initialize();

        // Sale
        transaction();

        // Finish

    }

    /**
     * Initialize method
     */
    private static void initialize() {
        // Declare and Initialization
        String fileLine;
        Scanner fileScanner = null;
        File fileRef = new File(INVENTORY_FILE);
        itemArray = new Items[numberOfInventoryItems];

        // Setting up scanner
        try {
            fileScanner = new Scanner(fileRef);

            // Scan in imput and split by new line chars
            fileLine = fileScanner.nextLine();
            String[] splitFileImport = fileLine.split(Pattern.quote(","));

            // Input code, name, price into Items objects in the array, advance index by 1, split index by 4
            for (int index = 0, splitIndex = 0; index < 10; index+=1, splitIndex+=3) {
                // Create by index in array and imported from split input array
                itemArray[index] = new Items(Integer.parseInt(splitFileImport[splitIndex]),
                        String.valueOf(splitFileImport[splitIndex+1]),
                        Double.parseDouble(splitFileImport[splitIndex+2]));
            }
        }

        // WILL NEED TO UPDATE CATCHES
        catch (IOException ioException)
        {
            // FILE NOT FOUND
//            System.out.print(ioException);
            ioException.printStackTrace();
        }
        catch (Exception e){
            // Will need to change, caused by "Cannot invoke "Items.setCode(int)" because "CashRegister.itemArray[index]" is null"

//            System.out.print(e);
            e.printStackTrace();
        }

    }

    /**
     * Sale method
     */
    private static void transaction(){
        // Welcome message output
        System.out.print(WELCOME_MESSAGE);

        // Start Sale Interaction
        int beginningSaleValue = welcome();


    }

    /**
     * Welcome method
     *
     * returns 2 if input is Y,y
     * returns 1 if input is N,n
     * else returns 0
     */
    private static int welcome(){
        // Declare and Initialization
        int returnInt = 0;
        boolean codeInputFlag = false;


        // User input try/catch for Y,N,y,n
        try
        {
            // Output Beginning Message
            System.out.print(BEGINNING_SALE_MESSAGE);

            // setup scanner for input
            Scanner inputScanner = new Scanner(System.in);
//            inputScanner.close();     For when you ready to close it

            // loop till input is correct
            do {
                // user input
                String userInput = inputScanner.next();

                //Test if input is 1 char long and is Yy
                if (userInput.matches("[Yy]{1}")) {

                    // Input Correct, user = yes
                    returnInt = 2;

                    // Print text break
                    System.out.print(BREAK_LINE);

                    // Start sale   !!!!!!!!!!!!!!!!

                    // Loop till input is correct
                    do {
                        // Prompt for code input
                        System.out.print("\n"+ENTER_CODE_MESSAGE);
                        // User input
                        userInput = inputScanner.next();
                        // Check input
                        if (userInput.matches("\\b([1-9]|10)\\b")){
                            // Code Input Correct
                            codeInputFlag = true;

                            // Add Item to Sale
                            switch (userInput) {
                                case "1":
                                    //Add Sale Item
                                    break;
                                case "2":
                                    //Add Sale Item
                                    break;
                                case "3":
                                    //Add Sale Item
                                    break;
                                case "4":
                                    //Add Sale Item
                                    break;
                                case "5":
                                    //Add Sale Item
                                    break;
                                case "6":
                                    //Add Sale Item
                                    break;
                                case "7":
                                    //Add Sale Item
                                    break;
                                case "8":
                                    //Add Sale Item
                                    break;
                                case "9":
                                    //Add Sale Item
                                    break;
                                case "10":
                                    //Add Sale Item
                                    break;
                            }
                        }
                        else {
                            // Code Input Incorrect
                            // Print incorrect message
                            System.out.print(INPUT_INCORRECT_MESSAGE + "[1-10]\t");
                        }
                    } while (codeInputFlag == false);

                }
                //Test if input is 1 char long and is Nn
                else if (userInput.matches("[Nn]{1}")){

                    // Input Correct, user = no
                    returnInt = 1;

                    // EOD earnings
                }
                else {
                    // Input incorrect
                    // Print incorrect message
                    System.out.print(INPUT_INCORRECT_MESSAGE + "(Y/N)\t");
                }
            } while (returnInt == 0);

            return returnInt;

            // add extra exception for input problems
        } catch (Exception e){
            // Input incorrect
            e.printStackTrace();

            return 0;
        }
    }

            //!!!importFromFile

        //!!!runSale

            //!!!printRecite

        //import and initilaize ItemArray
            //split by "," into ItemArray 0-29
        
        //prompt user Y/N for sale
            //Y
               //create NEW Sale object
               //prompt for itemCode
                  //if code == 1-10
                      //use code to find item
                  //if code == -1
                      //print list/receipt and return to prompt user Y/N for sale
                  //else retry code till valid
            //N
                //print daySaleTotal
}
