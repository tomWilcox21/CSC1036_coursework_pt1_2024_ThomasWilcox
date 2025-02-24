import java.util.List;
import java.util.Scanner;

public class ReportingIO {
    public List<String> carEntries;

    public static boolean isNumeric(String str) {
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }


    public void inputCarData(){
        Scanner sc = new Scanner(System.in);
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
        System.out.println("Enter the Manufacturer: ");
        String Manufacturer = sc.nextLine();
    }

    public static void welcomeScreen(){
        Scanner sc = new Scanner(System.in);
        ReportingIO r = new ReportingIO();
        System.out.println("Welcome to the Car Reporting System, what would you like to view?");
        System.out.println("1.Enter Manufacturer data\n2.Enter Model data\n3.List all Manufacturers\n4.List all models made by a manufacturer and their details\n5.Provide reporting statistics on: manufacturer with the largest revenue for cars sold of a given type,\nmost expensive car model sold (including all its details), and all car models made with a price\ngreater than a given amount of money (including all their details)\n6.Exit");
        String choice = sc.nextLine();
        if(!r.isNumeric(choice)){
            System.out.println("Please enter a valid number");
            welcomeScreen();
        }else{
            if(choice.equals("2")){
                r.inputCarData();
            }else if(choice.equals("5")){
                Manufacturer manufacturer = new Manufacturer();

            }
        }

    }

    public static void main(String[] args) {
        ReportingIO r = new ReportingIO();
        r.welcomeScreen();


    }
}
