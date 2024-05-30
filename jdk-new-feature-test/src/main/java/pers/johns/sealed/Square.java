package pers.johns.sealed;

/**
 * ClassName    : Square
 * Description  : 正方形
 * CreateTime   : 2024/5/30 22:22
 *
 * @author : JohnS
 * @version : 1.0
 */
public final class Square extends Shape{
    private Integer length;

    public Square() {
    }

    public Square(Integer size, Integer length) {
        super(length * length);
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        setSize(length * length);
        this.length = length;
    }

    @Override
    public String toString() {
        return "Square[Size = " + getSize() + ", Length = " + length + "]";
    }
}
