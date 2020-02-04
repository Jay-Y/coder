package com.becypress.service.example.api.v1;

import com.becypress.framework.common.api.BasicDomainRestController;
import com.becypress.service.upiw.member.Member;
import com.becypress.service.upiw.member.MemberAndMemberVOConvertMapper;
import com.becypress.service.upiw.member.MemberVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 成员相关接口控制器<br>
 * Comments Name: MemberController<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@Api(tags = "Member", description = "成员相关接口")
@RestController
@RequestMapping(value = "/api/v1/members")
@Slf4j
public class MemberController extends BasicDomainRestController<Member, MemberVO, MemberApplicationService, MemberAndMemberVOConvertMapper>
{
    public MemberController(MemberApplicationService memberApplicationService, MemberAndMemberVOConvertMapper memberAndMemberVOConvertMapper)
    {
        super(memberApplicationService, memberAndMemberVOConvertMapper);
    }
}
