package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Gim_arsts;
import com.kd.feedback.services.Gim_arstsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
public class Gim_arstsController {

    @Autowired
    private Gim_arstsService gim_arstsService;

    //Gimenes arsta kontrolleri
    //Gimenes arstu saraksts
    @RequestMapping(value = {"/gim_arstsList"}, method = RequestMethod.GET)
    public String gim_arsti(Model model) {
        List<Gim_arsts> gim_arsti = gim_arstsService.all();
        model.addAttribute("gim_arsti", gim_arsti);

        return "gim_arstsList";
    }

    //Ģimenes ārsta profils
    @RequestMapping(value = {"/showGim_arsts/{id}"}, method = RequestMethod.GET)
    public String gim_arsts(@PathVariable("id") Integer id, Model model) {

        Gim_arsts gim_arsts = gim_arstsService.getById(id);
        model.addAttribute("gim_arsts", gim_arsts);
        model.addAttribute("pacienti", gim_arsts.getPacienti());

        return "showGim_arsts";
    }

    //Pievienot gimenes arstu GET
    @RequestMapping(value = {"/editGim_arsts"}, method = RequestMethod.GET)
    public String showAddGim_arstsPage(Model model) {

        Gim_arsts gim_arsts = new Gim_arsts();
        model.addAttribute("gim_arsts", gim_arsts);

        return "editGim_arsts";
    }

    //Pievienot/rediget gimenes arstu POST
    @RequestMapping(value = {"/editGim_arsts"}, method = RequestMethod.POST)
    public String saveGim_arsts(@ModelAttribute("gim_arstsForm") Gim_arsts gim_arsts) {
        gim_arstsService.save(gim_arsts);

        return "redirect:/showGim_arsts/" + gim_arsts.getId();
    }

    //Rediget pacienta datus GET
    @RequestMapping(value = {"/editGim_arsts/{id}"}, method = RequestMethod.GET)
    public String showUpdateGim_arstsPage(@PathVariable Integer id, Model model) {
        Gim_arsts gim_arsts = gim_arstsService.getById(id);
        model.addAttribute("gim_arsts", gim_arsts);

        return "editGim_arsts";
    }

    //Nodzest gimenes arstu
    @RequestMapping(value = {"/deleteGim_arsts"}, method = RequestMethod.POST)
    public String deleteGim_arsts(@RequestParam Integer id) {
        gim_arstsService.deleteById(id);

        return "redirect:/gim_arstsList";
    }

}
