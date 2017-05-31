package com.ssm.dao;

import com.ssm.bean.ModeBean;
import com.ssm.bean.ModeBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModeBeanMapper {
    long countByExample(ModeBeanExample example);

    int deleteByExample(ModeBeanExample example);

    int deleteByPrimaryKey(Long modeid);

    int insert(ModeBean record);

    int insertSelective(ModeBean record);

    List<ModeBean> selectByExampleWithBLOBs(ModeBeanExample example);

    List<ModeBean> selectByExample(ModeBeanExample example);

    ModeBean selectByPrimaryKey(Long modeid);

    int updateByExampleSelective(@Param("record") ModeBean record, @Param("example") ModeBeanExample example);

    int updateByExampleWithBLOBs(@Param("record") ModeBean record, @Param("example") ModeBeanExample example);

    int updateByExample(@Param("record") ModeBean record, @Param("example") ModeBeanExample example);

    int updateByPrimaryKeySelective(ModeBean record);

    int updateByPrimaryKeyWithBLOBs(ModeBean record);

    int updateByPrimaryKey(ModeBean record);
}