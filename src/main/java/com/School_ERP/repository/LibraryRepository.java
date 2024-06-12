package com.School_ERP.repository;

import com.School_ERP.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Library findByBookId(Long bookId);
    List<Library> findByBooks(String books);

}
