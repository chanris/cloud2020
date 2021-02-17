package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyue7@foxmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    /*产品id*/
    private Long productId;
    /*总库存*/
    private Integer total;
    /*已用*/
    private Integer used;
    /*剩余*/
    private Integer residue;
}
