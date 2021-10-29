package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class CategoryAdapter(categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private var _categories: ArrayList<Category> = categories

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_category, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = _categories[position].title
        var picUrl = ""
        when (position) {
            0 -> {
                picUrl = "cat_1"
                holder.mainLayout.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background1
                )
            }
            1 -> {
                picUrl = "cat_2"
                holder.mainLayout.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background2
                )
            }
            2 -> {
                picUrl = "cat_3"
                holder.mainLayout.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background3
                )
            }
            3 -> {
                picUrl = "cat_4"
                holder.mainLayout.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background4
                )
            }
            4 -> {
                picUrl = "cat_5"
                holder.mainLayout.background = ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.category_background5
                )
            }
        }
        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            picUrl,
            "drawable",
            holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.categoryPic)
    }

    override fun getItemCount(): Int {
        return _categories.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var categoryName: TextView = itemView.findViewById(R.id.categoryName)
        var categoryPic: ImageView = itemView.findViewById(R.id.categoryPic)
        var mainLayout: ConstraintLayout = itemView.findViewById(R.id.mainLayout)
    }
}