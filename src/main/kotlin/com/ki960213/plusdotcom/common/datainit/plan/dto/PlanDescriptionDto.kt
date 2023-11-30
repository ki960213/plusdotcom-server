package com.ki960213.plusdotcom.common.datainit.plan.dto

import com.ki960213.plusdotcom.plan.domain.PlanDescription

data class PlanDescriptionDto(
    val shareData: String,
    val messagePolicy: String,
    val callingPolicy: String
) {

    fun toDomain() = PlanDescription(
        shareData = shareData,
        messagePolicy = messagePolicy,
        callingPolicy = callingPolicy
    )
}
