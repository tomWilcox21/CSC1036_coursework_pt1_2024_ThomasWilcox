import java.util.ArrayList;
import java.util.List;

/**
 * This Class will allow the user to add and get manufacturers as well as access reports about car models and
 * manufacturers
 * @author Thomas Wilcox
 */

public class Reporting {
    private List<Manufacturer> manufacturers;

    /**
     * This method will get the manufacturers object list and return it
     * @return returns the manufacturers list
     */

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    /**
     * This method will return a specific manufacturer that has been inputted by the user
     * @param name name of the manufacturer that the user is searching for
     * @return returns the corresponding manufacturer object and its linked car models or null if it does not exist
     */

    public Manufacturer getManufacturerByName(String name) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getManufacturerName().equalsIgnoreCase(name)) {
                return manufacturer;
            }
        }
        return null;
    }

    /**
     * Adds a manufacturer object to the manufacturers object list
     * @param manufacturer this is the manufacturer that the user wants to add
     */

    public void addManufacturer(Manufacturer manufacturer){
        manufacturers.add(manufacturer);
    }

    /**
     * Public method that allows other classes to access the manufacturers object list
     */

    public Reporting() {
        manufacturers = new ArrayList<Manufacturer>();
    }

    /**
     * Will search through all of the manufacturers and their linked car models to find the car model that is most expensive
     * @return will return the most expensive car model or null if there are no manufacturers found
     */

    public CarModel mostExpensiveSold(){
        if(manufacturers.isEmpty()){
            return null;
        }

        CarModel carModel = manufacturers.get(0).getModels().get(0);

        for(Manufacturer manufacturer : manufacturers){
            List<CarModel> carModels = manufacturer.getModels();
            for(CarModel carModel1 : carModels){
                if(carModel1.getNumSold()>0 && carModel1.getSalePrice() > carModel.getSalePrice()){
                    carModel = carModel1;
                }
            }
        }

        return carModel;
    }

    /**
     * Method will return the manufacturer that has the largest revenue of a given type of car model
     * @param type the type of car that the user wants to know
     * @return returns a manufacturer or a null if none are found
     */

    public Manufacturer largestTypeRevenue(String type){
        if(manufacturers.isEmpty()){
            return null;
        }
        Manufacturer manufacturer = manufacturers.get(0);
        for(Manufacturer manufacturer1 : manufacturers){
                if(manufacturer1.totalRevenue(type) > manufacturer.totalRevenue(type)){
                    manufacturer = manufacturer1;
            }
        }
        return manufacturer;
    }

    /**
     * Will return a list of car models that are above a threshold price
     * @param price this is the minimum threshold price that has been set by the user
     * @return will return the list of car models or null if no manufacturers are found
     */

    public List<CarModel> abovePrice(int price){
        if(manufacturers.isEmpty()){
            return null;
        }
        List<CarModel> carModels = new ArrayList<>();
        for(Manufacturer manufacturer : manufacturers){
            carModels.addAll(manufacturer.carAbovePrice(price));
        }
        return carModels;
    }
}
