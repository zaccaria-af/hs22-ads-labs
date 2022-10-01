package ch.zhaw.ads.lab01;

import ch.zhaw.ads.Stack;

import java.util.LinkedList;
import java.util.List;

public class ListStack implements Stack {

    private List<Object> list = new LinkedList<>();

    public ListStack() {
    }

    @Override
    public void push(Object x) throws StackOverflowError {
        list.add(0,x);
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void removeAll() {
        list = new LinkedList<>();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
