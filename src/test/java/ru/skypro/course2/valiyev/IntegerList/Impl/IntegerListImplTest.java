package ru.skypro.course2.valiyev.IntegerList.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.valiyev.IntegerList.IntegerList;
import ru.skypro.course2.valiyev.IntegerList.exception.IntegerListIndexOutOfRangeException;
import ru.skypro.course2.valiyev.IntegerList.exception.IntegerListItemNullException;
import ru.skypro.course2.valiyev.IntegerList.exception.IntegerListNullException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.skypro.course2.valiyev.IntegerList.Impl.Constants.TestConstants.*;

class IntegerListImplTest {
    private final IntegerList integerList_1 = new IntegerListImpl();
    private final IntegerList integerList_2 = new IntegerListImpl();

    @BeforeEach
    void SetUp() {
        for (int i = 0; i < 8; i++) {
            if (i == 5) {
                integerList_1.add(ITEM_LAST_4);
                integerList_2.add(ITEM_LAST_4);
            }
            integerList_1.add(i);
            integerList_2.add(i);
        }
    }
    @Test
    void shouldAddByItem() {
        assertEquals(ITEM_8, integerList_1.add(ITEM_8));
        assertEquals(ITEM_9, integerList_1.add(ITEM_9));
    }

    @Test
    void shouldAddByIndexItem() {
        assertEquals(ITEM_8, integerList_1.add(5, ITEM_8));
        assertEquals(ITEM_9, integerList_1.add(0, ITEM_9));
    }

    @Test
    void shouldAddIndexOutOfRangeException() {
        assertThrows(IntegerListIndexOutOfRangeException.class, () -> integerList_1.add(-1, 1));
    }

    @Test
    void shouldAddNullItemException() {
        assertThrows(IntegerListItemNullException.class, () -> integerList_1.add(1, null));
    }

    @Test
    void shouldSetByIndexItem() {
        assertEquals(ITEM_8, integerList_1.set(5, ITEM_8));
        assertEquals(ITEM_9, integerList_1.set(0, ITEM_9));
    }

    @Test
    void shouldRemoveByItem() {
        assertEquals(INDEX_2, integerList_1.remove(2));
        assertEquals(INDEX_0, integerList_1.remove(0));
    }

    @Test
    void shouldRemoveByIndex() {
        assertEquals(ITEM_7, integerList_1.remove(6));
        assertEquals(ITEM_0, integerList_1.remove(0));
    }

    @Test
    void shouldContainsByItem() {
        assertTrue(integerList_1.contains(ITEM_7));
        assertFalse(integerList_1.contains(ITEM_10));
    }

    @Test
    void shouldIndexOfByItem() {
        assertEquals(4, integerList_1.indexOf(ITEM_5));
    }

    @Test
    void shouldLastIndexOfByItem() {
        assertEquals(5, integerList_1.lastIndexOf(ITEM_LAST_4));
    }

    @Test
    void shouldGetByIndex() {
        assertEquals(ITEM_5, integerList_1.get(4));
    }

    @Test
    void shouldEqualsByOtherIntegerList() {
        assertTrue(integerList_1.equals(integerList_2));
    }

    @Test
    void shouldEqualsIntegerListNullException() {
        assertThrows(IntegerListNullException.class, () -> integerList_1.equals(null));
    }

    @Test
    void shouldSize() {
        assertEquals(9, integerList_1.size());
    }

    @Test
    void shouldIsEmpty() {
        assertTrue(IS_EMPTY_LIST.isEmpty());
    }

    @Test
    void shouldClear() {
        integerList_1.clear();
        assertTrue(integerList_1.isEmpty());
    }

    @Test
    void shouldToArray() {
        assertArrayEquals(integerList_1.toArray(), integerList_2.toArray());
    }
}