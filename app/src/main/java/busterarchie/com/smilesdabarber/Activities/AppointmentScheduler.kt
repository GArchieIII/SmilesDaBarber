package busterarchie.com.smilesdabarber.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import busterarchie.com.smilesdabarber.Data.Styles
import busterarchie.com.smilesdabarber.Model.Appointments
import busterarchie.com.smilesdabarber.Adapters.CutListAdapter
import busterarchie.com.smilesdabarber.Data.Appointment
import busterarchie.com.smilesdabarber.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_appointment_scheduler.*
import java.util.*

class AppointmentScheduler : AppCompatActivity() {

    private var scheduleDb= FirebaseDatabase.getInstance()
    private var schdbRef = scheduleDb.getReference("Appointments").push()
    private var firebaseDatabase:FirebaseDatabase= FirebaseDatabase.getInstance()
    var apointmentRef=firebaseDatabase.getReference("Appointments").push()
    lateinit var clientName:EditText
    lateinit var SclientContact:EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_scheduler)
        var StyleGroup: RadioGroup = findViewById(R.id.rgHairStyles)




        btnMakeAppointment.setOnClickListener {
            SclientContact = findViewById(R.id.edtCContact)
            clientName = findViewById(R.id.edtName)
            var mClientName= clientName.text.toString()
            var YClientNumber = SclientContact.text.toString()
            lateinit var selectedStyle: String
            when (StyleGroup.checkedRadioButtonId) {

                R.id.rbHaircut -> {
                    selectedStyle = "HairCut"
                }
                R.id.rbLineUp -> {
                    selectedStyle = "Line Up"
                }
                R.id.rbRazorLine -> {
                    selectedStyle = "Razor Linet"
                }
                R.id.rbSalisburyMobile -> {
                    selectedStyle = "Salisbury Mobile"
                }
                R.id.rbCollegeCut -> {
                    selectedStyle = "College Cut"
                }
                R.id.rb15_20miRadius -> {
                    selectedStyle = "15-20mi Radius Cut"
                }
                R.id.rb25_40miRadius -> {
                    selectedStyle = "25-40mi Radius Cut"
                }
                R.id.rb45_55miRadius -> {
                    selectedStyle = "45-50mi Radius Cut"
                }
                R.id.rbKidsCut -> {
                    selectedStyle = "Kids Cut"
                }
            }

            println(YClientNumber)

            var myappointment = Appointments(mClientName, YClientNumber,selectedStyle )
            apointmentRef.setValue(myappointment)
        }
    }

    }

