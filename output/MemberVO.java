package com.becypress.service.upiw.member;

import com.becypress.configurator.error.CustomException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.yframework.toolkit.StringUtil;

/**
 * Description: 成员视图对象<br>
 * Comments Name: Member<br>
 * Date: 2020/02/04 20:01:53<br>
 * Author: ysj<br>
 * EditorDate: 2020/02/04 20:01:53<br>
 * Editor: ysj
 */
@ApiModel(value = "成员", description = "成员视图对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO
{
    @ApiModelProperty(value = "成员ID")
    private String id; // 成员ID

    @ApiModelProperty(value = "成员名称")
    private String name; // 成员名称

    @ApiModelProperty(value = "成员备注")
    private String remarks; // 成员备注

    public MemberVO(String id)
    {
        this.id = id;
    }

    public void verifyId()
    {
        if (StringUtil.isBlank(this.getId()))
        {
            throw new CustomException("成员ID不能为空，请检查请求是否有误");
        }
    }
}