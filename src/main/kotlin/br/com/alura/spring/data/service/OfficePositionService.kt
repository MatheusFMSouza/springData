package br.com.alura.spring.data.service

import br.com.alura.spring.data.model.OfficePosition
import br.com.alura.spring.data.repository.OfficePositionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OfficePositionService(
        val officePositionRepository: OfficePositionRepository
) {

    fun init(scanner: Scanner, systemExit: Boolean) {
        while (systemExit) {
            println("Informe o que deseja fazer com os cargos")
            println("0 - Voltar ao menu")
            println("1 - Salvar cargo")
            println("2 - Atualizar o nome do cargo")
            println("3 - Listar cargos")
            println("4 - Procurar cargo via Id")
            println("5 - Deletar cargo via Id")
            when (scanner.nextInt()) {
                0 -> break
                1 -> saveOfficePosition(scanner)
                2 -> updateOfficePosition(scanner)
                3 -> findAllOfficePositions()
                4 -> {
                    val officePosition = findByIdOfficePosition(scanner)
                    when (officePosition != null) {
                        true -> {
                            println("============================================")
                            println("Id -> " + officePosition.id)
                            println("Descrição -> " + officePosition.description)
                            println("============================================")
                        }
                        else -> false
                    }
                }
                5 -> deleteOfficePosition(scanner)
            }
        }
    }

    private fun findByIdOfficePosition(scanner: Scanner): OfficePosition? {
        print("Voce possui o Id do cargo ? (1 - Sim || 2 - Nao)")
        when (scanner.nextInt()) {
            1 -> {
                print("Informe o Id do cargo: ")
                val id = scanner.nextInt()
                val officePosition = officePositionRepository.findById(id)
                return OfficePosition(
                        id = officePosition.get().id,
                        description = officePosition.get().description
                )
            }
            2 -> findAllOfficePositions()
        }
        return null
    }

    private fun deleteOfficePosition(scanner: Scanner) {
        println("Para apagar um cargo é necessário ter o Id de" +
                " identificaçao")
        val officePositionDeletion = findByIdOfficePosition(scanner)
        when (officePositionDeletion != null) {
            true -> {
                officePositionRepository.delete(officePositionDeletion)
                println("Cargo deletado com sucesso!")
            }
            else -> false
        }
    }

    private fun updateOfficePosition(scanner: Scanner) {
        println("Para atualizar um cargo é necessário ter o Id de" +
                "identificaçao")
        print("Voce possui o Id do cargo ? (1 - Sim || 2 - Nao)")
        when (scanner.nextInt()) {
            1 -> {
                print("Informe o Id do cargo: ")
                val id = scanner.nextInt()
                print("Informe o novo nome do cargo: ")
                val newDescriptionOfficePosition = scanner.next()

                val officePosition = OfficePosition(
                        id = id,
                        description = newDescriptionOfficePosition
                )

                officePositionRepository.save(officePosition)
                println("Cargo atualizado com sucesso!")
            }
            2 -> findAllOfficePositions()
        }
    }

    private fun findAllOfficePositions() {
        val officesPositions = officePositionRepository.findAll()
        println("============================================")
        when ((officesPositions as ArrayList).isNotEmpty()) {
            true -> {
                officesPositions.forEach { officesPosition ->
                    println("Id -> " + officesPosition.id)
                    println("Descrição -> " + officesPosition.description)
                    println("============================================")
                }
            }
            else -> {
                println("Não possui registros no banco de dados!")
                println("============================================")
            }
        }
    }

    private fun saveOfficePosition(scanner: Scanner) {
        print("Informe o nome do novo cargo (sem espaço): ")
        val newDescriptionOffice = scanner.next()
        val officePosition = OfficePosition(description = newDescriptionOffice)
        officePositionRepository.save(officePosition)
        println("Cargo salvo com sucesso!")
    }


}