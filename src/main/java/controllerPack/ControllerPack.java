package controllerPack;
import ca.sheridancollege.midterm.DataBaseAccess.DatabaseAccess;
import ca.sheridancollege.midterm.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ControllerPack {

    @Autowired
    protected DatabaseAccess databaseAccess;

    ModelAndView modelAndView;

    @GetMapping("/")
    public ModelAndView index() {
        modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/addCountry")
    public ModelAndView addNewCountry(HttpSession session) {
        Country country = new Country();
        modelAndView = new ModelAndView("AddCountry", "country", country);
        return modelAndView;
    }

    @PostMapping("/list")
    public ModelAndView countriesList(@ModelAttribute Country country, HttpSession session, @RequestParam int population) {
        country.setPopulation(population);
        int template[] = new int[population];
        int sum = 0;
        for (int i = 0; i < population; i++) {
            sum += template[i];
        }
        country.setPopulation(sum);
        databaseAccess.insertCountry(country);
        return modelAndView;
    }
}
