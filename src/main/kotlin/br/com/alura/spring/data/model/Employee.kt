package br.com.alura.spring.data.model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.util.*
import javax.persistence.*

@Entity
@Table(name= "funcionario")
data class Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        val name: String,
        val CPF: String,
        val wage: Double,
        val dtHiring: Date,

        @ManyToOne
        @JoinColumn(name = "officePosition_id")
        val officePosition: OfficePosition,

        @Fetch(FetchMode.SELECT)
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "employee_unitWork",
                joinColumns = arrayOf(JoinColumn(
                        name ="fk_employee"
                )),
                inverseJoinColumns = arrayOf(JoinColumn(
                        name = "fk_unitWork"
                ))
        )
        val unitWork: List<UnitWork>
)