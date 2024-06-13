package com.School_ERP.service;

import com.School_ERP.dto.LibraryDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LibraryService {

    ResponseEntity<?> addBook(LibraryDto libraryDto) ;

    ResponseEntity<?> assingeeBook(int admNo, Long bookId);
    ResponseEntity<?> getStudentOfAssignedBook(long bookId);

    List<LibraryDto> searchByBookName(String books);

    ResponseEntity<?> deleteBook(long bookId) ;

    List<LibraryDto> findAllBook();

    LibraryDto findByIdLibrary(long bookId) ;

    ResponseEntity<?> updateBook(long bookId, LibraryDto libraryDto) ;

    ResponseEntity<?> returnBook(long bookId);

}
