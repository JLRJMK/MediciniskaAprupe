package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Apmeklejums;
import com.kd.feedback.models.Gim_arsts;
import com.kd.feedback.models.Medmasa;
import com.kd.feedback.models.Pacients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    //Medmasu saraksts
    @RequestMapping(value = {"/medmasaList"}, method = RequestMethod.GET)
    public String medmasas(Model model) {
        model.addAttribute("medmasas", DataLists.medmasas);
        return "medmasaList";
    }

    //Pievienot medmasu GET
    @RequestMapping(value = {"/addMedmasa"}, method = RequestMethod.GET)
    public String showAddMedmasaPage(Model model) {

        Medmasa medmasa = new Medmasa();
        model.addAttribute("medmasa", medmasa);

        return "addMedmasa";
    }

    //Pievienot medmasu POST
    @RequestMapping(value = {"/addMedmasa"}, method = RequestMethod.POST)
    public String saveMedmasa(@ModelAttribute("medmasaForm") Medmasa medmasa) {
        DataLists.medmasas.add(medmasa);

        return "redirect:/medmasaList";
    }

    //Nodzest medmasu
    @RequestMapping(value = {"/deleteMedmasa"}, method = RequestMethod.POST)
    public String deleteMedmasa(@RequestParam Integer id) {
        Medmasa medmasa = Medmasa.getById(id);
        medmasa.delete();

        return "redirect:/medmasaList";
    }

    //Pacientu kontrolleri
    //Pacientu saraksts
    @RequestMapping(value = {"/pacientsList"}, method = RequestMethod.GET)
    public String pacienti(Model model) {
        model.addAttribute("pacienti", DataLists.pacientsList);

        return "pacientsList";
    }

    //Pacienta profils
    @RequestMapping(value = {"/showPacients/{id}"}, method = RequestMethod.GET)
    public String pacients(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("pacients", Pacients.getById(id));
        model.addAttribute("apmeklejumi", DataLists.apmeklejumsList);

        return "showPacients";
    }

    //Pievienot pacientu GET
    @RequestMapping(value = {"/addPacients"}, method = RequestMethod.GET)
    public String showAddPacientsPage(Model model) {

        Pacients pacients = new Pacients();
        model.addAttribute("pacients", pacients);

        return "addPacients";
    }

    //Pievienot pacientu POST
    @RequestMapping(value = {"/addPacients"}, method = RequestMethod.POST)
    public String savePacients(@ModelAttribute("pacientsForm") Pacients pacients) {
        DataLists.pacientsList.add(pacients);

        return "redirect:/pacientsList";
    }

    //Nodzest pacientu
    @RequestMapping(value = {"/deletePacients"}, method = RequestMethod.POST)
    public String deletePacients(@RequestParam Integer id) {
        Pacients pacients = Pacients.getById(id);
        pacients.delete();

        return "redirect:/pacientsList";
    }

    //Gimenes arsta kontrolleri
    //Gimenes arstu saraksts
    @RequestMapping(value = {"/gim_arstsList"}, method = RequestMethod.GET)
    public String gim_arsti(Model model) {
        model.addAttribute("gim_arsti", DataLists.gim_arstsList);

        return "gim_arstsList";
    }

    //Pievienot gimenes arstu GET
    @RequestMapping(value = {"/addGim_arsts"}, method = RequestMethod.GET)
    public String showAddGim_arstsPage(Model model) {

        Gim_arsts gim_arsts = new Gim_arsts();
        model.addAttribute("gim_arsts", gim_arsts);

        return "addGim_arsts";
    }

    //Pievienot gimenes arstu POST
    @RequestMapping(value = {"/addGim_Arsts"}, method = RequestMethod.POST)
    public String saveGim_arsts(@ModelAttribute("gim_arstsForm") Gim_arsts gim_arsts) {
        DataLists.gim_arstsList.add(gim_arsts);

        return "redirect:/gim_arstsList";
    }

    //Nodzest gimenes arstu
    @RequestMapping(value = {"/deleteGim_arsts"}, method = RequestMethod.POST)
    public String deleteGim_arsts(@RequestParam Integer id) {
        Gim_arsts gim_arsts = Gim_arsts.getById(id);
        gim_arsts.delete();

        return "redirect:/gim_arstsList";
    }


    //Apmeklejuma kontrolleri
    //Apmeklejumu saraksts
    @RequestMapping(value = {"/apmeklejumsList"}, method = RequestMethod.GET)
    public String apmeklejumi(Model model) {
        model.addAttribute("apmeklejumi", DataLists.apmeklejumsList);
        return "apmeklejumsList";
    }

    //Nodzest apmeklejumu
    @RequestMapping(value = {"/deleteApmeklejums"}, method = RequestMethod.POST)
    public String deleteApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        apmeklejums.delete();

        return "redirect:/apmeklejumsList";
    }


    //Apstiprinat apmeklejumu
    @RequestMapping(value = {"/confirmApm"}, method = RequestMethod.POST)
    public String apstApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        apmeklejums.setState(Apmeklejums.STATUS_ACCEPTED);
        apmeklejums.save();

        return "redirect:/apmeklejumsList";
    }

    //Atcelt apmeklejumu
    @RequestMapping(value = {"/undoApm"}, method = RequestMethod.POST)
    public String undoApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        apmeklejums.setState(Apmeklejums.STATUS_CREATED);
        apmeklejums.save();

        return "redirect:/showMedmasa";
    }

    //Pabeigt apmeklejumu
    @RequestMapping(value = {"/completeApm"}, method = RequestMethod.POST)
    public String completeApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        apmeklejums.setState(Apmeklejums.STATUS_CONFIRMED);
        apmeklejums.save();

        return "redirect:/showMedmasa";
    }


}
