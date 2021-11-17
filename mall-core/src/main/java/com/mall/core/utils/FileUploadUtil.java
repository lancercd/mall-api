package com.mall.core.utils;

import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FileUploadUtil {

    /**
     * 文件存放的目录
     */
    public static String BASE_PATH = null;

    private static final String EMPTY_STRING = "";


    /**
     * 随机文件名 不包含拓展名
     * @return RandomFileName
     */
    private static String getRandomFileName(){
        return String.valueOf(UUID.randomUUID());
    }


    /**
     * 获取上传图片上传文件夹的目录
     * @return String
     * @throws FileNotFoundException
     */
    private static String getPath() throws FileNotFoundException {
        if(BASE_PATH == null){
            BASE_PATH = ResourceUtils.getURL("classpath:").getPath() + "static/upload/";

            File directory = new File(BASE_PATH);

            if (directory.exists()) {
                if (!directory.isDirectory()) {
                    throw new RuntimeException("File " + directory + " exists and is not a directory. Unable to create directory.");
                }
            }else if(!directory.mkdirs() && !directory.isDirectory()) {
                throw new RuntimeException("File " + directory + " exists and is " + "not a directory. Unable to create directory.");
            }
        }
        return BASE_PATH;
    }

    /**
     * 获取文件名后缀
     * @param originalFilename 文件名
     * @return 后缀名
     */
    private static String getFileSuffix(String originalFilename) {
        if (originalFilename == null) {
            return EMPTY_STRING;
        }
        int index = originalFilename.lastIndexOf('.');
        return index > -1? originalFilename.substring(index) : EMPTY_STRING;
    }

    /**
     * 获取文件MediaType (仅限图片)
     * @param originalFilename 文件名
     * @return String
     */
    public static String getMediaType(String originalFilename) {
        String fileSuffix = getFileSuffix(originalFilename);
        switch(fileSuffix) {
            case ".jpg":
            case ".jpeg":
            case ".jfif":
                return "image/jpeg";
            case ".gif":
                return "image/gif";
            case ".png":
                return "image/png";
            case ".ico":
                return "image/x-icon";
            case ".svg":
                return "image/svg+xml";
            case ".tiff":
                return "image/tiff";
            default:
                return EMPTY_STRING;

        }
    }

    /**
     * 图片保存
     * @param file MultipartFile
     * @return url
     * @throws Exception
     */
    public static String save(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        String fileSuffix = getFileSuffix(originalFilename);

        String fileName = getRandomFileName() + fileSuffix;

        String basePath = getPath();

        // 获取文件对象
        File f = new File(basePath, fileName);
        // 完成文件的上传
        file.transferTo(f);

        return "/image/" + fileName;
    }

    public static Resource loadAsResource(String path) throws FileNotFoundException {
        return LocalStorageUtil.loadAsResource("static/upload/" + path);
    }

}
