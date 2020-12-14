package com.kd.feedback.controllers;
import com.kd.feedback.data.DataLists;
import com.kd.feedback.models.Apmeklejums;
import com.kd.feedback.models.Gim_arsts;
import com.kd.feedback.models.Medmasa;
import com.kd.feedback.models.Pacients;
import com.kd.feedback.models.Dokuments;
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


}
