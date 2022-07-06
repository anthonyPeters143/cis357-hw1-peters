// Homework 1: Sales Register Program
// Course: CIS357
// Due date: 4-4-22
// Name: Anthony Peters
// GitHub: https://github.com/anthonyPeters143/cis357-hw1-peters
// Instructor: Il-Hyung Cho
// Program description: The Sale class tracks item totals, quantities, as well as sale total, total with tax included,
// and End of day total for CashRegister class. Sale class can also create a receipt and reset totals while leaving the
// End of day total.

import java.text.DecimalFormat;

/**
 * @author Anthony Peters
 *
 * Sales class store sale itemTotals, itemQuantity, saleTotal, totalWithTax, EODtotal and allows CashRegister to
 * reset the sale totals, create receipt, add/get/set totals and quantities of all fields
 */

public class Sale {

    /** Item totals are used to track the total for each item type checked out */
    private double item1Total,item2Total,item3Total,item4Total,
            item5Total,item6Total,item7Total,item8Total,item9Total,item10Total;
    /** Item quantity are used to track the amount of each item type checked out */
    private int item1Quantity,item2Quantity,item3Quantity,item4Quantity,
            item5Quantity,item6Quantity,item7Quantity,item8Quantity,item9Quantity,item10Quantity;
    /** Sale totals are used to track the amount of all itemTotal and total with tax adds the .06 tax onto the total */
    private double saleTotal, totalWithTax;
    /** End of Day total tracks over all sales for day and isn't reset when other sale totals are */
    private double EODtotal;

    /**
     * Non-Aug. Constructor
     * Calls resetSale method to reset sale totals
     */
    Sale(){
            EODtotal = 0;
            resetSale();
        }

        /**
         * Receipt is created by concatenating Strings together if an item type total is higher than 0, then adds
         * subtotals and total with tax after
         *
         * @param   currencyFormat, currency format for totals
         * @return  String of receipt including any items totals and overall subtotal and total with tax
         */
        public String createReceipt(DecimalFormat currencyFormat){
            String returnString = "";

            // Add up all item totals
            saleTotal = item1Total+item2Total+item3Total+item4Total+item5Total+item6Total+item7Total+item8Total+item9Total+item10Total;

            // Determine total with tax included
            totalWithTax = saleTotal + (saleTotal * 0.06);

            // increment EODtotal counter
            EODtotal += saleTotal;

            // Create return string
            if (item1Total > 0) {returnString = returnString.concat("\t" + item1Quantity +"\tbottled water\t $" + String.format("%1$8s",currencyFormat.format(item1Total)+"\n"));}
            if (item2Total > 0) {returnString = returnString.concat("\t" + item2Quantity +"\tcandy\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item2Total)+"\n"));}
            if (item10Total > 0) {returnString = returnString.concat("\t" + item10Quantity +"\tcaramel\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item10Total)+"\n"));}
            if (item3Total > 0) {returnString = returnString.concat("\t" + item3Quantity +"\tchocolate\t\t $" +  String.format("%1$8s",currencyFormat.format(item3Total)+"\n"));}
            if (item8Total > 0) {returnString = returnString.concat("\t" + item8Quantity +"\tdonut\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item8Total)+"\n"));}
            if (item4Total > 0) {returnString = returnString.concat("\t" + item4Quantity +"\tgum\t\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item4Total)+"\n"));}
            if (item6Total > 0) {returnString = returnString.concat("\t" + item6Quantity +"\tjuice\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item6Total)+"\n"));}
            if (item7Total > 0) {returnString = returnString.concat("\t" + item7Quantity +"\tpopcorn\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item7Total)+"\n"));}
            if (item9Total > 0) {returnString = returnString.concat("\t" + item9Quantity +"\tpretzel\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item9Total)+"\n"));}
            if (item5Total > 0) {returnString = returnString.concat("\t" + item5Quantity +"\tsoda\t\t\t $" +  String.format("%1$8s",currencyFormat.format(item5Total)+"\n"));}
            returnString = returnString.concat("Subtotal\t\t\t\t $" +  String.format("%1$7s",currencyFormat.format(saleTotal))
                    +"\nTotal with Tax (6%)\t\t $" +  String.format("%1$7s",currencyFormat.format(totalWithTax)));

            return returnString;
        }

        /** removes all item sale data, including itemTotals and saleTotal except for end of day total */
        public void resetSale() {
            // Item totals
            item1Total = 0.0;
            item2Total = 0.0;
            item3Total = 0.0;
            item4Total = 0.0;
            item5Total = 0.0;
            item6Total = 0.0;
            item7Total = 0.0;
            item8Total = 0.0;
            item9Total = 0.0;
            item10Total = 0.0;

            // Item quantities
            item1Quantity = 0;
            item2Quantity = 0;
            item3Quantity = 0;
            item4Quantity = 0;
            item5Quantity = 0;
            item6Quantity = 0;
            item7Quantity = 0;
            item8Quantity = 0;
            item9Quantity = 0;
            item10Quantity = 0;

            // Sale total
            saleTotal = 0;
            totalWithTax = 0;
        }

        /**
         * Add double to item 1 total
         *
         * @param input double type, item sale amount
         */
        public void addItem1Total(double input){item1Total += input;}
        /**
         * Add double to item 2 total
         *
         * @param input double type, item sale amount
         */
        public void addItem2Total(double input){item2Total += input;}
        /**
         * Add double to item 3 total
         *
         * @param input double type, item sale amount
         */
        public void addItem3Total(double input){item3Total += input;}
        /**
         * Add double to item 4 total
         *
         * @param input double type, item sale amount
         */
        public void addItem4Total(double input){item4Total += input;}
        /**
         * Add double to item 5 total
         *
         * @param input double type, item sale amount
         */
        public void addItem5Total(double input){item5Total += input;}
        /**
         * Add double to item 6 total
         *
         * @param input double type, item sale amount
         */
        public void addItem6Total(double input){item6Total += input;}
        /**
         * Add double to item 7 total
         *
         * @param input double type, item sale amount
         */
        public void addItem7Total(double input){item7Total += input;}
        /**
         * Add double to item 8 total
         *
         * @param input double type, item sale amount
         */
        public void addItem8Total(double input){item8Total += input;}
        /**
         * Add double to item 9 total
         *
         * @param input double type, item sale amount
         */
        public void addItem9Total(double input){item9Total += input;}
        /**
         * Add double to item 10 total
         *
         * @param input double type, item sale amount
         */
        public void addItem10Total(double input){item10Total += input;}

        /**
         * Add quantity to item 1 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem1Quantity(int input) {this.item1Quantity += input;}
        /**
         * Add quantity to item 2 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem2Quantity(int input) {this.item2Quantity += input;}
        /**
         * Add quantity to item 3 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem3Quantity(int input) {this.item3Quantity += input;}
        /**
         * Add quantity to item 4 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem4Quantity(int input) {this.item4Quantity += input;}
        /**
         * Add quantity to item 5 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem5Quantity(int input) {this.item5Quantity += input;}
        /**
         * Add quantity to item 6 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem6Quantity(int input) {this.item6Quantity += input;}
        /**
         * Add quantity to item 7 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem7Quantity(int input) {this.item7Quantity += input;}
        /**
         * Add quantity to item 8 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem8Quantity(int input) {this.item8Quantity += input;}
        /**
         * Add quantity to item 9 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem9Quantity(int input) {this.item9Quantity += input;}
        /**
         * Add quantity to item 10 quantity
         *
         * @param input int type, item quantity amount
         */
        public void addItem10Quantity(int input) {this.item10Quantity += input;}

        /**
         * Returns total with tax included
         *
         * @return double, totalWithTax
         */
        public double getTotalWithTax() {return totalWithTax;}
        /**
         * Returns End of Day total
         *
         * @return double, EODtotal
         */
        public double getEODtotal() {return EODtotal;}
}

