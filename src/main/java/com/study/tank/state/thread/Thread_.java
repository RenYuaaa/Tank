package com.study.tank.state.thread;

/**
 * @author: renjiahui
 * @date: 2021-08-08 20:06
 * @description:
 */
public class Thread_ {

    ThreadState_ state;

    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }
}
