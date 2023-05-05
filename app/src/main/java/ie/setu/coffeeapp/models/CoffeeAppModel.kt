package ie.setu.coffeeapp.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoffeeAppModel(
    var id: Long = 0,
    var title: String = "",
    var brand: String = "",
    var price: Float = 0.0F,
    var shots: Int = 0,
    var image: Uri = Uri.EMPTY
) : Parcelable

@Parcelize
data class Location(var lat: Double = 0.0,
                    var lng: Double = 0.0,
                    var zoom: Float = 0f) : Parcelable


