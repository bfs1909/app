package com.example.trabalhoapp2.listitems

import com.example.trabalhoapp2.R
import com.example.trabalhoapp2.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {


    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Chesse Pizza",
                price = "10.50"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                name = "Clessic Pizza",
                price = "25.00"
            ),
            Product(
                imgProduct = R.drawable.mixed_pizza,
                name = "Mixed Pizza",
                price = "25.00"
            ),
            Product(
                imgProduct = R.drawable.salmon_pizza,
                name = "Salmon Pizza",
                price = "14.00"
            ),

            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Chesse Pizza",
                price = "10.50"
            ),
            Product(
                imgProduct = R.drawable.cheese_pizza,
                name = "Chesse Pizza",
                price = "10.50"
            )
        )
        _productList.value = productList
        return productListFlow
    }



}