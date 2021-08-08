package com.study.tank.state.thread;

/**
 * @author: renjiahui
 * @date: 2021-08-08 20:08
 * @description: 有限状态机的模型，不是state模式
 */
public class NewState extends ThreadState_ {

    private Thread_ thread;

    public NewState(Thread_ thread) {
        this.thread = thread;
    }

    @Override
    void move(Action input) {
        if (input.msg == "start") {
            thread.state = new RunningState(thread);
        }
    }

    @Override
    void run() {

    }
}
