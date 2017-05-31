package com.ssm.controller;

import com.ssm.bean.ModeBean;
import com.ssm.service.ModeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by don on 5/28/17.
 */
@Controller
@RequestMapping(value = "/game")
public class GameController {
    private static Logger logger = LogManager.getLogger();
    @Autowired
    private ModeService modeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView showGame(@PathVariable("id")Integer id){
        ModeBean mode = modeService.getModeById(id);

            System.out.println(mode.getModename());
            System.out.println(mode.getXsize());
            System.out.println(mode.getYsize());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        modelAndView.addObject("mode", mode);

        return modelAndView;
    }
}
