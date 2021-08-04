package com.study.tank.command;

/**
 * @author: renjiahui
 * @date: 2021-08-04 23:49
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        Content content = new Content();

        InsertCommand insertCommand = new InsertCommand();
        insertCommand.execute();
        insertCommand.unExecute();

        CopyCommand copyCommand = new CopyCommand(content);
        copyCommand.execute();
        copyCommand.unExecute();

        DeleteCommand deleteCommand = new DeleteCommand(content);
        deleteCommand.execute();
        deleteCommand.unExecute();

        System.out.println(content.msg);
    }
}
