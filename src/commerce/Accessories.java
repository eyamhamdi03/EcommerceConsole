package commerce;
import java.util.Scanner;

public class Accessories extends Product {
    private String accessoryType; 
    private String compatibility; 

    public Accessories() {super();}
    // Constructor for Accessories class
    public Accessories( String name, double price, String brand,
                        String description, String warranty,
                        String accessoryType, String compatibility,Vendor V) {
        super(name, price, brand, description, warranty,V);
        this.accessoryType = accessoryType;
        this.compatibility = compatibility;
    }

    public String getAccessoryType() {
        return accessoryType;
    }

      public String getCompatibility() {
        return compatibility;
    }

      public void setAccessoryType(String accessoryType, Vendor vendor) {
          if (isVendorAuthorized(vendor)) {
              this.accessoryType = accessoryType;
          } else {
              System.out.println("Unauthorized vendor for this product!");
          }
      }

      // Setter for Compatibility with vendor verification
      public void setCompatibility(String compatibility, Vendor vendor) {
          if (isVendorAuthorized(vendor)) {
              this.compatibility = compatibility;
          } else {
              System.out.println("Unauthorized vendor for this product!");
          }
      }
      @Override
      public void affiche() {
          super.affiche(); // Inherit the base product details
          System.out.println("Accessory Type: " + accessoryType);
          System.out.println("Compatibility: " + compatibility);
      }
      public void getProductDetails() {
    	  super.getProductDetails();
    	  Scanner scanner = new Scanner(System.in);

          System.out.println("Enter accessory type:");
          this.accessoryType = scanner.nextLine();

          System.out.println("Enter compatibility:");
          this.compatibility = scanner.nextLine();

          super.getProductDetails(); // Appel de la méthode parent pour les détails supplémentaires
          
          System.out.println("Accessories details entered successfully!");
      }
}
