package app.localhost.mercadolivro.exceptions

class NotFoundException(
    override var message: String,
    val errorCode: String
) : Exception()
