package com.example.controller;

import com.example.entity.Patient;
import com.example.entity.PatientAddress;
import com.example.model.PatientAddressDetailsRequestModel;
import com.example.model.PatientDetailsRequestModel;
import com.example.service.PatientService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientRestController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

//    @GetMapping("/patient")
//    public List<Patient> getPatients(){
//        List<Patient> patients = patientService.getPatients();
//        return patients;
//    }

    @GetMapping("/patient")
    public ResponseEntity<List<Patient>> getPatients(){
        List<Patient> patients = patientService.getPatients();
        if(patients.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }

//    @GetMapping("/patient/{id}")
//    public Patient getPatient(@PathVariable(value = "id")int id){
//        Patient patient = patientService.getPatient(id);
//        return patient;
//    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable(value = "id")int id){
        Patient patient = patientService.getPatient(id);
        if(patient == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }

//    @GetMapping("/patient/address")
//    public List<PatientAddress> getPatientsAddresses(){
//        List<PatientAddress> patientsAddresses = patientService.getPatientAddresses();
//        return patientsAddresses;
//    }

    @GetMapping("/patient/address")
    public ResponseEntity<List<PatientAddress>> getPatientsAddresses(){
        List<PatientAddress> patientsAddresses = patientService.getPatientAddresses();
        if(patientsAddresses.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PatientAddress>>(patientsAddresses, HttpStatus.OK);
    }

//    @GetMapping("/patient/address/{id}")
//    public PatientAddress getPatientAddress(@PathVariable(value = "id")int id){
//        PatientAddress patientAddress = patientService.getPatientAddress(id);
//        return patientAddress;
//    }

    @GetMapping("/patient/address/{id}")
    public ResponseEntity<PatientAddress> getPatientAddress(@PathVariable(value = "id")int id){
        PatientAddress patientAddress = patientService.getPatientAddress(id);
        if(patientAddress == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PatientAddress>(patientAddress, HttpStatus.OK);
    }


//    @PostMapping(value="/patient",
//                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Patient createPatient(@RequestBody PatientDetailsRequestModel requestPatientDetails){
//        Patient patient = new Patient();
//        BeanUtils.copyProperties(requestPatientDetails, patient);
//        patientService.savePatient(patient);
//        return patient;
//    }

    //===========================================================================================================
    /*
    W przypadku gdy chcemy dodać nową osobą a podamy złą nazwę atrybutu (np. zamiast surname suraname) co prawda
    ani użytkowinik ani adres nie są dodawane jednak w tabeli adresów id przeskakuje na kolejne.
    */
    //===========================================================================================================

    @PostMapping(value="/patient",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDetailsRequestModel requestPatientDetails){
        try{
            Patient patient = new Patient();
            BeanUtils.copyProperties(requestPatientDetails, patient);
            patientService.savePatient(patient);
            return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

//    @PostMapping(value="/patient/address",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public PatientAddress createPatientAddress(@RequestBody PatientAddressDetailsRequestModel requestPatientAddressDetails){
//        PatientAddress patientAddress = new PatientAddress();
//        BeanUtils.copyProperties(requestPatientAddressDetails, patientAddress);
//        patientService.savePatientAdress(patientAddress);
//        return patientAddress;
//    }

    @PostMapping(value="/patient/address",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PatientAddress> createPatientAddress(@RequestBody PatientAddressDetailsRequestModel requestPatientAddressDetails){
        try{
            PatientAddress patientAddress = new PatientAddress();
            BeanUtils.copyProperties(requestPatientAddressDetails, patientAddress);
            patientService.savePatientAddress(patientAddress);
            return new ResponseEntity<PatientAddress>(patientAddress, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="/patient/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id")int id, @RequestBody PatientDetailsRequestModel requestPatientDetails){
        try {
            Patient patient = patientService.getPatient(id);
            BeanUtils.copyProperties(requestPatientDetails, patient);
            patientService.savePatient(patient);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="/patient/address/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PatientAddress> updatePatientAddress(@PathVariable(value = "id")int id, @RequestBody PatientAddressDetailsRequestModel requestPatientAddressDetails){
        try {
            PatientAddress patientAddress = patientService.getPatientAddress(id);
            BeanUtils.copyProperties(requestPatientAddressDetails, patientAddress);
            patientService.savePatientAddress(patientAddress);
            return new ResponseEntity<PatientAddress>(patientAddress, HttpStatus.OK);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/patient/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable (value = "id")int id){
        try{
            patientService.deletePatient(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/patient/address/{id}")
    public ResponseEntity<PatientAddress> deletePatientAddress(@PathVariable (value = "id")int id){
        try{
            patientService.deletePatientAddress(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
