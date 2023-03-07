package ie.setu.coffeeapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoffeeAppModel(var id: Long = 0,
                          var title: String = "",
                          var description: String = "") : Parcelable


