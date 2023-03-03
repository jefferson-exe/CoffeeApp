package ie.setu.coffeeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import ie.setu.coffeeapp.databinding.ActivityCoffeeappBinding
import ie.setu.coffeeapp.main.MainApp
import ie.setu.coffeeapp.models.CoffeeAppModel
import timber.log.Timber
import timber.log.Timber.i

class CoffeeAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoffeeappBinding
    var coffeeapp = CoffeeAppModel()
    lateinit var app : MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityCoffeeappBinding.inflate(layoutInflater)
            setContentView(binding.root)

            app = application as MainApp
            i("CoffeeApp Activity started...")
            binding.btnAdd.setOnClickListener() {
                coffeeapp.title = binding.coffeeappTitle.text.toString()
                coffeeapp.description = binding.description.text.toString()
                if (coffeeapp.title.isNotEmpty()) {
                    app.coffees.add(coffeeapp.copy())
                    i("add Button Pressed: ${coffeeapp}")
                    for (i in app.coffees.indices)
                        { i("Coffeeapp[$i]:${this.app.coffees[i]}") }
                }
                else {
                    Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
    }
}
