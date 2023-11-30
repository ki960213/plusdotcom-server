package com.ki960213.plusdotcom.plan.controller.dto

import com.ki960213.plusdotcom.plan.domain.DataPolicy
import com.ki960213.plusdotcom.plan.domain.LimitedDataPolicy
import com.ki960213.plusdotcom.plan.domain.UnlimitedDataPolicy
import java.lang.IllegalArgumentException

sealed class DataPolicyResponse(val type: String) {
    companion object {

        fun from(dataPolicy: DataPolicy): DataPolicyResponse = when (dataPolicy) {
            is UnlimitedDataPolicy -> UnlimitedDataPolicyResponse
            is LimitedDataPolicy -> LimitedDataPolicyResponse(dataPolicy)
            else -> throw IllegalArgumentException("${UnlimitedDataPolicy::class.simpleName} 객체나 ${LimitedDataPolicy::class.simpleName} 객체만 응답값으로 만들 수 있습니다. 잘못된 클래스: ${dataPolicy::class.simpleName}")
        }
    }
}

data object UnlimitedDataPolicyResponse : DataPolicyResponse(UnlimitedDataPolicy::class.simpleName!!)

data class LimitedDataPolicyResponse(
    val defaultDataQuantity: Int,
    val components: List<DataPolicyComponentResponse>
) : DataPolicyResponse(LimitedDataPolicy::class.simpleName!!) {

    constructor(dataPolicy: LimitedDataPolicy) : this(
        defaultDataQuantity = dataPolicy.defaultDataQuantity,
        components = dataPolicy.components.map(::DataPolicyComponentResponse)
    )
}
