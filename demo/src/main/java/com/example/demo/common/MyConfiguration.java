package com.example.demo.common;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getRunner(StudentService studentService) {
        return args -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                printMenu();
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        addStudent(studentService, sc);
                        break;
                    case 2:
                        searchStudent(studentService, sc);
                        break;
                    case 3:
                        editStudentId(studentService, sc);
                        break;
                    case 4:
                        deleteStudent(studentService, sc);
                        break;
                    case 5:
                        showAll(studentService);
                        return;
                    case 6:
//                        updateStudents(studentService, sc);
                        break;
                    case 7:
                        deleteAll(studentService, sc);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        };
    }

    public void printMenu() {
        System.out.println("============================");
        System.out.println("Menu: \n1. Add\n2. Search\n3. Edit\n4. Delete\n5. ShowAll\n6. Search Name\n7. DeleteAll");
    }

    public void addStudent(StudentService studentService, Scanner sc) {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        Students students = new Students(name, email);
        System.out.println(students);
        studentService.saveStudents(students);
    }
    public void searchStudent(StudentService studentService, Scanner sc) {
        System.out.println("Nhap id: ");
        Long id = sc.nextLong();
        Students students = studentService.getStudentsById(id);
        if (students == null) {
            System.out.println("Not found");
        } else {
            System.out.println(students);
        }
    }

    public void editStudentId(StudentService studentService, Scanner sc) {
        System.out.println("Nhap id: ");
        Long id = sc.nextLong();
        Students students = studentService.getStudentsById(id);
        if (students == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Nhap name: ");
            String name = sc.nextLine();
            System.out.println("Nhap email: ");
            String email = sc.nextLine();
            students.setName(name);
            students.setEmail(email);
            studentService.updateStudents(id, students);
        }
    }
    public void deleteStudent(StudentService studentService, Scanner sc) {
        System.out.println("Nhap id: ");
        Long id = sc.nextLong();
        String result = studentService.deleteStudents(id);
        if (result == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Deleted successfully");
        }
    }
    public void deleteAll(StudentService studentService, Scanner sc) {
        studentService.deleteAll();
        System.out.println("All students have been deleted.");
    }
//    public void searchName(StudentService studentService, Scanner sc) {
//        System.out.println("Nhap name: ");
//        String name = sc.nextLine();
//        List<Students> students = studentService.getByName(name);
//        if (students.size() == 0) {
//            System.out.println("Not found");
//        } else {
////            for (Students s : students){
////                System.out.println(s);
////            }
//            students.forEach(
//                    sv->{System.out.println(sv);}
//            );
//        }
//    }

    public void showAll(StudentService studentService){
        List<Students> students = studentService.getAllStudents();
        students.forEach(
                sv->{System.out.println(sv);}
        );
    }

}
