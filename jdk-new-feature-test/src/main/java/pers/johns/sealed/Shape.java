package pers.johns.sealed;

/**
 * ClassName    : Shape
 * Description  : 形状
 * CreateTime   : 2024/5/30 22:21
 *
 * @author : JohnS
 * @version : 1.0
 */
public sealed class Shape permits Circle, Square{
    private Integer size;

    public Shape(Integer size) {
        this.size = size;
    }

    public Shape() {
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shape[Size = " + getSize() + "]";
    }
}
