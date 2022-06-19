package com.mufid.product

data class BaseResponse<T>(
    var status: Boolean = false,
    var message: String = "",
    var data: T? = null
)
