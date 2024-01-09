package com.example.qianhua.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {

    private static File createFileByUrl(String remoteFileUrl){
        String path = System.getProperty("user.dir");
        File tempFile = new File(path,"temp");
        if (!tempFile.exists()){
            tempFile.mkdirs();
        }

        String fileName = remoteFileUrl.substring(remoteFileUrl.lastIndexOf("/"));
        FileOutputStream downloadFileStream = null;
        InputStream openInputStream = null;
        File savefile = null;

        try{
            savefile = new File(tempFile.getAbsolutePath() + fileName);
            URL url = new URL(remoteFileUrl);
            URLConnection urlConnection = url.openConnection();
            openInputStream = urlConnection.getInputStream();
            int index;
            byte[] bytes = new byte[1024];
            downloadFileStream = new FileOutputStream(savefile);
            while ((index = openInputStream.read(bytes)) != -1){
                downloadFileStream.write(bytes,0,index);
                downloadFileStream.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (openInputStream != null){
                    openInputStream.close();
                }
                if (downloadFileStream != null){
                    downloadFileStream.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return savefile;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        JSONObject j = new JSONObject();
        j.put("code","0");

        if (true){
            j.put("code","-1");
        }

        String name = "www.aaa/test1.mp4";
        System.out.println(name.substring(name.lastIndexOf("/")+1,name.lastIndexOf(".")));

        String url = "https://img.alicdn.com/imgextra/i3/735315515/O1CN01DGDczX1qbv7M5TRhI_!!735315515.jpg";
//        createFileByUrl(url);
        File localFile = new File("D:\\视频\\抖音\\test1.mp4");
        System.out.println(localFile.getName());

        String encodedUrl = "https://scm-ross-uat.oss-cn-shanghai.aliyuncs.com/image/genimg/1618454033334/_BI1443/DY0501_Z/black/DY0501_Z-%E9%A2%9C%E8%89%B2%E5%9B%BE-black.jpg?etag=1618454035892";
        String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");
        String newrul = decodedUrl.substring(decodedUrl.lastIndexOf("/")+1);

        Map<String,Object> mm = new HashMap<>();
        mm.put("code","asdf");
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(mm));
        Object code = jsonObject.get("code");
        if (code instanceof String){
            System.out.println(JSONObject.toJSONString(code));
        }


        System.out.println(newrul);

    }
}
