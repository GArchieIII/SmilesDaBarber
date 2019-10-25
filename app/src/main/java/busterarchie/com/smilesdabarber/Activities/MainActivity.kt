package busterarchie.com.smilesdabarber.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import busterarchie.com.smilesdabarber.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var firebaseDatabase = FirebaseDatabase.getInstance()
    var databaseref = firebaseDatabase.getReference("Clients").push()
    //var firebaseUser:FirebaseUser?=null
    var mAuth = FirebaseAuth.getInstance()
    //var userId=firebaseUser!!.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        NewReg.setOnClickListener{

            var ncIntent=Intent(this, NewClientReg::class.java)
            startActivity(ncIntent)
        }



        btnLogin.setOnClickListener {

            var edtEmail = edtEmail.text.toString().trim()
            var edtPassword = edtPassword.text.toString().trim()

            if (edtEmail.isEmpty() || edtPassword.isEmpty()) {
                val emailerrr: String = "Please Enter A Valid Email"
                val Passworderr: String = "Please Enter A Valid Password"

                edtEmail = emailerrr
                edtPassword = Passworderr
            } else {

                mAuth!!.signInWithEmailAndPassword(edtEmail, edtPassword)
                        .addOnCompleteListener { task: Task<AuthResult> ->

                            if (task.isSuccessful) {

                                Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show()
                                var intent = Intent(this,SmilesAdmin::class.java)
                                startActivity(intent)


                            } else {
                                Toast.makeText(this, "Sign in unsuccessful please Reenter Email And Password", Toast.LENGTH_SHORT).show()


                                //Not a Accessable client
                            }


                        }
            }
        }

        }



    }








