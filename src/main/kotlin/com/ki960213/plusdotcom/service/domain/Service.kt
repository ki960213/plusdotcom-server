package com.ki960213.plusdotcom.service.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Service(
    @Id @GeneratedValue
    val id: Long,

    @Enumerated(EnumType.STRING)
    val type: ServiceType,

    @Column(unique = true)
    val name: String,

    val imageUrl: String
)
