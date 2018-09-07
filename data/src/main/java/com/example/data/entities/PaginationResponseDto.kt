package com.example.data.entities

data class PaginationResponseDto(val offset: Int?,
                                 val max: Int?,
                                 val size: Int?,
                                 val links: List<LinkResponseDto>?)