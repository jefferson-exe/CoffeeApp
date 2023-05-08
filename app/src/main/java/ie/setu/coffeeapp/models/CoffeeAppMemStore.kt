package ie.setu.coffeeapp.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

    class CoffeeAppMemStore : CoffeeAppStore {

        val coffees = ArrayList<CoffeeAppModel>()

        override fun findAll(): List<CoffeeAppModel> {
            return coffees
        }

        override fun create(coffeeapp: CoffeeAppModel) {
            coffeeapp.id = getId()
            coffees.add(coffeeapp)
            logAll()
        }

        override fun update(coffeeapp: CoffeeAppModel) {
            var foundCoffeeApp: CoffeeAppModel? = coffees.find { p -> p.id == coffeeapp.id }
            if (foundCoffeeApp != null) {
                foundCoffeeApp.title = coffeeapp.title
                foundCoffeeApp.brand = coffeeapp.brand
                foundCoffeeApp.price = coffeeapp.price
                foundCoffeeApp.shots = coffeeapp.shots
                foundCoffeeApp.image = coffeeapp.image
                foundCoffeeApp.lat = coffeeapp.lat
                foundCoffeeApp.lng = coffeeapp.lng
                foundCoffeeApp.zoom = coffeeapp.zoom
                logAll()
            }
        }

        private fun logAll() {
            coffees.forEach { i("${it}") }
        }
    }