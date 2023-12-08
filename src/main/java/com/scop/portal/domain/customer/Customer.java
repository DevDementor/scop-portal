package com.scop.portal.domain.customer;

import lombok.Data;

/**
 * packageName    : com.scop.portal.domain.customer
 * fileName       : Customer
 * author         : Mr.Lee
 * date           : 2023-12-05
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-05        Mr.Lee      최초 생성
 */
@Data
public class Customer {
    private String id;
    private String name;
    private String createTime;
}
