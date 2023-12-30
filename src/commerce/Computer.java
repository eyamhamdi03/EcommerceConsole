package commerce;
import java.util.Scanner;

public class Computer extends Product {
    private String processor;
    private int ramSizeGB;
    private int storageSizeGB;
    public Computer() {super();}
    // Constructor for Computer class
    public Computer( String name, double price, String brand,
                    String description, String warranty,
                    String processor, int ramSizeGB, int storageSizeGB,Vendor V) {
        super(name, price, brand, description, warranty,V);
        this.processor = processor;
        this.ramSizeGB = ramSizeGB;
        this.storageSizeGB = storageSizeGB;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRamSizeGB() {
        return ramSizeGB;
    }

   

    public int getStorageSizeGB() {
        return storageSizeGB;
    }


    // Setter for Processor with vendor verification
    public void setProcessor(String processor, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.processor = processor;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for RAM Size with vendor verification
    public void setRamSizeGB(int ramSizeGB, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.ramSizeGB = ramSizeGB;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Storage Size with vendor verification
    public void setStorageSizeGB(int storageSizeGB, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.storageSizeGB = storageSizeGB;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }
    @Override
    public void affiche() {
        super.affiche(); // Inherit the base product details
        System.out.println("Processor: " + processor);
        System.out.println("RAM Size: " + ramSizeGB + "GB");
        System.out.println("Storage Size: " + storageSizeGB + "GB");}
    public void getProductDetails() {
        super.getProductDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter processor:");
        this.processor = scanner.nextLine();

        System.out.println("Enter RAM size in GB:");
        this.ramSizeGB = scanner.nextInt();

        System.out.println("Enter storage size in GB:");
        this.storageSizeGB = scanner.nextInt();

        super.getProductDetails();
        
        System.out.println("Computer details entered successfully!");
    }

}
