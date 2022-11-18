package com.example.libraryservice.entity;

import lombok.Data;
import com.example.libraryservice.model.FolderRequestModel;

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
public Folder(){
    super();
}

public Folder(FolderRequestModel folderRequestModel){
    this.folderName = folderRequestModel.getFolderName();
    this.folderPath = folderRequestModel.getFolderPath();
}
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
