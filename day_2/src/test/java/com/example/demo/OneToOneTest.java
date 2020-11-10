package com.example.demo;

import com.example.demo.entity.Card;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repository.CardRepository;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 * FileName:OneToOneTest
 * Author: kaishen
 * Date: 2020/10/26 19:08
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OneToOneTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void testManytoMany(){
        HashSet<Student> students = new HashSet<>();
        HashSet<Teacher> teachers = new HashSet<>();
        Student student = new Student();
        student.setName("济公");
        Student student2 = new Student();
        student2.setName("武松");
        students.add(student);
        students.add(student2);

        studentRepository.save(student);
        studentRepository.save(student2);

        Teacher teacher1 = new Teacher();
        teacher1.setName("聋老师");
        teacher1.setStudents(students);
        teachers.add(teacher1);
        teacherRepository.save(teacher1);
    }



    @Test
    public void testOneToMoney(){
        //关联添加
        /*School school = new School();
        school.setName("清华大学");
        schoolRepository.save(school);
        Teacher teacher = new Teacher();
        teacher.setName("孔子");
        teacher.setSchool(school);
        teacherRepository.save(teacher);*/

        //关联查询
        /*School school = schoolRepository.findById(1L).get();
        List<Teacher> list = school.getTeacherList();
        System.out.println(school.getName());
        for (Teacher teacher: list
             ) {
            System.out.println(teacher.getName());
        }*/
        //先将Teacher表的外键设置为空，然后删除school表的指定值
        //schoolRepository.deleteById(1L);

        //直接删除指定的Teacher表的值，并没有删除School表的数据
        //teacherRepository.deleteById(1L);
    }

    @Test
    public void testOneToOne(){
        Student student1 = new Student();
        student1.setName("乔峰");
        student1.setSex("male");
        Student student2 = new Student();
        student2.setName("鸠摩智");
        student2.setSex("male");
        Card card1 = new Card();
        card1.setNum(422802);
        Card card2 = new Card();
        card2.setNum(422803);

//        student1.setCard(card1);

        /*studentRepository.save(student1);   //关联保存

        studentRepository.save(student2);   //分别保存
        cardRepository.save(card2);*/

        studentRepository.deleteById(1L);   //关联删除
    }
}
