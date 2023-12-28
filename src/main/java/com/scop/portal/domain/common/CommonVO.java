package com.scop.portal.domain.common;

import lombok.*;

/**
 * packageName    : com.scop.portal.domain
 * fileName       : CommonVO
 * author         : Mr.Lee
 * date           : 2023-12-22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-22        Mr.Lee      최초 생성
 */

@Getter
@Setter
public class CommonVO {
    private String stmFrstRegDtm;
    private String stmLastModDtm;
    private String stmFrstRegUserId;
    private String stmLastModfUserId;
}
