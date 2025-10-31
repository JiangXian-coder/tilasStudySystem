package com.jiangxian.controller;

import com.jiangxian.pojo.Result;
import com.jiangxian.utils.AliyunOssOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    //注入阿里云对象
    @Autowired
    private AliyunOssOperator aliyunOssOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.warn("上传文件：{}", file);
        if(!file.isEmpty()) {
            //生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString().
                    replace("-", "") + extName;
            String url = aliyunOssOperator.upload(file.getBytes(), uniqueFileName);
            return Result.success(url);
        }
        return Result.error("上传失败");
    }
}
