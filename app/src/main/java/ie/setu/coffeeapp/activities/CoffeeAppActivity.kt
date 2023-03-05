package ie.setu.coffeeapp.activities

//import android.os.Build.VERSION_CODES.R
import ie.setu.coffeeapp.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ie.setu.coffeeapp.databinding.ActivityCoffeeappBinding
import ie.setu.coffeeapp.main.MainApp
import ie.setu.coffeeapp.models.CoffeeAppModel

class CoffeeAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoffeeappBinding
    var coffeeapp = CoffeeAppModel()
    lateinit var app : MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityCoffeeappBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding = ActivityCoffeeappBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.toolbarAdd.title = title
            setSupportActionBar(binding.toolbarAdd)
            app = application as MainApp
            //i("CoffeeApp Activity started...")
            binding.btnAdd.setOnClickListener() {
                coffeeapp.title = binding.coffeeappTitle.text.toString()
                coffeeapp.description = binding.description.text.toString()
                if (coffeeapp.title.isNotEmpty()) {
                    // app.placemarks.add(placemark.copy())
                    app.coffees.create(coffeeapp.copy())
                    setResult(RESULT_OK)
                    finish()
                }
                else {
                    Snackbar.make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_coffeeapp, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
