package com.mall.core.utils.File;

import com.mall.core.exception.BusinessException;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * FileUtils
 */
public class FileUtil {

    /**
     * 文件下载的接口地址,与后面要写的文件下载接口相呼应
     */
    private static final String DOWNLOAD_API = "/api/file/download";

    /**
     * filePath 与后面要写的文件下载接口相呼应
     */
    private static final String FILE_PATH_KEY = "filePath";

    /**
     * rename 与后面要写的文件下载接口相呼应
     */
    private static final String RENAME_KEY = "rename";

    /**
     *
     */
    private static final String EMPTY_STRING = "";

    /**
     * forceMkdir
     * @param directory 文件夹
     */
    public static void forceMkdir(File directory){
        String message;
        if (directory.exists()) {
            if (!directory.isDirectory()) {
                message = "File " + directory + " exists and is not a directory. Unable to create directory.";
                throw new BusinessException(message);
            }
        } else if (!directory.mkdirs() && !directory.isDirectory()) {
            message = "Unable to create directory " + directory;
            throw new BusinessException(message);
        }
    }

    /**
     * getFileSuffix
     * @param fileName 文件名
     * @return java.lang.String
     */
    public static String getFileSuffix(String fileName){
        int index = fileName.lastIndexOf(".");
        return index>-1 ? fileName.substring(index) : EMPTY_STRING;
    }

    /**
     * getDownloadUrl
     * @param filePath
     * @param rename
     * @return java.lang.String
     */
    public static String getDownloadUrl(String filePath, String rename){
        if(StringUtils.isEmpty(rename)){
            return MessageFormat.format("{0}?{1}={2}", DOWNLOAD_API, FILE_PATH_KEY, URLEncoder.encode(filePath, StandardCharsets.UTF_8));
        }
        return MessageFormat.format("{0}?{1}={2}&{3}={4}", DOWNLOAD_API, FILE_PATH_KEY, URLEncoder.encode(filePath, StandardCharsets.UTF_8), RENAME_KEY, URLEncoder.encode(rename, StandardCharsets.UTF_8));
    }

    /**
     * getDownloadUrl
     * @param filePath
     * @return java.lang.String
     */
    public static String getDownloadUrl(String filePath){
        return getDownloadUrl(filePath, null);
    }

}