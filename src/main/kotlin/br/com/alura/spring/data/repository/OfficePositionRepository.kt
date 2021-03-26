package br.com.alura.spring.data.repository

import br.com.alura.spring.data.model.OfficePosition
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OfficePositionRepository: CrudRepository<OfficePosition, Int> {

}
