package com.dbsqrstring.dbsqrstring.service;

import com.dbsqrstring.dbsqrstring.model.Dbs;
import com.dbsqrstring.dbsqrstring.repository.DbsRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jcraft.jsch.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

import static com.dbsqrstring.dbsqrstring.constants.DbsConstants.*;

@Service
public class QrStringService {

    private static final Logger log = LoggerFactory.getLogger(QrStringService.class);

    @Autowired
    private QrStringService qrStringService;

    @Autowired
    private DbsRepository dbsRepository;

    private Connection con = null;

    public void readexcel(MultipartFile file) throws IOException {

        ArrayList<String> list = new ArrayList<>();

        File xlsxfile = new File("D:\\dbsproject\\dbsinput.xlsx");
        FileInputStream inputStream = new FileInputStream(xlsxfile);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        DataFormatter fmt = new DataFormatter();
       /* Integer colind1 = null;
        Integer colind2 = null;
        Integer colind3 = null;
        Integer colind4 = null;

        String col1 = "CUSTOMER NAME";
        String col2 = "VPA";
        String col3 = "CITY";
        String col4 = "MCC";*/
        while (iterator.hasNext()) {
            Row nextrow = iterator.next();
            Iterator<Cell> cellIterator = nextrow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                //HSSFDataFormatter formatter = new HSSFDataFormatter();

                switch (cell.getCellType()) {
                    case STRING:
                        log.info("cellstringvalues============={}", cell.getStringCellValue());


                        //list.add(cell.getStringCellValue());
                       /* log.info("listvalues============={}", list);
                        String result=String.join("",list);
                        log.info("result============={}", result);*/




                        /*if (!cell.getStringCellValue().isEmpty()) {
                            list.add(cell.getStringCellValue());
                            log.info("list -------------{}",list);*/
                       /* List<Cell> cells = new ArrayList<Cell>();
                        Row firstRow = sheet.getRow(0);
                        for (Cell cell1 : firstRow) {*/
                            /*if (cell1.getStringCellValue().equals(col1)) {
                                // list.add(cell.getStringCellValue());
                                columnNo = cell1.getColumnIndex();
                                //log.info("list -------------{}", cells);
                            }*/
                            /*switch (cell1.getStringCellValue()) {

                               case "CUSTOMER NAME":
                                    colind1 = cell1.getColumnIndex();

                                case "VPA":
                                    colind2 = cell1.getColumnIndex();
                                case "CITY":
                                    colind3 = cell1.getColumnIndex();
                                case "MCC":
                                    colind4 = cell1.getColumnIndex();
                                    break;
                                default:
                                    break;
                            }
                        }

                        if (colind1 != null) {
                            for (Row row1 : sheet) {
                                Cell c1 = row1.getCell(colind1);
                                Cell c2 = row1.getCell(colind2);
                                Cell c3 = row1.getCell(colind3);
                                Cell c4 = row1.getCell(colind4);
                                if (c1 == null || c1.getCellType() == CellType.BLANK
                                        && c2 == null || c2.getCellType() == CellType.BLANK
                                        && c3 == null || c3.getCellType() == CellType.BLANK
                                        && c4 == null || c4.getCellType() == CellType.BLANK) {
                                } else {
                                    cells.add(c1);
                                    cells.add(c2);
                                    cells.add(c3);
                                    cells.add(c4);




                                }
                            }
                        } else {
                            log.info("Column Not found  " + col1 + " " + col2 + " " + col3 + " " + col4);

                        }
                        log.info("data in the excel-------------------{}", cells);

                        break;
                    default:
                        break;

               }

*/
                }
            }

            log.info("file reading done successfully");


            workbook.close();
            inputStream.close();
        }
    }


    public List<String> dbsinput() throws Exception {

        log.info("method starts-------------------");
        String finalencodedstring = null;

       /* String jdbcURL = "jdbc:mysql://uatapp.bijlipay.co.in:3306/web_bijlipay_edc?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "3PUct4EC68";*/

        // File xlsxfile = new File(EXCEL_FILE_PATH);

        //String excelFilePath = "D:\\dbsproject\\dbsinput1.xlsx";

        /*int batchSize = 20;
        Connection connection = null;*/
       /* FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(xlsxfile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        log.info("file uploaded----------{}", inputStream);
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
        //Sheet firstSheet = workbook.getSheetAt(0);
       /* workbook.getNumberOfSheets();
        log.info("number of sheets====================");
        List<String> encodedStringList = null;
        for (Sheet firstSheet : workbook) {
            for (Row row : firstSheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();
                log.info("Cell========================");
                switch (cell.getCellType()) {

                    case STRING:
                        log.info("switch starts=====================");
                        log.info("table insertion starts==============");
                        String date = row.getCell(0).getStringCellValue();
                        //log.info("address==============",date);
                        String customer_name = row.getCell(1).getStringCellValue();
                        String email_id = row.getCell(2).getStringCellValue();
                        String address = row.getCell(3).getStringCellValue();
                        String vpa = row.getCell(4).getStringCellValue();
                        String branch_name = row.getCell(5).getStringCellValue();
                        String state = row.getCell(6).getStringCellValue();
                        String country = row.getCell(7).getStringCellValue();
                        String pincode = row.getCell(8).getStringCellValue();
                        String city = row.getCell(9).getStringCellValue();
                        String pan = row.getCell(10).getStringCellValue();
                        // log.info("mobilenumber==================",row.getCell(11).getStringCellValue());
                        String mobile_number = row.getCell(11).getStringCellValue();

                        String nature_of_business = row.getCell(12).getStringCellValue();
                        String mcc = row.getCell(13).getStringCellValue();
                        //double branch_code = row.getCell(14).getNumericCellValue();
                        String bank_name = row.getCell(15).getStringCellValue();

                        Dbs dbs = new Dbs();
                        dbs.setDate(date);
                        dbs.setCustomerName(customer_name);
                        dbs.setEmailId(email_id);
                        dbs.setAddress(address);
                        dbs.setVpa(vpa);
                        dbs.setBranchName(branch_name);
                        dbs.setState(state);
                        dbs.setCountry(country);
                        dbs.setPincode(pincode);
                        dbs.setCity(city);
                        dbs.setPan(pan);
                        dbs.setMobileNumber(mobile_number);
                        dbs.setNatureOfBusiness(nature_of_business);
                        dbs.setMcc(mcc);
                        //dbs.setBranchCode(branch_code);
                        dbs.setBankName(bank_name);
                        dbsRepository.save(dbs);
                        log.info("switch ends=====================");*/
        List<String> encodedStringList = new ArrayList<>();

        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select * from dbs";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String customerName = resultset.getString(8);
                log.info("CustomerName============{}", customerName);
                String city = resultset.getString(6);
                log.info("city======================={}", city);
                String mcc = resultset.getString(11);
                log.info("mcc=========={}", mcc);
                String pincode = resultset.getString(15);
                log.info("pincode=============={}", pincode);
                String vpa = resultset.getString(17);
                log.info("vpa==========={}", vpa);
                String str1 = null;
                String str2=null;
                String qrstring = "000201010211021640000000000000000827000000000000000000000000000" + "26" + (14 + 4 + vpa.length() + 7) + "0010A000000524";

                if (vpa.length() < 10) {
                    str1 = "010" + vpa.length() + String.format("%s", vpa);
                } else {
                    str1 = "01" + vpa.length() + String.format("%s", vpa);
                }


                String qrstring2 = qrstring + str1 + "02030.027230010A000000524" + "010500001" + "5204" + String.format("%s", mcc) + "53033565802IN" + "59" + customerName.length() + String.format("%s", customerName);

                if (city.length() < 10) {
                    str2 = "600" + city.length() + String.format("%s", city);
                    log.info("str==============={}", str1);
                } else {
                    str2 = "60" + city.length() + String.format("%s", city);
                    log.info("str==============={}", str1);
                }

                String qrstring3= qrstring2 + str2 + "6106" + String.format("%s", pincode) + "6212070800000000";

                String finalqr = qrstring3 + qrStringService.crccal(qrstring3);
                log.info("finalqr===================={}", finalqr);

                byte[] qr = qrStringService.generateQr(finalqr, WIDTH, HEIGHT);
                Base64.Encoder encoder = Base64.getEncoder();

                finalencodedstring = encoder.encodeToString(qr);
                log.info("finalstring===================={}", finalencodedstring);
                //encodedStringList = new ArrayList<>();
                encodedStringList.add(finalencodedstring);
                log.info("Final String list================={}", encodedStringList);
                log.info("List Size================={}", encodedStringList.size());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // List<String> encodedStringList = null;
/*

            String qrstr1 = qrStringService.stringFormation1();
            String qrstr2 = qrStringService.stringFormation2();
            String qrstr3 = qrStringService.stringFormation3();
            String qrstr4 = qrStringService.stringFormation4();
            String qrstr5 = qrStringService.stringFormation5();
            String qrstr6 = qrStringService.stringFormation6();
            String qrstr7 = "0105" + qrStringService.increment();
*/


        // String qrstring = "000201010211021640000000000000000827000000000000000000000000000" + qrstr1 + "0010A000000524" + qrstr6 + "02030.027230010A000000524" + qrstr7 + qrstr2 + "53033565802IN" + qrstr3 + qrstr4 + qrstr5 + "6212070800000000";


        //String crcinput = "000201010211021640000000000000000827000000000000000000000000000" + qrstr1 + "0010A000000524" + qrstr6 + "02030.027230010A000000524" + qrstr7 + qrstr2 + "53033565802IN" + qrstr3 + qrstr4 + qrstr5 + "6212070800000000".getBytes("ASCII");
        // String finalqr = qrstring + qrStringService.crccal(qrstring);
            /*log.info("finalqr===================={}", finalqr);

            byte[] qr = qrStringService.generateQr(finalqr, WIDTH, HEIGHT);
            Base64.Encoder encoder = Base64.getEncoder();

            String finalencodedstring = encoder.encodeToString(qr);
            log.info("finalstring===================={}", finalencodedstring);
            encodedStringList = new ArrayList<>();
            encodedStringList.add(finalencodedstring);*/


        //   }
        //   }
        // }
        // log.info("Final String list================={}", encodedStringList);
        return encodedStringList;
    }


    public void dbsinput1(MultipartFile file) throws Exception {
        log.info("method starts-------------------");
        String uploadDir = EXCEL_FILE_PATH;
        File fh = new File("/tmp/");
        if (!fh.exists()) {
            fh.mkdir();
        }
// Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        final String filepath = uploadDir + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + file.getOriginalFilename());
        Files.write(path, bytes);

        FileInputStream inputStream = new FileInputStream(new File(filepath));
        log.info("file uploaded----------{}", inputStream);
        Workbook workbook = new XSSFWorkbook(inputStream);
        //Sheet firstSheet = workbook.getSheetAt(0);
        workbook.getNumberOfSheets();
        log.info("number of sheets====================");
        List<String> encodedStringList = null;
        for (Sheet firstSheet : workbook) {
            for (Row row : firstSheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();
                log.info("Cell========================");
                switch (cell.getCellType()) {

                    case STRING:
                        log.info("switch starts=====================");
                        log.info("table insertion starts==============");
                        String date = row.getCell(0).getStringCellValue();
                        //log.info("address==============",date);
                        String customer_name = row.getCell(1).getStringCellValue();
                        String email_id = row.getCell(2).getStringCellValue();
                        String address = row.getCell(3).getStringCellValue();
                        String vpa = row.getCell(4).getStringCellValue();
                        String branch_name = row.getCell(5).getStringCellValue();
                        String state = row.getCell(6).getStringCellValue();
                        String country = row.getCell(7).getStringCellValue();
                        String pincode = row.getCell(8).getStringCellValue();
                        String city = row.getCell(9).getStringCellValue();
                        String pan = row.getCell(10).getStringCellValue();
                        // log.info("mobilenumber==================",row.getCell(11).getStringCellValue());
                        String mobile_number = row.getCell(11).getStringCellValue();

                        String nature_of_business = row.getCell(12).getStringCellValue();
                        String mcc = row.getCell(13).getStringCellValue();
                        //double branch_code = row.getCell(14).getNumericCellValue();
                        String bank_name = row.getCell(15).getStringCellValue();

                        Dbs dbs = new Dbs();
                        dbs.setDate(date);
                        dbs.setCustomerName(customer_name);
                        dbs.setEmailId(email_id);
                        dbs.setAddress(address);
                        dbs.setVpa(vpa);
                        dbs.setBranchName(branch_name);
                        dbs.setState(state);
                        dbs.setCountry(country);
                        dbs.setPincode(pincode);
                        dbs.setCity(city);
                        dbs.setPan(pan);
                        dbs.setMobileNumber(mobile_number);
                        dbs.setNatureOfBusiness(nature_of_business);
                        dbs.setMcc(mcc);
                        //dbs.setBranchCode(branch_code);
                        dbs.setBankName(bank_name);
                        dbsRepository.save(dbs);
                        log.info("Data saved successfully=========");

                }
            }
        }
    }

    public String stringFormation() {

        String finalstr = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select * from dbs";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String customerName = resultset.getString(8);
                String city = resultset.getString(6);
                String mcc = resultset.getString(11);
                String pincode = resultset.getString(15);
                String vpa = resultset.getString(17);
                finalstr = String.format("%s%s%s%s%s", customerName, city, vpa, mcc, pincode);
                log.info("finalstr==============={}", finalstr);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return finalstr;

    }

    public String stringFormation3() {

        String str1 = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select d.customer_name  from dbs d";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String customerName = resultset.getString(1);
                str1 = "59" + customerName.length() + String.format("%s", customerName);
                log.info("str==============={}", str1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str1;

    }

    public String stringFormation1() {

        String str1 = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select d.vpa  from dbs d";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String vpa = resultset.getString(1);
                str1 = "26" + (14 + 4 + vpa.length() + 7);
                log.info("str==============={}", str1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str1;

    }

    public String stringFormation2() {

        String str1 = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select d.mcc  from dbs d";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String mcc = resultset.getString(1);
                str1 = "5204" + String.format("%s", mcc);
                log.info("str==============={}", str1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str1;

    }

    public String stringFormation4() {

        String str1 = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select d.city  from dbs d";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String city = resultset.getString(1);
                //String result = String.format("%4d", i * j);
                if (city.length() < 10) {
                    str1 = "600" + city.length() + String.format("%s", city);
                    log.info("str==============={}", str1);
                } else {
                    str1 = "60" + city.length() + String.format("%s", city);
                    log.info("str==============={}", str1);
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str1;

    }

    public String stringFormation5() {

        String str1 = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select d.pincode  from dbs d";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String pincode = resultset.getString(1);
                str1 = "6106" + String.format("%s", pincode);
                log.info("str==============={}", str1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str1;

    }

    public String stringFormation6() {

        String str1 = null;
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
            Statement stmnt = con.createStatement();
            String query = "Select d.vpa  from dbs d";
            ResultSet resultset = stmnt.executeQuery(query);
            while (resultset.next()) {
                String vpa = resultset.getString(1);
                if (vpa.length() < 10) {
                    str1 = "010" + vpa.length() + String.format("%s", vpa);
                    log.info("str==============={}", str1);
                } else {
                    str1 = "01" + vpa.length() + String.format("%s", vpa);
                    log.info("str==============={}", str1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str1;

    }


    public String increment() {

        String str = "00000";
        Integer i = Integer.parseInt(str);
        i++;
        str = String.format("%0" + str.length() + "d", i);
        log.info("str============={}", str);

        return str;
    }


    public String crccal(String bytes) {

        int crc1 = 0xFFFF;          // initial value
        int polynomial = 0x1021;   // 0001 0000 0010 0001  (0, 5, 12)

        //byte[] bytes = "00020101021102164000000000000000082700000000000000000000000000026470010A0000005240108MAAD@LVB02030.027230010A0000005240105000025204541153033565802IN5923MYLAPORE AMBIKA APPALAM6008MYLAPORE61066000046212070800000000".getBytes("ASCII");
        byte[] bytes1 = bytes.getBytes();
        for (byte b : bytes1) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc1 >> 15 & 1) == 1);
                crc1 <<= 1;
                if (c15 ^ bit) crc1 ^= polynomial;
            }
        }
        crc1 &= 0xffff;
        log.info("CRC16-CCITT = " + Integer.toHexString(crc1));
        String crc = "6304" + Integer.toHexString(crc1);
        log.info("crc============={}", crc);
        return crc;
    }


    public byte[] generateQr(String qrstring, int width, int height) throws Exception {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrstring, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig(0xFF000000, 0xFFFFFFFF);
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, con);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;


    }

    public List<Dbs> getQrdata() {
        return dbsRepository.getData();
    }


    public void writeDataIntoExcel(List<String> qrlist) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream outputStream = new FileOutputStream("D:\\dbsproject\\QrString.xlsx");
        XSSFSheet spreadsheet
                = workbook.createSheet(" DBS Qr String ");

        /*Map<String, Object[]> qrstring
                = new TreeMap<String, Object[]>();*/

        String[] headers = {"QrString"};
        Row headerRow = spreadsheet.createRow(0);
        Font font = workbook.createFont();
        font.setBold(true);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i, CellType.STRING);
            cell.setCellValue(headers[i]);
        }
        for (int i = 0; i < qrlist.size(); i++) {
            List<String> item = Collections.singletonList(qrlist.get(i));
            XSSFRow row = spreadsheet.createRow(i + 1);
            for (int j = 0; j < item.size(); j++) {
                row.createCell(j).setCellValue(item.get(j));
            }
        }


        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        log.info("Qrstring is written successfully!!!");
           // return workbook;

    }

    private static final String REMOTE_HOST = "192.168.4.200";
    private static final String USERNAME = "uat";
    private static final String PASSWORD = "Uat@1234";
    private static final int REMOTE_PORT = 22;
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;
    //String remoteFile="dbsinput2.xlsx";
    String remoteFile="/home/uat";
    String localDir="D:\\dbsproject\\";

    public  void sftpDownload() throws JSchException, SftpException {

        JSch jsch = new JSch();
        Session jschSession = jsch.getSession(USERNAME, REMOTE_HOST);
        jschSession.setPassword(PASSWORD);
        jschSession.connect();
        //return (ChannelSftp) jschSession.openChannel("sftp");
        Channel sftp = jschSession.openChannel("sftp");
        jschSession.connect(SESSION_TIMEOUT);
        sftp.connect(CHANNEL_TIMEOUT);
        ChannelSftp channelSftp = (ChannelSftp) sftp;
        channelSftp.get(remoteFile, localDir+"dbsinput.xlsx");

    }




}




