package ie.setu.coffeeapp.activities

import ie.setu.coffeeapp.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ie.setu.coffeeapp.databinding.ActivityCoffeeappBinding
import ie.setu.coffeeapp.main.MainApp
import ie.setu.coffeeapp.models.CoffeeAppModel
import timber.log.Timber
import timber.log.Timber.i

class CoffeeAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoffeeappBinding
    var coffeeapp = CoffeeAppModel()
    var edit = false

    lateinit var app : MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityCoffeeappBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.toolbarAdd.title = title
            setSupportActionBar(binding.toolbarAdd)

            app = application as MainApp

            if (intent.hasExtra("coffee_edit")) {
                edit = true
                coffeeapp = intent.extras?.getParcelable("coffee_edit")!!
                binding.coffeeappTitle.setText(coffeeapp.title)
                binding.description.setText(coffeeapp.description)
            }

            binding.btnAdd.setOnClickListener() {
                coffeeapp.title = binding.coffeeappTitle.text.toString()
                coffeeapp.description = binding.description.text.toString()
                if (coffeeapp.title.isEmpty()) {
                    Snackbar
                        .make(it,R.string.enter_coffee_title, Snackbar.LENGTH_LONG)
                        .show()
                }
                else {
                    if (edit) {
                        app.coffees.update(coffeeapp.copy())
                    }
                    else {
                        app.coffees.create(coffeeapp.copy())
                    }
                    setResult(RESULT_OK)
                    finish()
                }

            }


        binding.btnDel.setOnClickListener() {
            app.coffees.delete(coffeeapp)
            setResult(RESULT_OK)
            finish()
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
