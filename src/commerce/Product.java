package commerce;
import java.util.Scanner;

public abstract class Product {
	static int lastAssignedId = 0;
    private String name;
    private int id;
    private double price;
    private String brand ;
    private String description;
    private String warranty;
    private Vendor vendor ; 

    public Product() 
    {
    	name="";
    	
    }
    public String getCategory() {
        return this.getClass().getSimpleName();
    }
    public Product( String name, double price,String brand,String d , String w,Vendor V) {
        this.id = ++lastAssignedId;

        this.name = name;
        this.price = price;
        this.brand=brand;
        this.description=d;
        this.warranty=w;
        this.vendor=V;
    }
    public String getDescription() {
        return description;
    }
    public Vendor getVendor() {return(vendor);}
    
 // Setter for Brand with vendor verification
    public void setBrand(String brand, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.brand = brand;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Name with vendor verification
    public void setName(String name, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.name = name;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Price with vendor verification
    public void setPrice(double price, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.price = price;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Description with vendor verification
    public void setDescription(String description, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.description = description;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Setter for Warranty with vendor verification
    public void setWarranty(String warranty, Vendor vendor) {
        if (isVendorAuthorized(vendor)) {
            this.warranty = warranty;
        } else {
            System.out.println("Unauthorized vendor for this product!");
        }
    }

    // Getter and Setter for Warranty
    public String getWarranty() {
        return warranty;
    }

    

    public String getName() {
        return name;
    }

    public String getBrand() {return(brand);}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }
    protected boolean isVendorAuthorized(Vendor vendor) {
        return this.vendor.equals(vendor);
    }

 
    	public void affiche() {
            System.out.println("Product ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Brand: " + brand);
            System.out.println("Price: " + price);
            System.out.println("Description: " + description);
            System.out.println("Warranty: " + warranty);
            if (vendor != null) {
                System.out.println("Vendor: " + vendor.getFullName());
            }

    }
    	
    	public void getProductDetails() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter product name:");
            this.name = scanner.nextLine();

            System.out.println("Enter product price:");
            this.price = scanner.nextDouble();
            scanner.nextLine(); // Pour consommer la nouvelle ligne restante

            System.out.println("Enter product brand:");
            this.brand = scanner.nextLine();

            System.out.println("Enter product description:");
            this.description = scanner.nextLine();

            System.out.println("Enter product warranty:");
            this.warranty = scanner.nextLine();
                   }
    	 
    
}

