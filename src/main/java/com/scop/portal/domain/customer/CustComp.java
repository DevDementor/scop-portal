package com.scop.portal.domain.customer;

import com.scop.portal.domain.common.CommonVO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CustComp extends CommonVO {

    //고객 회사 아이디
    private String custCompId;

    //고객 회사명
    @NotBlank(message = "고객사 명을 입력해 주세요.")
    private String custCompNm;

    //담당자 명
    @NotBlank(message = "담당자 이름을 입력해 주세요.")
    private String cpsnNm;

    //담당자 전화 번호
    @NotBlank(message = "담당자 연락처를 입력해 주세요.")
    private String cpsnTelNo;

    //고객 회사 메모 내용
    private String custCompMemoCtt;

    //담당장 이메일
    @NotBlank(message = "담당자 이메일을 입력해 주세요.")
    private String cpsnEmail;
}
