package app.localhost.mercadolivro.exceptions

import app.localhost.mercadolivro.controllers.responses.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException::class)
    fun handlerNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.NOT_FOUND.value(),
            message = ex.message,
            internalCode = ex.errorCode,
            errors = null
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handlerBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.BAD_REQUEST.value(),
            message = ex.message,
            internalCode = ex.errorCode,
            errors = null
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}
