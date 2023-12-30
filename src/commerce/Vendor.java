package commerce;
import java.util.List;
import java.util.Scanner;

public class Vendor extends User {
	private String address;
	int id ;
	Inventory I ;
    

    public Vendor(int id, String fullName, String email, String password, String address, int phoneNumber,Inventory I) {
        super(fullName, email, password,phoneNumber);
        this.address = address;
        this.I=I;
        this.id = id;
       

    }
   
   
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vendor)) {
            return false;
        }
        Vendor otherCustomer = (Vendor) obj;
        return this.getId() == otherCustomer.getId();
    }
    public void afficher() {
    	System.out.println("ID: " + id);
        super.afficher(); 
        System.out.println("Address: " + address);
        
    }
    
    public void addQuantity(Inventory I) {
        String Category=chosenCategory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of your product to add quantity");
        String name=scanner.nextLine();
        Product existingProduct=I.searchProductByCategoryAndName(Category, name);
        if ((existingProduct == null)) {
            System.out.println("Product not existing in the inventory. Do you want to add a new one? (Y/N)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                addProductToInventory(I);
            } else {
                System.out.println("Quantity not added to inventory.");
            }}
        else 
        {
            System.out.println("Please enter the quantity to add:");

        }
     
        
        
    }

    public void modifyProductQuantity(Inventory I) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the category of the product:");
        String category = scanner.nextLine();

        System.out.println("Enter the name of the product:");
        String productName = scanner.nextLine();

        Product productToModify = I.searchProductByCategoryAndName(category, productName);

        if (productToModify != null) {
            System.out.println("Product found:");
            productToModify.affiche();

            System.out.println("Enter the new quantity:");
            int newQuantity = scanner.nextInt();
            I.addStock(category, productToModify, this, newQuantity);
           
            System.out.println("Quantity for " + productName + " in category " + category + " updated to " + newQuantity);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }
    
    public void addProductToInventory(Product newProduct) {
      	Scanner scanner = new Scanner(System.in);
           Product existingProduct = I.searchProductByCategoryAndName(newProduct.getClass().getSimpleName(), newProduct.getName());
           if ((existingProduct != null)&&(existingProduct.getVendor()==this)) {
               System.out.println("Product already exists in inventory. Do you want to add the quantity? (Y/N)");
               String choice = scanner.nextLine();
               if (choice.equalsIgnoreCase("Y")) {
                   I.addStock(newProduct.getClass().getSimpleName(), existingProduct, newProduct.getVendor(), 1);
                   System.out.println("Quantity added to the existing product.");
               } else {
                   System.out.println("Product not added to inventory.");
               }
           } else {
               I.addProductToInventory(newProduct.getClass().getSimpleName(), newProduct, 1);
               System.out.println("Product added to inventory.");
           }

            
       }


            public void addProductToInventory(Inventory I) {
       	 Scanner scanner = new Scanner(System.in);

           
        	Product newProduct =chooseCategory();
            // Obtenir les détails du produit
            if (newProduct != null) {
                newProduct.getProductDetails();
            } else {
                System.out.println("Product details cannot be obtained.");
                 
                return;
            }

            // Vérifier si le produit existe déjà dans l'inventaire
            // Si oui, demander à l'utilisateur s'il veut ajouter la quantité
            Product existingProduct = I.searchProductByCategoryAndName(newProduct.getClass().getSimpleName(), newProduct.getName());
            if ((existingProduct != null)&&(existingProduct.getVendor()==this)) {
                System.out.println("Product already exists in inventory. Do you want to add the quantity? (Y/N)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    I.addStock(newProduct.getClass().getSimpleName(), existingProduct, newProduct.getVendor(), 1);
                    System.out.println("Quantity added to the existing product.");
                } else {
                    System.out.println("Product not added to inventory.");
                }
            } else {
                I.addProductToInventory(newProduct.getClass().getSimpleName(), newProduct, 1);
                System.out.println("Product added to inventory.");
            }

             
        }
        public void modifyProductInventory(Inventory I) {
            Product newProduct = chooseCategory();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the name of the product to search:");
            String productName = scanner.nextLine();

            Product existingProduct = I.searchProductByCategoryAndName(newProduct.getClass().getSimpleName(), productName);

            if (existingProduct == null) {
                System.out.println("Product not found. Do you want to add a new product? (Y/N)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    addProductToInventory(I);
                } else {
                    System.out.println("Product does not exist. Quitting modification.");
                }
            } else {
                System.out.println("Modified details for product:");
                System.out.println("Old Product Details:");
                existingProduct.getProductDetails(); // Afficher les détails existants

                System.out.println("Enter modified details for the product:");
                System.out.println("\nPlease note that unchanged characteristics must be re-entered.");
                newProduct.getProductDetails();

                I.replaceProductById(existingProduct.getId(), newProduct); // Remplacer le produit existant par le nouveau produit
                System.out.println("Product modified successfully!");
            }

             
        }
    
        public void deleteProductFromInventory(Inventory inventory) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the product you want to delete:");
            int productId = scanner.nextInt();

            Product productToDelete = inventory.searchProductById(productId);
            if (productToDelete != null) {
                inventory.deleteProduct(productToDelete, this);
            } else {
                System.out.println("Product not found in inventory with ID: " + productId);
            }
        }
        public void Search() {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Would you like to search by name or by filters? (name/filters)");
            String searchChoice = scanner.nextLine();
            List<Product>result = null;
            if (searchChoice.equalsIgnoreCase("name")) {
                System.out.println("Please enter the name of the product: ");
                String productName = scanner.nextLine();
                result=I.searchProductsByName(productName);
                
            } else if (searchChoice.equalsIgnoreCase("filters")) {
                System.out.println("Choose a filter (price/brand/warranty/category): ");
                String filterChoice = scanner.nextLine();

                if (filterChoice.equalsIgnoreCase("price")) {
                    System.out.println("Please enter the price range (min max): ");
                    double minPrice = scanner.nextDouble();
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine(); 

                    result=I.searchByPriceRange(minPrice, maxPrice);
                } else if (filterChoice.equalsIgnoreCase("brand")) {
                    System.out.println("Please enter the brand name: ");
                    String brandName = scanner.nextLine();

                    result= I.searchByBrand(brandName);                    // Display the products found
                } else if (filterChoice.equalsIgnoreCase("warranty")) {
                    System.out.println("Please enter the warranty format (eg. 2 years): ");
                    String warrantyInput = scanner.nextLine();
                    result=I.searchByWarranty(warrantyInput);
                }else if (filterChoice.equalsIgnoreCase("category")) 
                {
                	 String category =chosenCategory();
                	 result=I.SearchByCategory(category);
                }
                else {
                    System.out.println("Invalid filter choice!");
                }
                displayResults(result);
            } else {
                System.out.println("Invalid search choice!");
            }

            
            
        }
         
    @Override
        public void afficherMenu() {
    	boolean running = true ;
            Scanner scanner = new Scanner(System.in);
            while (running) {
            System.out.println("Welcome, Vendor!");
            System.out.println("Menu:");
            System.out.println("1. Add product to the inventory");
            System.out.println("2. Modify a product in the inventory");
            System.out.println("3. Modify the quantity of a product in the inventory");
            System.out.println("4. Delete a product from the inventory");
            System.out.println("5. View products in the inventory");
            System.out.println("6. Search for a product in the inventory");
            System.out.println("0. Logout");

            System.out.println("Choose an option (0-6):");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addProductToInventory(I);
                    break;
                case 2:
                	modifyProductInventory(I);
                	       
                	break;
                case 3:
                	modifyProductInventory(I);
                	break;
                case 4:
                    deleteProductFromInventory(I);
                    break;
                case 5:
                	I.displayInventoryForVendor(this);
                	break;
                case 6:
                    Search();
                    break;
                
                case 0 :
                	Logout();
                	running= false ;
                default:
                    System.out.println("Invalid option");
                    break;
            }
             
            
            }
        }
   
  


}