package ie.setu.coffeeapp.models

import android.content.Context
import android.net.Uri
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import ie.setu.coffeeapp.helpers.*
import timber.log.Timber
import java.lang.reflect.Type
import java.util.*

const val JSON_FILE = "coffees.json"
val gsonBuilder: Gson = GsonBuilder().setPrettyPrinting()
    .registerTypeAdapter(Uri::class.java, UriParser())
    .create()
val listType: Type = object : TypeToken<ArrayList<CoffeeAppModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class CoffeeappJSONStore(private val context: Context) : CoffeeAppStore {

    var coffees = mutableListOf<CoffeeAppModel>()

    init {
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<CoffeeAppModel> {
        logAll()
        return coffees
    }

    override fun create(coffeeapp: CoffeeAppModel) {
        coffeeapp.id = generateRandomId()
        coffees.add(coffeeapp)
        serialize()
    }


    override fun update(coffeeapp: CoffeeAppModel) {
        // todo
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(coffees, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        coffees = gsonBuilder.fromJson(jsonString, listType)
    }

    private fun logAll() {
        coffees.forEach { Timber.i("$it") }
    }
}

class UriParser : JsonDeserializer<Uri>,JsonSerializer<Uri> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Uri {
        return Uri.parse(json?.asString)
    }

    override fun serialize(
        src: Uri?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src.toString())
    }
}



