package com.study.tank.command;

/**
 * @author: renjiahui
 * @date: 2021-08-04 23:47
 * @description:
 */
public class DeleteCommand extends Command {
    Content content;

    String deleted;

    public DeleteCommand(Content content) {
        this.content = content;
    }

    @Override
    public void execute() {
        deleted = content.msg.substring(0, 5);
        content.msg = content.msg.substring(5, content.msg.length());
    }

    @Override
    public void unExecute() {
        content.msg = deleted + content.msg;
    }
}
