package com.rishu.chapter02;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    // immutable list
    private List<Video> videos = List.of(new Video("this is video1"),
            new Video("this is video2"),
            new Video("this is video3"));

    public List<Video> getVideos(){
        return videos;
    }

    public Video create(Video newVideo) {
        List<Video> extend = new ArrayList<>(videos);
        extend.add(newVideo);
        this.videos = List.copyOf(extend);
        return newVideo;
    }

}
