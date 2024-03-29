package com.dicoding.sportapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.sportapplication.databinding.ItemRowUkorBinding

class ListUkorAdapter(private val listUkor: ArrayList<Ukor>) : RecyclerView.Adapter<ListUkorAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowUkorBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listUkor.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, supervisor, location, photo) = listUkor[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UkorDetailActivity::class.java)
            intent.putExtra(UkorDetailActivity.EXTRA_NAME, name)
            intent.putExtra(UkorDetailActivity.EXTRA_DESCRIPTION, description)
            intent.putExtra(UkorDetailActivity.EXTRA_LOCATION, location)
            intent.putExtra(UkorDetailActivity.EXTRA_SUPERVISOR, supervisor)
            intent.putExtra(UkorDetailActivity.EXTRA_PHOTO, photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    class ListViewHolder(var binding: ItemRowUkorBinding) : RecyclerView.ViewHolder(binding.root)
}