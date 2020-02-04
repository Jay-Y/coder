package com.becypress.service.upiw.member;

import com.becypress.configurator.database.mybatis.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

/**
 * Description: MemberRepository<br>
 * Comments Name: MemberRepository<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@Repository
public class MemberRepository extends AbstractRepository<Member, MemberPersistentMapper>
{
    public MemberRepository(MemberPersistentMapper persistentMapper)
    {
        super(persistentMapper);
    }
}