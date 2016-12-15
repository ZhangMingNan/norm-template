package com.neusoft.norm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 作者: 张明楠 创建于 16/9/14.
 */
public class ListTest {
    @Test
    public void testAssertList1() {

        List<String> actual = Arrays.asList("a", "b", "c");
        List<String> expected = Arrays.asList("a", "b", "c");

        //All passed / true

        //1. Test equal.
        assertThat(actual, is(expected));

        //2. If List has this value?
        assertThat(actual, hasItems("b"));

        //3. Check List Size
        assertThat(actual, hasSize(3));

        assertThat(actual.size(), is(3));

        //4.  List order

        // Ensure Correct order
        assertThat(actual, contains("a", "b", "c"));

        // Can be any order
        assertThat(actual, containsInAnyOrder("c", "b", "a"));

        //5. check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

    }
    @Test
    public void testAssertList2() {

        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        //All passed / true

        //1. Test equal.
        assertThat(actual, is(expected));

        //2. Check List has this value
        assertThat(actual, hasItems(2));

        //3. Check List Size
        assertThat(actual, hasSize(5));

        assertThat(actual.size(), is(5));

        //4.  List order

        // Ensure Correct order
        assertThat(actual, contains(1, 2, 3, 4, 5));

        // Can be any order
        assertThat(actual, containsInAnyOrder(5, 4, 3, 2, 1));

        //5. check empty list
        assertThat(actual, not(IsEmptyCollection.empty()));

        assertThat(new ArrayList<>(), IsEmptyCollection.empty());

        //6. Test numeric comparisons
        assertThat(actual, everyItem(greaterThanOrEqualTo(1)));

        assertThat(actual, everyItem(lessThan(10)));

    }
    @Test
    public void testAssertList3() {

        List<Fruit> list = Arrays.asList(
                new Fruit("Banana", 99),
                new Fruit("Apple", 20)
        );

        //Test equals
        assertThat(list, hasItems(
                new Fruit("Banana", 99),
                new Fruit("Apple", 20)
        ));

        assertThat(list, containsInAnyOrder(
                new Fruit("Apple", 20),
                new Fruit("Banana", 99)
        ));

        //Test class property, and its value
        assertThat(list, containsInAnyOrder(
                hasProperty("name", is("Apple")),
                hasProperty("name", is("Banana"))
        ));

    }

    public class Fruit {

        public Fruit(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }

        private String name;
        private int qty;

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //Test equal, override equals() and hashCode()
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fruit fruit = (Fruit) o;
            return qty == fruit.qty &&
                    Objects.equals(name, fruit.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, qty);
        }
    }

}
