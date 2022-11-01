package com.example.unitonetasks.models

data class ApiResponse(
    var `data`: Data,
    var errors: List<Any>,
    var message: String,
    var status: Boolean
)