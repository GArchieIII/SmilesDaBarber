package busterarchie.com.smilesdabarber.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import busterarchie.com.smilesdabarber.R
import busterarchie.com.smilesdabarber.priceinfo
import kotlinx.android.synthetic.main.activity_client_home.*
import kotlinx.android.synthetic.main.content_client_home.*

class ClientHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_home)
        setSupportActionBar(toolbar)

        btnRequestAppointment.setOnClickListener{
            var name=intent.getStringExtra("UserName")

            var intent = Intent(this, AppointmentScheduler::class.java)
            intent.putExtra("UserName",name)
            startActivity(intent)
        }
        btnViewStyles.setOnClickListener {

            var intent=Intent(this, priceinfo::class.java)
            startActivity(intent)
        }


    }

}
