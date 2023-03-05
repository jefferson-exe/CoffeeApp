package ie.setu.coffeeapp.models

import timber.log.Timber.i

class CoffeeAppMemStore : CoffeeAppStore {

    val coffees = ArrayList<CoffeeAppModel>()

    override fun findAll(): List<CoffeeAppModel> {
        return coffees
    }

    override fun create(placemark: CoffeeAppModel) {
        coffees.add(placemark)
        logAll()
    }

    fun logAll() {
        coffees.forEach{ i("${it}") }
    }
}
