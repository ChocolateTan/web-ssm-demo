package com.ssm.serviceImpl;

import com.ssm.bean.ModeBean;
import com.ssm.bean.ModeBeanExample;
import com.ssm.dao.ModeBeanMapper;
import com.ssm.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by don on 5/28/17.
 */
@Service
public class ModeServiceImpl implements ModeService{

    @Autowired
    private ModeBeanMapper modeBeanMapper;

    @Override
    public int insertSelectiveMode(ModeBean modeBean) {
        return modeBeanMapper.insertSelective(modeBean);
    }

    @Override
    public int deleteMode(long id) {
        ModeBeanExample modeBeanExample = new ModeBeanExample();
        modeBeanExample.createCriteria().andModeidEqualTo(id);
        return modeBeanMapper.deleteByExample(modeBeanExample);
    }

    @Override
    public ModeBean getModeById(long id) {
        return modeBeanMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ModeBean> listMode() {
        return modeBeanMapper.selectByExample(null);
    }

    @Override
    public int updateMode(ModeBean modeBean) {
        return modeBeanMapper.updateByPrimaryKey(modeBean);
    }
}
