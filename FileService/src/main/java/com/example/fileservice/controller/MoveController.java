package com.example.fileservice.controller;

import com.example.fileservice.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/move")
@CrossOrigin(origins = "localhost:3000")
public class MoveController {

    @Autowired
    MoveService moveService;

    @GetMapping("/get/directories")
    public List<Path> getDirectories() throws IOException {
        Path path = Paths.get("C:\\Users\\casgo\\Documents\\School\\semester 3\\Individual\\ProjectTest");
        return moveService.listDirectories(path);
    }

    @GetMapping("/get/files")
    public List<Path> getFiles() throws IOException {
        Path path = Paths.get("C:\\Users\\casgo\\Documents\\School\\semester 3\\Individual\\ProjectTest");
        return moveService.hasMP3(path, ".mp3");
    }

}
