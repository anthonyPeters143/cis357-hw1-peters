// Homework 1: Sales Register Program
// Course: CIS357
// Due date: xxx
// Name: Anthony Peters
// GitHub: xxx
// Instructor: Il-Hyung Cho
// Program description:

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/** Javadoc comments for CashRegister.java */
public class CashRegister {

    // Global vars
    private final static int numberOfInventoryItems = 10;
    private static Items[] itemArray = new Items[10];
    private static Sale sale;
    private static final DecimalFormat currencyFormat = new DecimalFormat("#,###.00");

    // Constants
    private static final String INVENTORY_FILE = "INVENTORY_FILE",
        WELCOME_MESSAGE                     = "\nWelcome to Peter's cash register system!\n",
        BEGINNING_SALE_MESSAGE              = "\nBeginning a new sale? (Y/N) ",
//        INPUT_INCORRECT_MESSAGE             = "Input incorrect, should be : ",     // add char to end of message
        SALE_INPUT_INCORRECT_MESSAGE        = "!!! Invalid input\nShould be (Y/N)\n",
        CODE_INPUT_INCORRECT_MESSAGE        = "!!! Invalid product code\nShould be [1-10], -1 = quit",
        QUANTITY_INPUT_INCORRECT_MESSAGE    = "!!! Invalid quantity\nShould be [1-100]",
        BREAK_LINE                          = "--------------------",
        ENTER_CODE_MESSAGE                  = "Enter product code: ",
        ITEM_NAME_MESSAGE                   = "         item name: ",
        ENTER_QUANTITY_MESSAGE              = "Enter quantity:     ",
        ITEM_TOTAL_MESSAGE                  = "        item total: $",
        RECEIPT_LINE                        = "\n----------------------------\n",
        RECEIPT_TOP                         ="Items list:\n",
        TENDERED_AMOUNT_RECEIPT             = "\nTendered amount\t\t\t $",
        TENDER_AMOUNT_WRONG                 = "\nAmount entered is invalid",
        TENDER_AMOUNT_TOO_SMALL             = "\nAmount entered is too small",
        CHANGE_AMOUNT                       = "Change\t\t\t\t\t $",
        EOD_MESSAGE                         = "\nThe total sale for the day is  $",
        THANK_YOU                           = "Thanks for using POST system. Goodbye.";

    /**
     * Main method
     */
    public static void main(String[] args) {     //DONT FORGET TO ADD EXCEPTION
        // Declare and Initialization Item object array
        initialize();

        // Sale
        transaction();

        // Finish
        System.exit(0);
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
        sale = new Sale();

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

            // Close scanner
            fileScanner.close();
        }

        // WILL NEED TO UPDATE CATCHES
        catch (IOException ioException)
        {
            // FILE NOT FOUND
            ioException.printStackTrace();
        }
        catch (Exception e){
            // Will need to change, caused by "Cannot invoke "Items.setCode(int)" because "CashRegister.itemArray[index]" is null"
            e.printStackTrace();
        }

    }

    /**
     * Transaction method
     *
     * drives the check-out process
     */
    private static void transaction(){
        // Welcome message output
        System.out.print(WELCOME_MESSAGE);

        // Start Sale Interaction
        checkOut();

    }

    /**
     * checkOut method
     *
     * returns 2 if input is Y,y
     * returns 1 if input is N,n
     * else returns 0
     */
    private static int checkOut(){
        // Declare and Initialization
        int returnInt = 0, itemQuantity;
        String itemCode;
        double itemPrice = 0, tenderAmount = 0;
        boolean codeInputFlag = false, quantityInputFlag = false, dayFinshedFlag = false,
                quitSaleFlag, tenderCorrectFlag = false;

        // User input try/catch for Y,N,y,n
        try
        {
            // Setup scanner for input
            Scanner inputScanner = new Scanner(System.in);
//            inputScanner.close();     For when you ready to close it

            // loop till input is correct
            do {
                quitSaleFlag =false;

                // Output Beginning Message
                System.out.print(BEGINNING_SALE_MESSAGE);

                // User input
                String userInput = inputScanner.next();

                // Test if input is 1 char long and is Yy
                if (userInput.matches("[Yy]{1}")) {

                    // Input Correct, user = yes
                    returnInt = 2;

                    // Print text break
                    System.out.print(BREAK_LINE);

                    // Loop till input is valid
                    do {
                        try {
                            // Prompt for code input
                            System.out.print("\n"+ENTER_CODE_MESSAGE);

                            // User input
                            userInput = inputScanner.next();

                            // Check if code input is [1-10]
                            if (userInput.matches("\\b([1-9]|10)\\b")){
                                // Code Input Valid
                                itemCode = userInput;
                                codeInputFlag = true;

                                // Output Item name message + item name from itemArray
                                System.out.print(ITEM_NAME_MESSAGE + itemArray[Integer.parseInt(userInput)-1].getitemName());

                                // Loop till input is valid
                                do {
                                    try {
                                    // Prompt for item quantity
                                    System.out.print("\n"+ENTER_QUANTITY_MESSAGE);

                                    // User input
                                    userInput = inputScanner.next();

                                    itemQuantity = Integer.parseInt(userInput);

                                    // Check if quantity is [1-100]
                                    if (itemQuantity > 0 && itemQuantity <= 100) {
                                        // Quantity input valid
                                        quantityInputFlag = true;

                                        // Add Item price to Sale object
                                        switch (itemCode) {
                                            case "1":
                                                itemPrice = itemArray[0].getPrice() * itemQuantity;
                                                sale.addItem1Total(itemPrice);
                                                sale.addItem1Quantity(itemQuantity);
                                                break;
                                            case "2":
                                                itemPrice = itemArray[1].getPrice() * itemQuantity;
                                                sale.addItem2Total(itemPrice);
                                                sale.addItem2Quantity(itemQuantity);
                                                break;
                                            case "3":
                                                itemPrice = itemArray[2].getPrice() * itemQuantity;
                                                sale.addItem3Total(itemPrice);
                                                sale.addItem3Quantity(itemQuantity);
                                                break;
                                            case "4":
                                                itemPrice = itemArray[3].getPrice() * itemQuantity;
                                                sale.addItem4Total(itemPrice);
                                                sale.addItem4Quantity(itemQuantity);
                                                break;
                                            case "5":
                                                itemPrice = itemArray[4].getPrice() * itemQuantity;
                                                sale.addItem5Total(itemPrice);
                                                sale.addItem5Quantity(itemQuantity);
                                                break;
                                            case "6":
                                                itemPrice = itemArray[5].getPrice() * itemQuantity;
                                                sale.addItem6Total(itemPrice);
                                                sale.addItem6Quantity(itemQuantity);
                                                break;
                                            case "7":
                                                itemPrice = itemArray[6].getPrice() * itemQuantity;
                                                sale.addItem7Total(itemPrice);
                                                sale.addItem7Quantity(itemQuantity);
                                                break;
                                            case "8":
                                                itemPrice = itemArray[7].getPrice() * itemQuantity;
                                                sale.addItem8Total(itemPrice);
                                                sale.addItem8Quantity(itemQuantity);
                                                break;
                                            case "9":
                                                itemPrice = itemArray[8].getPrice() * itemQuantity;
                                                sale.addItem9Total(itemPrice);
                                                sale.addItem9Quantity(itemQuantity);
                                                break;
                                            case "10":
                                                itemPrice = itemArray[9].getPrice() * itemQuantity;
                                                sale.addItem10Total(itemPrice);
                                                sale.addItem10Quantity(itemQuantity);
                                                break;
                                        }

                                        // Output item total
                                        System.out.print(ITEM_TOTAL_MESSAGE + currencyFormat.format(itemPrice) + "\n");

                                    }
                                    else {
                                        // Quantity Input Incorrect
                                        // Print incorrect message
                                        System.out.print(QUANTITY_INPUT_INCORRECT_MESSAGE);
                                    }

                                } catch (Exception e) {
                                        // Quantity input is incorrect
                                        System.out.print(QUANTITY_INPUT_INCORRECT_MESSAGE);
                                }

                                    // SOMETHING HERE IS WRONG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                                } while (!quantityInputFlag && codeInputFlag);

                                // Finish sale
                            } else if (Integer.parseInt(userInput) == -1) {
                                quitSaleFlag = true;

                                // Quit and Print receipt for sale
                                // add receipt top
                                System.out.print(RECEIPT_LINE + RECEIPT_TOP + sale.createReceipt(currencyFormat));

                                // Loop till tendered amount is larger than total with tax
                                do {
                                    try {
                                        // Prompt for tender amount
                                        System.out.print(TENDERED_AMOUNT_RECEIPT);

                                        // User input
                                        tenderAmount = Double.parseDouble(inputScanner.next());

                                        // Tender amount is correct
                                        if (tenderAmount >= sale.getTotalWithTax()) {
                                            tenderCorrectFlag = true;

                                            // Change
                                            // find change by subtracting tenderAmount by Total with tax
                                            System.out.print(CHANGE_AMOUNT + currencyFormat.format(tenderAmount-sale.getTotalWithTax()) + RECEIPT_LINE);

                                            // return value to 0, loop will re-prompt for sale
                                            returnInt = 0;

                                            // reset sale counter in Sale object
                                            sale.resetSale();
                                        }
                                        else {
                                            // Tender is wrong
                                            System.out.print(TENDER_AMOUNT_TOO_SMALL);
                                        }
                                    } catch (Exception e) {
                                        // Tender is wrong
                                        System.out.print(TENDER_AMOUNT_WRONG);
                                    }

                                } while (!tenderCorrectFlag);


                            } else {
                                // Code Input Incorrect
                                // Print incorrect message
                                System.out.print(CODE_INPUT_INCORRECT_MESSAGE);
                            }

                            // Input exception handler
                        } catch (NumberFormatException numberFormatException) {
                            // Input Incorrect, output message determined by boolean flags
                                // Code input is incorrect
                                System.out.print(CODE_INPUT_INCORRECT_MESSAGE);
                        }

                        // ADD ADDITIONAL FLAG FOR REPEAT
                    } while (!codeInputFlag || !quitSaleFlag);

                }
                //Test if input is 1 char long and is Nn
                else if (userInput.matches("[Nn]{1}")){

                    // Input Correct, user = no
                    returnInt = 1;

                    // EOD earnings
                    System.out.print(EOD_MESSAGE + currencyFormat.format(sale.getEODtotal()) +
                            "\n" + THANK_YOU);
                }
                else {
                    // Input incorrect
                    // Print incorrect message
                    System.out.print(SALE_INPUT_INCORRECT_MESSAGE);
                }
            } while (returnInt == 0);

            // close input scanner
            inputScanner.close();

            return returnInt;

        } catch (Exception e){
            // Input incorrect
            e.printStackTrace();

            return 0;
        }
    }


}

