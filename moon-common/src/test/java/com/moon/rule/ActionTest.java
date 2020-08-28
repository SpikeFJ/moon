package com.moon.rule;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {

    @Test
    public  void test1(){
        // if(deviceA.日电量>1000)
        // then  在 XX 时间 do 打印日电量

        // if(用户A属于角色B)
        // then  在 XX 时间 do(用户A移除)

        // if 业务对象的属性/数据 满足 条件
        // then 立刻/延时 执行 action

        //设备A，用户都属于业务对象
        //日电量、角色都属于业务对象的属性/数据
        //所以 条件 是针对 具体的业务对象 设置的
        //if 都是事件触发吗，时间触发呢：时间是不是也可以归纳为事件触发


        //目前主流的iftt都是针对对象，如相册的 新增、打开、查询、删除等动作，触发后续动作
        //很多触发器和动作应该是通用的

    }

}