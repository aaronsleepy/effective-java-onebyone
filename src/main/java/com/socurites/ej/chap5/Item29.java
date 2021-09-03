package com.socurites.ej.chap5;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 29. 이왕이면 제네릭 타입으로 만들라
 */
public class Item29 {

    // Before Generic Type
    static class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (0 == size) {
                throw new EmptyStackException();
            }

            Object result = elements[--size];
            elements[size] = null;
            return result;
        }

        private void ensureCapacity() {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }


    // Generic Type
    static class GenericStack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public GenericStack() {
            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public E pop() {
            if (0 == size) {
                throw new EmptyStackException();
            }

            E result = elements[--size];
            elements[size] = null;
            return result;
        }

        private void ensureCapacity() {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }
}
