package com.example.md3pactivity03
fun main() {
    val groceryList = arrayListOf(
        "Apples",
        "Bananas",
        "Oranges",
        "Grapes",
        "Strawberries",
        "Blueberries",
        "Raspberries",
        "Mangoes",
        "Pineapples",
        "Watermelons",
        "Lemons",
        "Limes",
        "Potatoes",
        "Onions",
        "Garlic",
        "Carrots",
        "Broccoli",
        "Spinach",
        "Lettuce",
        "Tomatoes"
    )

    val cart = HashMap<String, Int>()

    for (item in groceryList) {
        cart[item] = 0
    }

    println("Welcome to the grocery store!")
    println("Here is a list of items available for purchase:")
    groceryList.forEach { item ->
        println("- $item")
    }

    var continueShopping = true
    while (continueShopping) {
        println("Enter the name of a grocery item to add to your cart, 'remove' to remove an item, 'checkout' to see the items and quantity, or type 'quit' to stop shopping:")
        val input = readLine()?.trim()?.lowercase()
        when {
            input == "quit" -> {
                continueShopping = false
            }
            input == "remove" -> {
                removeFromCart(cart, groceryList)
            }
            input == "checkout" -> {
                checkOut(cart)
            }
            groceryList.contains(input!!.capitalize()) -> {
                addToCart(input, cart)
            }
            else -> {
                println("Sorry, $input is not available in the store.")
            }
        }
    }

    println("Your cart contains:")
    cart.forEach { (item, quantity) ->
        if (quantity > 0) {
            println("$item x$quantity")
        }
    }
}

fun addToCart(itemName: String?, cart: HashMap<String, Int>) {
    println("Enter the quantity of $itemName:")
    val itemQuantity = readLine()?.toIntOrNull()
    if (itemQuantity == null) {
        println("Invalid input. Please enter a number.")
    } else {
        cart[itemName!!.capitalize()] = cart[itemName.capitalize()]!! + itemQuantity
        println("$itemName x$itemQuantity added to your cart.")
    }
}

fun removeFromCart(cart: HashMap<String, Int>, groceryList: ArrayList<String>) {
    println("Enter the name of the item to remove from your cart:")
    val itemName = readLine()?.capitalize()
    if (itemName != null && groceryList.contains(itemName)) {
        val currentQuantity = cart[itemName] ?: 0
        if (currentQuantity > 0) {
            println("Enter the quantity to remove:")
            val itemQuantity = readLine()?.toIntOrNull()
            if (itemQuantity == null) {
                println("Invalid input. Please enter a number.")
            } else if (itemQuantity > currentQuantity) {
                println("You can't remove more items than are in your cart.")
            } else {
                cart[itemName] = currentQuantity - itemQuantity
                println("$itemQuantity $itemName removed from your cart.")
            }
        } else {
            println("$itemName is not in your cart.")
        }
    } else {
        println("Sorry, $itemName is not available in the store.")
    }
}

fun checkOut(cart: HashMap<String, Int>) {
    println("Your cart contains:")
    cart.forEach { (item, quantity) ->
        if (quantity > 0) {
            println("$item x$quantity")
        }
    }
}

