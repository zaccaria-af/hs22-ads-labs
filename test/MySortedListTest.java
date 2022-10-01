/**
 * @(#)ListTest.java
 *
 *
 * @author
 * @version 1.00 2017/8/30
 */

import ch.zhaw.ads.MySortedList;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;

public class MySortedListTest {
    MySortedList list;

    String fileToTest = "MySortedList.java";

    @Test
    public void checkFileUpload() throws Exception {
        File f = new File(fileToTest);
        assertTrue("File uploaded "+fileToTest,f.exists());
    }

    @Before
    public void setUp() throws Exception {
        list = new MySortedList();
    }

    @Test
    public void testAdd() {
        list.clear();
        list.add("A");
        Object o = list.get(0);
        assertEquals("A", o);
    }

    @Test
    public void testAdd2() {
        list.clear();
        list.add("B");
        list.add("A");
        Object o = list.get(0);
        assertEquals("A",o);
        o = list.get(1);
        assertEquals("B",o);
    }

    @Test
    public void testAdd3() {
        list.clear();
        list.add("C");
        list.add("B");
        list.add("A");
        Object o = list.get(0);
        assertEquals("A",o);
        o = list.get(1);
        assertEquals("B",o);
        o = list.get(2);
        assertEquals("C",o);
    }

    @Test
    public void testMixed() {
        List list2 = new LinkedList();
        for (int i = 0; i < 100; i++) {
            Character c = (char) ('A' + (Math.random()*26));
            // System.out.println(""+ c);
            int op = (int)(Math.random()*2);
            switch (op) {
                case 0 : list.add(c); list2.add(c); break;
                case 1 : list.remove(c); list2.remove(c); break;
            }
        }
        Collections.sort(list2);
        assertEquals(list2.size(), list.size());
        for (int i = 0; i < list.size(); i++) {
            char c1 = (char)list.get(i);
            char c2 = (char)list2.get(i);
            assertEquals(c1,c2);
        }

    }

}
