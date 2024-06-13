package com.School_ERP.controller;


import com.School_ERP.entity.sports;

import com.School_ERP.service.SportsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@RestController
@RequestMapping("/api/sports")
@Tag(name = "Sports API", description = "API for managing sports")
public class SportsController {

	
	

	    @Autowired
	    private SportsService sportsService;

	    @Operation(summary = "Get all sports with id and staff")
	    @GetMapping("/all/")
	    public List<sports> getAllSports() {
	        return sportsService.getAllSports();
	    }

	    @Operation(summary = "Get sports by ID")
	    @GetMapping("/{id}")
	    public ResponseEntity<sports> getSportsById(@PathVariable Long id) {
	        sports sports = sportsService.getSportsById(id);
	        return sports != null ? ResponseEntity.ok(sports) : ResponseEntity.notFound().build();
	    }

	    @Operation(summary = "Create new sports")
	    @PostMapping
	    public sports createSports(@RequestBody sports sports) {
	        return sportsService.createSports(sports);
	    }

	    @Operation(summary = "Update sports")
	    @PutMapping("/{id}")
	    public ResponseEntity<sports> updateSports(@PathVariable Long id, @RequestBody sports sports) {
	        sports updatedSports = sportsService.updateSports(id, sports);
	        return updatedSports != null ? ResponseEntity.ok(updatedSports) : ResponseEntity.notFound().build();
	    }

	    @Operation(summary = "Delete sports")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSports(@PathVariable Long id) {
	        sportsService.deleteSports(id);
	        return ResponseEntity.noContent().build();
	    }

	    @Operation(summary = "Get all sports (only names)")
	    @GetMapping("/names")
	    public List<String> getAllSportsNames() {
	        return sportsService.getAllSportsNames();
	    }

	    @Operation(summary = "Get all sports staff (only names)")
	    @GetMapping("/staff")
	    public List<String> getAllSportsStaff() {
	        return sportsService.getAllSportsStaff();
	    }
	}

