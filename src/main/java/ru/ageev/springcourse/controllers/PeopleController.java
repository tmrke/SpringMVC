package ru.ageev.springcourse.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ageev.springcourse.dao.PersonDao;
import ru.ageev.springcourse.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;

    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model) {
        //get all people and pass for show to view
        model.addAttribute("people", personDao.index());

        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        // get a person by id from DAO and pass for show to view
        model.addAttribute("person", personDao.show(id));

        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDao.save(person);

        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDao.show(id));

        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDao.update(person, id);

        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDao.delete(id);
        return "redirect:/people";
    }
}
