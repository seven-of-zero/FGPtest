package com.soz.controller;

import com.soz.pojo.User;
import com.soz.service.UserService;
import com.soz.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class ExportController {

    @Autowired
    private UserService userService;

    @RequestMapping("/export")
    public String export(HttpSession session){
        String name = (String)session.getAttribute("name");
        User user = userService.findAll(name);
        HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
        HSSFSheet sheet = wb.createSheet("表1");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("nickname");
        row.createCell(2).setCellValue("password");
        row.createCell(3).setCellValue("email");
        row.createCell(4).setCellValue("picture");
        row.createCell(5).setCellValue("authority");
        row.createCell(6).setCellValue("token");
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue(user.getId());
        row1.createCell(1).setCellValue(user.getNickname());
        row1.createCell(2).setCellValue(user.getPassword());
        row1.createCell(3).setCellValue(user.getEmail());
        row1.createCell(4).setCellValue(user.getPicture());
        row1.createCell(5).setCellValue(user.getAuthority());
        row1.createCell(6).setCellValue(user.getToken());
        ExcelUtil.exportOutPutExcel("C:\\Users\\Administrator\\Desktop\\ExportExcel.xlsx", wb);
        session.setAttribute("success","导出成功");
        return "redirect:/";
    }

}
