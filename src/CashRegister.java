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
        WELCOME_MESSAGE = "Welcome to Peters cash register system!\n\nBeginning a new sale? (Y/N)";

    /**
     * Main method
     */
    public static void main(String[] args) {     //DONT FORGET TO ADD EXCEPTION
        // Declare and Initialization Item object array
        initialize();

        // Sale

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
            System.out.print(ioException);
        }
        catch (Exception e){
            // Will need to change, caused by "Cannot invoke "Items.setCode(int)" because "CashRegister.itemArray[index]" is null"

            System.out.print(e);
        }

    }



        //!!!start/initial

        //    {
        //        // Declare and Initialization
        //        QuakeData[] quakeArray = new QuakeData[ARRAY_SIZE];
        //        boolean endSearchingFlag = false;
        //
        //        // Program Identification
        //        identification();
        //
        //        // Processing quakes into array
        //        fileProcessing(quakeArray);
        //
        //        // Looping till user wants to end
        //        do {
        //
        //            // Initialize as false need to true
        //            endSearchingFlag = searchingData(quakeArray);
        //
        //        } while (endSearchingFlag);
        //
        //        // Terminate Program
        //        System.exit(0);
        //    }

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
