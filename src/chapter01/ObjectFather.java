package chapter01;

import org.w3c.dom.ls.LSOutput;

public class ObjectFather {
    int order = 1;

    {
        System.out.println("order in declared fiead: " + order);
    }

    {
        this.order = 2;
        System.out.println("order in block of code: " + order);
    }

    public ObjectFather(int constructOrder) {
        this.order = constructOrder;
        System.out.println("ObjectFather created, order in construct: " + order);
    }
}
