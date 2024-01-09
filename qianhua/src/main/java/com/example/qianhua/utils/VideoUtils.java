package com.example.qianhua.utils;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class VideoUtils {

    public static void main(String[] args) throws Exception {
//        String remoteFileUrl = "https://scm-dam.oss-cn-shanghai-internal.aliyuncs.com/scm-dam/uat/baozun/2023-12-15/CJ1495_b934d12a-9936-4513-b6d6-78f26d0d2531.mp4";
//        URL url = new URL(remoteFileUrl);
//        URLConnection urlConnection = url.openConnection();
//        InputStream openInputStream = urlConnection.getInputStream();

        String videoFile = "D:\\视频\\抖音\\无封面测试.mp4";
//        String frameFile = "D:\\视频\\抖音\\test2.jpg";
        String frameFile = videoFile.substring(videoFile.lastIndexOf("\\")+1);
        String j = frameFile.substring(0,frameFile.indexOf(".")+1)+ "jpg";
        fetchFrame(videoFile,j);
//        fetchFrame2(openInputStream,frameFile);
    }


    public static String fetchFrame(String videofile, String framefile) throws Exception{
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int length = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < length) {
            // 去掉前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabImage();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }
        ImageIO.write(FrameToBufferedImage(f), "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("生成缩略图完成");
        return targetFile.getAbsolutePath();
    }


    public static String fetchFrame2(InputStream videofile, String framefile) throws Exception{
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int length = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < length) {
            // 去掉前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabImage();
            if ((i > 15) && (f.image != null)) {
                break;
            }
            i++;
        }
        ImageIO.write(FrameToBufferedImage(f), "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("生成缩略图完成");
        return targetFile.getAbsolutePath();
    }

    public static BufferedImage FrameToBufferedImage(Frame frame) {
        //创建BufferedImage对象
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        return bufferedImage;
    }

}
