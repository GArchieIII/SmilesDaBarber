package busterarchie.com.smilesdabarber

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import busterarchie.com.smilesdabarber.Data.Styles
import busterarchie.com.smilesdabarber.Model.Appointments
import busterarchie.com.smilesdabarber.Model.CutListAdapter
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_appointment_scheduler.*
import java.util.*

class AppointmentScheduler : AppCompatActivity() {

    private var adapter: CutListAdapter?=null
    private var StyleList:ArrayList<String>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var myStyle:String?=null
    private var myDay:String?=null
    private var myName:String?=null
    private var scheduleDb= FirebaseDatabase.getInstance()
    private var schdbRef = scheduleDb.getReference("Appointments").push()
    private var firebaseDatabase:FirebaseDatabase= FirebaseDatabase.getInstance()
    private var apointmentRef=firebaseDatabase.getReference("Appointments").push()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_scheduler)

        val dayArray:Array<String> = arrayOf("Mon","Tues","Wens","Thurs","Fri","Sat")
        val styleArray:Array<String> = arrayOf("Fade","Bald Fade","Brush Cut","Shape up","Afro")






        spDay.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,dayArray)

        spStyle.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,styleArray)






        var styleList = ArrayList<Styles>()

        styleList.add(Styles("Shape Up",R.drawable.shapeup))
        styleList.add(Styles("Afro",R.drawable.afro))
        styleList.add(Styles("Brush Cut",R.drawable.fro))
        styleList.add(Styles("Bald Fade",R.drawable.fade))



        layoutManager = LinearLayoutManager(this)
        adapter = CutListAdapter(styleList!!,this)



        rvStylePrice.layoutManager=layoutManager
        rvStylePrice.adapter=adapter


        adapter!!.notifyDataSetChanged()


        btnMakeAppointment.setOnClickListener{
            var myDay:String="Hello"
            var myStyle:String="Killer"
            var myAppointment: Appointments=Appointments("",myDay,myStyle,"")

            apointmentRef.setValue(myAppointment)



        }








    }
        fun CreateAppointment(){







        }
}
