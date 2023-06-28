package com.homework26.homework26.list;

import com.homework26.homework26.exception.ElementNoFoundException;
import com.homework26.homework26.exception.InvalidIndexException;
import com.homework26.homework26.exception.ItemCannotBeNullException;
import com.homework26.homework26.exception.StorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {

    private StringListImpl list;

    @BeforeEach
    public void setUp() {
        list = new StringListImpl();
    }

    @Test
    void addTest() {
        list.add("Roman");
        assertEquals(1, list.size());
        assertTrue(list.contains("Roman"));
    }

    @Test
    void addForIndexTest() {
        list.add("Hello");
        list.add("Pasha");
        list.add(1, "friend");
        assertEquals("Hello", list.get(0));
        assertEquals("friend", list.get(1));
        assertEquals("Pasha", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void removeTest() {
        list.add("Jorge");
        list.remove("Jorge");
        assertTrue(list.isEmpty());
    }

    @Test
    void removeForIndexTest() {
        list.add("Star");
        list.add("Wars");
        list.remove(0);
        assertEquals("Wars", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void setTest() {
        list.add("Hello");
        list.add("Rita");
        list.set(0, "Bye-Bye");
        assertEquals("Bye-Bye", list.get(0));
    }

    @Test
    void indexOfTest() {
        list.add("Sveta");
        list.add("Anna");
        list.add("Marina");
        assertEquals(0, list.indexOf("Sveta"));
        assertEquals(1, list.indexOf("Anna"));
        assertEquals(2, list.lastIndexOf("Marina"));
        assertEquals(-1, list.indexOf("Bob"));
    }

    @Test
    void equalsTest() {
        StringList otherList = new StringListImpl();
        list.add("Hello");
        otherList.add("Hello");
        assertTrue(list.equals(otherList));
    }

    @Test
    void clearTest() {
        list.add("Hello");
        list.add("World");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void add_StorageIsFullExceptionTest() {
        for (int i = 0; i < 10; i++) {
            list.add("Item " + i);
        }
        assertThrows(StorageIsFullException.class, () ->
                list.add("Extra Item"));
    }

    @Test
    void add_InvalidIndexExceptionTest() {
        assertThrows(InvalidIndexException.class, () ->
                list.add(-1, "Sasha"));
    }

    @Test
    void add_ItemCannotBeNullException() {
        assertThrows(ItemCannotBeNullException.class, () ->
                list.add(null));
    }

    @Test
    void set_NullItemExceptionTest() {
        list.add("Hello");
        assertThrows(ItemCannotBeNullException.class, () ->
                list.set(0, null));
    }

    @Test
    void remove_ElementNoFoundExceptionTest() {
        assertThrows(ElementNoFoundException.class, () ->
                list.remove("Sasha"));
    }
}
