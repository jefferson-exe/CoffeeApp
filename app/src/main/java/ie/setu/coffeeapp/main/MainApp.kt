package ie.setu.coffeeapp.main

import android.app.Application
import ie.setu.coffeeapp.models.CoffeeAppMemStore
import ie.setu.coffeeapp.models.CoffeeAppStore
import timber.log.Timber
import timber.log.Timber.i

class MainApp : Application() {

    lateinit var coffees: CoffeeAppStore

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        coffees = CoffeeAppMemStore()
        i("CoffeeApp started")

    }
}
