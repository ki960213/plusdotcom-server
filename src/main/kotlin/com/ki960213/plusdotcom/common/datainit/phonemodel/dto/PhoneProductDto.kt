package com.ki960213.plusdotcom.common.datainit.phonemodel.dto

import com.ki960213.plusdotcom.phone.domain.PhoneModel
import com.ki960213.plusdotcom.phone.domain.PhoneProduct

data class PhoneProductDto(
    val colorName: String,
    val colorCode: String,
    val imageUrls: List<String>,
    val stock: Int
) {

    fun toDomain(phoneModel: PhoneModel) = PhoneProduct(
        id = -1,
        phoneModel = phoneModel,
        colorName = colorName,
        colorCode = colorCode,
        imageUrls = imageUrls,
        stock = 100
    )
}
