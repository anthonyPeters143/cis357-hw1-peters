# cis357-hw1-peters
A java program to emulate a cash register at grocery store, including an inventory that stores codes, names, and prices. Produces a receipt with list of price, quantity, name of items, subtotal, total with tax, tendered amount, and change. Will allow for more than one sale, expectation handling, and give the day's total sale earnings.


public class CashRegister {
    public static void main(String[] args) {
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
}

//CASHREGISTER CLASS
//stores - double dayTotal = 0, File INVENTORY = "File Directory Path" 
//Item[] importItemArray(FILE FIlENAME), String giveDayTotal(double dayTotal)

//SALE OBJECTS
//stores - double saleSubtotal,tenderAmount,changeTotal,saleTotal = 0.00, taxRate = 0.06,
//    int[] itemAmountArray = {0,0,0,0,0,0,0,0,0,0}
//void addPrice(double price),void subPrice(double price),double getPrice(),void setPrice(double price), void changeItemAmount(int code)

//ITEM OBJECTS
//stores - itemCode,itemName,unitPrice
//int getCode(), string getName(), double getPrice()
