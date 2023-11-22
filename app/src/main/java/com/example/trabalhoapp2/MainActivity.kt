package com.example.trabalhoapp2

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trabalhoapp2.adapter.ProductAdapter
import com.example.trabalhoapp2.databinding.ActivityMainBinding
import com.example.trabalhoapp2.listitems.Products
import com.example.trabalhoapp2.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()
    private var clicked = false


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.statusBarColor = Color.parseColor("#E0E0E0")

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index, value ->
                for (p in value){
                    productList.add(p)
                }
            }
        }

        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this,2)
        productAdapter = ProductAdapter(this,productList)
        recyclerViewProducts.adapter = productAdapter

        binding.btAll.setOnClickListener {
                clicked = true
            if (clicked){
                binding.btAll.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btAll.setTextColor(Color.WHITE)
                binding.btRegular.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btRegular.setTextColor(R.color.dark_gray)
                binding.btPopChase.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPopChase.setTextColor(R.color.dark_gray)
                binding.btPopFlocked.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPopFlocked.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtlistTitle.text = "All"
            }
        }

        binding.btRegular.setOnClickListener {
                clicked = true
            if (clicked){
                binding.btRegular.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btRegular.setTextColor(Color.WHITE)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.btPopChase.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPopChase.setTextColor(R.color.dark_gray)
                binding.btPopFlocked.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPopFlocked.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtlistTitle.text = "Funko Pop Regular"
            }
        }

        binding.btPopChase.setOnClickListener {
                clicked = true
            if (clicked){
                binding.btPopChase.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPopChase.setTextColor(Color.WHITE)
                binding.btRegular.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btRegular.setTextColor(R.color.dark_gray)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.btPopFlocked.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPopFlocked.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtlistTitle.text = "Funko Pop Chase"
            }
        }

        binding.btPopFlocked.setOnClickListener {
                clicked = true
            if (clicked){
                binding.btPopFlocked.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btPopFlocked.setTextColor(Color.WHITE)
                binding.btPopChase.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPopChase.setTextColor(R.color.dark_gray)
                binding.btRegular.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btRegular.setTextColor(R.color.dark_gray)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.txtlistTitle.text = "Funko Pop Flocked"
            }
        }
    }
}