package com.ki960213.plusdotcom.phone.controller.response

import com.ki960213.plusdotcom.phone.domain.PhoneDescription

data class PhoneDescriptionResponse(
    val cpu: String,
    val display: String,
    val size: String,
    val camera: String,
    val memory: String,
    val battery: String,
    val waterproof: String
) {

    constructor(description: PhoneDescription) : this(
        cpu = description.cpu,
        display = description.display,
        size = description.size,
        camera = description.camera,
        memory = description.memory,
        battery = description.battery,
        waterproof = description.waterproof
    )
}
