package com.becypress.ext.service.afr.api.v1;

import cn.boc.service.pay.trade.center.channel.ChannelVO;
import com.becypress.framework.common.api.BaseRestController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: 渠道相关接口控制器<br>
 * Comments Name: ChannelController<br>
 * Date: 2019/05/20 15:36:59<br>
 * Author: ysj<br>
 * EditorDate: 2019/05/20 15:36:59<br>
 * Editor: ysj
 */
@Api(tags = "Channels", description = "渠道相关接口")
@RestController
@RequestMapping(value = "/api/v1/channels")
@Slf4j
public class ChannelController extends BaseRestController
{
    private final ChannelApplicationService channelApplicationService;

    public ChannelController(ChannelApplicationService channelApplicationService)
    {
        this.channelApplicationService = channelApplicationService;
    }

    @ApiOperation("创建渠道")
    @PostMapping
    public ResponseEntity<ChannelVO> createChannel(@RequestBody ChannelVO vo)
    {
        return this.created(this.channelApplicationService.createChannel(vo));
    }

    @ApiOperation("删除渠道")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable String id)
    {
        this.channelApplicationService.deleteChannel(new ChannelVO(id));
        return this.deleted();
    }

    @ApiOperation("获取渠道列表")
    @GetMapping
    public ResponseEntity<List<ChannelVO>> listChannels()
    {
        return this.ok(this.channelApplicationService.listChannels(null));
    }

    @ApiOperation("获取渠道分页列表（指定分页信息，可选过滤条件）")
    @GetMapping(value = "/page")
    public ResponseEntity<PageInfo> listChannelsOfPage(@RequestParam(required = false) String query, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id desc") String sort)
    {
        return this.ok(this.channelApplicationService.listChannelsOfPage(y.util().json().jsonToObject(query, QueryParameterList.class), page, size, sort).toPageInfo());
    }

    @ApiOperation("更替渠道")
    @PutMapping
    public ResponseEntity<Void> replaceChannel(@RequestBody ChannelVO vo)
    {
        this.channelApplicationService.replaceChannel(vo);
        return this.created();
    }

    @ApiOperation("修改渠道（指定渠道ID）")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateChannelById(@PathVariable String id, @RequestBody ChannelVO vo)
    {
        vo.setId(id);
        this.channelApplicationService.updateChannel(vo);
        return this.created();
    }

    @ApiOperation("修改渠道")
    @PatchMapping
    public ResponseEntity<Void> updateChannel(@RequestBody ChannelVO vo)
    {
        this.channelApplicationService.updateChannel(vo);
        return this.created();
    }
}
