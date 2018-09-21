package org.bozoben.kothune

import org.bozoben.kothune.Salaire
import org.bozoben.kothune.SalaireRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ThuneController (private val repository: SalaireRepository) {

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = "Kothune, Les salaires en toute transparence"
        model["salaires"] = repository.findAll()
        return "home"
    }

    @GetMapping("/newsalaire")
    fun redirectTocreate(model: Model): String {
        model["title"] = "Ajouter vos données"
        return "newsalaire"
    }

    @PostMapping("/newsalaire")
    fun create(model: Model, @ModelAttribute salaire: Salaire): String {
        repository.save(salaire)
        return "redirect:/"
    }

}