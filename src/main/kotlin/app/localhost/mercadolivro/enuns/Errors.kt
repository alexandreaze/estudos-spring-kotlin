package app.localhost.mercadolivro.enuns

enum class Errors(val code: String, val message: String) {
    ML101(code = "ML-101", message = "Book [%s] not exists"),
    ML102(code = "ML-102", message = "Book [%s] not exists"),
}
