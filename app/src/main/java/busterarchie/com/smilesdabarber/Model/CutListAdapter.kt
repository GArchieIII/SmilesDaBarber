package busterarchie.com.smilesdabarber.Model



import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import busterarchie.com.smilesdabarber.Data.Styles
import busterarchie.com.smilesdabarber.R

class CutListAdapter(var styleList:ArrayList<Styles>, private val context:Context):RecyclerView.Adapter<CutListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.style_add,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return styleList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(styleList[position])
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItem(style:Styles){
            var name: TextView = itemView.findViewById(R.id.txtStyleName) as TextView
            var image: ImageView = itemView.findViewById(R.id.imgStyleImage) as ImageView

            name.text= style.StyleName
            image.setImageResource(style.image)



           // styleName.Text =
        }

    }


}