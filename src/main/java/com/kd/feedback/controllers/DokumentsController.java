package com.kd.feedback.controllers;

import com.kd.feedback.models.Dokuments;
import com.kd.feedback.services.DokumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DokumentsController {

    @Autowired
    private DokumentsService dokumentsService;

    //Dokumentu kontrolleri
    //Dokumentu saraksts
    @RequestMapping(value = {"/dokumentsList"}, method = RequestMethod.GET)
    public String Dokumenti(Model model) {
        List<Dokuments> dokumenti = dokumentsService.all();
        model.addAttribute("dokumenti", dokumenti);
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
        dokumentsService.save(dokuments);

        return "redirect:/dokumentsList";
    }

    //Rediget dokumenta datus GET
    @RequestMapping(value = {"/editDokuments/{id}"}, method = RequestMethod.GET)
    public String showUpdateDokumentsPage(@PathVariable Integer id, Model model) {
        Dokuments dokuments = dokumentsService.getById(id);
        model.addAttribute("dokuments", dokuments);

        return "editDokuments";
    }


    //Nodzest dokumentu
    @RequestMapping(value = {"/deleteDokuments"}, method = RequestMethod.POST)
    public String deleteDokuments(@RequestParam Integer id) {
        dokumentsService.deleteById(id);

        return "redirect:/dokumentsList";
    }
}
