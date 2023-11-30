package com.ki960213.plusdotcom.common.datainit.plan.dto

import com.ki960213.plusdotcom.plan.domain.CostPolicy

data class CostPolicyDto(
    val dataUnit: Int,
    val cost: Double,
    val maximumCost: Int?
) {

    fun toDomain() = CostPolicy(
        dataUnit = dataUnit,
        cost = cost,
        maximumCost = maximumCost
    )
}
