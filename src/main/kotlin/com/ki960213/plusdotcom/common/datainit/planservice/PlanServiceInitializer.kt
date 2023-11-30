package com.ki960213.plusdotcom.common.datainit.planservice

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ki960213.plusdotcom.common.datainit.PLAN_SERVICE_ORDER
import com.ki960213.plusdotcom.common.datainit.planservice.dto.PlanServiceDto
import com.ki960213.plusdotcom.plan.domain.PlanRepository
import com.ki960213.plusdotcom.service.domain.ServiceRepository
import jakarta.transaction.Transactional
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Transactional
@Order(PLAN_SERVICE_ORDER)
@Component
class PlanServiceInitializer(
    private val planRepository: PlanRepository,
    private val serviceRepository: ServiceRepository
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val planServices = jacksonObjectMapper()
            .readValue<List<PlanServiceDto>>(ClassPathResource("data/plan-services.json").file)

        val plans = planRepository.findAll().associateBy { it.planName }
        val services = serviceRepository.findAll().associateBy { it.name }

        planServices.forEach { dto ->
            val plan = plans[dto.planName] ?: return@forEach
            dto.serviceNames.forEach inner@{ plan.addService(services[it] ?: return@inner) }
        }
    }
}
