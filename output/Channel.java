package cn.boc.service.pay.trade.center.channel;

import com.becypress.framework.common.core.AbstractDomainObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Description: 渠道<br>
 * Comments Name: Channel<br>
 * Date: 2019/05/20 15:36:59<br>
 * Author: ysj<br>
 * EditorDate: 2019/05/20 15:36:59<br>
 * Editor: ysj
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "channels")
public class Channel extends AbstractDomainObject
{
    @Column(name = "name")
    private String name; // 渠道名称

    @Column(name = "remark")
    private String remark; // 渠道备注

    public Channel(String id)
    {
        this.id = id;
    }
}