package commerce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coupons {
	private Map<String, Double> coupons;

    public Coupons() {
    	this.coupons = new HashMap<>(); // Initializing the map

    	this.coupons.put("coupon10", 10.0); // 10% reduction
    	this.coupons.put("coupon20", 20.0); // 20% reduction
    	this.coupons.put("coupon30", 30.0); // 30% reduction
    	this.coupons.put("coupon40", 40.0); // 40% reduction
    	this.coupons.put("coupon50", 50.0); // 50% reduction
    }
    public void displayAllCoupons() {
        System.out.println("All Coupons:");
        for (Map.Entry<String, Double> entry : coupons.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "% reduction");
        }
    }
	
	public boolean searchCoupon(String couponCode) {
        if (coupons.containsKey(couponCode)) {
            System.out.println("Coupon found: " + couponCode);
            return true;
        } else {
            System.out.println("Coupon not found: " + couponCode);
            return false;
        }
    }

	public Order applyCoupon(Order O) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Do you have a coupon to assure a reduction for your order? (y/n)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("y")) {
                System.out.println("Enter the coupon code:");
                String couponCode = scanner.nextLine();

                if (searchCoupon(couponCode)) {
                    if (coupons.containsKey(couponCode)) {
                        double reductionPercentage = coupons.get(couponCode);
                        double newAmount =O.getTotalAmount() *(100 - reductionPercentage) / 100; // Apply the reduction percentage
                        System.out.println("Coupon applied! New total amount: " + newAmount);
                        O.setTotalAmount(newAmount);
                    } else {
                        System.out.println("Coupon not found or invalid.");
                    }
                } else {
                    System.out.println("Coupon not found or invalid.");
                }
            }
        }
        return (O);
    }
	public void addCoupon(String couponCode, double reductionPercentage) {
        if (!coupons.containsKey(couponCode)) {
            coupons.put(couponCode, reductionPercentage);
            System.out.println("Coupon added: " + couponCode);
        } else {
            System.out.println("Coupon already exists: " + couponCode);
        }
    }

    public void deleteCoupon(String couponCode) {
        if (coupons.containsKey(couponCode)) {
            coupons.remove(couponCode);
            System.out.println("Coupon deleted: " + couponCode);
        } else {
            System.out.println("Coupon does not exist: " + couponCode);
        }
    }


}
