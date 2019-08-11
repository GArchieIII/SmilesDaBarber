package busterarchie.com.smilesdabarber.Adapters



import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import busterarchie.com.smilesdabarber.Data.Styles
import busterarchie.com.smilesdabarber.Model.Appointments
import busterarchie.com.smilesdabarber.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference

class CutListAdapter(databaseQuery:DatabaseReference,var context:Context):FirebaseRecyclerAdapter<Appointments,CutListAdapter.ViewHolder>(

        Appointments::class.java,
        R.layout.row_of_client_cuts,
        CutListAdapter.ViewHolder::class.java,
        databaseQuery

){
    override fun populateViewHolder(viewHolder: CutListAdapter.ViewHolder?, model: Appointments?, position: Int) {
            var userId=getRef(position).key
            viewHolder!!.BindView(model!!,context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CutListAdapter.ViewHolder {

        return super.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(holder: CutListAdapter.ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            var clientNameTxt:String?=null
            var clientCutTxt:String?=null
            var contactInfoTxt:String?=null

        fun BindView(myappoint:Appointments,context: Context){

            var clientName= itemView.findViewById<TextView>(R.id.txtClientName)
            var clientCut=itemView.findViewById<TextView>(R.id.txtClientCut)
            var contactInfo=itemView.findViewById<TextView>(R.id.txtContactInfo)



            //setting up strings to pass intent
            clientNameTxt = myappoint.clientId
            clientCutTxt=myappoint.Style
            contactInfoTxt=myappoint.AcontactNumber

            clientName.text=myappoint.clientId
            clientCut.text=myappoint.Style
            contactInfo.text=myappoint.AcontactNumber


        }





    }


}