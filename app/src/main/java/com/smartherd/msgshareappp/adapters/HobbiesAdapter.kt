package com.smartherd.msgshareappp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.msgshareappp.R
import com.smartherd.msgshareappp.models.Hobby
import com.smartherd.msgshareappp.showToast


class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var currentHobby: Hobby? = null
        private var currentPosition: Int = 0
        init {
            itemView.setOnClickListener {
                context.showToast(currentHobby!!.title + "Clicked !")
            }
            itemView.findViewById<ImageView>(R.id.imgShare).setOnClickListener{
                val message : String = "My Hobby is: " + currentHobby!!.title

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent, " Share To :"))
            }
        }
        fun setData(hobby: Hobby?, pos: Int) {
            itemView.findViewById<TextView>(R.id.txvTitle).text = hobby!!.title

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}
