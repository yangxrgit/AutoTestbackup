package com.course.testng.Groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组测试方法222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组的测试方法333");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组测试方法444");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组方法运行之前运行的内容");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组方法运行之后运行的内容！！");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组方法运行之前运行的内容");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组方法运行之后运行的内容！！");
    }

}
