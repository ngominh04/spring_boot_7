package com.vn.devmaster.quanlysinhvien.demosinhvien.projection;

public interface IStudent_MonHoc {
    //Danh sách những sinh viên thi nhiều hơn 2 môn, gồm có Mã sinh viên, Họ tên  sinh viên, Số môn thi
    Integer getId();
    String getName();
    int getSoMonThi();
}
