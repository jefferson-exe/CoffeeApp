package ie.setu.coffeeapp.models

interface CoffeeAppStore {
    fun findAll(): List<CoffeeAppModel>
    fun create(coffeeapp: CoffeeAppModel)
    fun update(coffeeapp: CoffeeAppModel)
    fun delete(coffeeapp: CoffeeAppModel)
}