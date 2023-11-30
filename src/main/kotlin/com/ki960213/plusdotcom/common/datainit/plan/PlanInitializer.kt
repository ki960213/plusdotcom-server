package com.ki960213.plusdotcom.common.datainit.plan

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ki960213.plusdotcom.common.datainit.PLAN_ORDER
import com.ki960213.plusdotcom.common.datainit.plan.dto.PlanDto
import com.ki960213.plusdotcom.plan.domain.PlanRepository
import jakarta.transaction.Transactional
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Transactional
@Order(PLAN_ORDER)
@Component
class PlanInitializer(private val planRepository: PlanRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val plans = jacksonObjectMapper()
            .readValue<List<PlanDto>>(ClassPathResource("data/plans.json").file)
            .map(PlanDto::toDomain)

        planRepository.saveAll(plans)
    }
}
