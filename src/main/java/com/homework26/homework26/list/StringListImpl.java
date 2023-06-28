package com.homework26.homework26.list;

import com.homework26.homework26.exception.ElementNoFoundException;
import com.homework26.homework26.exception.InvalidIndexException;
import com.homework26.homework26.exception.ItemCannotBeNullException;
import com.homework26.homework26.exception.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] elements;
    private int size;

    public StringListImpl() {
        elements = new String[10];
    }

    public StringListImpl(int initSize) {
        elements = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        elements[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            elements[size++] = item;
            return item;
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        elements[index] = item;
        return item;
    }


    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNoFoundException();
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = elements[index];
        if (index != size-1) {
            System.arraycopy(elements, index + 1, elements, index, size - index-1);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new ItemCannotBeNullException();
        }
    }

    private void validateSize() {
        if (size == elements.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }
}
