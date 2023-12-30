package commerce;
import java.util.ArrayList;

public class Vendors extends Users{
private ArrayList<Vendor> VendorsList;
private int numberVendors;
Vendors(){VendorsList=new ArrayList<>();numberVendors =0;}
public void add(User newUser) {
	Vendor newVendor=(Vendor)newUser;
    if (!VendorsList.contains(newVendor)) {
    	VendorsList.add(newVendor);
    	numberVendors++;
    } else {
        System.out.println("Vendor already exists in the list.");
    }
}
public Vendor getVendor(int index) {
    if (index >= 0 && index < VendorsList.size()) {
        return VendorsList.get(index);
    } else {
        return null; 
}}

public int getNumber() {
    return numberVendors;
}
public void modify(User updatedUser) {
	Vendor updatedVendor= (Vendor)updatedUser;
    int index = VendorsList.indexOf(updatedVendor);
    if (index != -1) {
    	VendorsList.set(index, updatedVendor);
        System.out.println("Vendor updated successfully.");
    } else {
        System.out.println("Vendor does not exist in the list.");
    }
}

public Vendor findByMail(String email) {
	for (Vendor vendor : VendorsList) {
        if (vendor.getEmail().equals(email)) {
            return vendor; 
        }
    }
    return null;
}
public void afficher () 
{
	    System.out.println("List of all the Vendors :");
	    for (Vendor vendor : VendorsList) {
	        vendor.afficher();
	        System.out.println("---------------------------------");
	    }	
}
}
