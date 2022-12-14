package com.example.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.libraryservice.entity.Folder;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Folder findByFolderId(Long folderId);
}
