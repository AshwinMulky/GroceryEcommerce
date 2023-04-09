# Grocery Ecommerce
A Spring boot api to calculate the grocery receipt .

## Prerequisites
- Java 8 or greater
- Maven

## How to Run and test the project?
### Compile
Run `mvn clean package`

### Execute
Run `java -jar target/GroceryEcommerce-0.0.1-SNAPSHOT.jar`

### Test
Use Postman or Thunder Client in VS Code.

> **Note**: Item parameter name is renamed to **taxable** from **isTaxable** to make it compatible with code.

POST http://localhost:8080/grocery/receipt
Example Request Json:
{
  "items": [
    {
      "itemName": "Two Bite Brownies",
      "sku": 85294241,
      "taxable": false,
      "ownBrand": true,
      "price": 3.61
    },
    {
      "itemName": "Halo Top Vanilla Bean Ice Cream",
      "sku": 95422042,
      "taxable": true,
      "ownBrand": false,
      "price": 3.31
    }
  ]
}

### Output
{
  "subtotalBeforeDiscounts": 6.92,
  "discountTotal": 0.79,
  "subtotalAfterDiscounts": 6.13,
  "taxableSubtotalAfterDiscounts": 3.31,
  "taxTotal": 0.27,
  "grandTotal": 6.4
}

### Problem definition
Write a shopping cart receipt api (input cart.json)

Coupons discount an item's price before tax is calculated.
Coupons are automatically applied to a shopping cart if the item is present.
Use the coupons.json as a reference list.
The final price of an item cannot be negative.
Treat the "discountPrice" as a subtraction. A discount of $0.75 applied to an item with a price of $1.00 will have a final price of ($1.00 - $0.75) = $0.25.
Output the following: Subtotal before discounts, Discount total, Subtotal after discounts, Taxable subtotal after discounts, Tax total, and Grand total.

Output Grand total.

The tax rate is 0.0825 (8.25%).

### cart.json
`{
  "items": [
    {
      "itemName": "Two Bite Brownies",
      "sku": 85294241,
      "isTaxable": false,
      "ownBrand": true,
      "price": 3.61
    },
    {
      "itemName": "Halo Top Vanilla Bean Ice Cream",
      "sku": 95422042,
      "isTaxable": false,
      "ownBrand": false,
      "price": 3.31
    },
	....
	....
	]
	}`
	
### coupons.json
`{
  "coupons": [
    {
      "couponName": "Brownie Discount",
      "appliedSku": 85294241,
      "discountPrice": 0.79
    },
    {
      "couponName": "Tofurky Discount",
      "appliedSku": 61411728,
      "discountPrice": 1.01
    },
    {
      "couponName": "Spaghetti Discount",
      "appliedSku": 30532705,
      "discountPrice": 1.83
    },
    {
      "couponName": "Seafood Discount",
      "appliedSku": 21411389,
      "discountPrice": 1.50
    }
  ]
}`
