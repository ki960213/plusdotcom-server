package com.ki960213.plusdotcom.phone.domain

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OrderColumn

@Entity
class PhoneProduct(

    @Id @GeneratedValue
    private val id: Long,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn
    private val phoneModel: PhoneModel,

    val colorName: String,

    val colorCode: String,

    @OrderColumn
    @ElementCollection
    val imageUrls: List<String>,

    val stock: Int
)
