package com.example.demo.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.dto.ContractDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.httpServices.HttpServiceProvider;
import com.example.demo.utility.JsonHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/iconcile")
public class ContractController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/isAlive")
    public boolean isAlive() {
        return true;
    }

    @GetMapping("/contractsForEmployee")
    public String contracts(@RequestParam(value = "name") String name) {
        //http://localhost:8080/iconcile/contracts?name=temp

        try {
            HttpServiceProvider httpServiceProvider = new HttpServiceProvider();
            HttpResponse<String> responseJson = httpServiceProvider.callUri("http://43.205.203.68:8081/iconcile/employee?name=" + name);
			//HttpResponse<String> responseJson = httpServiceProvider.callUri("http://localhost:8081/iconcile/employee?name=" + name);

			ObjectMapper mapper = new ObjectMapper();
            List<EmployeeDTO> empList = Arrays.asList(mapper.readValue(responseJson.body(), EmployeeDTO[].class));
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
            return JsonHelper.getJsonString(contractList);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}