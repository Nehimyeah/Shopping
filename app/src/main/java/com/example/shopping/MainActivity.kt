package com.example.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.model.Product

class MainActivity : AppCompatActivity(), ProductAdapterCallback {
    private val cart = mutableListOf<Product>()
    private val products = ArrayList<Product>().apply {
        add(Product(R.drawable.mac_logo,R.drawable.ipad,"iPad", "iPad Pro 11-inch", 400.0))
        add(Product(R.drawable.mac_logo,R.drawable.mac,"MacBook M3 Pro", "12-core CPU, 18-core GPU", 2500.00))
        add(Product(R.drawable.dell_logo,R.drawable.dell,"Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00))
        add(Product(R.drawable.logitech_logo,R.drawable.logitech,"Logitech Keyboard", "Logitech - PRO X TKL LIGHTSPEED Wireless", 199.00))
//        add(Product(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"MacBook M3 Max", "14-core CPU, 30-core GPU", 3499.00))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(products, this, this)

    }

    fun showCart(view: View) {
        val result = cart.joinToString(separator = "\n", prefix = "", postfix = "")
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
    override fun onAddProduct(product: Product) {
        cart.add(product)
    }
}