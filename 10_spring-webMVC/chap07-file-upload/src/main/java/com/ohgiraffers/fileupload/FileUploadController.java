package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    private ResourceLoader resourceLoader;

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile, String singleFileDescription, Model model) throws IOException {
        System.out.println("singlefile : " + singleFile);
        System.out.println("singleFileDescription : " + singleFileDescription);

        Resource resource = resourceLoader.getResource("classpath:static/img/single"); // 이 경로를 저장해서 넣음
        String filePath = null;
        if(!resource.exists()) {
            String root = "src/main/resources/static/img/single"; // 위에서 저장한 경로가 존재하지 않으면 root에 넣어줌
            File file = new File(root);
            file.mkdirs(); // mk는 make directory -> 그래서 처음 실행했을땐 resources/static에 아무것도 없다가 폴더가 만들어짐
            filePath = file.getAbsolutePath();
        } else {
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath(); // 저장할 위치를 filePath에 가지고옴
        }

        String originalFileName = singleFile.getOriginalFilename(); // 원본이름.png
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".")); // .부터 가져오니까 .png(확장자를 가져옴)
        String savedName = UUID.randomUUID().toString().replace("-","") + ext; // 랜덤한 패턴으로 ce-077-b6g-wklwelek-werwfs 이런식으로 만들어진걸 -을 제거하고 위에서 만든 확장자를 붙임

        try {
            singleFile.transferTo(new File(filePath+"/"+savedName));
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("img","static/img/single/"+savedName);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패");
        }

        return "result";
    }

    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
                                  String multiFileDescription, Model model) throws IOException {
        System.out.println("multifile : " + multiFileDescription);
        System.out.println("multiFileDescription : " + multiFileDescription);

        Resource resource = resourceLoader.getResource("classpath:static/img/multi");
        String filePath = null;

        if(!resource.exists()) {
            String root = "src/main/resources/static/img/multi";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();
        } else {
            filePath = resourceLoader.getResource("classpath:static/img/multi").getFile().getAbsolutePath();
        }
        System.out.println("multi : " + filePath);

        List<FileDTO> files = new ArrayList<>();
        List<String> saveFiles = new ArrayList<>();

        // 저장하다 실패했을때를 생각한 로직인데 성능을 생각해서 Redis 같은거 안에서 캐싱하는 방법 있음
        try {
            for (MultipartFile multipartFile : multiFiles) {
                String originFileName = multipartFile.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-","") + ext;

                files.add(new FileDTO(originFileName, savedName, filePath, multiFileDescription));
                multipartFile.transferTo(new File(filePath + "/" + savedName));
                saveFiles.add("static/img/multi" + savedName);
            }
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("imgs", saveFiles);
        } catch (Exception e) {
            e.printStackTrace();
            for (FileDTO fileDTO : files) {
                new File(filePath + "/" + fileDTO.getSavedName()).delete();
            }
            model.addAttribute("message", "파일 업로드 실패!");
        }
        return "result";
    }
}
