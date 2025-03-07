/**
 * This class handles the car model objects that are created and allows details about them to be accessed
 * @author Thomas Wilcox
 */

public class CarModel {

    private String modelName;
    private int weight;
    private int salePrice;
    private int numSold;
    private String type;

    /**
     * This method creates an object for each car model added by the user, allows for data about the model to be stored
     * @param modelName name of the model inputted by the user
     * @param weight weight of the model inputted by the user
     * @param salePrice sale price of the model inputted by the user
     * @param numSold number of models sold inputted by the user
     * @param type type of car inputted by the user
     */

    public CarModel(String modelName, int weight, int salePrice, int numSold, String type) {
        this.modelName = modelName;
        this.weight = weight;
        this.salePrice = salePrice;
        this.numSold = numSold;
        this.type = type;
    }

    /**
     * Gets the sale price of a car model
     * @return returns the sale price
     */

    public int getSalePrice() {
        return salePrice;
    }

    /**
     * Gets the number of units sold
     * @return returns the number of units sold
     */

    public int getNumSold() {
        return numSold;
    }

    /**
     * Gets the type of car
     * @return returns the type
     */

    public String getType() {
        return type;
    }

    /**
     * Will return the car model object and all of its data as text and not a memory address
     * @return returns a car model object
     */

    @Override
    public String toString() {
        return "\nCarModel:" +
                "\nModelName: " + modelName +
                "\nWeight: " + weight +
                "\nSalePrice: " + salePrice +
                "\nNumSold: " + numSold +
                "\nBodyType: " + type + "\n";
    }

    /**
     * Main method added for testing
     * @param args
     */

    public static void main(String[] args) {
        CarModel carModel = new CarModel("Car Model", 10, 10, 10, "Car");
        System.out.println(carModel.getType());
        System.out.println(carModel.getSalePrice());
        System.out.println(carModel.getNumSold());

    }
}





