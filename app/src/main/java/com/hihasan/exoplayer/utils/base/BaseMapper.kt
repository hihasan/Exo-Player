package com.hihasan.exoplayer.utils.base

interface BaseMapper <ENTITY, DTO> {
    fun mapFromDtoToEntity(dto: DTO) : ENTITY
    fun fromDtoToEntity(initial: List<DTO>): List<ENTITY>
}