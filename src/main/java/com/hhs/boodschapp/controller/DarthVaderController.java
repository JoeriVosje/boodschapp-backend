package com.hhs.boodschapp.controller;

import com.hhs.boodschapp.model.entity.response.DarthVaderResponse;
import com.hhs.boodschapp.service.DarthVaderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DarthVaderController {
    private DarthVaderService darthVaderService;

    @DeleteMapping("deleteYouMust")
    public ResponseEntity<DarthVaderResponse> clearDatabase() {
        DarthVaderResponse darthVaderResponse = darthVaderService.clearDatabase();

        return new ResponseEntity<>(darthVaderResponse, HttpStatus.OK);
    }
}
