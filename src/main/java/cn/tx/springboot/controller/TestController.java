package cn.tx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam("pic") MultipartFile file, HttpServletRequest request){
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = "D:/imgup/";
        try{
           this.uploadFile(file.getBytes(), filePath, fileName);
        }catch (Exception e){

        }
        return "success";
    }

    public static void uploadFile(byte[] file,String filePath,String fileName) throws Exception{
            File targetFile = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            out.close();
    }
}
