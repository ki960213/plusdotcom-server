package com.ki960213.plusdotcom.plan.controller.dto

import com.ki960213.plusdotcom.plan.domain.CostPolicy

data class CostPolicyResponse(
    val dataUnit: Int,
    val cost: Double,
    val maximumCost: Int?
) {

    constructor(costPolicy: CostPolicy) : this(
        dataUnit = costPolicy.dataUnit,
        cost = costPolicy.cost,
        maximumCost = costPolicy.maximumCost
    )
}
