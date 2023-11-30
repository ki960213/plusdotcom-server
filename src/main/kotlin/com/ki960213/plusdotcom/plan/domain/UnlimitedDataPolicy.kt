package com.ki960213.plusdotcom.plan.domain

import jakarta.persistence.Entity

@Entity
class UnlimitedDataPolicy(id: Long, plan: Plan) : DataPolicy(id, plan)
