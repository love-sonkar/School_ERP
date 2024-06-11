package com.School_ERP.service.serviceImp;
import com.School_ERP.dto.LibraryDto;
import com.School_ERP.entity.Library;
import com.School_ERP.repository.LibraryRepository;
import com.School_ERP.service.LibraryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImp implements LibraryService {


    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<LibraryDto> findAllBook() {
        List<Library> listLibrary = libraryRepository.findAll();
        List<LibraryDto> list = listLibrary.stream().map(library -> {
            LibraryDto dto = null;
                dto = this.modelMapper.map(library, LibraryDto.class);
            return dto;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public LibraryDto findByIdLibrary(long bookId)  {
        Library library = libraryRepository.findByBookId(bookId);
        LibraryDto lDto = this.modelMapper.map(library, LibraryDto.class);;
        return lDto;
    }


    @Override
    public ResponseEntity<?> addBook(LibraryDto libraryDto)  {
        if(libraryDto.getBooks() != null){
            Library library =this.modelMapper.map(libraryDto, Library.class);
            libraryRepository.save(library);
            return ResponseEntity.ok(library);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
    }

    @Override
    public ResponseEntity<?> assingeeBook(String studentId, String bookId)  {
        // get student from studentId
        return ResponseEntity.ok("assignee Book to student");
    }


    @Override
    public LibraryDto searchByBookName(String bookName) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteBook(long bookId)  {
        Library library = libraryRepository.findByBookId(bookId);
        if(library == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
        }
        libraryRepository.delete(library);
        LibraryDto libraryDto = this.modelMapper.map(library, LibraryDto.class);
        return ResponseEntity.ok(libraryDto);
    }

    @Override
    public ResponseEntity<?> updateBook(long bookId, LibraryDto libraryDto)  {
        Library library = libraryRepository.findByBookId(bookId);
        LibraryDto convertDto = this.modelMapper.map(library, LibraryDto.class);;
        if(library == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
        }
        if(libraryDto.getBooks() !=null){
            convertDto.setBooks(libraryDto.getBooks());
        }
        Library updatedLibrary = this.modelMapper.map(convertDto,Library.class);
        libraryRepository.save(updatedLibrary);
        return ResponseEntity.ok(convertDto);
    }


}
