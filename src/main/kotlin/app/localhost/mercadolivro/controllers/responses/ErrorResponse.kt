package app.localhost.mercadolivro.controllers.responses

data class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FiedErrorResponse>?
)

data class FiedErrorResponse(
    var message: String,
    var field: String
)
