package com.ki960213.plusdotcom.common.datainit.phonemodel.dto

import com.ki960213.plusdotcom.phone.domain.PhoneDescription

data class PhoneDescriptionDto(
    val cpu: String,
    val display: String,
    val size: String,
    val camera: String,
    val memory: String,
    val battery: String,
    val waterproof: String
) {

    fun toDomain() = PhoneDescription(
        cpu = cpu,
        display = display,
        size = size,
        camera = camera,
        memory = memory,
        battery = battery,
        waterproof = waterproof
    )
}
