package cn.boc.service.pay.trade.center.channel;

import com.becypress.configurator.database.mybatis.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

/**
 * Description: ChannelRepository<br>
 * Comments Name: ChannelRepository<br>
 * Date: 2019/05/20 15:36:59<br>
 * Author: ysj<br>
 * EditorDate: 2019/05/20 15:36:59<br>
 * Editor: ysj
 */
@Repository
public class ChannelRepository extends AbstractRepository<Channel, ChannelPersistentMapper>
{
    public ChannelRepository(ChannelPersistentMapper persistentMapper)
    {
        super(persistentMapper);
    }
}