package commerce;
import java.util.Scanner;

public class Smartphone extends Product {
    private String operatingSystem;
    private int storageCapacityGB;
    private double displaySizeInches;

    public Smartphone( String name, double price, String brand,
                      String description, String warranty,
                      String operatingSystem, int storageCapacityGB, double displaySizeInches,Vendor V) {
        super( name,price, brand, description, warranty,V);
        this.operatingSystem = operatingSystem;
        this.storageCapacityGB = storageCapacityGB;
        this.displaySizeInches = displaySizeInches;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    

    public int getStorageCapacityGB() {
        return storageCapacityGB;
    }

   

    public double getDisplaySizeInches() {
        return displaySizeInches;
    }

    
 // Setter for operatingSystem with vendor verification
    public void setOperatingSystem(String operatingSystem, Vendor modifyingVendor) {
        if (modifyingVendor.equals(this.getVendor())) {
            this.operatingSystem = operatingSystem;
        } else {
            System.out.println("Unauthorized vendor access. Modification denied.");
        }
    }

    // Setter for storageCapacityGB with vendor verification
    public void setStorageCapacityGB(int storageCapacityGB, Vendor modifyingVendor) {
        if (modifyingVendor.equals(this.getVendor())) {
            this.storageCapacityGB = storageCapacityGB;
        } else {
            System.out.println("Unauthorized vendor access. Modification denied.");
        }
    }

    // Setter for displaySizeInches with vendor verification
    public void setDisplaySizeInches(double displaySizeInches, Vendor modifyingVendor) {
        if (modifyingVendor.equals(this.getVendor())) {
            this.displaySizeInches = displaySizeInches;
        } else {
            System.out.println("Unauthorized vendor access. Modification denied.");
        }
        
    }
    public Smartphone() {super();}
    @Override
    public void affiche() {
        super.affiche(); // Inherit the base product details
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Storage Capacity: " + storageCapacityGB + "GB");
        System.out.println("Display Size: " + displaySizeInches + " inches");
    }
    
    public void getProductDetails() {
        super.getProductDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter operating system:");
        this.operatingSystem = scanner.nextLine();

        System.out.println("Enter storage capacity in GB:");
        this.storageCapacityGB = scanner.nextInt();

        System.out.println("Enter display size in inches:");
        this.displaySizeInches = scanner.nextDouble();

        super.getProductDetails();
        
        System.out.println("Smartphone details entered successfully!");
    }

}
