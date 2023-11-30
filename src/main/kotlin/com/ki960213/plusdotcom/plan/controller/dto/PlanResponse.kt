package com.ki960213.plusdotcom.plan.controller.dto

import com.ki960213.plusdotcom.plan.domain.Plan
import com.ki960213.plusdotcom.service.controller.dto.ServiceResponse

data class PlanResponse(
    val id: Long,
    val planId: String,
    val planName: String,
    val networkTech: String,
    val defaultMonthlyCost: Int,
    val category: String,
    val description: PlanDescriptionResponse,
    val dataPolicies: Map<String, DataPolicyResponse>,
    val services: List<ServiceResponse>
) {

    constructor(plan: Plan) : this(
        id = plan.id,
        planId = plan.planId,
        planName = plan.planName,
        networkTech = plan.networkTech.toString(),
        defaultMonthlyCost = plan.defaultMonthlyCost,
        category = plan.category.toString(),
        description = PlanDescriptionResponse(plan.description),
        dataPolicies = plan.dataPolicies.map { (unitPeriod, dataPolicy) ->
            unitPeriod.toString() to DataPolicyResponse.from(dataPolicy)
        }.toMap(),
        services = plan.services.map(::ServiceResponse)
    )
}
