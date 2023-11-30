package com.ki960213.plusdotcom.phone.controller.response

import com.ki960213.plusdotcom.phone.domain.PhoneProduct

data class PhoneProductResponse(
    val colorName: String,
    val colorCode: String,
    val imageUrls: List<String>,
    val stock: Int
) {

    constructor(product: PhoneProduct) : this(
        colorName = product.colorName,
        colorCode = product.colorCode,
        imageUrls = product.imageUrls,
        stock = product.stock
    )
}
