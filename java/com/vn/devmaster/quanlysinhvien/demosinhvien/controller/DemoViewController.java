package com.vn.devmaster.quanlysinhvien.demosinhvien.controller;

import com.vn.devmaster.quanlysinhvien.demosinhvien.domain.Student;
import com.vn.devmaster.quanlysinhvien.demosinhvien.dto.StudentDTO;
import com.vn.devmaster.quanlysinhvien.demosinhvien.projection.IStudent_MonHoc;
import com.vn.devmaster.quanlysinhvien.demosinhvien.responsitory.StudentReponsitory;
import com.vn.devmaster.quanlysinhvien.demosinhvien.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/view")
public class DemoViewController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentReponsitory studentReponsitory;

//    @GetMapping("/demo/{name}")
//    public String viewDemo(@PathVariable("name") String name, Model model){
//        model.addAttribute("name",name);
//        return "demo";// return ra html vừa khởi tạo
//    }

//    @GetMapping("/demo/student")
//    public String showDemo(Model model){
//        StudentDTO studentDTO=new StudentDTO();
//        studentDTO.setFirst_name("Ngô");
//        studentDTO.setLast_name("Minh");
//        model.addAttribute("student",studentDTO);
//        return "demo"; // return ra html vừa khởi tạo
//    }

    @GetMapping("/demo/studentTable")
    public String showDemoStudentTable(Model model){
        model.addAttribute("studentTbale",studentReponsitory.getStudentMonHoc());
        return "demo";
    }

    @GetMapping("/demo/students_point_max")
    public String showDemoStudents(Model model){
        model.addAttribute("students_point_max", studentReponsitory.getStudentPointMaxList());
        return "demo1";
    }

    @GetMapping("/demo/studentTruot")
    public String showStudentTruot(Model model){
        model.addAttribute("studentTruot",studentReponsitory.getStudentTruot());
        return "demo2";
    }

    @GetMapping("/demo/classAvgMax")
    public String showClassAvgMax(Model model){
        model.addAttribute("classAvgMax",studentReponsitory.getClassAvgMax());
        return "demo3";
    }

}
