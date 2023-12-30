package commerce;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
public class Customer extends User {
    private String address;
    private int id;
    private Inventory I ;
    private LikedProducts likedProducts;
    private ShoppingCart shoppingCart;
    private Admin admin;
    Orders orders ;

    public void AddtoLikedlist() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add a product to your liked products? (yes/no):");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the product ID to add to liked products:");
            int productId = scanner.nextInt();
            Product productToAdd = I.searchProductById(productId);

            if (productToAdd != null) {
                likedProducts.addProduct(productToAdd.getCategory(),productToAdd);
                System.out.println("Product added to liked products!");
            } else {
                System.out.println("Product not found.");
            }
        }
        
             

}
    public void AddtoCart() {
    Scanner scanner= new Scanner(System.in);
    System.out.println("Do you want to add a product to your cart? (yes/no):");
    String response = scanner.next();

    if (response.equalsIgnoreCase("yes")) {
        System.out.println("Enter the product ID to add to cart:");
        int productId = scanner.nextInt();
        Product productToAdd = I.searchProductById(productId);

        if (productToAdd != null) {
        	int quantity=1;
        	 try {
                 System.out.println("How many items of this product do you want to buy? ");
                 quantity = scanner.nextInt();
                 scanner.nextLine(); // To consume the new line

             } catch (InputMismatchException e) {
                 System.out.println("Invalid input! Please enter a valid integer value.");
                 scanner.nextLine();
             } finally {
                 
             }
        
            shoppingCart.addProduct(productToAdd,quantity);
            System.out.println("Product added to cart!");
        } else {
            System.out.println("Product not found.");
        }
    }

   }
    
    public Customer(int id, String fullName, String email, String password, int phoneNumber, String address,Inventory I,Admin admin) {
        super( fullName, email, password, phoneNumber);
        this.I=I;
        this.address = address;
        this.id=id;
        this.admin=admin;
        shoppingCart=new ShoppingCart();
        likedProducts=new LikedProducts();
        orders=new Orders();
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

    public void afficher() {
    	System.out.println("ID: " + id);
        super.afficher(); 
        System.out.println("Address: " + address);
        
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer otherCustomer = (Customer) obj;
        return this.getId() == otherCustomer.getId();
    }
    
    public void afficherMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            while (running)
            {

            System.out.println("Welcome, Customer!");
            System.out.println("MENU:");
            System.out.println("1. View Liked Products");
            System.out.println("2. View All Products");
            System.out.println("3. Search for a Product");
            System.out.println("4. View Shopping Cart");
            System.out.println("5. View My Orders");
            System.out.println("0. Logout");
            System.out.println("Please choose an option (0-5):");
            
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    likedProducts.displayLikedProductsByCategory();
                    break;
                case 2:
                	I.displayInventoryForCustomers();
                	AddtoLikedlist();
                	AddtoCart();
                    break;
                case 3:
                	Search();
                    break;
                case 4:
                    shoppingCart.afficherShoppingCart();
                    displayOptions();
                    break;
                case 5:
                    orders.displayAllOrders();
                    break;
                
                case 0 :
                	running=false ;
                	Logout();
                default:
                    System.out.println("Invalid option");
                    break;
            }
            
            
        }
    }
    public void displayOptions() {
    	Scanner scanner = new Scanner(System.in);
    	int choice;

    	do {
    	    System.out.println("Choose an option:");
    	    System.out.println("1. Delete an element from the cart");
    	    System.out.println("2. Confirm your order");
    	    System.out.println("3. Clear Cart");
    	    System.out.println("4. Go back to the menu to explore products");
    	    

    	    choice = scanner.nextInt();
    	    scanner.nextLine(); // Consume newline

    	    switch (choice) {
    	        case 1:
    	            System.out.println("Deleting an element from the cart...");
    	            System.out.println("Please enter the product ID to delete:");
    	            int id = scanner.nextInt();
    	            shoppingCart.supprimerDeCarte(id);
    	            break;
    	        case 2:
    	            System.out.println("Confirming your order...");
    	            confirmOrder();
    	            System.out.println("Order Confirmed! Please wait for our call to confirm your delivery!");
                    System.out.println("Payment will be made upon receiving your product.");
                    System.out.println("Thank you for choosing our application for your shopping! Hope you have a good experience!");

    	            break;
    	        case 4:
    	            System.out.println("Going back to the menu to explore products...");
    	            break;
    	        case 3 : 
    	        	shoppingCart.clearCart();
    	        default:
    	            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
    	            break;
    	    }
    	} while (choice < 1 || choice > 3);

    	}


    
    public void confirmOrder () {
	Order order= new Order(shoppingCart,this,admin);
    	order.displayOrderDetails();
    	order.getAdmin().getCoupons().applyCoupon(order);
            Scanner scanner = new Scanner(System.in);
                System.out.println("Do you want to confirm this order? (y/n)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("y")) {
                	 boolean taken =I.takeOrder(order);
                    if (taken)
                	 {orders.addOrder(order);
                    
                    shoppingCart.clearCart();
                    System.out.println("Order confirmed and added to All Orders.");
                   
                } else {
                    System.out.println("Order not confirmed. Returning to the main menu.");
                }
                    
            } else {
                System.out.println("Order not confirmed. Returning to the main menu.");
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
    
}

