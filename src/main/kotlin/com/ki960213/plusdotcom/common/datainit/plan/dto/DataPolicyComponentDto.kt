package com.ki960213.plusdotcom.common.datainit.plan.dto

import com.ki960213.plusdotcom.plan.domain.DataPolicyComponent
import com.ki960213.plusdotcom.plan.domain.LimitedDataPolicy

data class DataPolicyComponentDto(
    val dataBoundary: Int,
    val speedLimit: Long?,
    val costPolicy: CostPolicyDto?
) {

    fun toDomain(dataPolicy: LimitedDataPolicy) = DataPolicyComponent(
        id = -1,
        dataPolicy = dataPolicy,
        dataBoundary = dataBoundary,
        speedLimit = speedLimit,
        costPolicy = costPolicy?.toDomain()
    )
}
