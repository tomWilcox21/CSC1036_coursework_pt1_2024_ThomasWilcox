import java.util.ArrayList;
import java.util.List;

public class Reporting {

    private List<Manufacturer> manufacturers;

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public Manufacturer getManufacturerByName(String name) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getManufacturerName().equalsIgnoreCase(name)) {
                return manufacturer;
            }
        }
        return null;
    }

    public void addManufacturer(Manufacturer manufacturer){
        manufacturers.add(manufacturer);
    }

    public Reporting() {
        manufacturers = new ArrayList<Manufacturer>();
    }

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
