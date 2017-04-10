package com.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

/**
 * @author David Shahbazyan
 * @since Apr 06, 2017
 */
public class ListTest_TestNG {
    private List<Integer> list;

    @BeforeMethod
    public void initMethodData() {
        list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void testListRemoveOneItem() {
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
    }

    @Test(description = "Removing an item from list using a for cycle will proceed with no exceptions.")
    public void testListCyclicRemoveItem_for() {
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }
        System.out.println(list);
    }

    @Test(description = "Removing an item from list using an iterator will proceed with no exceptions.")
    public void testListCyclicRemoveItem_iterator() {
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }

    @Test(expectedExceptions = ConcurrentModificationException.class,
            description = "Removing an item from list using foreach cycle will cause an ConcurrentModificationException.")
    public void testListCyclicRemoveItem_foreach() {
        System.out.println(list);
        for (Integer integer : list) {
            list.remove(integer);
        }
        System.out.println(list);
    }

    @AfterMethod
    public void removeMethodData() {
        list = null;
    }
}
