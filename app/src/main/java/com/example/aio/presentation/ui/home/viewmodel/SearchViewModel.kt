package com.example.aio.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aio.presentation.ui.home.data.Brand
import com.example.aio.presentation.ui.home.utility.BrandList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel : ViewModel() {
    private val _search = MutableStateFlow("")
    private val _isAvailable = MutableStateFlow(true)

    val isAvailable: StateFlow<Boolean>
        get() = _isAvailable
    val search: StateFlow<String>
        get() = _search

    private fun updateAvailability() {
        if (_search.value.isEmpty()) {
            _isAvailable.value = true
            return
        }

        val allBrands = listOf(
            BrandList.foodApp,
            BrandList.shoppingApp,
            BrandList.travelApp,
            BrandList.medicineApp,
            BrandList.groceryApp,
            BrandList.beautyApp,
        ).flatten()

        for(category in BrandList.categoryList) {
            if (category.name.contains(_search.value, ignoreCase = true)) {
                _isAvailable.value = true
                return
            }
        }
        _isAvailable.value = allBrands.any { it.name.contains(_search.value, ignoreCase = true) }
    }

    fun updateSearch(search: String) {
        _search.value = search
        updateAvailability()
    }

    fun isMatching(brands: List<Brand>, category: String): Boolean {
        if (_search.value.isEmpty()) return true
        if (category.contains(_search.value, ignoreCase = true)) return true

        return brands.any { it.name.contains(_search.value, ignoreCase = true) }
    }
}
