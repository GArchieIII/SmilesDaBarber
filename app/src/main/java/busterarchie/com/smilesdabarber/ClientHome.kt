package busterarchie.com.smilesdabarber

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_client_home.*
import kotlinx.android.synthetic.main.content_client_home.*

class ClientHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_home)
        setSupportActionBar(toolbar)

        btnRequestAppointment.setOnClickListener{

            var intent = Intent(this,AppointmentScheduler::class.java)
            startActivity(intent)
        }


    }

}
