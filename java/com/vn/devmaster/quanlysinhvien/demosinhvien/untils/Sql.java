package com.vn.devmaster.quanlysinhvien.demosinhvien.untils;

public class Sql {
    public static final String STUDENT_FILTER_BY_CLASS = "" +
            "select S.id id,concat(first_name,' ',last_name) as name,c.nameClasses className,s1.nameSubject subjectName,ss.point point from student s\n" +
            "left join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "left join `manage-student`.classes c on c.id = s.classes_id\n" +
            "left join `manage-student`.subject s1 on ss.id_subject = s1.id\n" +
            "where c.nameClasses='DEV02';";

    public static final String SYTUDENT_POINT_AVG = "" +
            "select S.id id,concat(first_name,' ',last_name) as name,c.nameClasses className ,avg(ss.point) avg from student s\n" +
            "left join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "left join `manage-student`.classes c on c.id = s.classes_id\n" +
            "group by S.id ,concat(first_name,' ',last_name) ,c.nameClasses ";

    public static final String STUDENT_AVG_8 = "" +
            "select S.id id,concat(first_name,' ',last_name) as name,c.nameClasses className ,avg(ss.point) avg from student s\n" +
            "left join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "left join `manage-student`.classes c on c.id = s.classes_id\n" +
            "group by S.id ,concat(first_name,' ',last_name) ,c.nameClasses\n" +
            "having avg(ss.point) >= 8";

    public static final String SUBJECT_AVG = "" +
            "select sub.id id,sub.nameSubject subjectName,avg(ss.point) avg from subject sub\n" +
            "    inner join `manage-student`.student_subject ss on sub.id = ss.id_subject\n" +
            "group by sub.id, sub.nameSubject";

    public static final String STUDENT_MAX_POINT = "" +
            "select concat(s.first_name,' ',s.last_name) name,max(ss.point) maxPoint from student s\n" +
            "    inner join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "group by concat(s.first_name,' ',s.last_name)";

    public static final String CLASS_AVG_MAX = "" +
            "select  classes.nameClasses ClassName,concat(s.first_name,' ',s.last_name) name,avg(ss.point) point from classes\n" +
            "    inner join `manage-student`.student s on classes.id = s.classes_id\n" +
            "    inner join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "    inner join `manage-student`.subject s2 on ss.id_subject = s2.id\n" +
            "group by classes.nameClasses, concat(s.first_name,' ',s.last_name)\n" +
            "having avg(ss.point) >8\n" +
            "order by avg(ss.point) desc\n" +
            "LIMIT 1";

    //Danh sách các sinh viên rớt trên 2 môn, gồm Mã sinh viên, Họ sinh viên, Tên  sinh viên, Mã khoa
    public static final String STUDENT_TRUOT = "" +
            "select s.id id,concat(s.first_name,' ',s.last_name) name, c.nameClasses nameClass\n" +
            "     , count(ss.point) soMonTruot\n" +
            "from student s\n" +
            "    inner join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "    inner join `manage-student`.classes c on s.classes_id = c.id\n" +
            " where ss.point<=4\n" +
            "group by s.id, concat(s.first_name,' ',s.last_name), c.nameClasses";

    //Danh sách những sinh viên thi nhiều hơn 2 môn, gồm có Mã sinh viên, Họ tên  sinh viên, Số môn thi
    public static final String STUDENT_MONHOC = "" +
            "select s.id id,concat(s.first_name,' ',s.last_name) name,count(s2.id) soMonThi from student s\n" +
            "    inner join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "    inner join `manage-student`.subject s2 on ss.id_subject = s2.id\n" +
            "group by s.id, concat(s.first_name,' ',s.last_name)\n" +
            "having count(s2.id) >=2";

    // lấy top 1 những sinh viên điểm cao nhất
    public static final String STUDENT_POINTMAX ="" +
            "select  classes.nameClasses className,concat(s.first_name,' ',s.last_name) name,avg(ss.point) point from classes\n" +
            "    inner join `manage-student`.student s on classes.id = s.classes_id\n" +
            "    inner join `manage-student`.student_subject ss on s.id = ss.id_student\n" +
            "    inner join `manage-student`.subject s2 on ss.id_subject = s2.id\n" +
            "group by classes.nameClasses, concat(s.first_name,' ',s.last_name)\n" +
            "having avg(ss.point) =\n" +
            "       (select avg(s5.point)  from `manage-student`.student_subject s5\n" +
            "           inner join `manage-student`.student s3 on s5.id_student = s3.id\n" +
            "            inner join `manage-student`.subject s4 on s5.id_subject = s4.id\n" +
            "        group by s3.last_name\n" +
            "        order by avg(s5.point) desc\n" +
            "        limit 1)";
}
