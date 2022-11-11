package com.example.libraryservice.controller;

import com.example.libraryservice.errors.FolderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.example.libraryservice.model.FolderRequestModel;
import com.example.libraryservice.service.FolderService;
import com.example.libraryservice.entity.Folder;

@RestController
@RequestMapping("/folders")
@CrossOrigin(origins = "*")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @GetMapping("/{id}")
    public Folder findFolderById(@PathVariable("id") Long folderId){
        if (folderService.findByFolderId(folderId) == null){
            throw new FolderNotFoundException("Folder not found");
        }
        return folderService.findByFolderId(folderId);
    }

    @GetMapping("/")
    public List<Folder> getAllFolders() {
        return folderService.getAllFolders();
    }

    @PostMapping("/add")
    public Folder saveLocation(@Valid @RequestBody FolderRequestModel newFolder) {
        Folder folder = new Folder(newFolder);
        return folderService.saveFolder(folder);
    }

    @PutMapping("/edit/{id}")
    public Folder updateLocation(@Valid @RequestBody FolderRequestModel  updatedFolder, @PathVariable Long id) {
        Folder folder = new Folder(updatedFolder);
        return folderService.updateFolder(folder, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLocation(@PathVariable Long id) {
        if (folderService.findByFolderId(id) == null){
            throw new FolderNotFoundException("Folder not found");
        }

        folderService.deleteById(id);
    }
}
