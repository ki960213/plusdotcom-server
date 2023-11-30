package com.ki960213.plusdotcom.phone.domain

import jakarta.persistence.Embeddable

@Embeddable
data class PhoneDescription(
    val cpu: String = "",
    val display: String = "",
    val size: String = "",
    val camera: String = "",
    val memory: String = "",
    val battery: String = "",
    val waterproof: String = ""
)
