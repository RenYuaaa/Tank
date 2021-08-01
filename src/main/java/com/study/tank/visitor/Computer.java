package com.study.tank.visitor;


/**
 * @author: renjiahui
 * @date: 2021-08-01 23:54
 * @description: visitor访问者模式：在结构不变的情况下动态改变对于内部元素的动作
 *  visitor模式适用于内部结构固定的
 *  该模式没有策略模式灵活，策略模式可以根据不同的条件做不同的事情，但该模式是做的事情相同，只是做的方法不同的区别。
 *  visitor模式总结起来，就是不同的人对同一件事的处理方式不同
 */
public class Computer {

    ComputerPart cup = new CPU();

    ComputerPart memory = new Memory();

    ComputerPart board = new Board();

    public void accept(Visitor visitor) {
        this.cup.accept(visitor);
        this.memory.accept(visitor);
        this.board.accept(visitor);
    }

    public static void main(String[] args) {
        PersonelVisitor personelVisitor = new PersonelVisitor();
        new Computer().accept(personelVisitor);
        System.out.println(personelVisitor.totalPrice);
    }
}

/**
 * 电脑组件
 */
abstract class ComputerPart {

    // TODO：重点是理解这里为什么要有这个accept方法
    abstract void accept(Visitor visitor);

    abstract double getPrice();
}

class CPU extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

interface Visitor {
    void visitCpu(CPU cpu);

    void  visitMemory(Memory memory);

    void visitBoard(Board board);
}

/**
 * 个人来访者
 */
class PersonelVisitor implements Visitor {

    /**
     * 电脑总价格
     */
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.85;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.95;
    }
}

/**
 * 企业来访者
 */
class CorpVisitor implements Visitor {
    /**
     * 电脑总价格
     */
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.75;
    }

    @Override
    public void visitBoard(Board board) {
        totalPrice += board.getPrice()*0.75;
    }
}