package com.hihasan.exoplayer.constant

import java.io.File

object ApplicationConstants {
    const val EXO_PLAYER = "exo_player"

    var videoExtensions = arrayOf(
        ".mp4", ".ts", ".mkv", ".mov",
        ".3gp", ".mv2", ".m4v", ".webm", ".mpeg1", ".mpeg2", ".mts", ".ogm",
        ".bup", ".dv", ".flv", ".m1v", ".m2ts", ".mpeg4", ".vlc", ".3g2",
        ".avi", ".mpeg", ".mpg", ".wmv", ".asf"
    )

    //all loaded files will be here
    var allMediaList: ArrayList<File> = ArrayList()
}