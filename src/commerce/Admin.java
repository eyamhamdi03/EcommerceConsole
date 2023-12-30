package commerce;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Admin extends User {
	private Vendors VendorsList ;
	private Customers CustomersList ;
	private Inventory inventory;
	private Orders orders ;
	private Coupons coupons;
    public Admin(String fullName, String email, String password, int phoneNumber, Vendors V , Customers C,Inventory inventory,Orders orders ) {
        super( fullName, email, password, phoneNumber);
        VendorsList=V;CustomersList=C;this.inventory=inventory;
        this.orders=orders ;
        coupons =new Coupons();
    }
    public Coupons getCoupons()
    {return(coupons);}
    
public int getId()
{return(1);}
  		

    	@Override
        public void afficherMenu() {
    		boolean running = true ;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome, Admin!");
            while (running) {
            System.out.println("Menu:");
            System.out.println("1. View the list of vendors");
            System.out.println("2. View the list of customers");
            System.out.println("3. View the list of products");
            System.out.println("4. View the list of all orders ");
            System.out.println("5. View the list of unconfirmed orders");
            System.out.println("6. Confirm orders");
            System.out.println("7. Read all coupons");
            System.out.println("8. Add a coupon");
            System.out.println("9. Delete a coupon");
            System.out.println("0. LogOut");
            System.out.println("Choose an option; (0-9):");
            
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    VendorsList.afficher();
                    break;
                case 2:
                	CustomersList.afficher();
                	break;
                case 3:
                    inventory.displayInventoryForAdmin();
                    break;
                case 4 : 
                	orders.displayAllOrders();
                
                case 5:
                	orders.displayNonConfirmedOrders();
                	break;
                case 6:
                    confirmOrders();
                    break;
                case 7:
                    readAllCoupons();
                    break;

                case 8:
                    addCoupon();
                    break;

                case 9:
                    deleteCoupon();
                    break;


               
                case 0:
                	Logout();
                	running = false ;
                	break ;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            }
            
         
        }
    	
    	private void readAllCoupons() {
    	    coupons.displayAllCoupons();
    	}

    	private void addCoupon() {
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.println("Enter the coupon code:");
    	    String code = scanner.nextLine();

    	    double percentage = -1;
    	    boolean validPercentage = false;
    	    while (!validPercentage) {
    	        try {
    	            System.out.println("Enter the reduction percentage (0-100):");
    	            percentage = scanner.nextDouble();
    	            if (percentage < 0 || percentage > 100) {
    	                throw new IllegalArgumentException("Percentage must be between 0 and 100");
    	            }
    	            validPercentage = true;
    	        } catch (InputMismatchException e) {
    	            System.out.println("Invalid input! Please enter a valid number.");
    	            scanner.nextLine(); // Consume the invalid input
    	        } catch (IllegalArgumentException e) {
    	            System.out.println(e.getMessage());
    	        }
    	    }

    	    scanner.nextLine(); // Consume newline
    	    

    	    coupons.addCoupon(code, percentage);
    	}

    	private void deleteCoupon() {
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.println("Enter the coupon code to delete:");
    	    String code = scanner.nextLine();
    	    
    	    coupons.deleteCoupon(code);
    	}
    
    	public void confirmOrders() {
    	    Scanner scanner = new Scanner(System.in);

    	    System.out.println("How many orders do you want to confirm?");
    	    int numberOfOrdersToConfirm = scanner.nextInt();
    	    scanner.nextLine(); // Consume the newline

    	    for (int i = 0; i < numberOfOrdersToConfirm; i++) {
    	        System.out.println("Enter the order ID to confirm:");
    	        int orderId = scanner.nextInt();
    	        scanner.nextLine(); // Consume the newline

    	        orders.confirmOrder(orderId); // Use the confirmOrder method in the Orders class
    	    }

    	    
    	}
}