package com.example.shayariapp.Adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shayariapp.AllShayariActivity
import com.example.shayariapp.MainActivity
import com.example.shayariapp.Model.CategoryModel
import com.example.shayariapp.R
import com.example.shayariapp.databinding.ItemCategoryBinding

class CategoryAdapter(val mainActivity: MainActivity, val list: ArrayList<CategoryModel>) :RecyclerView.Adapter<CategoryAdapter.CatViewHolder>() {

    val colorList = arrayListOf<String>("#1abc9c","#f1c40f","#2ecc71","#c0392b","#9b59b6")

    class CatViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(ItemCategoryBinding.inflate
            (LayoutInflater.from(
            parent.context
        ),parent,false)
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {

        if(position%5==0){
            // holder.binding.itemText.setBackgroundColor(Color.parseColor(colorList[0]))
            holder.binding.itemText.setBackgroundColor(R.drawable.gradient_1)
        }
        else if(position%5==1){
            holder.binding.itemText.setBackgroundColor(R.drawable.gradient_2)
        }
        else if(position%5==2){
            holder.binding.itemText.setBackgroundColor(R.drawable.gradient_3)
        }
        else if(position%5==3){
            holder.binding.itemText.setBackgroundColor(R.drawable.gradient_4)
        }
        else if(position%5==4){
            holder.binding.itemText.setBackgroundColor(R.drawable.gradient_5)
        }
        else{
            holder.binding.itemText.setBackgroundColor(R.drawable.gradient_4)
        }

        holder.binding.itemText.text = list[position].name.toString()
        holder.binding.root.setOnClickListener {
            val intent = Intent(mainActivity,AllShayariActivity::class.java)
            intent.putExtra("id",list[position].id)
            intent.putExtra("name",list[position].name)

            mainActivity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}