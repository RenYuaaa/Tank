package com.study.tank.template.v2;

/**
 * @author: renjiahui
 * @date: 2021-08-08 16:25
 * @description: 模板方法模式2
 *  例如，去银行办理业务一般要经过以下4个流程：取号、排队、办理具体业务、对银行工作人员进行评分等，
 *  其中取号、排队和对银行工作人员进行评分的业务对每个客户是一样的，可以在父类中实现，
 *  但是办理具体业务却因人而异，它可能是存款、取款或者转账等，可以延迟到子类中实现。
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();
    }
}


/**
 * 抽象类
 */
abstract class AbstractClass {

    /**
     * 模板方法
     */
    public void TemplateMethod() {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void SpecificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    /**
     * 抽象方法1
     */
    public abstract void abstractMethod1();

    /**
     * 抽象方法2
     */
    public abstract void abstractMethod2();
}

/**
 * 具体子类
 */
class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
