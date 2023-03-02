package ie.setu.coffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber


class CoffeeAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffeeapp)

        Timber.plant(Timber.DebugTree())

        Timber.i("CoffeeApp Activity started..")
    }
}