package commerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikedProducts {
    private Map<String, List<Product>> likedProductsByCategory;

    public LikedProducts() {
        this.likedProductsByCategory = new HashMap<>();
    }
    public void addProduct(String category, Product product) {
        if (!likedProductsByCategory.containsKey(category)) {
            likedProductsByCategory.put(category, new ArrayList<>());
        }

        List<Product> productsInCategory = likedProductsByCategory.get(category);

        boolean productExists = productsInCategory.stream().anyMatch(p -> p.getId() == product.getId());

        if (!productExists) {
            productsInCategory.add(product);
            System.out.println("Product added to liked products.");
        } else {
            System.out.println("Product already exists in liked products.");
        }
    }

    public void displayLikedProductsByCategory() {
        if (likedProductsByCategory.isEmpty()) {
            System.out.println("No liked products.");
        } else {
            System.out.println("Liked Products:");

            for (Map.Entry<String, List<Product>> entry : likedProductsByCategory.entrySet()) {
                String category = entry.getKey();
                List<Product> products = entry.getValue();

                System.out.println("Category: " + category);

                for (Product product : products) {
                    product.affiche(); 
                    
                    System.out.println("----------------------------------------");
                }

                System.out.println("========================================");
            }
        }
    }

public void deleteProduct(String category, Product product) {
    if (likedProductsByCategory.containsKey(category)) {
        List<Product> productsInCategory = likedProductsByCategory.get(category);
        
        boolean productExists = productsInCategory.stream().anyMatch(p -> p.getId() == product.getId());

        if (productExists) {
            productsInCategory.remove(product);
            System.out.println("Product removed from liked products.");
        } else {
            System.out.println("Product does not exist in liked products.");
        }
    }
}


public Product searchProduct(String category, String productName) {
    if (likedProductsByCategory.containsKey(category)) {
        List<Product> products = likedProductsByCategory.get(category);
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
    }
    return null; // Product not found in the given category with the specified name
}
}