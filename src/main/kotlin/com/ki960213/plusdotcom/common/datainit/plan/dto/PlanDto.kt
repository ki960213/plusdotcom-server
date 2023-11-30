package com.ki960213.plusdotcom.common.datainit.plan.dto

import com.ki960213.plusdotcom.phone.domain.NetworkTech
import com.ki960213.plusdotcom.plan.domain.DataPolicyUnitPeriod
import com.ki960213.plusdotcom.plan.domain.Plan
import com.ki960213.plusdotcom.plan.domain.PlanCategory

data class PlanDto(
    val planId: String,
    val planName: String,
    val networkTech: String,
    val defaultMonthlyCost: Int,
    val category: String,
    val dataPolicies: List<DataPolicyDto>,
    val description: PlanDescriptionDto
) {

    fun toDomain(): Plan {
        val plan = Plan(
            id = -1,
            planId = planId,
            planName = planName,
            networkTech = NetworkTech.valueOf(networkTech),
            defaultMonthlyCost = defaultMonthlyCost,
            category = PlanCategory.valueOf(category),
            description = description.toDomain()
        )
        dataPolicies.forEach { plan.addDataPolicy(DataPolicyUnitPeriod.valueOf(it.unitPeriod), it.toDomain(plan)) }
        return plan
    }
}
