package Utils;

import entity.Student;

import javax.servlet.http.HttpServletRequest;

public class getStudentEntity {

    static Student getEntity(HttpServletRequest request){
        String name = request.getParameter("student_name");
        String sex = request.getParameter("sex");
        String nation = request.getParameter("nation");
        String studentID = request.getParameter("studentID");
        String school = request.getParameter("school");
        String major = request.getParameter("major");

        Student student = new Student();
        student.setName(name);
        student.setSex(sex);
        student.setNation(nation);
        student.setStudentId(studentID);
        student.setSchool(school);
        student.setMajor(major);
        return student;
    }
}
