package com.ki960213.plusdotcom.plan.controller.dto

import com.ki960213.plusdotcom.plan.domain.PlanDescription

data class PlanDescriptionResponse(
    val shareData: String,
    val messagePolicy: String,
    val callingPolicy: String
) {

    constructor(description: PlanDescription) : this(
        shareData = description.shareData,
        messagePolicy = description.messagePolicy,
        callingPolicy = description.callingPolicy
    )
}
