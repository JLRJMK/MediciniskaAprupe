package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Medmasa;
import com.kd.feedback.models.Pacients;
import com.kd.feedback.services.MedmasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedmasaController {

    @Autowired
    private MedmasaService medmasaService;


    // Medmasas kontrolleri
    //Medmasu saraksts
    @RequestMapping(value = {"/medmasaList"}, method = RequestMethod.GET)
    public String medmasas(Model model) {
        List<Medmasa> medmasas = medmasaService.all();
        return "medmasaList";
    }

    //Medmasas profils
    @RequestMapping(value = {"/showMedmasa/{id}"}, method = RequestMethod.GET)
    public String medmasa(@PathVariable("id") Integer id, Model model) {

        Medmasa medmasa = medmasaService.getById(id);
        model.addAttribute("medmasa", medmasa);
        model.addAttribute("apmeklejumi", medmasa.getApmeklejumi());

        return "showMedmasa";
    }

    //Pievienot medmasu GET
    @RequestMapping(value = {"/editMedmasa"}, method = RequestMethod.GET)
    public String showAddMedmasaPage(Model model) {

        Medmasa medmasa = new Medmasa();
        model.addAttribute("medmasa", medmasa);

        return "editMedmasa";
    }

    //Pievienot/redirect medmasu POST
    @RequestMapping(value = {"/editMedmasa"}, method = RequestMethod.POST)
    public String saveMedmasa(@ModelAttribute("medmasaForm") Medmasa medmasa) {
        medmasaService.save(medmasa);

        return "redirect:/showMedmasa/" + medmasa.getId();
    }

    //Rediget medmasas datus GET
    @RequestMapping(value = {"/editMedmasa/{id}"}, method = RequestMethod.GET)
    public String showUpdateMedmasaPage(@PathVariable Integer id, Model model) {
        Medmasa medmasa = medmasaService.getById(id);
        model.addAttribute("medmasa", medmasa);

        return "editMedmasa";
    }

    //Nodzest medmasu
    @RequestMapping(value = {"/deleteMedmasa"}, method = RequestMethod.POST)
    public String deleteMedmasa(@RequestParam Integer id) {
        medmasaService.deleteById(id);

        return "redirect:/medmasaList";
    }
}
