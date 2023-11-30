package com.ki960213.plusdotcom.phone.controller.response

import com.ki960213.plusdotcom.phone.domain.PhoneModel

data class PhoneModelResponse(
    val id: Long,
    val phoneModelId: String,
    val phoneModelName: String,
    val manufacturer: String,
    val networkTech: String,
    val hashTags: List<String>,
    val descriptionImageUrls: List<String>,
    val description: PhoneDescriptionResponse,
    val price: Int,
    val products: List<PhoneProductResponse>,
    val convenienceFunctions: List<String>,
    val publiclySubsidies: Map<Long, Int>
) {

    constructor(phoneModel: PhoneModel) : this(
        id = phoneModel.id,
        phoneModelId = phoneModel.phoneModelId,
        phoneModelName = phoneModel.phoneModelName,
        manufacturer = phoneModel.manufacturer.toString(),
        networkTech = phoneModel.networkTech.toString(),
        hashTags = phoneModel.hashTags.toList(),
        descriptionImageUrls = phoneModel.descriptionImageUrls,
        description = PhoneDescriptionResponse(phoneModel.description),
        price = phoneModel.price,
        products = phoneModel.products.map(::PhoneProductResponse),
        convenienceFunctions = phoneModel.convenienceFunctions.map { it.toString() },
        publiclySubsidies = phoneModel.publiclySubsidies.map { (plan, amount) -> plan.id to amount }.toMap()
    )
}
