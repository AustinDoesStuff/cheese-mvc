package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by austindoesstuff on 3/9/17.
 */
@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "A List of Mah Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeese(Model model){
        model.addAttribute("title", "Add Cheese Plz");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheese(@RequestParam String cheeseName){
        cheeses.add(cheeseName);
        return "redirect:";
    }

}
