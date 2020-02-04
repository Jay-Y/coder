package com.becypress.service.example.api.v1;

import com.becypress.framework.common.api.BasicDomainApplicationService;
import com.becypress.service.upiw.member.Member;
import com.becypress.service.upiw.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 成员应用服务<br>
 * Comments Name: MemberApplicationService<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@Service
public class MemberApplicationService extends BasicDomainApplicationService<Member, MemberRepository>
{
    public MemberApplicationService(MemberRepository memberRepository)
    {
        super(memberRepository);
    }
}
