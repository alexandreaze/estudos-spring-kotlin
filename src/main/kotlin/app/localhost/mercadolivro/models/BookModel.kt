package app.localhost.mercadolivro.models

import app.localhost.mercadolivro.enuns.BookStatus
import app.localhost.mercadolivro.enuns.Errors
import app.localhost.mercadolivro.exceptions.BadRequestException
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "books")
class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column
    var name: String,
    @Column
    var price: BigDecimal,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if (field == BookStatus.CANCELED || field == BookStatus.DELETED) {
                throw BadRequestException(message = Errors.ML102.message, errorCode = Errors.ML102.code)
            }
            field = value
        }

    constructor(
        id: Long? = null,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?,
        name: String
    ) : this(id, name, price, customer) {
        this.status = status
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BookModel) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (price != other.price) return false
        if (customer != other.customer) return false
        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + (customer?.hashCode() ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        return result
    }
}
