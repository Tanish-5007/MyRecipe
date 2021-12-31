package com.example.myrecipe.domain.util

interface DomainMapper <Entity, DomainModel> {

    fun mapToDomainModel(model: Entity): DomainModel


    fun mapFromDomainModel(domainModel: DomainModel): Entity


}