import org.junit.*;

import static org.junit.Assert.*;

public class MyMathTest {
    MyMath myMath = new MyMath();
    //MyMath.sum
    //1,2,3 => 6
    @Before
    public void beforeAll(){
        System.out.println("before");
    }

    @After
    public void afterAll(){
        System.out.println("after");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Test
    public void sumWith3Nums(){
        System.out.println("Test1");
        //Check that result is 6
        assertEquals(6, myMath.sum(new int[]{1,2,3}));
    }

    @Test
    public void sumWith1Num(){
        System.out.println("Test2");
        assertEquals(3, myMath.sum(new int[]{3}));
    }

    @Test
    public void assertTest(){
        System.out.println("Test3");
        assertEquals(1,1);
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
    }

}