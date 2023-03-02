package com.studentcrud.service;

import com.studentcrud.user.Student;
import com.studentcrud.view.UserInterface;
import java.util.ArrayList;

public class StudentManager { //학생관리와 관련된 기능
    //기능은 입력, 검색, 출력, 삭제가 있음

    private static StudentManager studentManager = null;

    private StudentManager() {}

    public static StudentManager getInstance() { //싱글톤
        if(studentManager == null) {
            studentManager = new StudentManager();
        }
        return studentManager;
    }
    ArrayList<Student> list = new ArrayList<>();

    UserInterface ui = new UserInterface();
    public void inputStudent(Student student) { // 입력받은 student ArrayList 를 리스트에 추가해주는 메서드
        list.add(ui.typeStudent());
    }
    public void searchStudent() { //검색할 때 쓰는 메서드
        int search = ui.findStudent();
        Student findedStudent = null;
        for (Student std : list) {
            if (search == std.getId()) {
                findedStudent = std;
            }
        }
        if(findedStudent != null){
            ui.printStudent(findedStudent);
        }else {
            ui.searchFailed(search);
        }
    }
    public boolean studentExistenceTest (int id) { //중복 있으면 true 없으면 false 반환 입력할 때 쓰는 메서드
        Student findedStudent = null;
        for(Student std : list) {
            if(id == std.getId()) {
                findedStudent = std;
            }
        }
        return findedStudent != null;
    }
    public boolean studentLogin(int id,String pw) { //입력 받은 인자로 로그인 하는 메서드
        Student findedStudent = null;
        for(Student std : list) {
            if(id==std.getId()) { //아이디 체크
                findedStudent = std;
            }
        }
        if(findedStudent == null) {
            return false;
        }else {
            return pw.equals(findedStudent.getPw());
        }
    }
    public void deleteStudent() { //삭제
        int search = ui.findStudent(); int cnt = 0;
        for (Student std : list) {
            if (search == std.getId()) {
                list.remove(cnt);
                break;
            }
            cnt ++;
        }
    }
    public void printStudent() { // 출력했을 때 쓰는 전체 리스트가 출력되는 메서드
        for(Student std : list) {
            ui.printStudent(std);
        }
    }
    public int findIndex(int id) { //입력받은 아이디로 인덱스를 찾아주는 메서드
        int cnt = 0;
        for(Student std : list) {
            if(id == std.getId()) {
                break;
            };
            cnt++;
        }
        return cnt;
    }
}



