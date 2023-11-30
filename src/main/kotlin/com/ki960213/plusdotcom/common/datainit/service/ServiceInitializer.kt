package com.ki960213.plusdotcom.common.datainit.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ki960213.plusdotcom.common.datainit.SERVICE_ORDER
import com.ki960213.plusdotcom.common.datainit.service.dto.ServiceDto
import com.ki960213.plusdotcom.service.domain.ServiceRepository
import jakarta.transaction.Transactional
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Transactional
@Order(SERVICE_ORDER)
@Component
class ServiceInitializer(private val serviceRepository: ServiceRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val services = jacksonObjectMapper()
            .readValue<List<ServiceDto>>(ClassPathResource("data/services.json").file)
            .map(ServiceDto::toDomain)

        serviceRepository.saveAll(services)
    }
}
