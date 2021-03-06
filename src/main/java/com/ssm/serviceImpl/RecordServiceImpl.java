package com.ssm.serviceImpl;

import com.ssm.bean.RecordBean;
import com.ssm.bean.RecordBeanExample;
import com.ssm.dao.RecordBeanMapper;
import com.ssm.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by don on 6/2/17.
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordBeanMapper recordBeanMapper;

    @Override
    public int insertSelectiveRecord(RecordBean recordBean) {
        return recordBeanMapper.insertSelective(recordBean);
    }

    @Override
    public int deleteRecord(long id) {
        return 0;
    }

    @Override
    public RecordBean getRecordById(long id) {
        return null;
    }

    @Override
    public List<RecordBean> listRecord(Long id) {
        RecordBeanExample example = new RecordBeanExample();
        example.createCriteria().andModeidEqualTo(id);
        return recordBeanMapper.selectByExample(example);
    }

    @Override
    public List<RecordBean> listRecordAsc(Long id) {
        RecordBeanExample example = new RecordBeanExample();
        example.createCriteria().andModeidEqualTo(id);
        example.setOrderByClause("step asc, createDate desc");

        return recordBeanMapper.selectByExample(example);
    }

    @Override
    public int updateRecord(RecordBean recordBean) {
        return 0;
    }
}
