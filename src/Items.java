
public class Items {
    /** Class to store item's ItemCode, itemName, and unit price*/

    //global vars
    private int itemCode;
    private String itemName;
    private double price;

    /**
     * Non-Aug. Constructor
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
     * @param importPrice     Double price with 2 Significant figures
     */
    Items(int importItemCode, String importItemName, double importPrice){
        itemCode = importItemCode;
        itemName = importItemName;
        price = importPrice;
    }

    // get methods
    public int getItemCode() {
        return this.itemCode;
    }

    public String getitemName() {
        return this.itemName;
    }

    public double getPrice() {
        return this.price;
    }

    // set methods
    public void setItemCode(int importItemCode) {
        this.itemCode = importItemCode;
    }

    public void setitemName(String importitemName) {
        this.itemName = importitemName;
    }

    public void setPrice(double importPrice) {
        this.price = importPrice;
    }
}