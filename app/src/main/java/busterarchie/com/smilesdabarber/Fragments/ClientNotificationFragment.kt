package busterarchie.com.smilesdabarber.Fragments


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import busterarchie.com.smilesdabarber.Activities.SmilesAdmin
import busterarchie.com.smilesdabarber.Adapters.ClientlistAdapter
import busterarchie.com.smilesdabarber.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.clientnotificationtab.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ClientNotificationFragment : Fragment() {

    var firebase:FirebaseDatabase?=null
    var cuttingNow:Boolean?=null
    var switchRef:DatabaseReference?=null
    var clientRef:DatabaseReference?=null
    var fireUser:FirebaseUser?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       fireUser= FirebaseAuth.getInstance().currentUser


        swCutNotify.setOnCheckedChangeListener { buttonView, isChecked ->

            firebase = FirebaseDatabase.getInstance()
            switchRef = firebase!!.getReference("Admin").child("CuttingNow")


            if(buttonView.isChecked==true) {



                cuttingNow = true
                switchRef!!.child("CuttingNow").setValue(cuttingNow)
                Toast.makeText(this.context, "Smiles is cutting Now", Toast.LENGTH_LONG).show()
                swCutNotify.setTextColor(Color.parseColor("#1fba62"))

            }else{

                cuttingNow = false
                switchRef!!.child("CuttingNow").setValue(cuttingNow)
                Toast.makeText(this.context, "Smiles is no longer Cutting", Toast.LENGTH_LONG).show()
                swCutNotify.setTextColor(Color.parseColor("#f0f2f5"))



            }




        }

        var uid=fireUser!!.uid
        var databaseref= FirebaseDatabase.getInstance().reference.child("Clients").child(uid)
        var keys=databaseref.key

        var clientRef:DatabaseReference=FirebaseDatabase.getInstance().reference.child("Clients")


        var linearLayoutmanager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvClients.setHasFixedSize(true)
        rvClients.layoutManager=linearLayoutmanager
        rvClients.adapter=ClientlistAdapter(clientRef!!,context!!)







    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.clientnotificationtab,container,false)




}
}
