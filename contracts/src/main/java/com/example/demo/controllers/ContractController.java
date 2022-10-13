package com.example.demo.controllers;

import com.example.demo.dto.ContractDTO;
import com.example.demo.dto.EmployeeDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/iconcile")
public class ContractController {
    private static final String EMP_GET_URI = "http://localhost:8081/iconcile/employee?name=%s";

    @GetMapping("/isAlive")
    public boolean isAlive() {
        return true;
    }

    @GetMapping("/contractsForEmployee")
    public ResponseEntity<List<ContractDTO>> contracts(@RequestParam(value = "name") String name) {

        try {
            RestTemplate restTemplate = new RestTemplateBuilder().build();

            EmployeeDTO[] forObject = restTemplate.getForObject(String.format(EMP_GET_URI, name), EmployeeDTO[].class);

            List<EmployeeDTO> empList = Arrays.asList(forObject);
            List<ContractDTO> contractList = new ArrayList<>();
            for (EmployeeDTO employeeDTO : empList) {
                ContractDTO contractDTO = new ContractDTO();
                contractDTO.setAddress(employeeDTO.getAddress());
                contractDTO.setEmpId(employeeDTO.getId());
                contractDTO.setContractPlace("Pune");
                contractDTO.setEmpName(employeeDTO.getName());
                contractDTO.setContractStatus(true);
                contractList.add(contractDTO);
            }
            return ResponseEntity.ok(contractList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}