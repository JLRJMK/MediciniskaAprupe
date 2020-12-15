package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Pacients;
import com.kd.feedback.services.PacientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PacientsController {



    @Autowired
    private PacientsService pacientsService;


    //Pacientu kontrolleri
    //Pacientu saraksts
    @RequestMapping(value = {"/pacientsList"}, method = RequestMethod.GET)
    public String pacienti(Model model) {
        List<Pacients> pacienti = pacientsService.all();
        model.addAttribute("pacienti", pacienti);

        return "pacientsList";
    }

    //Pacienta profils
    @RequestMapping(value = {"/showPacients/{id}"}, method = RequestMethod.GET)
    public String pacients(@PathVariable("id") Integer id, Model model) {

        Pacients pacients = pacientsService.getById(id);
        model.addAttribute("pacients", pacients);
        model.addAttribute("apmeklejumi", pacients.getApmeklejumi());

        return "showPacients";
    }

    //Pievienot pacientu GET
    @RequestMapping(value = {"/editPacients"}, method = RequestMethod.GET)
    public String showAddPacientsPage(Model model) {

        Pacients pacients = new Pacients();
        model.addAttribute("pacients", pacients);

        return "editPacients";
    }

    //Pievienot/rediget pacientu POST
    @RequestMapping(value = {"/editPacients"}, method = RequestMethod.POST)
    public String savePacients(@ModelAttribute("pacientsForm") Pacients pacients) {
        pacientsService.save(pacients);

        return "redirect:/showPacients/" + pacients.getId();
    }

    //Rediget pacienta datus GET
    @RequestMapping(value = {"/editPacients/{id}"}, method = RequestMethod.GET)
    public String showUpdatePacientsPage(@PathVariable Integer id, Model model) {
        Pacients pacients = pacientsService.getById(id);
        model.addAttribute("pacients", pacients);

        return "editPacients";
    }

    //Nodzest pacientu
    @RequestMapping(value = {"/deletePacients"}, method = RequestMethod.POST)
    public String deletePacients(@RequestParam Integer id) {
        pacientsService.deleteById(id);
        return "redirect:/pacientsList";
    }
}
