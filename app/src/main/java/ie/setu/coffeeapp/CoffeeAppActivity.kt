package ie.setu.coffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber
import timber.log.Timber.i


class CoffeeAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffeeapp)

        Timber.plant(Timber.DebugTree())

        i("CoffeeApp Activity started..")
    }
}