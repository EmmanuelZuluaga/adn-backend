package com.example.adnprueba.adnprueba.web.controller;

import com.example.adnprueba.adnprueba.dto.AdnDtoInput;
import com.example.adnprueba.adnprueba.dto.ResultDtoOutput;
import com.example.adnprueba.adnprueba.service.AdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/adn")
public class AdnController {


    @Autowired
    private AdnService adnService;


    @PostMapping("/mutations")
    public ResponseEntity<ResultDtoOutput> getAll(@RequestBody AdnDtoInput matrix){
        try{
            ArrayList<String> list= (ArrayList<String>) this.adnService.getStateMutations(matrix.getAdn());
            ResultDtoOutput resultDto= new ResultDtoOutput(list.size()>0?true:false,list);
            return new ResponseEntity<>(resultDto, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED );
    }


}
