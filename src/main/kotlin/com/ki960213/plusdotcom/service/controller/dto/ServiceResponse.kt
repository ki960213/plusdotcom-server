package com.ki960213.plusdotcom.service.controller.dto

import com.ki960213.plusdotcom.service.domain.Service

data class ServiceResponse(
    val id: Long,
    val type: String,
    val name: String,
    val imageUrl: String
) {

    constructor(service: Service) : this(
        id = service.id,
        type = service.type.toString(),
        name = service.name,
        imageUrl = service.imageUrl
    )
}
