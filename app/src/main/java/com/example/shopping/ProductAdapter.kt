package com.example.shopping

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping.model.Product

class ProductAdapter(
    private val productList: List<Product>,
    private val context: Context,
    private val callback: ProductAdapterCallback
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productLogo: ImageView = view.findViewById(R.id.imageProductLogo)
        val productImage: ImageView = view.findViewById(R.id.imageProduct)
        val productName: TextView = view.findViewById(R.id.productName)
        val productDescription: TextView = view.findViewById(R.id.productDescription)
        val productCost: TextView = view.findViewById(R.id.productCost)
        val addItem: Button = view.findViewById(R.id.btnAddItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productLogo.setImageResource(product.logo)
        holder.productImage.setImageResource(product.imageId)
        holder.productName.text = product.productName
        holder.productDescription.text = product.productDescription
        holder.productCost.text = "${product.cost}"
        holder.addItem.setOnClickListener{
            callback.onAddProduct(product)
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(context, ProductDetailsActivity::class.java).apply {
                putExtra("product", product)
            }
            context.startActivity(intent)
        }

    }

    override fun getItemCount() = productList.size
}
