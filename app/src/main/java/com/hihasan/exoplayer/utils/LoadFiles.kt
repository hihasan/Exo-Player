package com.hihasan.exoplayer.utils

import com.hihasan.exoplayer.constant.ApplicationConstants
import java.io.File

class LoadFiles {
    companion object {
        fun load_Directory_Files(directory: File) {
            val fileList: Array<File> = directory.listFiles()!!
            if (fileList != null && fileList.size > 0) {
                for (i in fileList.indices) {
                    if (fileList[i].isDirectory()) {
                        load_Directory_Files(fileList[i])
                    } else {
                        val name: String = fileList[i].getName().toLowerCase()
                        for (extension in ApplicationConstants.videoExtensions) {
                            //check the type of file
                            if (name.endsWith(extension!!)) {
                                ApplicationConstants.allMediaList.add(fileList[i])
                                //when we found file
                                break
                            }
                        }
                    }
                }
            }
        }
    }
}