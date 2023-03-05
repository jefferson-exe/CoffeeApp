package ie.setu.coffeeapp.models

class CoffeeAppMemStore : CoffeeAppStore {

    val coffees = ArrayList<CoffeeAppModel>()

    override fun findAll(): List<CoffeeAppModel> {
        return coffees
    }

    override fun create(placemark: CoffeeAppModel) {
        coffees.add(placemark)
    }
}
