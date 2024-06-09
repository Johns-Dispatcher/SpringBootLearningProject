package pers.johns.springboot.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;
import pers.johns.springboot.model.pojo.Album;

/**
 * InterfaceName : AlbumService
 * Description   :
 * CreateTime    : 2024/6/9 19:39
 *
 * @author : JohnS
 * @version : 1.0
 */

@HttpExchange("https://jsonplaceholder.typicode.com/")
public interface AlbumService {

    @HttpExchange(method = "GET", url = "/albums/{id}")
    Album getById(@PathVariable Integer id);
}
