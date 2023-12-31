
Project Overview
The Java-based eCommerce console application I've developed is a testament to robust Object-Oriented Programming principles and comprehensive software design. By meticulously structuring the project into distinct classes, I've successfully realized a feature-rich platform that encompasses a spectrum of functionalities. From user authentication with role-based access to meticulous product management enabling CRUD operations and seamless shopping cart management, the application ensures a smooth user experience. Facilitating the entire shopping journey, it seamlessly transitions from cart to order completion, maintaining meticulous transaction records. Inventory management ensures accurate stock updates, while dynamic product search and filtering empower users to discover and refine their product choices. Moreover, the incorporation of a simulated payment system adds a layer of realism to the shopping experience. Additionally, the optional features, such as the customizable product like list for customers and the admin-exclusive coupon management system, further elevate the application's usability and administrative capabilities. This project stands as a testament to a high-level understanding of OOP principles in Java, manifesting in an all-encompassing eCommerce solution.

Purpose
The primary objective of this application is to demonstrate a proficient grasp of Object-Oriented Programming (OOP) principles by effectively managing various classes. Through a command-line interface, the application offers a specialized platform tailored for electronic product enthusiasts. It facilitates the exploration, purchase, and management of electronic items within distinct categories, showcasing a systematic application of different classes to ensure modularity, extensibility, and efficient management of functionalities.

Users
The User abstract class serves as the base blueprint for all user types within the e-commerce application. It encapsulates essential user information and common functionalities used across different user roles.
The application encompasses three primary user roles, each with specific permissions and capabilities:
admin :
The `Admin` class represents the administrator role in the e-commerce application, inheriting functionalities from the `User` class. It provides administrative privileges to manage vendors, customers, products, orders, and coupons within the system.

Email: admin@gmail.com
Password: admin1234
Vendors
Role: Product providers
Vendors:
The `Vendor` class represents a seller in the e-commerce application. It extends the functionalities of the `User` class and encapsulates actions specific to managing products, inventory, and product-related operations.

Vendor 1
Email: vendor1@example.com
Password: password
Address: Address 1
Vendor 2
Email: vendor2@example.com
Password: password
Address: Address 2
Vendor 3
Email: vendor3@example.com
Password: password
Address: Address 3
Customer :
The `Customer` class represents a customer entity in the e-commerce application. It extends the functionalities of the `User` class and encapsulates specific actions related to browsing, managing shopping carts, orders, and preferences.
You can create new customers or vendors that will be added automatically to the vendors and customers list 
Users
The `Users` abstract class acts as a template, enforcing consistent methods that subclasses must implement to manage user-related functionalities effectively. This abstraction allows for flexibility in handling users while maintaining a standardized interface across different user types within the e-commerce system. Subclasses can tailor these methods to suit their unique user management needs.







The heart of the application lies in its ability to manage and showcase a wide range of electronic products. This is achieved through:

### Vendor's Product Management:
- **Ability:** A vendor can manage (add, modify, and view) only their own products within the inventory.
- **Permissions:** Vendors can update product details (brand, name, price, description, and warranty) but are restricted to their own products.
- **Interaction:** Vendors can add new products, update existing product details, and view their products' information and availability.

### Customer's Interaction with Products:
- **Ability:** Customers can only view, add liked products, add products to their cart, and purchase items.
- **Permissions:** Customers cannot modify or manage product details. They interact with products mainly for browsing, liking, adding to cart, and purchasing.
- **Interaction:** Customers can view all products available, search by filters or names, add liked products to their list, and add items to their cart for purchase.

### Admin's Role in Product Management:
- **Functionality:** The admin is responsible for confirming orders placed by different customers.
- **Confirmation Impact:** Unconfirmed orders retain the products in the inventory.
- **Order Management:** The admin has the authority to confirm orders. Once confirmed, products get reserved for delivery, removing them temporarily from the inventory. However, if an order is not confirmed, the product remains available in the inventory for other customers to purchase.

### Product Management Overview:
- **Vendor's Role:** Adding, modifying, and viewing their own products.
- **Customer's Role:** Browsing, liking, adding to cart, and purchasing products.
- **Admin's Role:** Confirming orders to manage product availability in the inventory based on confirmed purchases.


The system ensures vendors have control over their own products, customers can interact with available items, and the admin maintains inventory accuracy by confirming orders that affect product availability. This approach helps maintain a balanced interaction between different user roles and product management within the e-commerce platform.
Product Categories
Categories Available: Computers, Laptops, Keyboards, Mice, Monitors, Printers, Scanners, Software, Smartphones
Attributes: Each product has attributes such as name, price, details, and available quantity.
Inventory Management
Vendor Access: Vendors exclusively manage their inventory, adding new products or updating existing ones.
Automated Tracking: Inventory automatically updates post-purchase, ensuring real-time stock availability.
Key Functionalities
Shopping Cart
Functionality: Allows users to manage selected products, quantity, and proceed to order completion.
Order Processing: Completing orders, modifying order details, and initiating payment processes.
Order Management
User Interaction: Customers can view their order history and track order statuses.
Additional Features
Coupon Codes: Admin-exclusive feature for managing discount codes. 
Initially , many Coupons are created {coupon10,coupon20,coupon30,coupon40,coupon50}
Search and Filtering: Product Discovery: Users can search and filter products by category, price range, brand, and warranty.
Payment Processing: The payment is ensured when delivery. were still working on the transaction part 


The application is structured using Java classes, with distinct functionalities encapsulated within individual classes, including Users, Inventory, Orders, Admin, Vendors, and Customers.

