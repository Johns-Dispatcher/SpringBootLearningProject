package pers.johns.springboot.model.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * ClassName    : Order
 * Description  :
 * CreateTime   : 2024/6/8 11:06
 *
 * @author : JohnS
 * @version : 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @NotNull(message = "订单名称不能为空")
    private String name;

    @NotNull(message = "商品必须有数量")
    @Range(min = 1, max = 99, message = "商品数量应该在 [{min}, {max}] 区间内")
    private Integer number;

    @NotNull(message = "需要指定用户ID")
    @Min(value = 1, message = "用户ID不能小于1")
    private Integer userId;
}
