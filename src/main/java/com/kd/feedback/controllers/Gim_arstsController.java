package com.kd.feedback.controllers;

import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Gim_arsts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Gim_arstsController {

    //Gimenes arsta kontrolleri
    //Gimenes arstu saraksts
    @RequestMapping(value = {"/gim_arstsList"}, method = RequestMethod.GET)
    public String gim_arsti(Model model) {
        model.addAttribute("gim_arsti", DataLists.gim_arstsList);

        return "gim_arstsList";
    }

    //Ģimenes ārsta profils
    @RequestMapping(value = {"/showGim_arsts/{id}"}, method = RequestMethod.GET)
    public String gim_arsts(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("gim_arsts", Gim_arsts.getById(id));
        model.addAttribute("pacienti", DataLists.pacientsList);

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
        gim_arsts.save();

        return "redirect:/showGim_arsts/" + gim_arsts.getId();
    }

    //Rediget pacienta datus GET
    @RequestMapping(value = {"/editGim_arsts/{id}"}, method = RequestMethod.GET)
    public String showUpdateGim_arstsPage(@PathVariable Integer id, Model model) {
        Gim_arsts gim_arsts = Gim_arsts.getById(id);
        model.addAttribute("gim_arsts", gim_arsts);

        return "editGim_arsts";
    }

    //Nodzest gimenes arstu
    @RequestMapping(value = {"/deleteGim_arsts"}, method = RequestMethod.POST)
    public String deleteGim_arsts(@RequestParam Integer id) {
        Gim_arsts gim_arsts = Gim_arsts.getById(id);
        if (gim_arsts != null) {
            gim_arsts.delete();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/gim_arstsList";
    }

}
