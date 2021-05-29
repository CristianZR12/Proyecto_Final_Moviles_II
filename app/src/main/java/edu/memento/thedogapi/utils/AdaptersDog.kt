package edu.memento.thedogapi.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.memento.thedogapi.R
import kotlinx.android.synthetic.main.item_dog.view.*
import edu.memento.thedogapi.model.Dog

class AdaptersDog(): RecyclerView.Adapter<AdaptersDog.ViewHolder>() {

    lateinit var items:ArrayList<Dog>

    fun setCats(items:List<Dog>) {
        this.items = items as ArrayList<Dog>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.dogName.text = model.name
        holder.dogTemperament.text = model.temperament
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized) {
            items.size
        } else {
            0
        }
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val dogName: TextView = view.tv_name_dog
        val dogTemperament:TextView = view.tv_temperament_dog
    }
}