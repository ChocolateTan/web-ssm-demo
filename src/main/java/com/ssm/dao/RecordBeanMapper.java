package com.ssm.dao;

import com.ssm.bean.RecordBean;
import com.ssm.bean.RecordBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecordBeanMapper {
    long countByExample(RecordBeanExample example);

    int deleteByExample(RecordBeanExample example);

    int insert(RecordBean record);

    int insertSelective(RecordBean record);

    List<RecordBean> selectByExample(RecordBeanExample example);

    int updateByExampleSelective(@Param("record") RecordBean record, @Param("example") RecordBeanExample example);

    int updateByExample(@Param("record") RecordBean record, @Param("example") RecordBeanExample example);
}