package com.example.fundsystembackend.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

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
public class ChinaMutualFundDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer objectId;

    /**
     * Wind代码
     */
    private String fInfoWindCode;

    /**
     * 全称
     */
    private String fInfoFullname;

    private String fInfoFrontCode;

    private String fInfoBackendCode;

    /**
     * 成立时间
     */
    private Time fInfoSetupdate;

    /**
     * 基金经理
     */
    private List<ChinaMutualFundManager> chinaMutualFundManagerList;

    /**
     * 最新单位净值
     */
    private Float newNavUnit;

    /**
     * 最新涨跌幅
     */
    private Float newPercent;


}
