package com.becypress.service.upiw.member;

import com.becypress.framework.common.core.ObjectConvertMapper;
import org.mapstruct.Mapper;

/**
 * Description: MemberAndMemberVOConvertMapper<br>
 * Comments Name: MemberAndMemberVOConvertMapper<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@Mapper(componentModel = "spring")
public interface MemberAndMemberVOConvertMapper extends ObjectConvertMapper<Member, MemberVO>
{
}
