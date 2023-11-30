package com.ki960213.plusdotcom.plan.controller

import com.ki960213.plusdotcom.common.extension.findByIdOrThrow
import com.ki960213.plusdotcom.plan.controller.dto.PlanResponse
import com.ki960213.plusdotcom.plan.domain.PlanRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/plans")
@RestController
class PlanController(
    private val planRepository: PlanRepository,
) {

    @GetMapping
    fun getPlans(): List<PlanResponse> = planRepository.findAll().map(::PlanResponse)

    @GetMapping("/{id}")
    fun getPlan(@PathVariable id: Long): PlanResponse = PlanResponse(planRepository.findByIdOrThrow(id))
}
