package pers.johns.record;

import pers.johns.record.print.Printable;

import java.util.StringJoiner;

/**
 * RecordName   : Product
 * Description  :
 * CreateTime   : 2024/5/30 13:21
 *
 * @author : JohnS
 * @version : 1.0
 */
public record Product(Integer id, String name) implements Printable {
    @Override
    public void print() {
        StringJoiner joiner = new StringJoiner("-");
        System.out.println(joiner.add(id.toString()).add(name));
    }
}
