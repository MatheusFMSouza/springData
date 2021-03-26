package br.com.alura.spring.data

import br.com.alura.spring.data.service.OfficePositionService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class SpringDataApplication(
        val officePositionService: OfficePositionService
) : CommandLineRunner {



    override fun run(vararg args: String?) {
        var systemExit = true
        val scanner = Scanner(System.`in`)

        while (systemExit) {
            println("Qual acao vc quer executar")
            println("0 - Sair")
            println("1 - Cargos")
            print("informe a opção desejada: ")
            when (scanner.nextInt()){
                0 -> break
                1 -> officePositionService.init(scanner, systemExit)
            }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringDataApplication>(*args)
}