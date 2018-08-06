package com.course.testng.Groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("GroupsOnClass3中的stu1运行");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3中的stu2运行");
    }
}
