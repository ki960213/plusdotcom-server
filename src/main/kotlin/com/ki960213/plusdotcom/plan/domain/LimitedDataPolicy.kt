package com.ki960213.plusdotcom.plan.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import org.hibernate.annotations.SortNatural
import java.util.*

@Entity
class LimitedDataPolicy(
    id: Long,
    plan: Plan,
    val defaultDataQuantity: Int // 단위는 MB
) : DataPolicy(id, plan) {

    @SortNatural
    @OneToMany(mappedBy = "dataPolicy", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val _components: SortedSet<DataPolicyComponent> = TreeSet()
    val components: List<DataPolicyComponent>
        get() = _components.toList()

    fun addComponent(component: DataPolicyComponent) {
        _components.add(component)
    }
}
