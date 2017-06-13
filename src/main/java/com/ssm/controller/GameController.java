package com.ssm.controller;

import com.ssm.bean.ModeBean;
import com.ssm.bean.RecordBean;
import com.ssm.service.ModeService;
import com.ssm.service.RecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by don on 5/28/17.
 */
@Controller
@RequestMapping(value = "/game")
public class GameController {
    private static Logger logger = LogManager.getLogger();
    @Autowired
    private ModeService modeService;

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView showGame(@PathVariable("id") Integer id) {
        ModeBean mode = modeService.getModeById(id);
        List<RecordBean> recordList = recordService.listRecordAsc(Long.valueOf(id));

        System.out.println(mode.getModename());
        System.out.println(mode.getXsize());
        System.out.println(mode.getYsize());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        modelAndView.addObject("mode", mode);
        modelAndView.addObject("recordList", recordList);

        return modelAndView;
    }

    @RequestMapping(value = "/submitGameResult", method = RequestMethod.POST)
    public ModelAndView submitGameResult(String modeId, String name, String step) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");

        System.out.println(modeId);
        System.out.println(name);
        System.out.println(step);

        RecordBean recordBean = new RecordBean();
        recordBean.setRecordname(name);
        recordBean.setModeid(Long.parseLong(modeId));
        recordBean.setStep(Integer.parseInt(step));
        recordService.insertSelectiveRecord(recordBean);

        return modelAndView;
    }
}
