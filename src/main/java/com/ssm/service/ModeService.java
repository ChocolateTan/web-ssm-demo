package com.ssm.service;

import com.ssm.bean.ModeBean;

import java.util.List;

/**
 * Created by don on 5/28/17.
 */
public interface ModeService {
    int insertSelectiveMode(ModeBean modeBean);
    int deleteMode(long id);
    ModeBean getModeById(long id);
    List<ModeBean> listMode();
    int updateMode(ModeBean modeBean);
}
