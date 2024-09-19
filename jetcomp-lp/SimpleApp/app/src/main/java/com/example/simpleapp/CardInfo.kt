package com.example.simpleapp

object CardInfo {
    val name: List<String> = listOf("Boiled potatoes", "Black pepper", "Mozzarella cheese", "Sour cream", "Salt", "Egg", "Fried bacon", "Scallion")
    val desc: List<String> = listOf("2 Medium-sized","As much as you want","180 g","Half can", "As much as you want", "1 un.", "As much as you want", "As much as you want")
    val img: List<Int> = listOf(R.drawable.b_potatos, R.drawable.black_pepper, R.drawable.m_cheese, R.drawable.sour_cream, R.drawable.salt, R.drawable.eggs, R.drawable.fried_bacon, R.drawable.scallion)

    fun checkCardInfoIntegrity(): Boolean {
        return name.count() == desc.count() && name.count() == img.count()
    }
}