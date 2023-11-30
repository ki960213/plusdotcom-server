package com.ki960213.plusdotcom.phone.domain

import com.ki960213.plusdotcom.plan.domain.Plan
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MapKeyJoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OrderColumn
import java.time.LocalDate

@Entity
class PhoneModel(

    @Id @GeneratedValue
    val id: Long,

    @Column(unique = true)
    val phoneModelId: String,

    @Column(unique = true)
    val phoneModelName: String,

    @Enumerated(EnumType.STRING)
    val manufacturer: Manufacturer,

    @Enumerated(EnumType.STRING)
    val networkTech: NetworkTech,

    @ElementCollection
    val hashTags: Set<String>,

    val thumbnailUrl: String,

    @OrderColumn
    @ElementCollection
    val descriptionImageUrls: List<String>,

    val screenSize: Double, // 단위는 inch

    val ramCapacity: Int, // 단위는 GB

    val romCapacity: Int, // 단위는 GB

    val batteryCapacity: Int, // 단위는 mAh

    val description: PhoneDescription,

    val price: Int,

    val releaseDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @ElementCollection
    val convenienceFunctions: Set<ConvenienceFunction>
) {

    @OneToMany(mappedBy = "phoneModel", cascade = [CascadeType.ALL], orphanRemoval = true)
    private val _products: MutableList<PhoneProduct> = mutableListOf()
    val products: List<PhoneProduct>
        get() = _products

    @MapKeyJoinColumn(name = "PLAN_ID")
    @ElementCollection
    private val _publiclySubsidies: MutableMap<Plan, Int> = mutableMapOf()
    val publiclySubsidies: Map<Plan, Int>
        get() = _publiclySubsidies

    fun addProduct(product: PhoneProduct) {
        _products.add(product)
    }

    fun putPubliclySubsidy(plan: Plan, amount: Int) {
        _publiclySubsidies[plan] = amount
    }
}
