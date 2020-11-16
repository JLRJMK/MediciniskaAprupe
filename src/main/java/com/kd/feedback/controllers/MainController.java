package com.kd.feedback.controllers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.kd.feedback.models.Gim_arsts;
import com.kd.feedback.models.Medmasa;
import com.kd.feedback.models.Pacients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Value("${welcome.message}")
    private String message;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

// Medmasas kontrolleri

    @RequestMapping(value = {"/medmasaList"}, method = RequestMethod.GET)
    public String medmasas(Model model) {
        model.addAttribute("medmasas", Medmasa.medmasas);
        return "medmasaList";
    }

    @RequestMapping(value = {"/addMedmasa"}, method = RequestMethod.GET)
    public String showAddMedmasaPage(Model model) {

        Medmasa medmasa = new Medmasa();
        model.addAttribute("medmasa", medmasa);

        return "addMedmasa";
    }

    @RequestMapping(value = {"/addMedmasa"}, method = RequestMethod.POST)
    public String saveMedmasa(@ModelAttribute("medmasaForm") Medmasa medmasa) {
        Medmasa.medmasas.add(medmasa);

        return "redirect:/medmasaList";
    }

   @RequestMapping(value = {"/deleteMedmasa"}, method = RequestMethod.POST)
    public String deleteMedmasa(@RequestParam Integer id){
        Medmasa.deleteById(id);

        return "redirect:/medmasaList";
    }

    //Pacientu kontrolleri

    @RequestMapping(value = {"/pacientsList"}, method = RequestMethod.GET)
    public String pacienti(Model model){
        model.addAttribute("pacienti", Pacients.pacientsList);

        return "pacientsList";
    }

    //Apmeklejuma kontrolleri

    @RequestMapping(value = {"/apmeklejumiList"}, method = RequestMethod.GET)
    public String apmeklejumi(Model model){
        model.addAttribute("apmeklejumi", Pacients.pacientsList);

        return "pacientsList";
    }



}
