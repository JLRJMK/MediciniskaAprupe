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

    // Medmasas kontrolleri
    //Medmasu saraksts
    @RequestMapping(value = {"/medmasaList"}, method = RequestMethod.GET)
    public String medmasas(Model model) {
        model.addAttribute("medmasas", DataLists.medmasas);
        return "medmasaList";
    }

    //Medmasas profils
    @RequestMapping(value = {"/showMedmasa/{id}"}, method = RequestMethod.GET)
    public String medmasa(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("medmasa", Medmasa.getById(id));
        model.addAttribute("apmeklejumi", DataLists.apmeklejumsList);

        return "showMedmasa";
    }

    //Pievienot medmasu GET
    @RequestMapping(value = {"/editMedmasa"}, method = RequestMethod.GET)
    public String showAddMedmasaPage(Model model) {

        Medmasa medmasa = new Medmasa();
        model.addAttribute("medmasa", medmasa);

        return "editMedmasa";
    }

    //Pievienot/redirect medmasu POST
    @RequestMapping(value = {"/editMedmasa"}, method = RequestMethod.POST)
    public String saveMedmasa(@ModelAttribute("medmasaForm") Medmasa medmasa) {
        medmasa.save();

        return "redirect:/showMedmasa/" + medmasa.getId();
    }

    //Rediget medmasas datus GET
    @RequestMapping(value = {"/editMedmasa/{id}"}, method = RequestMethod.GET)
    public String showUpdateMedmasaPage(@PathVariable Integer id, Model model) {
        Medmasa medmasa = Medmasa.getById(id);
        model.addAttribute("medmasa", medmasa);

        return "editMedmasa";
    }

    //Nodzest medmasu
    @RequestMapping(value = {"/deleteMedmasa"}, method = RequestMethod.POST)
    public String deleteMedmasa(@RequestParam Integer id) {
        Medmasa medmasa = Medmasa.getById(id);
        if (medmasa != null) {
            medmasa.delete();
        } else {
            return "redirect:/notFoundError";
        }

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
    @RequestMapping(value = {"/editPacients"}, method = RequestMethod.GET)
    public String showAddPacientsPage(Model model) {

        Pacients pacients = new Pacients();
        model.addAttribute("pacients", pacients);

        return "editPacients";
    }

    //Pievienot/rediget pacientu POST
    @RequestMapping(value = {"/editPacients"}, method = RequestMethod.POST)
    public String savePacients(@ModelAttribute("pacientsForm") Pacients pacients) {
        pacients.save();

        return "redirect:/showPacients/" + pacients.getId();
    }

    //Rediget pacienta datus GET
    @RequestMapping(value = {"/editPacients/{id}"}, method = RequestMethod.GET)
    public String showUpdatePacientsPage(@PathVariable Integer id, Model model) {
        Pacients pacients = Pacients.getById(id);
        model.addAttribute("pacients", pacients);

        return "editPacients";
    }

    //Nodzest pacientu
    @RequestMapping(value = {"/deletePacients"}, method = RequestMethod.POST)
    public String deletePacients(@RequestParam Integer id) {
        Pacients pacients = Pacients.getById(id);
        if (pacients != null) {
            pacients.delete();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/pacientsList";
    }

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
        Pacients pacients = Pacients.getById(id);
        System.out.println(id);
        if (pacients != null) {
            apmeklejums.setState(Apmeklejums.STATUS_CREATED);
            apmeklejums.setPacients(Pacients.getById(id));
            apmeklejums.save();
            return "redirect:/showPacients/" + pacients.getId();
        } else{
            return "redirect:/notFoundError";
        }
    }


    //Nodzest apmeklejumu
    @RequestMapping(value = {"/deleteApmeklejums"}, method = RequestMethod.POST)
    public String deleteApm(@RequestParam Integer id) {
        Apmeklejums apmeklejums = Apmeklejums.getById(id);
        if (apmeklejums != null) {
            apmeklejums.delete();
        } else {
            return "redirect:/notFoundError";
        }

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

    //Dokumentu kontrolleri
    //Dokumentu saraksts
    @RequestMapping(value = {"/dokumentsList"}, method = RequestMethod.GET)
    public String Dokumenti(Model model) {
        model.addAttribute("dokumenti", DataLists.dokumentsList);
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
        dokuments.save();

        return "redirect:/dokumentsList";
    }

    //Rediget dokumenta datus GET
    @RequestMapping(value = {"/editDokuments/{id}"}, method = RequestMethod.GET)
    public String showUpdateDokumentsPage(@PathVariable Integer id, Model model) {
        Dokuments dokuments = Dokuments.getById(id);
        model.addAttribute("dokuments", dokuments);

        return "editDokuments";
    }


    //Nodzest dokumentu
    @RequestMapping(value = {"/deleteDokuments"}, method = RequestMethod.POST)
    public String deleteDokuments(@RequestParam Integer id) {
        Dokuments dokuments = Dokuments.getById(id);
        if (dokuments != null) {
            dokuments.delete();
        } else {
            return "redirect:/notFoundError";
        }

        return "redirect:/dokumentsList";
    }

}
