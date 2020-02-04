package com.becypress.service.upiw.member;

import com.becypress.configurator.error.CustomException;
import com.becypress.framework.common.core.AbstractDomainObject;
import com.becypress.toolkit.ObjectUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.yframework.toolkit.StringUtil;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Description: 成员<br>
 * Comments Name: Member<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
public class Member extends AbstractDomainObject
{
    @Column(name = "name")
    private String name; // 成员名称

    @Column(name = "remarks")
    private String remarks; // 成员备注

    public Member(String id)
    {
        this.id = id;
    }

    public boolean exist(final MemberRepository memberRepository)
    {
        Member temp = memberRepository.get(this);
        return ObjectUtil.INSTANCE.exist(this, temp);
    }

    public void verifyId()
    {
        if (StringUtil.isBlank(this.getId()))
        {
            throw new CustomException("成员ID不能为空，请检查请求是否有误");
        }
    }
}