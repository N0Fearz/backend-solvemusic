package com.example.fileservice.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Service
public class MoveService {

    public List<Path> listDirectories(Path path) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.list(path)) {
            result = walk.filter(Files::isDirectory)
                    .toList();
        }
        return result;
    }

    public List<Path> hasMP3(Path path, String extension) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith(extension))
                    .toList();
        }
        return result;
    }
}
