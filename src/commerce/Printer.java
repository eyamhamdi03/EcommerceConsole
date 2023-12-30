package commerce; 
import java.util.Scanner;
public class Printer extends Product {
    private String printerType; // Laser, Inkjet, etc.
    private String printTechnology; // Printing technology details
    public Printer() {super();}
    public Printer( String name, double price, String brand,
                   String description, String warranty,
                   String printerType, String printTechnology, Vendor V) {
        super(name, price, brand, description, warranty, V);
        this.printerType = printerType;
        this.printTechnology = printTechnology;
    }

    // Getters and Setters specific to Printer class
    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.printerType = printerType;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    public String getPrintTechnology() {
        return printTechnology;
    }

    public void setPrintTechnology(String printTechnology, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.printTechnology = printTechnology;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }
    @Override
    public void affiche() {
        super.affiche(); // Inherit the base product details
        System.out.println("Printer Type: " + printerType);
        System.out.println("Print Technology: " + printTechnology);
    }
    public void getProductDetails() {
        super.getProductDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter printer type:");
        this.printerType = scanner.nextLine();

        System.out.println("Enter print technology:");
        this.printTechnology = scanner.nextLine();

        
        System.out.println("Printer details entered successfully!");
    }

}


