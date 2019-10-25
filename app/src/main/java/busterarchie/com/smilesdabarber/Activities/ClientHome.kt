package busterarchie.com.smilesdabarber.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import busterarchie.com.smilesdabarber.R
import busterarchie.com.smilesdabarber.priceinfo
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_client_home.*
import kotlinx.android.synthetic.main.content_client_home.*

class ClientHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_home)
        setSupportActionBar(toolbar)


        val databaseref= FirebaseDatabase.getInstance().getReference("Admin").child("CuttingNow")
        var cutting=databaseref.addValueEventListener(object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun equals(other: Any?): Boolean {
                return super.equals(other)
            }

            override fun onDataChange(p0: DataSnapshot?) {

               var cutting= p0!!.getValue()

                if(cutting==false){
                    ImgChairsOpenSign.visibility=View.INVISIBLE

                } else if(cutting==true){
                    ImgChairsOpenSign.visibility=View.VISIBLE
                }
            }
        })


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
