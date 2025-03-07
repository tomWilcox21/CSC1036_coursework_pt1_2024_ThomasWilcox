import java.util.ArrayList;
import java.util.List;

/**
 * This class handles all of the manufacturer objects and the car models that are linked to each one
 * @author Thomas Wilcox
 */

public class Manufacturer {

    private String manufacturerName;
    private  List<CarModel> lst;

    /**
     * This creates a list of car models for each manufacturer
     * @param manufacturerName name of the manufacturer that the user has entered
     */

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        lst = new ArrayList<>();
    }

    /**
     * Gets the name of a manufacturer and returns it
     * @return
     */

    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Retrieves all of the models linked to the manufacturer
     * @return returns a list of all of the car models
     */

    public List<CarModel> getModels() {
        return lst;
    }

    /**
     * Will add a car model to the list of car models corresponding to a certain manufacturer
     * @param carModel car model object to be added to the list
     */

    public void addCarModel(CarModel carModel) {
        lst.add(carModel);
    }

    /**
     * Will calculate the total revenue of a given type of car that the manufacturer produces and the return it
     * @param type the type of car that has been inputted by the user
     * @return returns the total revenue or null if no car models are found
     */

    public int totalRevenue(String type){
        if(lst.isEmpty()){
            return 0;
        }
        int totalRevenue = 0;

        for(CarModel carModel : lst){
            if(carModel.getType().equalsIgnoreCase(type)){
                totalRevenue += (carModel.getSalePrice()*carModel.getNumSold());
            }
        }
        return totalRevenue;
    }

    /**
     * Will return a list of cars produced by a given manufacturer that are above a threshold price
     * @param setPrice minimum threshold price set by user
     * @return returns a list of cars or null if none are found
     */

    public List<CarModel> carAbovePrice(int setPrice){
        if(lst.isEmpty()){
            return null;
        }
        List<CarModel> carModels = new ArrayList<>();
        for(CarModel carModel : lst){
            if(carModel.getSalePrice() > setPrice){
                carModels.add(carModel);
            }
        }
        return carModels;
    }

    /**
     * Method will return the manufacturer name and not its memory address
     * @return returns manufacturer name
     */

    @Override
    public String toString() {
        return "Manufacturer: " + manufacturerName;
    }

    /**
     * Main method added for testing
     * @param args
     */

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer("Test1");
        manufacturer.addCarModel(new CarModel("Test1", 500, 25000, 50000, "saloon"));
        manufacturer.addCarModel(new CarModel("Test2", 1000, 40000, 10000, "saloon"));
        System.out.println(manufacturer.totalRevenue("saloon"));
        System.out.println(manufacturer.carAbovePrice(25000));
        System.out.println(manufacturer.getModels());
    }
}
