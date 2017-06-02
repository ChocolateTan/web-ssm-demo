package com.ssm.service;

import com.ssm.bean.RecordBean;

import java.util.List;

/**
 * Created by don on 6/2/17.
 */
public interface RecordService {
    int insertSelectiveRecord(RecordBean recordBean);
    int deleteRecord(long id);
    RecordBean getRecordById(long id);
    List<RecordBean> listRecord();
    List<RecordBean> listRecordAsc();
    int updateRecord(RecordBean recordBean);
}
