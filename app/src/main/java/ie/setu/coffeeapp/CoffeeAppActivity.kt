package ie.setu.coffeeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.setu.coffeeapp.databinding.ActivityCoffeeappBinding
import timber.log.Timber
import timber.log.Timber.i


class CoffeeAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoffeeappBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffeeapp)

        Timber.plant(Timber.DebugTree())

        btnAdd.setOnClickListener() {
            i("add Button Pressed")
        }

        i("CoffeeApp Activity started..")
    }
}