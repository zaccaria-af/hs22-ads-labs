import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ch.zhaw.ads.MyList;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {

    private MyList myList;

    @Before
    public void setUp() throws Exception {
        myList = new MyList();
    }

    @Test
    public void testAdd() {
        String test = "test";
        assertTrue("Add should work", myList.add(test));
    }

    @Test
    public void testAddRemoveGet() {
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";
        myList.add(one);
        myList.add(two);
        myList.add(three);
        myList.add(four);

        assertEquals("4 should be at position 4 in the beginning", four, myList.get(4));
        assertTrue("Testing remove", myList.remove(two));
        assertEquals("Size should be 3 now", 3, myList.size());
        assertEquals("4 Should be at position 3 now", four, myList.get(3));
    }

}
