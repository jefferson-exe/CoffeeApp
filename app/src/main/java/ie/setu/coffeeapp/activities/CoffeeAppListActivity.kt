package ie.setu.coffeeapp.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ie.setu.coffeeapp.R
import ie.setu.coffeeapp.adapters.CoffeeAppAdapter
import ie.setu.coffeeapp.adapters.CoffeeAppListener
import ie.setu.coffeeapp.databinding.ActivityCoffeeAppListBinding
import ie.setu.coffeeapp.main.MainApp
import ie.setu.coffeeapp.models.CoffeeAppModel

class CoffeeAppListActivity : AppCompatActivity(), CoffeeAppListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivityCoffeeAppListBinding
    var coffeeapp = CoffeeAppModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeAppListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = CoffeeAppAdapter(app.coffees.findAll(), this)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, CoffeeAppActivity::class.java)
                getResult.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.coffees.findAll().size)
            }
        }

    override fun onCoffeeAppClick(coffeeapp: CoffeeAppModel) {
        val launcherIntent = Intent(this, CoffeeAppActivity::class.java)
        launcherIntent.putExtra("coffee_edit", coffeeapp)
        getClickResult.launch(launcherIntent)
    }

    private val getClickResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                (binding.recyclerView.adapter)?.
                notifyItemRangeChanged(0,app.coffees.findAll().size)
            }
        }
}



