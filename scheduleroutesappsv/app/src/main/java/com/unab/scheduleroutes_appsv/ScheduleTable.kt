package com.unab.scheduleroutes_appsv

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class ScheduleTable : AppCompatActivity() {

    private lateinit var tv_timenow:TextView
    private lateinit var tv_departments:TextView
    private lateinit var tv_city:TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_table)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        tv_timenow = findViewById(R.id.tv_datenow)
        tv_departments = findViewById(R.id.tv_Department)
        tv_city = findViewById(R.id.tv_Cities)

        //Formateando la fecha y hora actual.
        val current = LocalDateTime.now(ZoneId.of("UTC-6") )
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
        val formatted = current.format(formatter)
        println("> The current Date and Time is: $formatted")

        tv_timenow.setText("Fecha: $formatted")

        //Obteniendo los datos de departamento y municipio.
        val objetoIntent: Intent = intent
        var department = objetoIntent.getStringExtra("Department")
        var city = objetoIntent.getStringExtra("City")

        //Asignando los valores.
        tv_departments.setText("Departamento: " + department)
        tv_city.setText("Municipio: " + city)
    }
}