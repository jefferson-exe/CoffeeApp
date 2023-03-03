package ie.setu.coffeeapp.main

import android.app.Application
import ie.setu.coffeeapp.models.CoffeeAppModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val coffees = ArrayList<CoffeeAppModel>()
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("CoffeeApp started")
        coffees.add(CoffeeAppModel("One", "About one..."))
        coffees.add(CoffeeAppModel("Two", "About two..."))
        coffees.add(CoffeeAppModel("Three", "About three..."))
    }
}
