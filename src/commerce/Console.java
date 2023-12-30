package commerce;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
    	
        Customers customers = new Customers();
        Vendors vendors = new Vendors();
        Orders orders = new Orders();
        Inventory inventory =new Inventory();
        Admin admin = new Admin("Admin", "admin@gmail.com", "admin1234", 94766307,vendors,customers,inventory,orders);
        Vendor vendor1 = new Vendor(1, "Vendor 1", "vendor1@example.com", "password", "Address 1", 12345678, inventory);
        Vendor vendor2 = new Vendor(2, "Vendor 2", "vendor2@example.com", "password", "Address 2", 98765432, inventory);
        Vendor vendor3 = new Vendor(3, "Vendor 3", "vendor3@example.com", "password", "Address 3", 11111111, inventory);
        vendors.add(vendor1);
        vendors.add(vendor2);
        vendors.add(vendor3);
        Computer computerProduct = new Computer("Laptop", 1200.0, "BrandName", "Description", "1 year warranty", "Intel i5", 8, 512, vendor1);
        inventory.addProductToInventory("Computer", computerProduct, 12);
        Computer computerProduct2 = new Computer("Desktop", 999.0, "AnotherBrand", "Desktop PC Description", "2 years warranty", "AMD Ryzen 7", 16, 1024, vendor1);
        inventory.addProductToInventory("Computer", computerProduct2, 8);

        Computer computerProduct3 = new Computer("Gaming Laptop", 1500.0, "GamingBrand", "Gaming Laptop Description", "3 years warranty", "Intel i7", 16, 1024, vendor1);
        inventory.addProductToInventory("Computer", computerProduct3, 5);

        Computer computerProduct4 = new Computer("Mini PC", 699.0, "SmallBrand", "Small PC Description", "1 year warranty", "Intel Celeron", 4, 256, vendor1);
        inventory.addProductToInventory("Computer", computerProduct4, 20);
        Camera camera1 = new Camera("Camera 1", 499.99, "Brand X", "High-resolution camera", "1-year warranty", "4K", "CMOS", "Zoom", vendor2);
        Camera camera2 = new Camera("Camera 2", 599.99, "Brand Y", "Professional camera", "2-year warranty", "8K", "CCD", "Prime", vendor2);

        
        
        inventory.addProductToInventory("Cameras", camera1, 10);
        inventory.addProductToInventory("Cameras", camera2, 15);

        Printer printerProduct1 = new Printer("Inkjet Printer", 299.0, "PrinterBrand", "Inkjet Printer Description", "1 year warranty", "Inkjet", "Ink-based printing", vendor3);
        inventory.addProductToInventory("Printer", printerProduct1, 10);

        Printer printerProduct2 = new Printer("Laser Printer", 399.0, "LaserBrand", "Laser Printer Description", "2 years warranty", "Laser", "Laser-based printing", vendor3);
        inventory.addProductToInventory("Printer", printerProduct2, 7);

        
        boolean running = true;
        int i = 0;

        while (running) {
            if (i == 0) {
                System.out.println("\nWelcome! We're delighted to have you here today.");
            } else {
                System.out.println("Hello again!");
            }

            System.out.println("Are you here as an administrator, a customer, or a vendor?");
            System.out.println("Enter '1' for Administrator, '2' for Customer, '3' for Vendor, '0' to quit:");

            int choice = getIntInput();

            switch (choice) {
                case 0:
                	System.out.println("Thank you for using our e-commerce application.");
                	System.out.println("This project was conceived and implemented by Eya Mhamdi (GL2) in December 2023.");
                	System.out.println("Our console application marks my initial venture into developing a sizable project using Java and OOP principles.");
                	System.out.println("We hope your experience was pleasant, and we are committed to enhancing this project to improve its overall functionality.");
                	System.out.println("If you have any questions, advice, or feedback, feel free to reach me via email at eyamhamdi2003@gmail.com.");

                	running = false;
                    
                    break;
                case 1:
                    loginAdmin(admin);
                    admin.afficherMenu();
                    break;
                case 2:
                    int customerIndex = loginSignupMenu(customers,inventory,admin);
                    if (customerIndex != -1) {
                        Customer loggedCustomer = customers.getCustomer(customerIndex);
                        loggedCustomer.afficherMenu();
                    }
                    break;
                case 3:
                    int vendorIndex = loginSignupMenu(vendors,inventory,admin);
                    if (vendorIndex != -1) {
                        Vendor loggedVendor = vendors.getVendor(vendorIndex);
                        loggedVendor.afficherMenu();
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

    }

    private static int getIntInput() {
    	
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
        return choice;
    }
    private static void loginAdmin(Admin admin) {
        System.out.println("Hello there! For verification purposes, please provide your email address and password:");
        int attempts = 0;
        
        while (attempts < 5) {
            if (attempts != 0) {
                System.out.println("Be careful, only " + (5 - attempts) + " attempts left.");
            }
            
            System.out.print("Email Address: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            boolean loggedIn = admin.logIn(email, password);
            
            if (loggedIn) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Incorrect email or password! Please try again.");
                attempts++;
            }
        }
        
        if (attempts >= 5) {
            System.out.println("Maximum login attempts reached. Exiting...");
        }
    }
    private static int loginSignupMenu(Users users,Inventory inventory,Admin admin) {
        boolean running = true;
        int index = -1;

        while (running) {
            System.out.println("Hello! To access your account, are you currently registered or would you like to create a new account?");
            System.out.println("Enter '1' for Registered Account, '2' for Creating a New Account, '0' to quit:");
            int choice = getIntInput();

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    index = login(users,inventory);
                    break;
                case 2:
                    index = signup(users,inventory,admin);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            if (index != -1) {
                return index;
            }

        }

        return index;
    }
    private static int login(Users U,Inventory inventory ) {
        System.out.println("You chose to access a registered account.");
        System.out.println("For verification purposes, please provide your email address and its associated password:");
        
        int attempts = 0;
        boolean continueAttempts = true;
        
        while (attempts < 5 && continueAttempts) {
            if (attempts != 0) {
                System.out.println("Be careful, only " + (5 - attempts) + " attempts left.");
                System.out.print("Would you like to try again? (Yes/No): ");
                String tryAgain = scanner.nextLine();
                if (!tryAgain.equalsIgnoreCase("Yes")) {
                    continueAttempts = false;
                }
            }
            
            if (continueAttempts) {
                System.out.print("Email Address: ");
                String mail = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                
                User existingUser = U.findByMail(mail);
                
                if (existingUser == null) {
                    System.out.println("Please verify your email address!");
                } else {
                    boolean loggedIn = existingUser.logIn(mail, password);
                    if (loggedIn) {
                        System.out.println("Login successful! Welcome " + existingUser.getFullName());
                        return existingUser.getId();
                    } else {
                        System.out.println("Incorrect password!");
                    }
                }
                attempts++;
            }
        }
        
        if (attempts >= 5) {
            System.out.println("Maximum login attempts reached. Exiting...");
        }
        return -1;
    }

    private static int signup(Users U,Inventory inventory,Admin admin) {
        System.out.println("Let's create your account.");
        User newUser;
        String email;
        User finder;

        do {
            System.out.print("Enter your email: ");
            email = scanner.nextLine();
            finder = U.findByMail(email);

            if (finder != null) {
                System.out.print("This email already exists! Would you rather login to your existing account? (Yes/No) ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("Yes")) {
                    return login(U,inventory);
                }
            }
        } while (finder != null);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        if (U instanceof Vendors) {
            newUser = new Vendor(U.getNumber(), fullName, email, password, address, phoneNumber,inventory);
        } else {
            newUser = new Customer(U.getNumber(), fullName, email, password, phoneNumber, address,inventory,admin);
        }

        U.add(newUser);
        System.out.println("Signup Completed Successfully! Welcome " + fullName);
        return newUser.getId();
    }


}
