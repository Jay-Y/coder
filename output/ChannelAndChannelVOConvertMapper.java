package cn.boc.service.pay.trade.center.channel;

import com.becypress.framework.common.core.ObjectConvertMapper;
import org.mapstruct.Mapper;

/**
 * Description: ChannelAndChannelVOConvertMapper<br>
 * Comments Name: ChannelAndChannelVOConvertMapper<br>
 * Date: 2019/05/20 15:36:59<br>
 * Author: ysj<br>
 * EditorDate: 2019/05/20 15:36:59<br>
 * Editor: ysj
 */
@Mapper(componentModel = "spring")
public interface ChannelAndChannelVOConvertMapper extends ObjectConvertMapper<Channel, ChannelVO>
{
}
