package com.weloe.rmi;

import com.weloe.rmi.api.FirstInterface;

import java.rmi.Naming;
import java.util.concurrent.ExecutionException;

//客户端主方法
public class ClientMainClass {
    public static void main(String[] args) {
        //代理对象的创建
        FirstInterface first = null;
        try {
            //使用Lookup找服务，通过名字找服务，并自动创建代理对象
            //类型是Object，对象一定是Proxy的子类型，且一定实现了服务接口。
            first = (FirstInterface) Naming.lookup("rmi://localhost:9999/first");

            System.out.println("对象类型是："+first.getClass().getName());
            String first1 = first.first("world,2333");
            System.out.println(first1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
