
public class Items {
    /** Class to store item's code, name, and unit price*/

    //global vars
    private int code;
    private String name;
    private double price;

    /**
     * Non-Aug. Constructor
     */
    Items(){
        code = -1;
        name = "needName";
        price = 0.00;
    }

    /**
     * Aug. Constructor
     *
     * @param importCode      Interger [1-10]
     * @param importName      String title of item
     * @param importPrice     Double price with 2 Significant figures
     */
    Items(int importCode, String importName, double importPrice){
        code = importCode;
        name = importName;
        price = importPrice;
    }

    // get methods
    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    // set methods
    public void setCode(int importCode) {
        this.code = importCode;
    }

    public void setName(String importName) {
        this.name = importName;
    }

    public void setPrice(double importPrice) {
        this.price = importPrice;
    }
}