package com.study.tank.state.v2;

/**
 * @author: renjiahui
 * @date: 2021-08-08 16:44
 * @description: State行为模式
 *  如果一个类，它的很多operation(动作)，都是根据不同的state实现的话，那么就可以将state抽象出来，然后在具体的state中实现state中的方法
 */
public class MM {

    String name;

    MMState state;

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }
}
