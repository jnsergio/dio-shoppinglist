package com.example.shoppinglist

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private var addToCart: TextView? = null
private var productTitle: TextView? = null
private var price:TextView? = null
private var description:TextView? = null
private var quantity:TextView? = null
private var increaseQuantity: ImageView? = null
private var decreaseQuantity: ImageView? = null
private var product: Product? = null

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        addToCart = findViewById(R.id.product_detail_add_to_cart)
        productTitle = findViewById(R.id.product_detail_title)
        price = findViewById(R.id.product_detail_price)
        description = findViewById(R.id.product_detail_description)
        quantity = findViewById(R.id.product_detail_quantity)
        increaseQuantity = findViewById(R.id.product_detail_increase_quantity)
        decreaseQuantity = findViewById(R.id.product_detail_decrease_quantity)

        product = intent.getParcelableExtra("object") as Product?

        val drawableResourceId = this.resources.getIdentifier(product?.imageName, "drawable", this.packageName)
        var productImage:ImageView = findViewById(R.id.product_detail_image)
        Glide.with(this).load(drawableResourceId).into(productImage)

        productTitle?.text = product?.title
        price?.text = "R$" + product?.price
        description?.text = product?.description
        quantity?.text = "1"

        increaseQuantity?.setOnClickListener {
            var quantityIncresead = quantity?.text.toString().toInt() + 1
            quantity?.text = quantityIncresead.toString()
        }

        decreaseQuantity?.setOnClickListener(View.OnClickListener {

            var currentQuantity = quantity?.text.toString().toInt()
            if (currentQuantity > 1) {
                var quantityDecresead = currentQuantity - 1
                quantity?.text = quantityDecresead.toString()
            }
        })

        addToCart!!.setOnClickListener {
            super.onBackPressed()
        }
    }
}