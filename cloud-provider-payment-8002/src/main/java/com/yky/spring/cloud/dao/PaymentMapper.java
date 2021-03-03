package com.yky.spring.cloud.dao;

import com.yky.spring.cloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
