// Homework 1: Sales Register Program
// Course: CIS357
// Due date: 4-4-22
// Name: Anthony Peters
// GitHub: anthonyPeters143 / cis357-hw1-peters
// Instructor: Il-Hyung Cho
// Program description: CashRegister uses Sale and Item objects to track sales and items and interact with a cashier
// to allow them to input item code and quantity. Will prompt user for beginning a sale, inputting code, and inputting
// quantity.

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Anthony Peters
 *
 * The CashRegister contatins initialize and transaction methods, and uses Sale and Item objects
 */
public class CashRegister {

    /**
     * Number of items types in inventory
     */
    private final static int numberOfInventoryItems = 10;
    /**
     * Inventory for items
     */
    private static Items[] itemArray = new Items[numberOfInventoryItems];
    /**
     * Sale object
     */
    private static Sale sale;
    private static final DecimalFormat currencyFormat = new DecimalFormat("#,###.00");

    // String constants
    private static final String INVENTORY_FILE = "INVENTORY_FILE",
        WELCOME_MESSAGE                     = "\nWelcome to Peter's cash register system!\n",
        BEGINNING_SALE_MESSAGE              = "\nBeginning a new sale? (Y/N) ",
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
     * Main method drives class and exits the system when finished
     */
    public static void main(String[] args) {
        // Declare and Initialization Item object array
        initialize();

        // Sale
        transaction();

        // Finish
        System.exit(0);
    }

    /**
     * Method initializes Item array and Sale item
     *
     * @throws  IOException,if file is not found or file input is invalid
     */
    private static void initialize() {
        // Declare and Initialization
        String fileLine;
        Scanner fileScanner;
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
    }

    /**
     * Transaction method drives the check-out process loop and checks the output transaction number from checkOut
     * method then returns to main when checkOut returns not 1
     */
    private static void transaction(){
        int transactionNumber;

        // Welcome message output
        System.out.print(WELCOME_MESSAGE);

        // Loop till checkOut() returns != 1
        do {
            // Start Sale Interaction
            transactionNumber = checkOut();
        } while (transactionNumber != 1);
    }

    /**
     * checkOut method drives interaction between user input and Sale object by prompting for new sales, item codes
     * and quantities. When receiving 'Y' or 'y' inputs for new sale input, method will prompt for an item code [1-10]
     * then quantity amount [1-100]. If sale input is 'N' or 'n', method will output an exit message and End of Day
     * total. If item code entered is "-1", then method will output a receipt of totals, names, and quantities of items
     * sold in that sale then prompt and check input for tender and output change amount. Then reset to prompting for
     * new sales.
     *
     * @return      2 if input for new sale is 'Y'/'y', 1 if input is 'N'/'n', else 0
     */
    private static int checkOut(){
        // Declare and Initialization
        int returnInt = 0, itemQuantity;
        String itemCode;
        double itemPrice = 0, tenderAmount;
        boolean codeInputFlag = false, quantityInputFlag = false, tenderCorrectFlag = false,quitSaleFlag;

        // User input try/catch for Y,N,y,n
        try
        {
            // Setup scanner for input
            Scanner inputScanner = new Scanner(System.in);

            // loop till input is correct
            do {
                // Reset flag
                quitSaleFlag = false;

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
                            // Reset code flag
                            codeInputFlag = false;

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
                                System.out.print(ITEM_NAME_MESSAGE + itemArray[Integer.parseInt(itemCode)-1].getitemName());

                                // Loop till input is valid
                                do {
                                    try {
                                        // Reset flag
                                        quantityInputFlag = false;

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
                                            System.out.print(ITEM_TOTAL_MESSAGE +  String.format("%1$8s",currencyFormat.format(itemPrice) + "\n"));

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
                                } while (!quantityInputFlag);

                                // Finish sale
                            } else if (Integer.parseInt(userInput) == -1) {
                                codeInputFlag = true;
                                quitSaleFlag = true;

                                // Quit and Print top of receipt for sale
                                // add receipt top
                                System.out.print(RECEIPT_LINE + RECEIPT_TOP + sale.createReceipt(currencyFormat));

                                // Loop till tendered amount is larger than total with tax
                                do {
                                    try {
                                        // Reset tender flag
                                        tenderCorrectFlag = false;

                                        // Prompt for tender amount
                                        System.out.print(TENDERED_AMOUNT_RECEIPT);

                                        // User input
                                        tenderAmount = Double.parseDouble(inputScanner.next());

                                        // Tender amount is correct
                                        if (tenderAmount >= sale.getTotalWithTax()) {
                                            tenderCorrectFlag = true;

                                            // Change
                                            // find change by subtracting tenderAmount by Total with tax
                                            System.out.print(CHANGE_AMOUNT + String.format("%1$7s",currencyFormat.format(tenderAmount-sale.getTotalWithTax())) + RECEIPT_LINE);

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
                    } while (!codeInputFlag || !quitSaleFlag);

                }
                //Test if input is 1 char long and is Nn
                else if (userInput.matches("[Nn]{1}")){

                    // Input Correct, user = no
                    returnInt = 1;

                    // EOD earnings
                    System.out.print(EOD_MESSAGE +  String.format("%1$8s",currencyFormat.format(sale.getEODtotal())) +
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

