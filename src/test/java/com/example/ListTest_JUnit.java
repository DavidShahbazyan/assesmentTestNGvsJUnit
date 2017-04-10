package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * @author David Shahbazyan
 * @since Apr 06, 2017
 */
public class ListTest_JUnit {
    private List<Integer> list;

    @Before
    public void initMethodData() {
        list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testListRemoveOneItem() {
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testListCyclicRemoveItem_foreach() {
        System.out.println(list);
        for (Integer integer : list) {
            list.remove(integer);
        }
        System.out.println(list);
    }

    @After
    public void removeMethodData() {
        list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
