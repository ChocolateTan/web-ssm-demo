package com.ssm.dao;

import com.ssm.bean.UserBean;
import com.ssm.bean.UserBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBeanMapper {
    long countByExample(UserBeanExample example);

    int deleteByExample(UserBeanExample example);

    int deleteByPrimaryKey(Long userid);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    List<UserBean> selectByExample(UserBeanExample example);

    UserBean selectByPrimaryKey(Long userid);

    int updateByExampleSelective(@Param("record") UserBean record, @Param("example") UserBeanExample example);

    int updateByExample(@Param("record") UserBean record, @Param("example") UserBeanExample example);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}