package busterarchie.com.smilesdabarber.Fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.TextView
import android.widget.Toast
import busterarchie.com.smilesdabarber.Adapters.CutListAdapter
import busterarchie.com.smilesdabarber.Model.Appointments
import busterarchie.com.smilesdabarber.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.todayscuts.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TodaysCutsFragment : Fragment() {
    var mAppointmentDatabase:DatabaseReference?=null
    var firebaseUser:FirebaseUser?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.todayscuts,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseUser=FirebaseAuth.getInstance().currentUser
        var uid=firebaseUser!!.uid
        mAppointmentDatabase=FirebaseDatabase.getInstance().reference.child("Appointments").child(uid)

        var loinearlayoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        mAppointmentDatabase=FirebaseDatabase.getInstance().reference.child("Appointments")


        lvClientCuts.setHasFixedSize(true)
        lvClientCuts.layoutManager=loinearlayoutManager
        lvClientCuts.adapter=CutListAdapter(mAppointmentDatabase!!,context!!)
        mAppointmentDatabase!!.addChildEventListener(object:ChildEventListener{
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun equals(other: Any?): Boolean {
                return super.equals(other)
            }

            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
                Toast.makeText(context,"The Cut Has Been Handeled",Toast.LENGTH_LONG).show()
            }

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {

                var clientname=p0!!.getValue(Appointments::class.java)
                var name=clientname!!.clientId.toString()
                Toast.makeText(getContext(),"$name,has requested a cut ",Toast.LENGTH_LONG).show()
            }
        } )




    }


}
