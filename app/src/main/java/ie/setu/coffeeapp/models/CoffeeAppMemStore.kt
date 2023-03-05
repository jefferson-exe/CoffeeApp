package ie.setu.coffeeapp.models

interface CoffeeAppMemStore {
    fun findAll(): List<CoffeeAppModel>
    fun create(placemark: CoffeeAppModel)
}