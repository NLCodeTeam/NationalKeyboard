package ru.nlct.nationalkeyboard.domain

interface Mapper<Entity, Model> {
    fun toModel(entity: Entity): Model
    fun toEntity(model: Model): Entity
}