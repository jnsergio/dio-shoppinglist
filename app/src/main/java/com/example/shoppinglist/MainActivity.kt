package com.example.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var categoryListView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var pizzaListView:RecyclerView
    private lateinit var productAdapter: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carregarCategorias()
        carregarPizzas()
    }

    private fun carregarCategorias() {
        categoryListView = findViewById(R.id.categories_view)
        categoryListView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val categories: ArrayList<Category> = ArrayList<Category>()
        categories.add(Category("Pizza", "cat_1"))
        categories.add(Category("Lanches", "cat_2"))
        categories.add(Category("Hotdog", "cat_3"))
        categories.add(Category("Bebidas", "cat_4"))
        categories.add(Category("Doces", "cat_5"))

        categoryAdapter = CategoryAdapter(categories)
        categoryListView.adapter = categoryAdapter
    }

    private fun carregarPizzas() {
        pizzaListView = findViewById(R.id.products_view)
        pizzaListView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val pizzas: ArrayList<Product> = ArrayList<Product>()
        pizzas.add(
            Product(
                "Pepperoni",
                "pizza1",
                "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce",
                59.99
            )
        )
        pizzas.add(
            Product(
                "Mussarela",
                "pizza2",
                "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce",
                39.99
            )
        )
        pizzas.add(
            Product(
                "Calabresa",
                "pizza1",
                "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce",
                39.99
            )
        )
        pizzas.add(
            Product(
                "Portuguesa",
                "pizza2",
                "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce",
                49.99
            )
        )
        pizzas.add(
            Product(
                "Vegana",
                "pizza1",
                "olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil",
                58.55
            )
        )

        productAdapter = ProductAdapter(pizzas)
        pizzaListView.adapter = productAdapter
    }
}