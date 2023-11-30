package com.ki960213.plusdotcom.common.datainit.publiclysubsidy.dto

data class PubliclySubsidiesDto(
    val phoneModelName: String,
    val publiclySubsidies: List<PubliclySubsidyDto>
)

data class PubliclySubsidyDto(
    val planName: String,
    val amount: Int
)
