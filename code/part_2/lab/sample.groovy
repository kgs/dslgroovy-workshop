//YOUR CODE GOES HERE

class PizzaShop {

    def size(s) {
        println s
    }

    def crust(c) {
        println "$c crust"
    }

    def toppings(String[] toppings) {
        println "with toppings ${toppings.join(",")}"
    }

    def address(a) {
        println "to address $a"
    }

    def propertyMissing(p) {
        return p
    }

    static def order(Closure c) {
        def shop = new PizzaShop()
        println 'placing order for Pizza:'
        shop.with c
    }
}


PizzaShop.order {
    size large
    crust thin
    toppings Olives, Onions, Bell_Pepper
    address "101 Main St., ..."
}
/*
placing order for Pizza:
large
thin crust
with toppings Olives, Onions, Bell Peppers
to address 101 Main St., ...
*/