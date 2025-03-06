import java.util.ArrayList;
import java.util.List;

public class Manufacturer {

    private String manufacturerName;
    private  List<CarModel> lst;

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        lst = new ArrayList<>();
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<CarModel> getModels() {
        return lst;
    }

    public void addCarModel(CarModel carModel) {
        lst.add(carModel);
    }

    public CarModel mostExpensive(){
        if(lst.isEmpty()){
            return null;
        }

        CarModel carModel = lst.get(0);
        for(CarModel carModel1 : lst){
            if(carModel1.getSalePrice() > carModel.getSalePrice()){
                carModel = carModel1;
            }
        }
        return carModel;
    }

    public int totalRevenue(String type){
        if(lst.isEmpty()){
            return 0;
        }
        int totalRevenue = 0;

        for(CarModel carModel : lst){
            if(carModel.getType().equalsIgnoreCase(type)){
                totalRevenue += carModel.getSalePrice()*carModel.getNumSold();
            }
        }
        return totalRevenue;
    }

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

    @Override
    public String toString() {
        return "Manufacturer: " + manufacturerName;
    }


}
