import java.util.ArrayList;
import java.util.List;

public class Reporting {

    private List<Manufacturer> manufacturers;

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    public Reporting() {
        manufacturers = new ArrayList<Manufacturer>();
    }

    public CarModel mostExpensiveSold(){
        if(manufacturers.isEmpty()){
            return null;
        }

        CarModel carModel = manufacturers.get(0).getLst().get(0);

        for(Manufacturer manufacturer : manufacturers){
            List<CarModel> carModels = manufacturer.getLst();
            for(CarModel carModel1 : carModels){
                if(carModel1.getNumSold()>0 && carModel1.getSalePrice() > carModel.getSalePrice()){
                    carModel = carModel1;
                }
            }
        }

        return carModel;
    }
}
