package com.vn.devmaster.quanlysinhvien.demosinhvien.projection;

import javax.persistence.criteria.CriteriaBuilder;

public interface IStudent_Truot {
    //Danh sách các sinh viên rớt trên 2 môn, gồm Mã sinh viên, Họ sinh viên, Tên  sinh viên, Mã khoa

    Integer getId();
    String getName();
    String getNameClass();
    int getSoMonTruot();

}
