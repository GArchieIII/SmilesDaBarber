package busterarchie.com.smilesdabarber.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import busterarchie.com.smilesdabarber.Model.Client
import busterarchie.com.smilesdabarber.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_client_reg.*

class NewClientReg : AppCompatActivity() {

    private var currentUser:FirebaseUser?=null
    var mAuth:FirebaseAuth?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_client_reg)

        var register = btnRegisterNewClient

        var database= FirebaseDatabase.getInstance()
        var myref = database.getReference("Clients").push()



        register.setOnClickListener {

            mAuth = FirebaseAuth.getInstance()

            var clientName = edtClientName.text.toString()
            var clientNumber = edtClientNumber.text.toString()
            var clientEmail = edtClientEmail.text.toString().trim()
            var clientPassword = edtClientPassword.text.toString().trim()


            val myclient = Client(clientName,clientNumber,clientEmail,clientPassword)

            myref.setValue(myclient)


            mAuth!!.createUserWithEmailAndPassword(clientEmail, clientPassword)

                    .addOnCompleteListener(this, { task: Task<AuthResult> ->

                        if (task.isSuccessful) {
                            var user: FirebaseUser = mAuth!!.currentUser!!
                            Log.d("User", user.email.toString())
                            var intent= Intent(this, ClientHome::class.java)
                            intent.putExtra("UserName",clientName)
                            startActivity(intent)
                        } else {
                            Log.d("Error:", task.toString())
                        }
                    })





        }
    }

}


