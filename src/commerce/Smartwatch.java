package commerce;
import java.util.Scanner;

public class Smartwatch extends Product {
    private String displayType; // Type of display (e.g., OLED, LCD, etc.)
    private String connectivity; // Connectivity options (e.g., Bluetooth, Wi-Fi, etc.)
    private boolean fitnessTracker; // Indicates if it has fitness tracking features
    public Smartwatch() {super();}
    public Smartwatch(String name, double price, String brand,
                      String description, String warranty,
                      String displayType, String connectivity, boolean fitnessTracker,Vendor V) {
        super(name, price, brand, description, warranty,V);
        this.displayType = displayType;
        this.connectivity = connectivity;
        this.fitnessTracker = fitnessTracker;
    }

    public String getDisplayType() {
        return displayType;
    }

    
    public String getConnectivity() {
        return connectivity;
    }

    

    public boolean isFitnessTracker() {
        return fitnessTracker;
    }

    public void setDisplayType(String displayType, Vendor vendor) {
        if (vendor.equals(this.getVendor())) {
            this.displayType = displayType;
        } else {
            System.out.println("You are not authorized to modify this attribute.");
        }
    }

    // Setter for connectivity with vendor verification
    public void setConnectivity(String connectivity, Vendor vendor) {
        if (vendor.equals(this.getVendor())) {
            this.connectivity = connectivity;
        } else {
            System.out.println("You are not authorized to modify this attribute.");
        }
    }

    // Setter for fitnessTracker with vendor verification
    public void setFitnessTracker(boolean fitnessTracker, Vendor vendor) {
        if (vendor.equals(this.getVendor())) {
            this.fitnessTracker = fitnessTracker;
        } else {
            System.out.println("You are not authorized to modify this attribute.");
        }
    }
    @Override
    public void affiche() {
        super.affiche(); // Inherit the base product details
        System.out.println("Display Type: " + displayType);
        System.out.println("Connectivity: " + connectivity);
        System.out.println("Fitness Tracker: " + (fitnessTracker ? "Yes" : "No"));}
    public void getProductDetails() {
        super.getProductDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter display type:");
        this.displayType = scanner.nextLine();

        System.out.println("Enter connectivity:");
        this.connectivity = scanner.nextLine();

        System.out.println("Does it have fitness tracking? (true/false):");
        this.fitnessTracker = scanner.nextBoolean();

        super.getProductDetails();
        
        System.out.println("Smartwatch details entered successfully!");
    }

}
