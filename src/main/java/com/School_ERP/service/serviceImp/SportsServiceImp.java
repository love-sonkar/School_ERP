package com.School_ERP.service.serviceImp;



import com.School_ERP.entity.sports;
import com.School_ERP.repository.SportsRepository;

import com.School_ERP.service.SportsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SportsServiceImp implements SportsService {

	



	    @Autowired
	    private SportsRepository sportsRepository;

	    @Override
	    public List<sports> getAllSports() {
	        return sportsRepository.findAll();
	    }

	    @Override
	    public sports getSportsById(Long id) {
	        Optional<sports> sports = sportsRepository.findById(id);
	        return sports.orElse(null);
	    }

	    @Override
	    public sports createSports(sports sports) {
	        return sportsRepository.save(sports);
	    }

	    @Override
	    public sports updateSports(Long id, sports sports) {
	        if (sportsRepository.existsById(id)) {
	            sports.setSportsId(id);
	            return sportsRepository.save(sports);
	        }
	        return null;
	    }

	    @Override
	    public void deleteSports(Long id) {
	        sportsRepository.deleteById(id);
	    }

	    @Override
	    public List<String> getAllSportsNames() {
	        return sportsRepository.findAll()
	                               .stream()
	                               .map(sports::getSportsName)
	                               .collect(Collectors.toList());
	    }

	    @Override
	    public List<String> getAllSportsStaff() {
	        return sportsRepository.findAll()
	                               .stream()
	                               .map(sports::getSportsStaff)
	                               .collect(Collectors.toList());
	    }
	}

