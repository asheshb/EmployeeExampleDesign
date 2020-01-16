package com.example.employeeexample.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.employeeexample.R
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun createFile(context: Context, folder: String, ext: String): File {
    val timeStamp: String =
        SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val filesDir: File? = context.getExternalFilesDir(folder)
    val newFile = File(filesDir, "$timeStamp.$ext")
    newFile.createNewFile()
    return newFile
}


fun Activity.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, msg, duration).show()
}

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
