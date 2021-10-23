package app.localhost.mercadolivro.exceptions

class BadRequestException(
    override var message: String,
    val errorCode: String
) : Exception()
