package com.School_ERP.service;

import com.School_ERP.entity.sports;

import java.util.List;

public interface SportsService {

	List<sports> getAllSports();

	sports getSportsById(Long id);

	sports createSports(sports sports);

	sports updateSports(Long id, sports sports);

	void deleteSports(Long id);

	List<String> getAllSportsNames();

	List<String> getAllSportsStaff();
}
