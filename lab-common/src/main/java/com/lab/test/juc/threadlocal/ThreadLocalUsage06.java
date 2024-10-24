package com.lab.test.juc.threadlocal;

/**
 * ClassName: ThreadLocalUsage06
 * Description: ThreadLocal用法二，避免传参数的麻烦
 *
 * @Author agility6
 * @Create 2024/9/27 23:01
 * @Version: 1.0
 */
public class ThreadLocalUsage06 {

    public static void main(String[] args) {
        new Service1().process("");
    }
}

class Service1 {
    public void process(String name) {
        User user = new User("agility6");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2拿到用户名：" + user.name);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}