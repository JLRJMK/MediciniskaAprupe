package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Pacients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PacientsController {


    @Autowired
    private DataLists dataLists;

    //Pacientu kontrolleri
    //Pacientu saraksts
    @RequestMapping(value = {"/pacientsList"}, method = RequestMethod.GET)
    public String pacienti(Model model) {
        List<Pacients> pacienti = (List<Pacients>) dataLists.pacientsRepository.findAll();

        model.addAttribute("pacienti", pacienti);

        return "pacientsList";
    }

    //Pacienta profils
    @RequestMapping(value = {"/showPacients/{id}"}, method = RequestMethod.GET)
    public String pacients(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pacients", dataLists.pacientsRepository.findById(id).get());
        model.addAttribute("apmeklejumi", DataLists.apmeklejumsList);

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
        dataLists.pacientsRepository.save(pacients);

        return "redirect:/showPacients/" + pacients.getId();
    }

    //Rediget pacienta datus GET
    @RequestMapping(value = {"/editPacients/{id}"}, method = RequestMethod.GET)
    public String showUpdatePacientsPage(@PathVariable Integer id, Model model) {
        Pacients pacients = dataLists.pacientsRepository.findById(id).get();
        model.addAttribute("pacients", pacients);

        return "editPacients";
    }

    //Nodzest pacientu
    @RequestMapping(value = {"/deletePacients"}, method = RequestMethod.POST)
    public String deletePacients(@RequestParam Integer id) {
        Pacients pacients = dataLists.pacientsRepository.findById(id).get();
        dataLists.pacientsRepository.delete(pacients);
        return "redirect:/pacientsList";
    }
}
