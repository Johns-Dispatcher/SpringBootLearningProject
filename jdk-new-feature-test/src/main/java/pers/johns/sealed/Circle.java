package pers.johns.sealed;

/**
 * ClassName    : Circle
 * Description  : 长方形
 * CreateTime   : 2024/5/30 22:22
 *
 * @author : JohnS
 * @version : 1.0
 */
public non-sealed class Circle extends Shape{
    private Integer radius;

    public Circle(Integer radius) {
        super(radius * radius);
        this.radius = radius;
    }

    public Circle() {

    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
        setSize(radius * radius);
    }

    @Override
    public String toString() {
        return "Circle[Size = " + getSize() + ", Radius = " + radius + "]";
    }
}
