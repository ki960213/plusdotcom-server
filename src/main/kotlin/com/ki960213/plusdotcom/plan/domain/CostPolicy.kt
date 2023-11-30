package com.ki960213.plusdotcom.plan.domain

import jakarta.persistence.Embeddable

@Embeddable
data class CostPolicy(
    val dataUnit: Int, // 단위는 KB
    val cost: Double,
    val maximumCost: Int?
)
