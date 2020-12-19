package entity;


public class Student {

    private int id;
    private String name;
    private String sex;
    private String nation;// 民族
    private String school;// 学院
    private String major;//专业
    private String studentId;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return
                "序号=" + id +
                ", 姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 民族='" + nation + '\'' +
                ", 学院='" + school + '\'' +
                ", 专业='" + major + '\'' +
                ", 学号='" + studentId + '\'';
    }
}
