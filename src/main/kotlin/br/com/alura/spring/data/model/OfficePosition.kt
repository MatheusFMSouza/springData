package br.com.alura.spring.data.model

import javax.persistence.*

@Entity
@Table(name = "officePositions")
data class OfficePosition(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        val description: String? = null,

        @OneToMany(mappedBy = "officePosition")
        val employee: List<Employee?>? = null

)
