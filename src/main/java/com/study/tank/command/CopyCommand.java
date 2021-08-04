package com.study.tank.command;

/**
 * @author: renjiahui
 * @date: 2021-08-04 23:47
 * @description:
 */
public class CopyCommand extends Command {
    Content content;

    public CopyCommand(Content content) {
        this.content = content;
    }

    @Override
    public void execute() {
        content.msg = content.msg + content.msg;
    }

    @Override
    public void unExecute() {
        content.msg = content.msg.substring(0, content.msg.length() / 2);
    }
}
