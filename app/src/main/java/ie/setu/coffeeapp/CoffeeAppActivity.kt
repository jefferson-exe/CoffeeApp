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

        binding = ActivityCoffeeappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("CoffeeApp Activity started..")

        binding.btnAdd.setOnClickListener() {
            i("add Button Pressed")
        }
    }
}