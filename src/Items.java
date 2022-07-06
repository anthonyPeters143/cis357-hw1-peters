// Homework 1: Sales Register Program
// Course: CIS357
// Due date: 4-4-22
// Name: Anthony Peters
// GitHub: https://github.com/anthonyPeters143/cis357-hw1-peters
// Instructor: Il-Hyung Cho
// Program description: Items class stores item's code, name, and price and allows CashRegister to access and interact
// with item fields.

/**
 * @author Anthony Peters
 *
 * Class to store item's ItemCode, itemName, and unit price and allow Item's fields to be access through get and set
 * methods in CashRegister class
 */

public class Items {

    //global vars
    private int itemCode;
    private String itemName;
    private double price;

    /**
     * Non-Aug. Constructor
     *
     * Sets fields to placeholder values meant to be overriden
     */
    Items(){
        itemCode = -1;
        itemName = "needItemName";
        price = 0.00;
    }

    /**
     * Aug. Constructor
     *
     * @param importItemCode      Interger [1-10]
     * @param importitemName      String title of item
     * @param importPrice         Double price with 2 Significant figures
     */
    Items(int importItemCode, String importItemName, double importPrice){
        itemCode = importItemCode;
        itemName = importItemName;
        price = importPrice;
    }

    /**
     * Returns item code
     *
     * @return int, itemCode
     */
    public int getItemCode() {
        return this.itemCode;
    }

    /**
     * Returns item name
     *
     * @return String, itemName
     */
    public String getitemName() {
        return this.itemName;
    }

    /**
     * Returns item price
     *
     * @return double, itemPrice
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Sets item code
     *
     * @param int, itemCode
     */
    public void setItemCode(int importItemCode) {
        this.itemCode = importItemCode;
    }

    /**
     * Sets item name
     *
     * @param String, itemName
     */
    public void setitemName(String importitemName) {
        this.itemName = importitemName;
    }

    /**
     * Sets item price
     *
     * @param double, itemPrice
     */
    public void setPrice(double importPrice) {
        this.price = importPrice;
    }
}