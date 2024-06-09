package pers.johns.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.johns.springboot.model.pojo.Album;
import pers.johns.springboot.service.AlbumService;

/**
 * ClassName    : AlbumServiceTest
 * Description  :
 * CreateTime   : 2024/6/9 19:43
 *
 * @author : JohnS
 * @version : 1.0
 */

@SpringBootTest
public class AlbumServiceTest {

    @Autowired
    private AlbumService albumService;

    @Test
    public void testQuery() {
        Album album = albumService.getById(1);
        System.out.println(album);
    }
}
