package com.dbsqrstring.dbsqrstring.controller;


import com.dbsqrstring.dbsqrstring.model.Dbs;
import com.dbsqrstring.dbsqrstring.response.ApiResponse;
import com.dbsqrstring.dbsqrstring.service.QrStringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class QrStringController {

    private static final Logger log = LoggerFactory.getLogger(QrStringController.class);

    @Autowired
    private QrStringService qrStringService;

 

    @GetMapping("/generateQrString")
    public ResponseEntity<?> getQrString() throws Exception {
      /*  if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
        } else {
*/
        //qrStringService.readexcel(file);
        List<String> qrlist = qrStringService.dbsinput();
        qrStringService.writeDataIntoExcel(qrlist);



        //String qrstr=qrStringService.stringFormation();
           /* String qrstr1= qrStringService.stringFormation1();
            String qrstr2=qrStringService.stringFormation2();
            String qrstr3=qrStringService.stringFormation3();
            String qrstr4=qrStringService.stringFormation4();
            String qrstr5=qrStringService.stringFormation5();

            String qrstring="00020101021102164000000000000000082700000000000000000000000000026470010A000000524"+qrstr1+"02030.027230010A000000524010500001"+qrstr2+"53033565802IN"+qrstr3+qrstr4+qrstr5+"6212070800000000";

          String crcinput= "00020101021102164000000000000000082700000000000000000000000000026470010A000000524"+qrstr1+"02030.027230010A000000524010500001"+qrstr2+"53033565802IN"+qrstr3+qrstr4+qrstr5+"6212070800000000".getBytes("ASCII");
           String finalqr=qrstring+ qrStringService.crccal(crcinput);
           log.info("finalqr===================={}",finalqr);
            qrStringService.generateQr(finalqr,WIDTH,HEIGHT,QR_PATH);*/

        return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "QrString generated successfully", null), HttpStatus.OK);
    }


    @GetMapping("/getData")
    public ResponseEntity<?> getQrDetails() {
        log.info("method starts-------------------");
        List<Dbs> dbslist = qrStringService.getQrdata();
        if (dbslist != null) {
            log.info("dblist check--------------");
            return new ResponseEntity<>(new ApiResponse(HttpStatus.OK, "Customer Details are found", dbslist), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND, "Customer Details are not found", null), HttpStatus.NOT_FOUND);

        }
    }


    @PostMapping("/input-excel")
    public ResponseEntity<?> readExcel(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
        } else {
            qrStringService.dbsinput1(file);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Data inserted successfully!!!");
    }


}









