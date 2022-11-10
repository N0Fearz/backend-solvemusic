package src.main.java.com.example.libraryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import src.main.java.com.example.libraryservice.service.FolderService;
import src.main.java.com.example.libraryservice.entity.Folder;

@RestController
@RequestMapping("/folders")
@CrossOrigin(origins = "*")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @GetMapping("/{id}")
    public Folder FindFolderById(@PathVariable("id") Long folderId){
//        if (folderService.findFolderById(folderId) == null){
//            throw new com.example.fileservice.errors.LocationNotFoundException("Location not found");
//        }
        return folderService.findByFolderId(folderId);
    }

    @GetMapping("/")
    public List<Folder> GetAllFolders() {
        return folderService.getAllFolders();
    }

    @PostMapping("/add")
    public Folder saveLocation(@Valid @RequestBody Folder newFolder) {
        return folderService.saveFolder(newFolder);
    }

    @PutMapping("/edit/{id}")
    public Folder updateLocation(@Valid @RequestBody Folder updatedFolder, @PathVariable Long id) {
        return folderService.updateFolder(updatedFolder, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLocation(@PathVariable Long id) {
//        if (folderService.findFolderById(id) == null){
//            throw new com.example.fileservice.errors.LocationNotFoundException("Location not found");
//        }

        folderService.deleteById(id);
    }
}
