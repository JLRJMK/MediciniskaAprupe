package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Apmeklejums;
import com.kd.feedback.models.Pacients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApmeklejumsController {

    //Apmeklejuma kontrolleri
    //Apmeklejumu saraksts
    @RequestMapping(value = {"/apmeklejumsList"}, method = RequestMethod.GET)
    public String apmeklejumi(Model model) {
        model.addAttribute("apmeklejumi", DataLists.apmeklejumsList);
        return "apmeklejumsList";
    }

    //Izveidot apmeklejumu GET
    @RequestMapping(value = {"/addApmeklejums"}, method = RequestMethod.GET)
    public String showAddApmeklejumsPage(Model model) {
        Apmeklejums apmeklejums = new Apmeklejums();
        model.addAttribute("apmeklejums", apmeklejums);

        return "addApmeklejums";
    }

    //Izveidot apmeklejumu POST
    @RequestMapping(value = {"/addApmeklejums"}, method = RequestMethod.POST)
    public String saveApmeklejums(@RequestParam Integer id, @ModelAttribute("apmeklejumsForm") Apmeklejums apmeklejums) {
        /*Pacients pacients = Pacients.getById(id);
        System.out.println(id);
        if (pacients != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CREATED);
            apmeklejums.setPacients(Pacients.getById(id));
            apmeklejums.save();
            return "redirect:/showPacients/" + pacients.getId();
        } else{*/
            return "redirect:/notFoundError";
   //     }
    }


    //Nodzest apmeklejumu
    @RequestMapping(value = {"/deleteApmeklejums"}, method = RequestMethod.POST)
    public String deleteApm(@RequestParam Integer id) {
   /*     Apmeklejums apmeklejums = Apmeklejums.getById(id);
        if (apmeklejums != null) {
            apmeklejums.delete();
        } else {
            return "redirect:/notFoundError";
        }
*/
        return "redirect:/apmeklejumsList";
    }


    //Apstiprinat apmeklejumu
    @RequestMapping(value = {"/confirmApm"}, method = RequestMethod.POST)
    public String apstApm(@RequestParam Integer id) throws NullPointerException {

        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        if (apmeklejums != null) {
            apmeklejums.setState(Apmeklejums.STATUS_ACCEPTED);
            apmeklejums.save();
        }

        return "redirect:/apmeklejumsList";
    }

    //Atcelt apmeklejumu
    @RequestMapping(value = {"/undoApm"}, method = RequestMethod.POST)
    public String undoApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        if (apmeklejums != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CREATED);
            apmeklejums.save();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/showMedmasa/{id}";
    }

    //Pabeigt apmeklejumu
    @RequestMapping(value = {"/completeApm"}, method = RequestMethod.POST)
    public String completeApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        if (apmeklejums != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CONFIRMED);
            apmeklejums.save();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/showMedmasa/{id}";
    }
}
