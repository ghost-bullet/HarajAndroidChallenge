package com.example.harajtask

import android.content.Context
import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.databinding.ItemBinding
import com.squareup.picasso.Picasso
import com.example.harajtask.DetailsActivity

class DataAdapter (val context:Context, val list : List<DataHaraj>) : RecyclerView.Adapter<DataAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  {
        val binding : ItemBinding = ItemBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val li = list.get(position)
        holder.binding.title.text = li.title

        if(position % 2 ==0){
            holder.binding.container.setBackgroundColor(0x1C8C03)
        }
        Picasso.with(context).load(li.thumbURL).placeholder(R.drawable.ic_search).into(holder.binding.image)
        holder.binding.cityName.text = li.city

        if (li.commentCount == 0)
            holder.binding.commentContainer.visibility = View.INVISIBLE
        else{
            holder.binding.commentContainer.visibility = View.VISIBLE
            holder.binding.commentCount.text = "("+li.commentCount.toString()+")"
        }
        holder.binding.userName.text = li.username
        holder.binding.time.text = Helper().getDateString(li.date)

        holder.binding.container.setOnClickListener {onClick(li)}
    }

    fun onClick(li : DataHaraj) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("Data",li)
        context.startActivity(intent)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    class ViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

}
