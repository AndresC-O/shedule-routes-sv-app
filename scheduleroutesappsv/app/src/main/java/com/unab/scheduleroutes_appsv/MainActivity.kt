package com.unab.scheduleroutes_appsv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var sp_Departamento: Spinner
    private lateinit var sp_Municipio: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        sp_Departamento = findViewById(R.id.spinner_departamentos)
        sp_Municipio = findViewById(R.id.spinner_municipios)


        val allDepartamentos = arrayOf("Chalatenango", "Santa Ana", "Ahuachapán", "Sonsonate", "San Salvador", "La Libertad", "Cuscatlán", "San Miguel", "Morazán", "San Vicente", "Usulután", "Cabañas", "La Paz", "La Unión")

        var datosSpinerDep = ArrayAdapter(this, android.R.layout.simple_spinner_item, allDepartamentos)
        sp_Departamento.adapter = datosSpinerDep

        fun fillMunicipios(department:String):ArrayList<String>{

            var municipioList = arrayListOf<String>()

            when(department){
                "Chalatenango"->municipioList.addAll(listOf("Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque",
                    "Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción",
                    "Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa",
                    "San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen",
                    "San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla"))
                "San Salvador"->municipioList.addAll(listOf("Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango",
                    "Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás",
                    "Soyapango","Tonacatepeque"))
                "Sonsonate"->municipioList.addAll(listOf("Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán",
                    "San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate",
                    "Sonzacate"))
                "La Paz"->municipioList.addAll(listOf("Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio",
                    "San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes",
                    "San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo",
                    "Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca"))
                "La Libertad"->municipioList.addAll(listOf("Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa",
                    "La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo",
                    "San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza"))
                "San Miguel"->municipioList.addAll(listOf("Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique",
                    "Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge",
                    "San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa"))
                "Usulután"->municipioList.addAll(listOf("Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco",
                    "Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura",
                    "San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután"))
                "Cabañas"->municipioList.addAll(listOf("Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro",
                    "Sensuntepeque","Tejutepeque","Victoria"))
                "Santa Ana"->municipioList.addAll(listOf("Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán",
                    "San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque"))
                "San Vicente"->municipioList.addAll(listOf("Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo",
                    "San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz"))
                "La Unión"->municipioList.addAll(listOf("Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque",
                    "Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín"))
                "Morazán"->municipioList.addAll(listOf("Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti",
                    "Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando",
                    "San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín"))
                "Cuscatlán"->municipioList.addAll(listOf("Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía",
                    "San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa",
                    "Suchitoto","Tenancingo"))
                "Ahuachapán"->municipioList.addAll(listOf("Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla",
                    "San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín"))
            }

            return municipioList
        }

        sp_Departamento?.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var department:String=sp_Departamento.selectedItem.toString()
                val datosSpinerMunicipios = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, fillMunicipios(department))
                sp_Municipio.adapter = datosSpinerMunicipios
            }
        }
    }

    fun getData (Save: View){
        var departmentSelected=sp_Departamento.selectedItem.toString()
        var citySelected=sp_Municipio.selectedItem.toString()

        Toast.makeText(this, "Ha seleccionado: " + citySelected +", "+ departmentSelected +".", Toast.LENGTH_LONG).show()

        val intent = Intent(this@MainActivity, ScheduleTable::class.java)
        intent.putExtra("Department", departmentSelected)
        intent.putExtra("City", citySelected)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this@MainActivity, SplashActivity::class.java)
        startActivity(intent)
        finish()
    }
}