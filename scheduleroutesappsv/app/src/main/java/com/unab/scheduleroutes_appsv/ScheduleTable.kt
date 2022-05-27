package com.unab.scheduleroutes_appsv

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TableLayout
import android.widget.TableRow
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
    private lateinit var table_schedule: TableLayout

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

        //=========================================================================================
        table_schedule = findViewById(R.id.id_table)
        val array = arrayOf("1-B", "Chalatenango", "EN RUTA", "19:15", "22:00", "$12.00")
       
       //Creando una fila
        val row = TableRow(this)
        row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)

        //Creando una celda
        val cell = TextView(this)
        cell.text = "1-B"
        cell.textAlignment = View.TEXT_ALIGNMENT_CENTER
        cell.setTextColor(Color.parseColor("#FFFFFF"));
        cell.setPadding(3,3,3,3)
        cell.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        row.addView(cell)

        val cell1 = TextView(this)
        cell1.text = "Chalatenango"
        cell1.setTextColor(Color.parseColor("#FFFFFF"));

        // val param = cell1.layoutParams as ViewGroup.MarginLayoutParams
        // param.setMargins(20,0,0,0)
        // cell1.layoutParams = param

        cell1.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        cell1.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        row.addView(cell1)

        val cell2 = TextView(this)
        cell2.text = "EN RUTA"
        cell2.setTextColor(Color.parseColor("#FFFFFF"));
        cell2.textAlignment = View.TEXT_ALIGNMENT_CENTER
        cell2.setPadding(3,3,3,3)
        cell2.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        row.addView(cell2)

        val cell3 = TextView(this)
        cell3.text = "19:28"
        cell3.setTextColor(Color.parseColor("#FFFFFF"));
        cell3.textAlignment = View.TEXT_ALIGNMENT_CENTER
        cell3.setPadding(3,3,3,3)
        cell3.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        row.addView(cell3)

        val cell4 = TextView(this)
        cell4.text = "22:00"
        cell4.setTextColor(Color.parseColor("#FFFFFF"));
        cell4.textAlignment = View.TEXT_ALIGNMENT_CENTER
        cell4.setPadding(3,3,3,3)
        cell4.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        row.addView(cell4)

        val cell5 = TextView(this)
        cell5.text = "$18.00"
        cell5.setTextColor(Color.parseColor("#FFFFFF"));
        cell5.textAlignment = View.TEXT_ALIGNMENT_CENTER
        cell5.setPadding(3,3,3,3)
        cell5.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
        row.addView(cell5)

        table_schedule.addView(row)
    }
}