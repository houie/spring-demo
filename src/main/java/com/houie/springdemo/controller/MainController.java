package com.houie.springdemo.controller;

import com.houie.springdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by houie on 7/21/2017.
 */
@Controller
public class MainController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = {"", "/"})
    public ModelAndView getMain(ModelMap model, HttpSession session) {
        return new ModelAndView("main", model);
    }

    @RequestMapping(value = {"/json"})
    public ModelAndView getJson(ModelMap model, HttpSession session) {
        model.put("key", "value");
        model.put("demoService", demoService.getHelloWorld());
        return new ModelAndView("jsonView", model);
    }
}
