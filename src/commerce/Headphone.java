package commerce ;
import java.util.Scanner ;
public class Headphone extends Product {
    private String type;
    private String connectivity;
    public Headphone() {super();}
    public Headphone( String name, double price, String brand,
                     String description, String warranty,
                     String type, String connectivity, Vendor V) {
        super(name, price, brand, description, warranty, V);
        this.type = type;
        this.connectivity = connectivity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.type = type;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.connectivity = connectivity;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }
    @Override
    public void affiche() {
        super.affiche(); // Inherit the base product details
        System.out.println("Type: " + type);
        System.out.println("Connectivity: " + connectivity);}
    public void getProductDetails() {
        super.getProductDetails();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter headphone type:");
        this.type = scanner.nextLine();

        System.out.println("Enter connectivity:");
        this.connectivity = scanner.nextLine();

        super.getProductDetails();
        
        System.out.println("Headphone details entered successfully!");
    }

}

