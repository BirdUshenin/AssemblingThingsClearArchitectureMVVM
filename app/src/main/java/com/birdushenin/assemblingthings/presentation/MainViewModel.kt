package com.birdushenin.assemblingthings.presentation

import androidx.lifecycle.ViewModel
import com.birdushenin.assemblingthings.data.ShopListRepositoryImpl
import com.birdushenin.assemblingthings.domain.DeleteShopItemUseCase
import com.birdushenin.assemblingthings.domain.EditShopItemUseCase
import com.birdushenin.assemblingthings.domain.GetShopListUseCase
import com.birdushenin.assemblingthings.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}