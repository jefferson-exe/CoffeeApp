package ie.setu.coffeeapp.models

interface CoffeeAppStore {
    fun findAll(): List<CoffeeAppModel>
    fun create(placemark: CoffeeAppModel)
}