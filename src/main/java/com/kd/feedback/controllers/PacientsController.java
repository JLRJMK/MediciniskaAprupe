package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Gim_arsts;
import com.kd.feedback.models.Pacients;
import com.kd.feedback.services.Gim_arstsService;
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

    @Autowired
    private Gim_arstsService gim_arstsService;


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
    @RequestMapping(value = {"{id}/editPacients"}, method = RequestMethod.GET)
    public String showAddPacientsPage(@PathVariable Integer id, Model model) {

        Pacients pacients = new Pacients();
        pacients.setGim_arsts(gim_arstsService.getById(id));
        model.addAttribute("pacients", pacients);

        return "editPacients";
    }

    //Pievienot/rediget pacientu POST
    @RequestMapping(value = {"/editPacients"}, method = RequestMethod.POST)
    public String savePacients(@ModelAttribute("pacientsForm") Pacients pacients) {
        Gim_arsts gim_arsts = pacients.getGim_arsts();
        if(gim_arsts != null){
            pacients.setGim_arsts(gim_arsts);
            pacientsService.save(pacients);
            return "redirect:/showPacients/" + pacients.getId();
        }else {
            return "redirect:/notFoundError";
        }
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
