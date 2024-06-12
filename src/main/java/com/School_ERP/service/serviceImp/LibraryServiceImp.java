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
            library.setStatus("available");
            libraryRepository.save(library);
            return ResponseEntity.ok(library);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
    }

    @Override
    public ResponseEntity<?> assingeeBook(int adm_no, Long bookId)  {
        Library library = libraryRepository.findByBookId(bookId);
        if(adm_no==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        }
        library.setStatus("not available");
     library.setAdm_no(adm_no);
        libraryRepository.save(library);
        return ResponseEntity.ok("assignee Book to student");
    }


    @Override
    public List<LibraryDto> searchByBookName(String books) {
   List<Library> librarylist = libraryRepository.findByBooks(books);

       List<LibraryDto> list = librarylist.stream().map(library -> {
           LibraryDto dto = null;
           dto = this.modelMapper.map(library, LibraryDto.class);
           return dto;
       }).collect(Collectors.toList());
       return list;


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
    @Override
    public ResponseEntity<?> returnBook(long bookId) {
        Library library = libraryRepository.findByBookId(bookId);
        library.setStatus("available");
        library.setAdm_no(0);
        libraryRepository.save(library);
        return ResponseEntity.ok("Book return successfully");
    }



}
