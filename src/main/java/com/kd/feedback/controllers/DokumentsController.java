package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Dokuments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DokumentsController {

    //Dokumentu kontrolleri
    //Dokumentu saraksts
    @RequestMapping(value = {"/dokumentsList"}, method = RequestMethod.GET)
    public String Dokumenti(Model model) {
        model.addAttribute("dokumenti", DataLists.dokumentsList);
        return "dokumentsList";
    }
    //Pievienot dokumentu GET
    @RequestMapping(value = {"/editDokuments"}, method = RequestMethod.GET)
    public String showaddDokumentsPage(Model model) {

        Dokuments dokuments = new Dokuments();
        model.addAttribute("dokuments", dokuments);

        return "editDokuments";
    }

    //Pievienot/rediget dokumentu POST
    @RequestMapping(value = {"/editDokuments"}, method = RequestMethod.POST)
    public String saveDokuments(@ModelAttribute("dokumentsForm") Dokuments dokuments) {
        dokuments.save();

        return "redirect:/dokumentsList";
    }

    //Rediget dokumenta datus GET
    @RequestMapping(value = {"/editDokuments/{id}"}, method = RequestMethod.GET)
    public String showUpdateDokumentsPage(@PathVariable Integer id, Model model) {
        Dokuments dokuments = Dokuments.getById(id);
        model.addAttribute("dokuments", dokuments);

        return "editDokuments";
    }


    //Nodzest dokumentu
    @RequestMapping(value = {"/deleteDokuments"}, method = RequestMethod.POST)
    public String deleteDokuments(@RequestParam Integer id) {
        Dokuments dokuments = Dokuments.getById(id);
        if (dokuments != null) {
            dokuments.delete();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/dokumentsList";
    }
}
