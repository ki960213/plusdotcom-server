package com.ki960213.plusdotcom.common.datainit.plan.dto

import com.ki960213.plusdotcom.plan.domain.DataPolicy
import com.ki960213.plusdotcom.plan.domain.LimitedDataPolicy
import com.ki960213.plusdotcom.plan.domain.Plan
import com.ki960213.plusdotcom.plan.domain.UnlimitedDataPolicy

data class DataPolicyDto(
    val unitPeriod: String,
    val type: String,
    val defaultDataQuantity: Int?,
    val components: List<DataPolicyComponentDto>?
) {

    fun toDomain(plan: Plan): DataPolicy {
        if (type == UnlimitedDataPolicy::class.simpleName) {
            return UnlimitedDataPolicy(id = -1, plan = plan)
        } else if (type == LimitedDataPolicy::class.simpleName) {
            val dataPolicy = LimitedDataPolicy(
                id = -1,
                plan = plan,
                defaultDataQuantity = defaultDataQuantity
                    ?: throw IllegalArgumentException("요금제 json 파일에 무제한 요금제가 아닌데 기본 데이터 제공량이 정해지지 않은 요금제가 있습니다. 해당 파일을 다시 살펴보세요.")
            )
            components?.forEach { dataPolicy.addComponent(it.toDomain(dataPolicy)) }
            return dataPolicy
        }
        throw IllegalArgumentException("요금제 json 파일에 데이터 정책 타입이 UnlimitedDataPolicy와 LimitedDataPolicy가 아닌 잘못된 게 있습니다. $type")
    }
}
