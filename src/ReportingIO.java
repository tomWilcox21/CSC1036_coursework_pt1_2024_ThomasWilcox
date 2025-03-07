import java.util.List;
import java.util.Scanner;

/**
 * This Class allows the user to interface with the other classes,
 * they are able to add both manufacturers and car models as well as view data and reports about them
 * @author Thomas Wilcox
 */

public class ReportingIO {
    private static Reporting reporting = new Reporting(); // Changed to static

    /**
     * This method will check if what has been inputted by the user is a numerical value or not
     * @param str Text inputted by user
     * @return Returns True if the string is numerical or false if not
     */

    public static boolean isNumeric(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * This method allows the user to add a manufacturer to the manufacturer object
     */

    public void inputManufacturerData(){
        List<Manufacturer> manufacturers = reporting.getManufacturers();
        System.out.println("Manufacturer Name: ");
        String manufacturerName = new Scanner(System.in).nextLine();
        manufacturerName = manufacturerName.toLowerCase();
        Manufacturer manufacturer = new Manufacturer(manufacturerName);
        for(Manufacturer m : manufacturers){
            if(m.getManufacturerName().equals(manufacturerName)){
                System.out.println("Manufacturer already exists");
                inputManufacturerData();
            }
        }
        reporting.addManufacturer(manufacturer);
        System.out.println("Manufacturer added!");
        welcomeScreen();
    }

    /**
     * This allows the user to add a car model, they are able to input a manufacturer that it links to and then
     * add data such as the weight and price, this will then create a carModel object that will be added to the
     * manufacturer object that the model links to
     */


    public void inputCarData(){
        List<Manufacturer> manufacturers = reporting.getManufacturers();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter manufacturer name: ");
        String manufacturerName = sc.nextLine();
        Manufacturer manufacturer = reporting.getManufacturerByName(manufacturerName);
        if(manufacturer == null){
            System.out.println("Manufacturer does not exist");
            inputManufacturerData();
        }
        System.out.println("Enter the model name: ");
        String modelName = sc.nextLine();
        System.out.println("Enter the weight: ");
        int weight = sc.nextInt();
        System.out.println("Enter the sale price: ");
        int salePrice = sc.nextInt();
        System.out.println("Enter the number sold: ");
        int numSold = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the type of car: ");
        String typ = sc.nextLine();
        CarModel c = new CarModel(modelName, weight, salePrice, numSold, typ);
        manufacturer.addCarModel(c);
        System.out.println("Car model added!");
        System.out.println("Press any key to continue.");
        sc.nextLine();
        welcomeScreen();
    }

    /**
     * This method will list all the manufacturers that have been added to the manufacturers object list
     */

    public void listManufacturers(){
        List<Manufacturer> manufacturers = reporting.getManufacturers();
        Scanner sc = new Scanner(System.in);
        if(manufacturers.isEmpty()){
            System.out.println("No manufacturers found!");
        }else{
            for(Manufacturer manufacturer : manufacturers){
                System.out.println(manufacturer);
            }
        }
        System.out.println("Press any key to continue.");
        sc.nextLine();
        welcomeScreen();
    }

    /**
     * This method allows the user to input a manufacturer that has been added to the manufacturers object list,
     * this will then retrieve all the car models tied to the manufacturer and then display the data tied to the models
     */

    public void listModelsFromManufacturer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Manufacturer Name: ");
        String manufacturerName = sc.nextLine();
        manufacturerName = manufacturerName.toLowerCase();
        Manufacturer manufacturer = reporting.getManufacturerByName(manufacturerName);
        if(manufacturer == null){
            System.out.println("Manufacturer does not exist");

        }
        List<CarModel> models = manufacturer.getModels();
        if(models.isEmpty()){
            System.out.println("No models found");
            System.out.println("Press any key to continue.");
            sc.nextLine();
            welcomeScreen();
        }else{
            for(CarModel model : models){
                System.out.println(model);
            }
        }
        System.out.println("Press any key to continue.");
        sc.nextLine();
        welcomeScreen();
    }

    /**
     * This method allows the user to view different reports of statistics about car models and manufacturers,
     * they are able to view the Manufcaturer with the largest revenue of cars sold of a given type,
     * the most expensive car model and all of the car models above a certain price
     *
     */

    public void reportingStatistics(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like a report on?");
        System.out.println("1.Manufacturer with largest revenue for cars sold of a given type\n2.Most expensive car model sold\n3.All car models made with a price greater than a specified amount");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter type");
                String type = sc.nextLine();
                type = type.toLowerCase();
                System.out.println(reporting.largestTypeRevenue(type));
                System.out.println("Press any key to continue.");
                //sc.nextLine();
                welcomeScreen();
                break;
            case 2:
                System.out.println(reporting.mostExpensiveSold());
                System.out.println("Press any key to continue.");
                sc.nextLine();
                welcomeScreen();
                break;
            case 3:
                System.out.println("Enter threshold price");
                int thresholdPrice = sc.nextInt();
                System.out.println(reporting.abovePrice(thresholdPrice));
                System.out.println("Press any key to continue.");
                welcomeScreen();
        }
    }

    /**
     * This method allows the user to choose what they would like view or add out of the previous methods stated
     */

    public static void welcomeScreen(){
        Scanner sc = new Scanner(System.in);
        ReportingIO r = new ReportingIO();
        System.out.println("Welcome to the Car Reporting System, what would you like to view?");
        System.out.println("1.Enter Manufacturer data\n2.Enter Model data\n3.List all Manufacturers\n4.List all models made by a manufacturer and their details\n5.Provide reporting statistics on: manufacturer with the largest revenue for cars sold of a given type,\nmost expensive car model sold (including all its details), and all car models made with a price\ngreater than a given amount of money (including all their details)\n6.Exit");
        String choice = sc.nextLine();
        if(!r.isNumeric(choice) || Integer.parseInt(choice) > 6){
            System.out.println("Please enter a valid number");
            welcomeScreen();
        }else{
            switch (choice) {
                case "1":
                    r.inputManufacturerData();
                    break;
                case "2":
                    r.inputCarData();
                    break;
                case "3":
                    r.listManufacturers();
                    break;
                case "4":
                    r.listModelsFromManufacturer();
                    break;
                case "5":
                    r.reportingStatistics();
                    break;
                case "6":
                    System.exit(0);
                    break;
            }
        }

    }

    /**
     * Main method which the program starts through
     * @param args
     */

    public static void main(String[] args) {
        ReportingIO r = new ReportingIO();
        r.welcomeScreen();
    }
}
