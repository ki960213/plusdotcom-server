package com.ki960213.plusdotcom.service.controller

import com.ki960213.plusdotcom.service.controller.dto.ServiceResponse
import com.ki960213.plusdotcom.service.domain.ServiceRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/services")
@RestController
class ServiceController(
    private val serviceRepository: ServiceRepository
) {

    @GetMapping
    fun getServices(): List<ServiceResponse> = serviceRepository.findAll().map(::ServiceResponse)
}
