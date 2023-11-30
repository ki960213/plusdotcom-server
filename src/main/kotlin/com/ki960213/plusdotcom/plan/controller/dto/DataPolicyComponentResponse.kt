package com.ki960213.plusdotcom.plan.controller.dto

import com.ki960213.plusdotcom.plan.domain.DataPolicyComponent

data class DataPolicyComponentResponse(
    val dataBoundary: Int,
    val speedLimit: Long?,
    val costPolicy: CostPolicyResponse?
) {

    constructor(component: DataPolicyComponent) : this(
        dataBoundary = component.dataBoundary,
        speedLimit = component.speedLimit,
        costPolicy = component.costPolicy?.let(::CostPolicyResponse)
    )
}
