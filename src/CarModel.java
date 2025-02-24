import java.util.ArrayList;
import java.util.List;

public class CarModel {

    private String modelName;
    private int weight;
    private int salePrice;
    private int numSold;
    private String type;

    public CarModel(String modelName, int weight, int salePrice, int numSold, String type) {
        this.modelName = modelName;
        this.weight = weight;
        this.salePrice = salePrice;
        this.numSold = numSold;
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getNumSold() {
        return numSold;
    }

    public void setNumSold(int numSold) {
        this.numSold = numSold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\nCarModel:" +
                "\nModelName: " + modelName +
                "\nWeight: " + weight +
                "\nSalePrice: " + salePrice +
                "\nNumSold: " + numSold +
                "\nBodyType: " + type + "\n";
    }
}

//    public void log(String car, List<String> entries) {
//        entries.add(car);
//        System.out.println();
//        //return "Entry logged";
//    }




