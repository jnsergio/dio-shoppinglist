package com.example.shoppinglist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoppinglist.ProductDetailActivity
import com.example.shoppinglist.R
import java.util.*

class ProductAdapter(products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var _products: ArrayList<Product> = products

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_product, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = _products[position].title
        holder.price.text = _products[position].price.toString()

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            _products[position].imageName,
            "drawable",
            holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .into(holder.productImage)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("object", _products[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return _products.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.product_item_title)
        var price: TextView = itemView.findViewById(R.id.product_item_price)
        var productImage: ImageView = itemView.findViewById(R.id.product_item_image)
    }
}