package ie.setu.coffeeapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import ie.setu.coffeeapp.R
import ie.setu.coffeeapp.databinding.ActivityCoffeeappBinding
import ie.setu.coffeeapp.main.MainApp
import ie.setu.coffeeapp.models.CoffeeAppModel
import ie.setu.coffeeapp.helpers.showImagePicker
import ie.setu.coffeeapp.models.Location
import timber.log.Timber.i

class CoffeeAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoffeeappBinding
    var coffeeapp = CoffeeAppModel()
    lateinit var app : MainApp
    private lateinit var imageIntentLauncher : ActivityResultLauncher<Intent>
    private lateinit var mapIntentLauncher : ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            var edit = false
            binding = ActivityCoffeeappBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.toolbarAdd.title = title
            setSupportActionBar(binding.toolbarAdd)

            app = application as MainApp

            if (intent.hasExtra("coffee_edit")) {
                edit = true
                coffeeapp = intent.extras?.getParcelable("coffee_edit")!!
                binding.coffeeTitle.setText(coffeeapp.title)
                binding.coffeeBrand.setText(coffeeapp.brand)
                //binding.coffeePrice.setTextSize(coffeeapp.price)
                // binding.coffeeShots.setText(coffeeapp.shots)
                //... as before
                Picasso.get()
                    .load(coffeeapp.image)
                    .into(binding.coffeeImage)
                if (coffeeapp.image != Uri.EMPTY) {
                    binding.chooseImage.setText(R.string.change_coffee_image)
                }

            }

            binding.btnAdd.setOnClickListener() {
                coffeeapp.title = binding.coffeeTitle.text.toString()
                coffeeapp.brand = binding.coffeeBrand.text.toString()
                //coffeeapp.price = binding.coffeePrice.text.toString().toFloat()
                //coffeeapp.shots = binding.coffeeShots.text.toString().toInt()
                if (coffeeapp.title.isEmpty()) {
                    Snackbar
                        .make(it,R.string.enter_coffeetitle, Snackbar.LENGTH_LONG)
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

            binding.chooseImage.setOnClickListener {
                showImagePicker(imageIntentLauncher)
            }

            binding.coffeeLocation.setOnClickListener {
                i ("Set Location Pressed")
            }
            binding.coffeeLocation.setOnClickListener {
                val launcherIntent = Intent(this, MapActivity::class.java)
                mapIntentLauncher.launch(launcherIntent)
            }
            binding.coffeeLocation.setOnClickListener {
                val location = Location(52.245696, -7.139102, 15f)
                val launcherIntent = Intent(this, MapActivity::class.java)
                .putExtra("location", location)
                mapIntentLauncher.launch(launcherIntent)
        }


        registerImagePickerCallback()
        registerMapCallback()
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

    private fun registerImagePickerCallback() {
        imageIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                when(result.resultCode){
                    RESULT_OK -> {
                        if (result.data != null) {
                            i("Got Result ${result.data!!.data}")
                            coffeeapp.image = result.data!!.data!!
                            Picasso.get()
                                .load(coffeeapp.image)
                                .into(binding.coffeeImage)
                            binding.chooseImage.setText(R.string.change_coffee_image)
                        } // end of if
                    }
                    RESULT_CANCELED -> { } else -> { }
                }
            }
    }

    private fun registerMapCallback() {
        mapIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { i("Map Loaded") }
    }

}
