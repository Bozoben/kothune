package org.bozoben.kothune

import com.samskivert.mustache.Mustache
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.stream.Stream


@SpringBootApplication
class KothuneApplication
/*    @Bean
    fun mustacheCompiler(loader: Mustache.TemplateLoader?) =
        Mustache.compiler().escapeHTML(false).withLoader(loader)*/

fun main(args: Array<String>) {
    runApplication<KothuneApplication>(*args)
}

@Component
class DataInitializer(val repository: SalaireRepository) : ApplicationRunner {

    @Throws(Exception::class)
    override fun run(args: ApplicationArguments) {
        listOf("Jean", "Simone", "Alfred").forEach {
            repository.save(Salaire(name = it, job = "Job de " + it, income = it.hashCode().toString().substring(1, 5), company = "World company"))
        }
    }
}
