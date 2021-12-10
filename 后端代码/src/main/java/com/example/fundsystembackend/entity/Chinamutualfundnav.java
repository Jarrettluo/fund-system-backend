package com.example.fundsystembackend.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author luojiarui
 * @since 2021-12-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Chinamutualfundnav implements Serializable {

    private static final long serialVersionUID = 1L;

    private String objectId;

    /**
     * Wind代码
     */
    private String fInfoWindCode;

    /**
     * 公告日期
     */
    private LocalDate annDate;

    /**
     * 截至日期
     */
    private LocalDate priceDate;

    /**
     * 单位净值
     */
    private Float fNavUnit;

    /**
     * 累计净值
     */
    private Float fNavAccumulated;


}
