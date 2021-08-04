package com.study.tank.command;

/**
 * @author: renjiahui
 * @date: 2021-08-04 23:43
 * @description:
 */
public class InsertCommand extends Command {

    Content content;

    String strToInsert = "Http://www.ren.study.com";

    @Override
    public void execute() {
        content.msg = content.msg + strToInsert;
    }

    @Override
    public void unExecute() {
        content.msg = content.msg.substring(0, content.msg.length() - strToInsert.length());
    }
}
