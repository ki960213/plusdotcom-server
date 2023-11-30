package com.ki960213.plusdotcom.common.datainit.publiclysubsidy

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ki960213.plusdotcom.common.datainit.PUBLICLY_SUBSIDY_ORDER
import com.ki960213.plusdotcom.common.datainit.publiclysubsidy.dto.PubliclySubsidiesDto
import com.ki960213.plusdotcom.phone.domain.PhoneModelRepository
import com.ki960213.plusdotcom.plan.domain.PlanRepository
import jakarta.transaction.Transactional
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Transactional
@Order(PUBLICLY_SUBSIDY_ORDER)
@Component
private class PubliclySubsidyInitializer(
    private val phoneModelRepository: PhoneModelRepository,
    private val planRepository: PlanRepository
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val publiclySubsidies = jacksonObjectMapper()
            .readValue<List<PubliclySubsidiesDto>>(ClassPathResource("data/publicly-subsidies.json").file)

        val phoneModels = phoneModelRepository.findAll().associateBy { it.phoneModelName }
        val plans = planRepository.findAll().associateBy { it.planName }

        publiclySubsidies.forEach { dto ->
            val phoneModel = phoneModels[dto.phoneModelName] ?: return@forEach
            dto.publiclySubsidies.forEach inner@{
                val plan = plans[it.planName] ?: return@inner
                phoneModel.putPubliclySubsidy(plan, it.amount)
            }
        }
    }
}
