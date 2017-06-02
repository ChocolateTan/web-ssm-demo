package com.ssm.controller;

import com.ssm.bean.ModeBean;
import com.ssm.service.ModeService;
import com.ssm.service.RecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by don on 5/28/17.
 */

@Controller
@RequestMapping(value = "/mode")
public class ModeController {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    private ModeService modeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listModes() {
        List<ModeBean> list = modeService.listMode();
        for (int i = 0, size = list.size(); i < size; i++) {
            System.out.println(list.get(i).getModename());
        }
//        logger.info(list.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/game-mode");
        modelAndView.addObject("modeList", list);

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView modeCreate() {
        List<ModeBean> list = modeService.listMode();
        for (int i = 0, size = list.size(); i < size; i++) {
            System.out.println(list.get(i).getModename());
        }
//        logger.info(list.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/game-mode-create");

        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView modeCreatePost(String modeName, int inputX, int inputY,
                                       String color1, String color2, String color3) {
        System.out.println("传递过来的数据:" + inputX + "#" + inputY);
        System.out.println("传递过来的数据:" + color1);
        System.out.println("传递过来的数据:" + color2);
        System.out.println("传递过来的数据:" + color3);

        StringBuilder modeInfo = new StringBuilder();
        modeInfo.append("{");
        modeInfo.append("\"color1\":");
        modeInfo.append(color1);
        modeInfo.append(",");
        modeInfo.append("\"color2\":");
        modeInfo.append(color2);
        modeInfo.append(",");
        modeInfo.append("\"color3\":");
        modeInfo.append(color3);
        modeInfo.append("}");

        ModeBean modeBean = new ModeBean();
        modeBean.setModename(modeName);
//        modeBean.setModeid(99L);
        modeBean.setXsize(inputX);
        modeBean.setYsize(inputY);
        modeBean.setModeinfo(modeInfo.toString());
        modeService.insertSelectiveMode(modeBean);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/game-mode-create");
        return modelAndView;
    }
}
