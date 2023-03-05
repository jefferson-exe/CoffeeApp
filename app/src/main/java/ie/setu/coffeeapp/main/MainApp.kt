package ie.setu.coffeeapp.main

import android.app.Application
import ie.setu.coffeeapp.models.CoffeeAppMemStore
// import ie.setu.coffeeapp.models.CoffeeAppModel
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    val coffees = CoffeeAppMemStore()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        i("CoffeeApp started")

    }
}
