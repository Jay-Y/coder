package com.becypress.ext.service.afr.api.v1;

import com.becypress.configurator.database.mybatis.annotation.ConditionalFilterControl;
import com.becypress.configurator.database.mybatis.model.QueryParameterList;
import cn.boc.service.pay.trade.center.channel.Channel;
import cn.boc.service.pay.trade.center.channel.ChannelAndChannelVOConvertMapper;
import cn.boc.service.pay.trade.center.channel.ChannelRepository;
import cn.boc.service.pay.trade.center.channel.ChannelVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.yframework.toolkit.StringUtil;
import org.yframework.toolkit.y;

import java.util.List;

/**
 * Description: 渠道应用服务<br>
 * Comments Name: ChannelApplicationService<br>
 * Date: 2019/05/20 15:36:59<br>
 * Author: ysj<br>
 * EditorDate: 2019/05/20 15:36:59<br>
 * Editor: ysj
 */
@Service
public class ChannelApplicationService
{
    private final ChannelRepository channelRepository;

    private final ChannelAndChannelVOConvertMapper channelAndChannelVOConvertMapper;

    public ChannelApplicationService(ChannelRepository channelRepository, ChannelAndChannelVOConvertMapper channelAndChannelVOConvertMapper)
    {
        this.channelRepository = channelRepository;
        this.channelAndChannelVOConvertMapper = channelAndChannelVOConvertMapper;
    }

    public ChannelVO createChannel(ChannelVO vo)
    {
        Channel channel = this.channelAndChannelVOConvertMapper.o2ToO1(vo);
        this.channelRepository.add(channel);
        return this.channelAndChannelVOConvertMapper.o1ToO2(channel);
    }

    public void deleteChannel(ChannelVO vo)
    {
        vo.verifyId();
        this.channelRepository.remove(new Channel(vo.getId()));
    }

    @ConditionalFilterControl(pointcut = ".*ChannelPersistentMapper.select.*")
    public List<ChannelVO> listChannels(QueryParameterList parameters)
    {
        List<Channel> channels = this.channelRepository.list(new Channel());
        return this.channelAndChannelVOConvertMapper.o1sToO2s(channels);
    }

    @ConditionalFilterControl(pointcut = ".*ChannelPersistentMapper.select.*")
    public Page<ChannelVO> listChannelsOfPage(QueryParameterList parameters, int page, int size, String sort)
    {
        return PageHelper.
                startPage(page, size).
                setOrderBy(sort).
                doSelectPage(() -> this.listChannels(parameters));
    }

    public void replaceChannel(ChannelVO vo)
    {
        vo.verifyId();
        Channel channel = this.channelAndChannelVOConvertMapper.o2ToO1(vo);
        this.channelRepository.replace(channel);
    }

    public void updateChannel(ChannelVO vo)
    {
        vo.verifyId();
        Channel channel = this.channelAndChannelVOConvertMapper.o2ToO1(vo);
        this.channelRepository.update(channel);
    }
}
