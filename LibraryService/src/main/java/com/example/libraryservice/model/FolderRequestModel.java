package com.example.libraryservice.model;

import lombok.Data;

@Data
public class FolderRequestModel {
    private Long folderId;
    private String folderName;
    private String folderPath;
}
