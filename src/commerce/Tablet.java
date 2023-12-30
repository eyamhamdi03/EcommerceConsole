package commerce;
import java.util.Scanner;
public class Tablet extends Product {
    private String operatingSystem;
    private double screenSizeInches;
    private String connectivity; 
    public Tablet() {super();}
    public Tablet( String name, double price, String brand,
                  String description, String warranty,
                  String operatingSystem, double screenSizeInches, String connectivity,Vendor V) {
        super(name, price, brand, description, warranty,V);
        this.operatingSystem = operatingSystem;
        this.screenSizeInches = screenSizeInches;
        this.connectivity = connectivity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

 // Setter for Operating System with vendor verification
    public void setOperatingSystem(String operatingSystem, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.operatingSystem = operatingSystem;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Screen Size Inches with vendor verification
    public void setScreenSizeInches(double screenSizeInches, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.screenSizeInches = screenSizeInches;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Connectivity with vendor verification
    public void setConnectivity(String connectivity, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.connectivity = connectivity;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }
    
    


    public double getScreenSizeInches() {
        return screenSizeInches;
    }

    

    public String getConnectivity() {
        return connectivity;
    }

    @Override
    public void affiche() {
        super.affiche(); // Inherit the base product details
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Screen Size: " + screenSizeInches + " inches");
        System.out.println("Connectivity: " + connectivity);}
    

    public void getProductDetails() {
        super.getProductDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter operating system:");
        this.operatingSystem = scanner.nextLine();

        System.out.println("Enter screen size (in inches):");
        this.screenSizeInches = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline left by nextDouble()

        System.out.println("Enter connectivity:");
        this.connectivity = scanner.nextLine();

        super.getProductDetails();
        
        System.out.println("Tablet details entered successfully!");
    }

}
