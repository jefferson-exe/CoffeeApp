package ie.setu.coffeeapp.helpers

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import ie.setu.coffeeapp.R

fun showImagePicker(intentLauncher : ActivityResultLauncher<Intent>) {
    var chooseFile = Intent(Intent.ACTION_OPEN_DOCUMENT)
    chooseFile.type = "image/*"
    chooseFile = Intent.createChooser(chooseFile, R.string.select_placemark_image.toString())
    intentLauncher.launch(chooseFile)
}