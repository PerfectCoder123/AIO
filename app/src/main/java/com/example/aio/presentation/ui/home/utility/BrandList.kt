package com.example.aio.presentation.ui.home.utility

import com.example.aio.R
import com.example.aio.presentation.ui.home.data.Brand
import com.example.aio.presentation.ui.home.data.Category

object BrandList {
    val shoppingApp = listOf(
        Brand("Amazon", R.drawable.amazon, "https://www.amazon.in"),
        Brand("Flipkart", R.drawable.flipkart, "https://www.flipkart.com"),
        Brand("Snapdeal", R.drawable.snapdeal, "https://www.snapdeal.com"),
        Brand("Myntra", R.drawable.myntra, "https://www.myntra.com"),
        Brand("Shopclues", R.drawable.shopclues, "https://www.shopclues.com"),
        Brand("Ajio", R.drawable.ajio, "https://www.ajio.com/"),
        Brand("Nike", R.drawable.nike, "https://www.nike.com"),
        Brand("Puma", R.drawable.puma, "https://www.puma.com"),
        Brand("Shopsy", R.drawable.shopsy, "https://www.shopsy.in")
    )

    val medicineApp = listOf(
        Brand("PharmEasy", R.drawable.pharmeasy, "https://www.pharmeasy.in"),
        Brand("Practo", R.drawable.practo, "https://www.practo.com"),
        Brand("NetMeds", R.drawable.netmeds, "https://www.netmeds.com"),
    )

    val foodApp = listOf(
        Brand("Macdonald", R.drawable.mac, "https://mcdelivery.co.in/"),
        Brand("Swiggy", R.drawable.swiggy, "https://www.swiggy.com"),
        Brand("Dominos", R.drawable.dominos, "https://www.dominos.co.in"),
        Brand("KFC", R.drawable.kfc, "https://online.kfc.co.in/"),
    )

    val beautyApp = listOf(
        Brand("MamaEarth", R.drawable.mamaearth, "https://www.mamaearth.in"),
        Brand("Pantaloons", R.drawable.pentaloons, "https://www.pantaloons.com"),
        Brand("H & G", R.drawable.healthglow,"https://stores.healthandglow.com/")
    )

    val travelApp = listOf(
        Brand("MMT", R.drawable.makemytrip, "https://www.makemytrip.com"),
        Brand("Vistara", R.drawable.vistara, "https://www.vistara.com"),
        Brand("Goibibo", R.drawable.goibibo, "https://www.goibibo.com")
    )

    val groceryApp = listOf(
        Brand("Amazon", R.drawable.amazon, "https://www.amazon.in"),
        Brand("BigBazar", R.drawable.bigbazar, "https://www.bigbazar.com"),
        Brand("JioMart", R.drawable.jiomart, "https://www.jiomart.com"),
        Brand("Grofers", R.drawable.grofers, "https://www.grofers.com")
    )

    val categoryList = listOf(
        Category("Shopping", R.drawable.shopping, shoppingApp),
        Category("Beauty", R.drawable.skincare, beautyApp),
        Category("Travel", R.drawable.travel, travelApp),
        Category("Food", R.drawable.food, foodApp),
        Category("Grocery", R.drawable.grocery, groceryApp),
        Category("Medicine", R.drawable.medicine, medicineApp)
    )
}