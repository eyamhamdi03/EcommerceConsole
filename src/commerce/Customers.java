package commerce;
import java.util.ArrayList;

public class Customers extends Users {
private ArrayList<Customer> customersList ;
private int numberCustomers ;
Customers(){customersList=new ArrayList<>();numberCustomers=0;}
public void add(User newUser) {
	Customer newCustomer = (Customer)newUser;
    if (!customersList.contains(newCustomer)) {
        customersList.add(newCustomer);
        numberCustomers++;
    } else {
        System.out.println("Customer already exists in the list.");
    }
}
public Customer getCustomer(int index) {
    if (index >= 0 && index < customersList.size()) {
        return customersList.get(index);
    } else {
        return null; 
}}
public void afficher()
{
	   System.out.println("List of all Customers :");
	    for (Customer customer : customersList) {
	        customer.afficher();
	        System.out.println("---------------------------------");
	    }
}	

public int getNumber() {
    return numberCustomers;
}
public void modify(User updatedUser) {
	Customer updatedCustomer=(Customer) updatedUser;
    int index = customersList.indexOf(updatedCustomer);
    if (index != -1) {
        customersList.set(index, updatedCustomer);
        System.out.println("Customer updated successfully.");
    } else {
        System.out.println("Customer does not exist in the list.");
    }
}
    
public Customer findByMail(String email) {
	for (Customer customer : customersList) {
        if (customer.getEmail().equals(email)) {
            return customer; 
        }
    }
    return null;
}
	

}
