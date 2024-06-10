package com.School_ERP.service.serviceImp;

import com.School_ERP.dto.MedicalDto;
import com.School_ERP.entity.Medical;
import com.School_ERP.repository.MedicalRepository;
import com.School_ERP.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Autowired
    private MedicalRepository medicalRepository;

    @Override
    public List<MedicalDto> getAllMedicalRecords() {
        List<Medical> medicals = medicalRepository.findAll();
        return medicals.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public MedicalDto getMedicalRecordById(Long id) {
        Medical medical = medicalRepository.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));
        return convertToDto(medical);
    }

    @Override
    public MedicalDto createMedicalRecord(MedicalDto medicalDto) {
        Medical medical = convertToEntity(medicalDto);
        Medical savedMedical = medicalRepository.save(medical);
        return convertToDto(savedMedical);
    }

    @Override
    public MedicalDto updateMedicalRecord(Long id, MedicalDto medicalDto) {
        Medical medical = medicalRepository.findById(id).orElseThrow(() -> new RuntimeException("Medical record not found"));
        medical.setHandicap(medicalDto.getHandicap());
        medical.setMedical_condition(medicalDto.getMedicalCondition());
        medical.setAllergies(medicalDto.getAllergies());
        medical.setBlood_group(medicalDto.getBloodGroup());
        Medical updatedMedical = medicalRepository.save(medical);
        return convertToDto(updatedMedical);
    }

    @Override
    public void deleteMedicalRecord(Long id) {
        medicalRepository.deleteById(id);
    }

    private MedicalDto convertToDto(Medical medical) {
        MedicalDto medicalDto = new MedicalDto();
        medicalDto.setHandicap(medical.getHandicap());
        medicalDto.setMedicalCondition(medical.getMedical_condition());
        medicalDto.setAllergies(medical.getAllergies());
        medicalDto.setBloodGroup(medical.getBlood_group());
        return medicalDto;
    }

    private Medical convertToEntity(MedicalDto medicalDto) {
        Medical medical = new Medical();
        medical.setHandicap(medicalDto.getHandicap());
        medical.setMedical_condition(medicalDto.getMedicalCondition());
        medical.setAllergies(medicalDto.getAllergies());
        medical.setBlood_group(medicalDto.getBloodGroup());
        return medical;
    }
}
