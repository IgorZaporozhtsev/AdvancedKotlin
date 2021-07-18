package main.random

import kotlin.random.Random

/** Seems Nerdy youtube channel*/

fun main() {
    //Ctrl+J - тип переменной

    val posts = listOf(
        PostContent(0, Picture(generateRandomData(256)), ::pictureDownloader), // can replace to lambda { picture -> picture.data }
        PostContent(1, listOf(Picture(generateRandomData(256)), Picture(generateRandomData(256))))
        { pictures ->
            pictures
                .map { picture -> picture.data } //( ::pictureDownloader)
                .fold(byteArrayOf()) { acc, item -> acc + item }
        },
        PostContent(2, Video(generateRandomData(1024))) { video -> video.data } //can replace to method reference ::videoDownloader
    )

    println(posts)

    val downloadedContent = posts
        .map { post -> post.download() }.map { it.size }

    print(downloadedContent)
}

fun pictureDownloader(picture: Picture) = picture.data

fun videoDownloader(video: Video) = video.data

fun generateRandomData(length: Int): ByteArray = Random.nextBytes(length)

class Picture(val data: ByteArray){}

class Video(val data: ByteArray){}



class PostContent<T>(val id:Long, val content: T, val downloader: (T) -> ByteArray){
    override fun toString(): String {                     //Cmd+N
        return "PostContent(id=$id, content=$content)"
    }

    fun download() = downloader(content)
}

//признаки когда нужно использовать
// 1. когда у нас есть разные типы но они выполняют схожие действия (полиморфизм)
// Video, Picture используют метод download класса PostContent