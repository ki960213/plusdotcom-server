package com.ki960213.plusdotcom.plan.domain

import com.ki960213.plusdotcom.phone.domain.NetworkTech
import com.ki960213.plusdotcom.service.domain.Service
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.MapKeyEnumerated
import jakarta.persistence.OneToMany

@Entity
class Plan(
    @Id @GeneratedValue
    val id: Long,

    @Column(unique = true)
    val planId: String,

    @Column(unique = true)
    val planName: String,

    @Enumerated(EnumType.STRING)
    val networkTech: NetworkTech,

    val defaultMonthlyCost: Int,

    @Enumerated(EnumType.STRING)
    val category: PlanCategory,

    @Embedded
    val description: PlanDescription
) {

    @MapKeyEnumerated(EnumType.STRING)
    @OneToMany(mappedBy = "plan", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val _dataPolicies: MutableMap<DataPolicyUnitPeriod, DataPolicy> = mutableMapOf()
    val dataPolicies: Map<DataPolicyUnitPeriod, DataPolicy>
        get() = _dataPolicies

    @ManyToMany
    private val _services: MutableSet<Service> = mutableSetOf()
    val services: Set<Service>
        get() = _services

    fun addDataPolicy(unitPeriod: DataPolicyUnitPeriod, dataPolicy: DataPolicy) {
        _dataPolicies[unitPeriod] = dataPolicy
    }

    fun addService(service: Service) {
        _services.add(service)
    }
}
