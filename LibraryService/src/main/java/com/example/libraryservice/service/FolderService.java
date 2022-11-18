package com.example.libraryservice.service;

import java.util.List;

import com.example.libraryservice.entity.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.libraryservice.repository.FolderRepository;
import org.springframework.stereotype.Service;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public Folder findByFolderId(Long folderId) {
        return folderRepository.findByFolderId(folderId);
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Folder saveFolder(Folder newFolder) {
        return folderRepository.save(newFolder);
    }

    public Folder updateFolder(Folder updatedFolder, Long id) {
        return folderRepository.findById(id)
                .map(folder -> {
                    folder.setFolderName(updatedFolder.getFolderName());
                    folder.setFolderPath(updatedFolder.getFolderPath());
                    return folderRepository.save(folder);
                })
                .orElseGet(() -> {
                    updatedFolder.setFolderId(id);
                    return folderRepository.save(updatedFolder);
                });
    }

    public void deleteById(Long id) {
        folderRepository.deleteById(id);
    }
}
