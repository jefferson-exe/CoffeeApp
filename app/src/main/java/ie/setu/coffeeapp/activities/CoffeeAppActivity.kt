package ie.setu.coffeeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.coffeeapp.databinding.ActivityCoffeeappBinding
import ie.setu.coffeeapp.models.CoffeeAppModel
import timber.log.Timber
import timber.log.Timber.i

class CoffeeAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoffeeappBinding

    var coffeeapp = CoffeeAppModel()
    val coffees = ArrayList<CoffeeAppModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoffeeappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        i("Placemark Activity started...")

        binding.btnAdd.setOnClickListener() {
            coffeeapp.title = binding.coffeeappTitle.text.toString()
            coffeeapp.description = binding.description.text.toString()
            if (coffeeapp.title.isNotEmpty()) {
                coffees.add(coffeeapp.copy())

                i("add Button Pressed: $coffeeapp.title")
                for (i in coffees.indices)
                { i("Placemark[$i]:${this.coffees[i]}") }
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}
