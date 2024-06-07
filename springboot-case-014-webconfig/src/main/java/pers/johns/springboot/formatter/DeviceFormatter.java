package pers.johns.springboot.formatter;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;
import pers.johns.springboot.model.pojo.DeviceInfo;

import java.text.ParseException;
import java.util.Locale;
import java.util.StringJoiner;

/**
 * ClassName    : DeviceFormatter
 * Description  :
 * CreateTime   : 2024/6/7 14:56
 *
 * @author : JohnS
 * @version : 1.0
 */
public class DeviceFormatter implements Formatter<DeviceInfo> {

    @Override
    public DeviceInfo parse(String text, Locale locale)
            throws ParseException {
        DeviceInfo deviceInfo = null;
        if (StringUtils.hasLength(text)) {
            String[] items = text.split(";");
            if (items.length >= 5) {
                deviceInfo = new DeviceInfo();
                deviceInfo.setItem1(items[0]);
                deviceInfo.setItem2(items[1]);
                deviceInfo.setItem3(items[2]);
                deviceInfo.setItem4(items[3]);
                deviceInfo.setItem5(items[4]);
            }
        }
        return deviceInfo;
    }

    @Override
    public String print(DeviceInfo object, Locale locale) {
        StringJoiner joiner = new StringJoiner(";");
        joiner
                .add(object.getItem1())
                .add(object.getItem2())
                .add(object.getItem3())
                .add(object.getItem4())
                .add(object.getItem5());
        return joiner.toString();
    }
}
