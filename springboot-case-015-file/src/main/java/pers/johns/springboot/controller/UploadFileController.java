package pers.johns.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ClassName    : UploadFileController
 * Description  :
 * CreateTime   : 2024/6/7 20:47
 *
 * @author : JohnS
 * @version : 1.0
 */

@Controller
public class UploadFileController {

    private static final String RELATIVE_UPLOAD_PATH = "static/upload/";

    @PostMapping("/uploadFile")
    public String uploadFile(
            @RequestParam("uploadFile")
            MultipartFile file,
            Model model
    ) {
        Map<String, Object> info = new HashMap<>();

        try {
            if (!file.isEmpty()) {
                info.put("上传的参数名称", file.getName());
                info.put("文件内容类型", file.getContentType());

                var filename = file.getOriginalFilename();
                info.put("原始文件名称", filename);

                var ext = "unknown";
                if (filename != null && filename.lastIndexOf(".") > 0) {
                    ext = filename.substring(filename.lastIndexOf(".") + 1);
                }
                info.put("文件扩展名", ext);

                var newFilename = UUID.randomUUID().toString() + "." + ext;
                info.put("上传存储的文件名称", newFilename);

                var newFilepath = ResourceUtils.getURL("classpath:").getPath() + RELATIVE_UPLOAD_PATH;

                File newFileDir = new File(newFilepath);
                if (!newFileDir.exists()) {
                    newFileDir.mkdirs();
                }

                newFilepath = newFilepath + newFilename;
                info.put("上传存储的文件路径", newFilepath);

                info.put("文件访问路径", RELATIVE_UPLOAD_PATH + newFilename);

                file.transferTo(new File(newFilepath));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("fileInfo", info);

        return "success";
    }
}
