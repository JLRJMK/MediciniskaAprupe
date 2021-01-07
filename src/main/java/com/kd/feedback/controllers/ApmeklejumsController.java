package com.kd.feedback.controllers;

import com.kd.feedback.models.Apmeklejums;
import com.kd.feedback.models.Pacients;
import com.kd.feedback.services.ApmeklejumsService;
import com.kd.feedback.services.PacientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ApmeklejumsController {

    @Autowired
    private ApmeklejumsService apmeklejumsService;

    @Autowired
    private PacientsService pacientsService;

    //Apmeklejuma kontrolleri
    //Apmeklejumu saraksts
    @RequestMapping(value = {"/apmeklejumsList"}, method = RequestMethod.GET)
    public String apmeklejumi(Model model) {
        List<Apmeklejums> apmeklejumi = apmeklejumsService.all();
        model.addAttribute("apmeklejumi", apmeklejumi);
        return "apmeklejumsList";
    }

    //Izveidot apmeklejumu GET
    @RequestMapping(value = {"/addApmeklejums/{id}"}, method = RequestMethod.GET)
    public String showAddApmeklejumsPage(@PathVariable Integer id, Model model) {
        Apmeklejums apmeklejums = new Apmeklejums();
        apmeklejums.setPacients(pacientsService.getById(id));
        model.addAttribute("apmeklejums", apmeklejums);

        return "addApmeklejums";
    }

    //Izveidot apmeklejumu POST
    @RequestMapping(value = {"/addApmeklejums"}, method = RequestMethod.POST)
    public String saveApmeklejums(@ModelAttribute("apmeklejumsForm") Apmeklejums apmeklejums) {
        Pacients pacients = apmeklejums.getPacients();
        if (pacients != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CREATED);
            apmeklejums.setPacients(pacients);
            apmeklejumsService.save(apmeklejums);
            return "redirect:/showPacients/" + pacients.getId();
        } else{
            return "redirect:/notFoundError";
       }
    }


    //Nodzest apmeklejumu
    @RequestMapping(value = {"/deleteApmeklejums"}, method = RequestMethod.POST)
    public String deleteApm(@RequestParam Integer id) {
        apmeklejumsService.deleteById(id);

        return "redirect:/apmeklejumsList";
    }


    //Apstiprinat apmeklejumu
    @RequestMapping(value = {"/confirmApm"}, method = RequestMethod.POST)
    public String apstApm(@RequestParam Integer id) throws NullPointerException {

        Apmeklejums apmeklejums = apmeklejumsService.getById(id);
        if (apmeklejums != null) {
            apmeklejums.setState(Apmeklejums.STATUS_ACCEPTED);
            apmeklejumsService.save(apmeklejums);
        }

        return "redirect:/apmeklejumsList";
    }

    //Atcelt apmeklejumu
    @RequestMapping(value = {"/undoApm"}, method = RequestMethod.POST)
    public String undoApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = apmeklejumsService.getById(id);
        if (apmeklejums != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CREATED);
            apmeklejumsService.save(apmeklejums);
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/showMedmasa/{id}";
    }

    //Pabeigt apmeklejumu
    @RequestMapping(value = {"/completeApm"}, method = RequestMethod.POST)
    public String completeApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = apmeklejumsService.getById(id);
        if (apmeklejums != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CONFIRMED);
            apmeklejumsService.save(apmeklejums);
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/showMedmasa/{id}";
    }
}
