import java.text.DecimalFormat;

public class Sale {
    /** Class to store sale itemTotals, itemQuantity, */

    private double item1Total,item2Total,item3Total,item4Total,
            item5Total,item6Total,item7Total,item8Total,item9Total,item10Total;
    private int item1Quantity,item2Quantity,item3Quantity,item4Quantity,
            item5Quantity,item6Quantity,item7Quantity,item8Quantity,item9Quantity,item10Quantity;
    private double saleTotal, totalWithTax, EODtotal;

        /**
        * Non-Aug. Constructor
        */
        Sale(){
            resetSale();
        }

        /**
         * Create Receipt
         *
         * @return String of receipt including any items
         */
        public String createReceipt(DecimalFormat currencyFormat){
            String returnString = "";
            saleTotal = item1Total+item2Total+item3Total+item4Total+item5Total+item6Total+item7Total+item8Total+item9Total+item10Total;
            totalWithTax = saleTotal + (saleTotal * 0.06);
            EODtotal += saleTotal;

            if (item1Total > 0) {returnString = returnString.concat("\t" + item1Quantity +"\tbottled water\t $" + currencyFormat.format(item1Total)+"\n");}
            if (item2Total > 0) {returnString = returnString.concat("\t" + item2Quantity +"\tcandy\t\t\t $" + currencyFormat.format(item2Total)+"\n");}
            if (item10Total > 0) {returnString = returnString.concat("\t" + item10Quantity +"\tcaramel\t\t\t $" + currencyFormat.format(item10Total)+"\n");}
            if (item3Total > 0) {returnString = returnString.concat("\t" + item3Quantity +"\tchocolate\t\t $" + currencyFormat.format(item3Total)+"\n");}
            if (item8Total > 0) {returnString = returnString.concat("\t" + item8Quantity +"\tdonut\t\t\t $" + currencyFormat.format(item8Total)+"\n");}
            if (item4Total > 0) {returnString = returnString.concat("\t" + item4Quantity +"\tgum\t\t\t\t $" + currencyFormat.format(item4Total)+"\n");}
            if (item6Total > 0) {returnString = returnString.concat("\t" + item6Quantity +"\tjuice\t\t\t $" + currencyFormat.format(item6Total)+"\n");}
            if (item7Total > 0) {returnString = returnString.concat("\t" + item7Quantity +"\tpopcorn\t\t\t $" + currencyFormat.format(item7Total)+"\n");}
            if (item9Total > 0) {returnString = returnString.concat("\t" + item9Quantity +"\tpretzel\t\t\t $" + currencyFormat.format(item9Total)+"\n");}
            if (item5Total > 0) {returnString = returnString.concat("\t" + item5Quantity +"\tsoda\t\t\t $" + currencyFormat.format(item5Total)+"\n");}
            returnString = returnString.concat("Subtotal\t\t\t\t $" + currencyFormat.format(saleTotal)
                    +"\nTotal with Tax (6%)\t\t $" + currencyFormat.format(totalWithTax));

            return returnString;
        }

        /**
         * Reset Sale method
         *
         * removes all item sale data, including itemTotals and saleTotal except for end of day total
         */
        public void resetSale() {
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


            saleTotal = 0.0;
        }

        /** add Item1 function
         *
         */
        public void addItem1Total(double input){item1Total += input;}
        public void addItem2Total(double input){item2Total += input;}
        public void addItem3Total(double input){item3Total += input;}
        public void addItem4Total(double input){item4Total += input;}
        public void addItem5Total(double input){item5Total += input;}
        public void addItem6Total(double input){item6Total += input;}
        public void addItem7Total(double input){item7Total += input;}
        public void addItem8Total(double input){item8Total += input;}
        public void addItem9Total(double input){item9Total += input;}
        public void addItem10Total(double input){item10Total += input;}
        public void addItem1Quantity(int item1Quantity) {this.item1Quantity += item1Quantity;}
        public void addItem2Quantity(int item2Quantity) {this.item2Quantity += item2Quantity;}
        public void addItem3Quantity(int item3Quantity) {this.item3Quantity += item3Quantity;}
        public void addItem4Quantity(int item4Quantity) {this.item4Quantity += item4Quantity;}
        public void addItem5Quantity(int item5Quantity) {this.item5Quantity += item5Quantity;}
        public void addItem6Quantity(int item6Quantity) {this.item6Quantity += item6Quantity;}
        public void addItem7Quantity(int item7Quantity) {this.item7Quantity += item7Quantity;}
        public void addItem8Quantity(int item8Quantity) {this.item8Quantity += item8Quantity;}
        public void addItem9Quantity(int item9Quantity) {this.item9Quantity += item9Quantity;}
        public void addItem10Quantity(int item10Quantity) {this.item10Quantity += item10Quantity;}

        // get method
        public double getItem1Total(){return item1Total;}
        public double getItem2Total(){return item2Total;}
        public double getItem3Total(){return item3Total;}
        public double getItem4Total(){return item4Total;}
        public double getItem5Total(){return item5Total;}
        public double getItem6Total(){return item6Total;}
        public double getItem7Total(){return item7Total;}
        public double getItem8Total(){return item8Total;}
        public double getItem9Total(){return item9Total;}
        public double getItem10Total(){return item10Total;}
        public int getItem1Quantity(){return item1Quantity;}
        public int getItem2Quantity(){return item2Quantity;}
        public int getItem3Quantity(){return item3Quantity;}
        public int getItem4Quantity(){return item4Quantity;}
        public int getItem5Quantity(){return item5Quantity;}
        public int getItem6Quantity(){return item6Quantity;}
        public int getItem7Quantity(){return item7Quantity;}
        public int getItem8Quantity(){return item8Quantity;}
        public int getItem9Quantity(){return item9Quantity;}
        public int getItem10Quantity(){return item10Quantity;}
        public double getSaleTotal() {return saleTotal;}
        public double getTotalWithTax() {return totalWithTax;}
        public double getEODtotal() {return EODtotal;}

        // set method
        public void setItem1Total(double input){this.item1Total = input;}
        public void setItem2Total(double input){this.item2Total = input;}
        public void setItem3Total(double input){this.item3Total = input;}
        public void setItem4Total(double input){this.item4Total = input;}
        public void setItem5Total(double input){this.item5Total = input;}
        public void setItem6Total(double input){this.item6Total = input;}
        public void setItem7Total(double input){this.item7Total = input;}
        public void setItem8Total(double input){this.item8Total = input;}
        public void setItem9Total(double input){this.item9Total = input;}
        public void setItem10Total(double input){this.item10Total = input;}
        public void setItem1Quantity(int item1Quantity) {this.item1Quantity = item1Quantity;}
        public void setItem2Quantity(int item2Quantity) {this.item2Quantity = item2Quantity;}
        public void setItem3Quantity(int item3Quantity) {this.item3Quantity = item3Quantity;}
        public void setItem4Quantity(int item4Quantity) {this.item4Quantity = item4Quantity;}
        public void setItem5Quantity(int item5Quantity) {this.item5Quantity = item5Quantity;}
        public void setItem6Quantity(int item6Quantity) {this.item6Quantity = item6Quantity;}
        public void setItem7Quantity(int item7Quantity) {this.item7Quantity = item7Quantity;}
        public void setItem8Quantity(int item8Quantity) {this.item8Quantity = item8Quantity;}
        public void setItem9Quantity(int item9Quantity) {this.item9Quantity = item9Quantity;}
        public void setItem10Quantity(int item10Quantity) {this.item10Quantity = item10Quantity;}


}

