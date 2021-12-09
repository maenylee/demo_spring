```
模板方法模式仅仅使用了Java的继承机制，但它是一个应用非常广泛的模式。
```

## 定义
   一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
## 通用类图说明
![类关系说明图](https://github.com/maenylee/demo_spring/blob/main/docs/img/bean02/class_relative.jpg?raw=true)
                                     
Abstract Class叫做抽象模板，它的方法分为两类：模板方法和基本方法。

基本方法：基本方法也叫做基本操作，是由子类实现的方法，并且在模板方法中被调用。

模板方法：可以有一个或者几个，一般是具体的方法，也就是一个框架，实现对基本方法的调度，完成固定的逻辑。

具体模板：ConcreteClass1和ConcreteClass2属于具体模板，实现父类所定义的一个或多个抽象方法，也就是父类定义的基本方法在子类中得以实现。

## 通用代码
- 抽象模板类
```
public abstract class AbstractClass {
     //基本方法
     protected abstract void doSomething();
     //基本方法
     protected abstract void doAnything();
     //模板方法
     public void templateMethod(){
             /*
              * 调用基本方法，完成相关的逻辑
              */
             this.doAnything();
             this.doSomething();
     }
}
```
- 具体模板类
```
public class ConcreteClass1 extends AbstractClass {
     //实现基本方法
     protected void doAnything() {
             //业务逻辑处理
     }
     protected void doSomething() {
             //业务逻辑处理
     }
}
public class ConcreteClass2 extends AbstractClass {     //实现基本方法
     protected void doAnything() {
             //业务逻辑处理
     }
     protected void doSomething() {
             //业务逻辑处理
     }
}
```
- 场景类
```
public class Client {
     public static void main(String[] args) {
             AbstractClass class1 = new ConcreteClass1();
             AbstractClass class2 = new ConcreteClass2();               
             //调用模板方法
             class1.templateMethod();
             class2.templateMethod();
     }
}
```
## 优缺点
优点：封装不变部分，扩展可变部分；提取公共部分代码，便于维护；行为由父类控制，子类实现

缺点：按照我们的设计习惯，抽象类负责声明最抽象、最一般的事物属性和方法，实现类完成具体的事物属性和方法。但是模板方法模式却颠倒了，抽象类定义了部分抽象方法，由子类实现，子类执行的结果影响了父类的结果，也就是子类对父类产生了影响，这在复杂的项目中，会带来代码阅读的难度，而且也会让新手产生不适感。

## 总结
模板模式就是在模板方法中对基本方法的调用。为了防止恶意的操作，一般模板方法前面会加上final关键字，不允许被覆写。
————————————————
原文链接：https://blog.csdn.net/qq_25827845/article/details/51868973
