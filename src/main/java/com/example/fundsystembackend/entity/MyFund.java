package com.example.fundsystembackend.entity;

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
public class MyFund implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String fundId;


}
