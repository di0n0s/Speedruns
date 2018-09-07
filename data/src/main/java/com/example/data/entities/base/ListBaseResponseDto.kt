package com.example.data.entities.base

import com.example.data.entities.PaginationResponseDto

open class ListBaseResponseDto<T>(val data: List<T>? = null,
                                  val pagination: PaginationResponseDto? = null)