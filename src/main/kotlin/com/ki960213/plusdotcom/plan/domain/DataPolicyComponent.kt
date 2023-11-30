package com.ki960213.plusdotcom.plan.domain

import jakarta.persistence.AttributeOverride
import jakarta.persistence.AttributeOverrides
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class DataPolicyComponent(
    @Id @GeneratedValue
    private val id: Long,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn
    private val dataPolicy: DataPolicy,

    val dataBoundary: Int, // 단위는 MB

    val speedLimit: Long?, // 단위는 Kbps

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "dataUnit", column = Column(nullable = true)),
        AttributeOverride(name = "cost", column = Column(nullable = true))
    )
    val costPolicy: CostPolicy?
) : Comparable<DataPolicyComponent> {

    override fun compareTo(other: DataPolicyComponent): Int = dataBoundary - other.dataBoundary

    override fun equals(other: Any?): Boolean =
        if (other is DataPolicyComponent) dataBoundary == other.dataBoundary else false

    override fun hashCode(): Int = dataBoundary.hashCode()
}
