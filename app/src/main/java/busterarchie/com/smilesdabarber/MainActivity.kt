package busterarchie.com.smilesdabarber

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnLogin=btnLogin



        var firebaseDatabase = FirebaseDatabase.getInstance()
        var databaseref = firebaseDatabase.getReference("Clients").push()
        var mAuth = FirebaseAuth.getInstance()

                btnNewRegister.setOnClickListener{

            var register = Intent(this,RegisterClient::class.java)

            startActivity(register)
        }


        btnLogin.setOnClickListener {

            var edtEmail = edtEmail.text.toString().trim()
            var edtPassword = edtPassword.text.toString().trim()

            mAuth!!.signInWithEmailAndPassword(edtEmail, edtPassword)
                    .addOnCompleteListener { task: Task<AuthResult> ->

                        if (task.isSuccessful) {

                            Toast.makeText(this,"Login successful",Toast.LENGTH_LONG).show()
                            var intent =Intent(this,ClientHome::class.java)
                            startActivity(intent)

                            TODO("Set Up user Interface For ")

                        } else {
                            Toast.makeText(this,"Sign in unsuccessful please Reenter Email And Password",Toast.LENGTH_SHORT).show()



                            //Not a Accessable client


                        }
                    }


        }





    }
}

