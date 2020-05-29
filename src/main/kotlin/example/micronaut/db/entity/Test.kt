package example.micronaut.db.entity

import example.micronaut.db.listener.TestIdListener
import javax.persistence.*

@EntityListeners(value = [TestIdListener::class])
@Entity
data class Test(@Id
                @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq")
                @SequenceGenerator(name = "department_id_seq", sequenceName = "department_id_seq")
                @Basic(optional = false)
                var id: Long? = null,
                val name: String? = null) {

    constructor(name: String) : this(null, name)


}