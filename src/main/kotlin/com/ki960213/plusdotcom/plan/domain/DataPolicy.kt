package com.ki960213.plusdotcom.plan.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class DataPolicy(
    @Id @GeneratedValue
    private val id: Long,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn
    private val plan: Plan
)
