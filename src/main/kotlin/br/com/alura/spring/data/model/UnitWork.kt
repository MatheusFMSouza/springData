package br.com.alura.spring.data.model

import javax.persistence.*

@Entity
@Table(name = "unidadeDeTrabalho")
data class UnitWork(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        val description: String,
        val rua: String,

        @ManyToMany(mappedBy = "unitWork", fetch = FetchType.EAGER)
        val employee: List<Employee>
)