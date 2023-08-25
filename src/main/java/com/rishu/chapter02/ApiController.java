package com.rishu.chapter02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ApiController {

    private final VideoService videoService;

    public ApiController(VideoService videoService){
        this.videoService = videoService;
    }

    @GetMapping(path = "api/videos")
    public List<Video> videos(){
        // Jackson is converting our list of videos into JSON
        return videoService.getVideos();
    }

    @PostMapping(path = "api/videos")
    // @RequestBody - Spring MVC annotation to signal the incoming Http request
    // body should be deserialized via Jackson into newVideo argument as a Video record
    public Video newVideo(@RequestBody Video newVideo){
        videoService.create(newVideo);
        return newVideo;
    }
}
