package ie.setu.coffeeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.setu.coffeeapp.databinding.CardCoffeeappBinding
import ie.setu.coffeeapp.models.CoffeeAppModel

interface CoffeeAppListener {
    fun onCoffeeAppClick(coffeeapp: CoffeeAppModel)
}

class CoffeeAppAdapter constructor(private var coffees: List<CoffeeAppModel>,
                                   private val listener: CoffeeAppListener) :
    RecyclerView.Adapter<CoffeeAppAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardCoffeeappBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val coffeeapp = coffees[holder.adapterPosition]
        holder.bind(coffeeapp, listener)
    }

    override fun getItemCount(): Int = coffees.size

    class MainHolder(private val binding : CardCoffeeappBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(coffeeapp: CoffeeAppModel, listener: CoffeeAppListener) {
            binding.coffeeappTitle.text = coffeeapp.title
            binding.description.text = coffeeapp.description
            binding.root.setOnClickListener { listener.onCoffeeAppClick(coffeeapp) }
        }
    }
}
