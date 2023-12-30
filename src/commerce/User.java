package commerce;

import java.util.List;
import java.util.Scanner;

public abstract class User {
    private String fullName;
    
    private String email;
    private String password;
    private int phoneNumber;
    abstract public int getId();

    public User( String fullName, String email, String password, int phoneNumber) {
        
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
public static void displayResults(List<Product> products) {
        
        
    	System.out.println("Search Results:");
    	if (products.isEmpty()) 
    	System.out.println("No products are available");
    	System.out.println("--------------------------");

        for (Product product : products) {
            product.affiche();
            System.out.println("--------------------------");
        }
    }

    public boolean logIn(String email,String password)
    {
    	return((this.getEmail().equals(email))&&(this.getPassword().equals(password)));
    }
    public String getFullName() {
        return fullName;
    }

    public static Product chooseCategory()
    {
    	 Scanner scanner = new Scanner(System.in);
         
         // Demander à l'utilisateur de choisir la catégorie du produit
         System.out.println("Choose the category of the product:");
         System.out.println("1. Accessories");
         System.out.println("2. Computer");
         System.out.println("3. Camera");
         System.out.println("4. Headphone");
         System.out.println("5. Smartphone");
         System.out.println("6. Smartwatch");
         System.out.println("7. Tablet");
         System.out.print("Enter your choice: ");
         int categoryChoice = scanner.nextInt();
         scanner.nextLine(); // Consume the newline left by nextInt()
         
         // Instancier le produit et obtenir ses détails en fonction de la catégorie choisie
         Product newProduct = null;
         switch (categoryChoice) {
             case 1:
                 newProduct = new Accessories();
                 break;
             case 2:
                 newProduct = new Computer();
                 break;
             case 3:
                 newProduct = new Camera();
                 break;
             case 4:
                 newProduct = new Headphone();
                 break;
             case 5:
                 newProduct = new Smartphone();
                 break;
             case 6:
                 newProduct = new Smartwatch();
                 break;
             case 7:
                 newProduct = new Tablet();
                 break;
             default:
                 System.out.println("Invalid choice!");
                 break;
         }
         

         return(newProduct);
    }

    
    public static String chosenCategory() {
        Scanner scanner = new Scanner(System.in);
        int categoryChoice;
        while (true) {
            System.out.println("Choose the category of the product:");
            System.out.println("1. Accessories");
            System.out.println("2. Computer");
            System.out.println("3. Camera");
            System.out.println("4. Headphone");
            System.out.println("5. Smartphone");
            System.out.println("6. Smartwatch");
            System.out.println("7. Tablet");
            System.out.print("Enter your choice: ");
            categoryChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()
            
            switch (categoryChoice) {
                case 1:
                    return "Accessories";
                case 2:
                    return "Computer";
                case 3:
                    return "Camera";
                case 4:
                    return "Headphone";
                case 5:
                    return "Smartphone";
                case 6:
                    return "Smartwatch";
                case 7:
                    return "Tablet";
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
        
        
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void afficher() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }
    public abstract void afficherMenu();
    public void Logout()
    {
        System.out.println("Logged out successfully!");
       
    }
    
}

