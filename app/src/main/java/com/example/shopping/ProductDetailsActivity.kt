package com.example.shopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.shopping.model.Product

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val img = findViewById<ImageView>(R.id.imageProduct)
        val productName = findViewById<TextView>(R.id.textProductName)
        val productDescription = findViewById<TextView>(R.id.textProductDescription)
        val productPrice = findViewById<TextView>(R.id.textProductPrice)
        val product = intent.getSerializableExtra("product") as Product;
        img.setImageResource(product.imageId)
        productName.text = product.productName
        productDescription.text = product.productDescription
        productPrice.text = product.cost.toString()
    }


    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}