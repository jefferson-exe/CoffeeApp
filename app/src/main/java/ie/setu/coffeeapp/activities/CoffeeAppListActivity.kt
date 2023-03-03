package ie.setu.coffeeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.setu.coffeeapp.R
import ie.setu.coffeeapp.main.MainApp

class CoffeeAppListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee_app_list)
        app = application as MainApp
    }
}
