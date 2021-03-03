package com.yky.spring.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @ClassName Payment
 * @Description TODO
 * @Author YKY
 * @Date 2020/8/7 14:21
 **/
@Data
@Builder
/**
 * 全参
 */
@AllArgsConstructor
/**
 * 空参
 */
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;

    private static final long serialVersionUID = 1L;
}
