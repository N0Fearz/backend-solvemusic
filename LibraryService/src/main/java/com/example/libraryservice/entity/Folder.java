package com.example.libraryservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long folderId;
    private String folderName;
    private String folderPath;

    public Long getFolderId() {
        return folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderId(Long id) {
        folderId = id;
    }

    public void setFolderName(String name) {
        folderName = name;
    }

    public void setFolderPath(String path) {
        folderPath = path;
    }
}
