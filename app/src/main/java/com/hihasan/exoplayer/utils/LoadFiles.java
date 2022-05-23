package com.hihasan.exoplayer.utils;

import com.hihasan.exoplayer.constant.ApplicationConstants;

import java.io.File;
import java.util.ArrayList;

public class LoadFiles {

    public static String[] videoExtensions = {".mp4",".ts",".mkv",".mov",
            ".3gp",".mv2",".m4v",".webm",".mpeg1",".mpeg2",".mts",".ogm",
            ".bup", ".dv",".flv",".m1v",".m2ts",".mpeg4",".vlc",".3g2",
            ".avi",".mpeg",".mpg",".wmv",".asf"};

    //all loaded files will be here
    public static ArrayList<File> allMediaList = new ArrayList<>();

    public static void load_Directory_Files(File directory){
        File[] fileList = directory.listFiles();
        if(fileList != null && fileList.length > 0){
            for (int i=0; i<fileList.length; i++){
                if(fileList[i].isDirectory()){
                    load_Directory_Files(fileList[i]);
                }
                else {
                    String name = fileList[i].getName().toLowerCase();
                    for (String extension: videoExtensions){
                        //check the type of file
                        if(name.endsWith(extension)){
                            allMediaList.add(fileList[i]);
                            //when we found file
                            break;
                        }
                    }
                }
            }
        }
    }
}
