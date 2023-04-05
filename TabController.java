package com.example.lab12.controllers;

import com.example.lab12.beans.Logic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TabController {
    private Logic logic;


    @PostMapping("tabulate")
    public String tabulate( @RequestParam double a,@RequestParam double begin, @RequestParam double end, @RequestParam double step, Model model){
        logic.fillPoints(a,begin,end,step);
        model.addAttribute("points",logic.getPoints());
        model.addAttribute("maxYNumber",logic.findMaxY());
        model.addAttribute("maxYIndex",logic.findMaxYIndex());
        model.addAttribute("maxNumber",logic.findMaxX());
        model.addAttribute("minYNumber",logic.findMinY());
        model.addAttribute("minYIndex",logic.findMinYIndex());
        model.addAttribute("minNumber",logic.findMinX());
        model.addAttribute("sum",logic.sum());
        model.addAttribute("average",logic.average());
        return "result";
    }

}