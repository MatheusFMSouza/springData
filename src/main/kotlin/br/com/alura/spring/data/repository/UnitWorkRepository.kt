package br.com.alura.spring.data.repository

import br.com.alura.spring.data.model.Employee
import br.com.alura.spring.data.model.OfficePosition
import br.com.alura.spring.data.model.UnitWork
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UnitWorkRepository: CrudRepository<UnitWork, Int> {

}
