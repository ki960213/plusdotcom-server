package com.ki960213.plusdotcom.common.datainit.service.dto

import com.ki960213.plusdotcom.service.domain.Service
import com.ki960213.plusdotcom.service.domain.ServiceType

data class ServiceDto(
    val serviceType: String,
    val name: String,
    val imageUrl: String
) {

    fun toDomain() = Service(
        id = -1,
        type = ServiceType.valueOf(serviceType),
        name = name,
        imageUrl = imageUrl
    )
}
