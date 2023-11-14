package com.example.shopping.model

import java.io.Serializable

data class Product(
    val logo: Int,
    val imageId: Int,
    val productName: String,
    val productDescription: String,
    val cost: Double
) : Serializable
