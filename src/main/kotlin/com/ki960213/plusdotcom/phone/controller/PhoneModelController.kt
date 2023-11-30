package com.ki960213.plusdotcom.phone.controller

import com.ki960213.plusdotcom.common.extension.findByIdOrThrow
import com.ki960213.plusdotcom.phone.controller.response.PhoneModelListItemResponse
import com.ki960213.plusdotcom.phone.controller.response.PhoneModelResponse
import com.ki960213.plusdotcom.phone.domain.PhoneModelRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/phone-models")
@RestController
class PhoneModelController(
    private val phoneModelRepository: PhoneModelRepository
) {

    @GetMapping
    fun getPhoneModels(): List<PhoneModelListItemResponse> = phoneModelRepository.findAll()
        .map(::PhoneModelListItemResponse)

    @GetMapping("/{id}")
    fun getPhoneModel(@PathVariable id: Long): PhoneModelResponse =
        PhoneModelResponse(phoneModelRepository.findByIdOrThrow(id))
}
