package commerce;
import java.util.Scanner;




public class Camera extends Product {
    private String resolution; 
    private String sensorType; 
    private String lensType;
    public Camera() {super();}

    public Camera( String name, double price, String brand,
                  String description, String warranty,
                  String resolution, String sensorType, String lensType,Vendor V) {
        super(name, price, brand, description, warranty,V);
        this.resolution = resolution;
        this.sensorType = sensorType;
        this.lensType = lensType;
    }

    public String getResolution() {
        return resolution;
    }

   

    public String getSensorType() {
        return sensorType;
    }

       public String getLensType() {
        return lensType;
    }


       // Setter for Resolution with vendor verification
       public void setResolution(String resolution, Vendor vendor) {
           if (isVendorAuthorized(vendor)) {
               this.resolution = resolution;
           } else {
               System.out.println("Unauthorized vendor for this product!");
           }
       }

       // Setter for Sensor Type with vendor verification
       public void setSensorType(String sensorType, Vendor vendor) {
           if (isVendorAuthorized(vendor)) {
               this.sensorType = sensorType;
           } else {
               System.out.println("Unauthorized vendor for this product!");
           }
       }

       // Setter for Lens Type with vendor verification
       public void setLensType(String lensType, Vendor vendor) {
           if (isVendorAuthorized(vendor)) {
               this.lensType = lensType;
           } else {
               System.out.println("Unauthorized vendor for this product!");
           }
       }
       @Override
       public void affiche() {
           super.affiche(); // Inherit the base product details
           System.out.println("Resolution: " + resolution);
           System.out.println("Sensor Type: " + sensorType);
           System.out.println("Lens Type: " + lensType);
       }

       public void getProductDetails() {
    	    super.getProductDetails();
    	    Scanner scanner = new Scanner(System.in);

    	    System.out.println("Enter resolution:");
    	    this.resolution = scanner.nextLine();

    	    System.out.println("Enter sensor type:");
    	    this.sensorType = scanner.nextLine();

    	    System.out.println("Enter lens type:");
    	    this.lensType = scanner.nextLine();

    	    super.getProductDetails();
    	    
    	    System.out.println("Camera details entered successfully!");
    	}


}
