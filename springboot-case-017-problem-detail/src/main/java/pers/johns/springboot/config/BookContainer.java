package pers.johns.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import pers.johns.springboot.model.BookRecord;

import java.util.List;

/**
 * ClassName    : BookContainer
 * Description  :
 * CreateTime   : 2024/6/8 15:05
 *
 * @author : JohnS
 * @version : 1.0
 */

@Setter
@Getter
@ConfigurationProperties(prefix = "product")
public class BookContainer {

    private List<BookRecord> books;
}
