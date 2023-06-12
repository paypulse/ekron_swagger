package com.example.ekorn_admin_swagger.GolfTestData.Controller;


import com.example.ekorn_admin_swagger.PUtils.CommonRes;
import com.example.ekorn_admin_swagger.PUtils.FileInput;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@NoArgsConstructor
@RestController
public class TestData {

    /**
     * 골프 클럽 정보 테스트 데이터
     * **/
    @ApiOperation(value = "golf_club 테스트 데이터 등록", notes = "golf_club 테스트 데이터 등록")
    @PostMapping(value="/test_golfclub" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonRes> testData_golfClub(@RequestParam(value="file", required = false) MultipartFile file) throws IOException {

        // 엑셀 데이터를 긁어  오기
        FileInput check = new FileInput();

        int rv =0;

        if(check.filecheck(file)){

            try{


                return ResponseEntity.ok(CommonRes.builder()
                        .data(rv)
                        .status("SUCCESS")
                        .msg("insert success")
                        .build());

            }catch (Exception e){
                return ResponseEntity.ok(CommonRes.builder()
                        .data(e)
                        .msg(e.getMessage())
                        .build());


            }



        }else{

            return ResponseEntity.ok(CommonRes.builder()
                    .status("FAIL")
                    .msg("no file")
                    .build());


        }




    }


}
