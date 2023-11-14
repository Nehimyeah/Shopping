package com.example.shopping

import com.example.shopping.model.Product

interface ProductAdapterCallback {
    fun onAddProduct(product: Product)
}
