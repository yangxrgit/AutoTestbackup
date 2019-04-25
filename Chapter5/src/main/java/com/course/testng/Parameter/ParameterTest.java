package com.course.testng.Parameter;

import org.testng.annotations.Parameters;

public class ParameterTest {

    @Parameters({"name","age"})
    public void paramTest(String name,int age){
        System.out.println("name=" + name + ";age=" + age);
    }

}
