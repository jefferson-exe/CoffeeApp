package ie.setu.coffeeapp.activities
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ie.setu.coffeeapp.R
import ie.setu.coffeeapp.databinding.ActivityCoffeeAppListBinding
import ie.setu.coffeeapp.databinding.CardCoffeeappBinding
import ie.setu.coffeeapp.main.MainApp
import ie.setu.coffeeapp.models.CoffeeAppModel

class CoffeeAppListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityCoffeeAppListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeAppListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = CoffeeAppAdapter(app.coffees)
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
                notifyItemRangeChanged(0,app.coffees.size)
            }
        }

}

class CoffeeAppAdapter constructor(private var coffees: List<CoffeeAppModel>) :
    RecyclerView.Adapter<CoffeeAppAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardCoffeeappBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val coffeeapp = coffees[holder.adapterPosition]
        holder.bind(coffeeapp)
    }

    override fun getItemCount(): Int = coffees.size

    class MainHolder(private val binding : CardCoffeeappBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(coffeeapp: CoffeeAppModel) {
            binding.coffeeappTitle.text = coffeeapp.title
            binding.description.text = coffeeapp.description
        }
    }
}

