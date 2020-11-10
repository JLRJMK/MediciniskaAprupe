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

@Controller
public class MainController {

    private static final List<Gim_arsts> gim_arstsList = new ArrayList<>();

    static {
        gim_arstsList.add(new Gim_arsts(1, "a", "aa", "aaa", "aaaa"));
        gim_arstsList.add(new Gim_arsts(2, "b", "bb", "bbb", "aaaa"));
    }

    private static final List<Medmasa> medmasas = new ArrayList<>();

    static {
        medmasas.add(new Medmasa(1, "C", "CC    ", "ccc", "cccc"));
        medmasas.add(new Medmasa(2, "d", "dd", "ddd", "dddd"));
    }


    @Value("${welcome.message}")
    private String message;


    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/medmasaList"}, method = RequestMethod.GET)
    public String medmasas(Model model) {
        model.addAttribute("medmasas", medmasas);
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


        medmasa.add(medmasa);

        return "redirect:/medmasaList";
    }

   /* @RequestMapping(value = {"/placeList"}, method = RequestMethod.POST)
    public String deletePlace(List<Medmasa> medmasas){

        Iterator<Place> iterator = places.iterator();
        iterator.remove();
        
        return "placeList";
    }
*/
}
