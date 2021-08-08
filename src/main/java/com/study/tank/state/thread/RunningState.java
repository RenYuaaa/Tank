package com.study.tank.state.thread;

/**
 * @author: renjiahui
 * @date: 2021-08-08 20:12
 * @description:
 */
public class RunningState extends ThreadState_ {
    private Thread_ thread;

    public RunningState(Thread_ thread) {
        this.thread = thread;
    }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}
