package com.yky.spring.cloud.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.yky.spring.cloud.domain.Payment;
import com.yky.spring.cloud.dao.PaymentMapper;
import com.yky.spring.cloud.service.PaymentService;

/**
 * @version 1.0
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author YKY
 * @Date 2020/8/7 14:58
 **/

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return paymentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    @Override
    public int insertSelective(Payment record) {
        return paymentMapper.insertSelective(record);
    }

    @Override
    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Payment record) {
        return paymentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        return paymentMapper.updateByPrimaryKey(record);
    }

}
