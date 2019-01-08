package com.chinesefirst.chinese;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FirstController {


    private static List<Cword> cwords = new ArrayList<Cword>();

    static {
        cwords.add(new Cword("天", "sky"));
        cwords.add(new Cword("火", "fire"));
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("cwords", cwords);
        return "list";
    }



}