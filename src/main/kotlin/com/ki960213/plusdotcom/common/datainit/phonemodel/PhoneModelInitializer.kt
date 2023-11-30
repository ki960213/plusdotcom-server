package com.ki960213.plusdotcom.common.datainit.phonemodel

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ki960213.plusdotcom.common.datainit.PHONE_MODEL_ORDER
import com.ki960213.plusdotcom.common.datainit.phonemodel.dto.PhoneModelDto
import com.ki960213.plusdotcom.phone.domain.PhoneModelRepository
import jakarta.transaction.Transactional
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.annotation.Order
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Transactional
@Order(PHONE_MODEL_ORDER)
@Component
class PhoneModelInitializer(private val phoneModelRepository: PhoneModelRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val phoneModels = jacksonObjectMapper()
            .readValue<List<PhoneModelDto>>(ClassPathResource("data/phone-models.json").file)
            .map(PhoneModelDto::toDomain)

        phoneModelRepository.saveAll(phoneModels)
    }
}
