package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Medmasa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MedmasaController {

    // Medmasas kontrolleri
    //Medmasu saraksts
    @RequestMapping(value = {"/medmasaList"}, method = RequestMethod.GET)
    public String medmasas(Model model) {
        model.addAttribute("medmasas", DataLists.medmasas);
        return "medmasaList";
    }

    //Medmasas profils
    @RequestMapping(value = {"/showMedmasa/{id}"}, method = RequestMethod.GET)
    public String medmasa(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("medmasa", Medmasa.getById(id));
        model.addAttribute("apmeklejumi", DataLists.apmeklejumsList);

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
        medmasa.save();

        return "redirect:/showMedmasa/" + medmasa.getId();
    }

    //Rediget medmasas datus GET
    @RequestMapping(value = {"/editMedmasa/{id}"}, method = RequestMethod.GET)
    public String showUpdateMedmasaPage(@PathVariable Integer id, Model model) {
        Medmasa medmasa = Medmasa.getById(id);
        model.addAttribute("medmasa", medmasa);

        return "editMedmasa";
    }

    //Nodzest medmasu
    @RequestMapping(value = {"/deleteMedmasa"}, method = RequestMethod.POST)
    public String deleteMedmasa(@RequestParam Integer id) {
        Medmasa medmasa = Medmasa.getById(id);
        if (medmasa != null) {
            medmasa.delete();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/medmasaList";
    }
}
