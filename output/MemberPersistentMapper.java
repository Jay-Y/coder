package com.becypress.service.upiw.member;

import com.becypress.configurator.database.mybatis.mapper.EntityPersistentMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description: MemberPersistentMapper<br>
 * Comments Name: MemberPersistentMapper<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@Mapper
public interface MemberPersistentMapper extends EntityPersistentMapper<Member>
{
}
