package cn.boc.service.pay.trade.center.channel;

import com.becypress.configurator.error.CustomException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.yframework.toolkit.StringUtil;

/**
 * Description: 渠道视图对象<br>
 * Comments Name: Channel<br>
 * Date: 2019/05/20 15:36:59<br>
 * Author: ysj<br>
 * EditorDate: 2019/05/20 15:36:59<br>
 * Editor: ysj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelVO
{
    private String id; // 渠道ID

    private String name; // 渠道名称

    public ChannelVO(String id)
    {
        this.id = id;
    }

    public void verifyId()
    {
        if (StringUtil.isBlank(this.getId()))
        {
            throw new CustomException("渠道ID不能为空，请检查请求是否有误", HttpStatus.BAD_REQUEST);
        }
    }
}