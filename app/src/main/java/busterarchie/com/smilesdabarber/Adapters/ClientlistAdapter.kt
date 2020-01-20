package busterarchie.com.smilesdabarber.Adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.util.Log.i
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import busterarchie.com.smilesdabarber.Model.Appointments
import busterarchie.com.smilesdabarber.Model.Client
import busterarchie.com.smilesdabarber.R
import busterarchie.com.smilesdabarber.editTextDialog.EditTextDialog
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ClientlistAdapter( databaseQuery: DatabaseReference,var context: Context):FirebaseRecyclerAdapter<Client,ClientlistAdapter.ViewHolder>(

        Client::class.java,
        R.layout.client_row,
        ClientlistAdapter.ViewHolder::class.java,
        databaseQuery

){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientlistAdapter.ViewHolder {
        return super.onCreateViewHolder(parent, viewType)


    }


    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun populateViewHolder(viewHolder: ClientlistAdapter.ViewHolder?, model: Client?, position: Int) {

        var userid=getRef(position).key
        viewHolder!!.BindView(model!!,context)
        viewHolder.itemView.setOnClickListener {

            var choice= arrayOf("Notify Client","Cancel","Remove Client")

            val dialogBuilder= AlertDialog.Builder(context)
            dialogBuilder.setItems(choice,DialogInterface.OnClickListener{DialogInterface,i->

                when(i){

                    0->{

                        Toast.makeText(context,"Send Message To Client",Toast.LENGTH_LONG).show()

                        val dialog=EditTextDialog.newInstance(text="idk",hint="Enter Message",isMultiline = true)

                        dialog.onOk={

                            //This is where the logic for messageing will go


                        }
                        dialog.show("Sending Message")



                    }
                    1->{
                        Toast.makeText(context,"Close Alert Dialoe",Toast.LENGTH_LONG).show()
                }
                    2->{
                    val fireRef=FirebaseDatabase.getInstance().reference.child("Clients").child(userid).setValue(null)
                        Toast.makeText(context,"This Client Has Been Removed from your client list",Toast.LENGTH_LONG).show()

                }

                }
            })
            dialogBuilder.setIcon(R.drawable.smileslogopng)
            dialogBuilder.setTitle("Handle Clients")
            dialogBuilder.show()



        }



    }

    override fun onBindViewHolder(viewHolder: ClientlistAdapter.ViewHolder, position: Int,payloads: MutableList<Any>) {
        super.onBindViewHolder(viewHolder, position,payloads)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var clientNameTxt:String?=null
        var clientImg:Int?=null


        fun BindView(myclient:Client,context:Context){

            var clientImage= itemView.findViewById<ImageView>(R.id.imgClient)
            var clientName = itemView.findViewById<TextView>(R.id.txtClientName)




            clientNameTxt=myclient.GetClientName()
            clientImg= R.drawable.smileslogopng

            clientName.text=clientNameTxt
            clientImage.setImageResource(clientImg!!.toInt())






        }







    }

}