package cn.handyplus.plugin.enter;

import cn.handyplus.lib.annotation.TableField;
import cn.handyplus.lib.annotation.TableName;
import cn.handyplus.lib.db.enums.IndexEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试类
 *
 * @author handy
 */
@Data
@TableName(value = "test", comment = "这是个测试表注释")
public class Test implements Serializable {

    @TableField(value = "id", comment = "ID")
    private Integer id;

    @TableField(value = "name", comment = "姓名", length = 64, indexEnum = IndexEnum.INDEX)
    private String name;

    @TableField(value = "age", comment = "年龄", length = 3)
    private Integer age;

    @TableField(value = "use_flag", comment = "使用标识")
    private Boolean useFlag;

    @TableField(value = "reg_date", comment = "注册时间")
    private Date regDate;
}
