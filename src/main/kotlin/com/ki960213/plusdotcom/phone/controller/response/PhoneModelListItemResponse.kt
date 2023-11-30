package com.ki960213.plusdotcom.phone.controller.response

import com.ki960213.plusdotcom.phone.domain.PhoneModel

data class PhoneModelListItemResponse(
    val id: Long,
    val phoneModelId: String,
    val phoneModelName: String,
    val manufacturer: String,
    val networkTech: String,
    val thumbnailUrl: String,
    val colorCodes: List<String>,
    val screenSize: Double,
    val ramCapacity: Int,
    val romCapacity: Int,
    val batteryCapacity: Int,
    val price: Int,
    val releaseDate: String,
    val convenienceFunctions: List<String>,
    val publiclySubsidies: Map<Long, Int>
) {

    constructor(phoneModel: PhoneModel) : this(
        id = phoneModel.id,
        phoneModelId = phoneModel.phoneModelId,
        phoneModelName = phoneModel.phoneModelName,
        manufacturer = phoneModel.manufacturer.toString(),
        networkTech = phoneModel.networkTech.toString(),
        thumbnailUrl = phoneModel.thumbnailUrl,
        colorCodes = phoneModel.products.map { it.colorCode },
        screenSize = phoneModel.screenSize,
        ramCapacity = phoneModel.ramCapacity,
        romCapacity = phoneModel.romCapacity,
        batteryCapacity = phoneModel.batteryCapacity,
        price = phoneModel.price,
        releaseDate = phoneModel.releaseDate.toString(),
        convenienceFunctions = phoneModel.convenienceFunctions.map { it.toString() },
        publiclySubsidies = phoneModel.publiclySubsidies.map { (plan, amount) -> plan.id to amount }.toMap()
    )
}
