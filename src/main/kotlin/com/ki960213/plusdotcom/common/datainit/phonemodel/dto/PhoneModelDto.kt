package com.ki960213.plusdotcom.common.datainit.phonemodel.dto

import com.ki960213.plusdotcom.phone.domain.ConvenienceFunction
import com.ki960213.plusdotcom.phone.domain.Manufacturer
import com.ki960213.plusdotcom.phone.domain.NetworkTech
import com.ki960213.plusdotcom.phone.domain.PhoneModel
import java.time.LocalDate

data class PhoneModelDto(
    val phoneModelId: String,
    val phoneModelName: String,
    val manufacturer: String,
    val networkTech: String,
    val hashTags: List<String>,
    val thumbnailUrl: String,
    val descriptionImageUrls: List<String>,
    val products: List<PhoneProductDto>,
    val screenSize: Double,
    val ramCapacity: Int,
    val romCapacity: Int,
    val batteryCapacity: Int,
    val description: PhoneDescriptionDto,
    val price: Int,
    val releaseDate: String,
    val convenienceFunctions: List<String>
) {

    fun toDomain(): PhoneModel {
        val phoneModel = PhoneModel(
            id = -1,
            phoneModelId = phoneModelId,
            phoneModelName = phoneModelName,
            manufacturer = Manufacturer.valueOf(manufacturer),
            networkTech = NetworkTech.valueOf(networkTech),
            hashTags = hashTags.toSet(),
            thumbnailUrl = thumbnailUrl,
            descriptionImageUrls = descriptionImageUrls,
            screenSize = screenSize,
            ramCapacity = ramCapacity,
            romCapacity = romCapacity,
            batteryCapacity = batteryCapacity,
            description = description.toDomain(),
            price = price,
            releaseDate = LocalDate.parse(releaseDate),
            convenienceFunctions = convenienceFunctions.map { ConvenienceFunction.valueOf(it) }.toSet()
        )
        products.map { it.toDomain(phoneModel) }.forEach { phoneModel.addProduct(it) }
        return phoneModel
    }
}
