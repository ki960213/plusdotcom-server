package com.ki960213.plusdotcom.plan.domain

import jakarta.persistence.Embeddable

@Embeddable
data class PlanDescription(
    val shareData: String,
    val messagePolicy: String,
    val callingPolicy: String
)
