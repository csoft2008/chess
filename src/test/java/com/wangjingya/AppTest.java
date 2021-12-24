package com.wangjingya;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
//        System.out.println((int)'⑪');
//        assertTrue( true );
//        System.out.printf("%02d",1);
//        System.out.println("\u001b[4;31;42mHelloWorld!");
//        System.out.println("\u001b[0m");
//        System.out.println("asdfasdf");
        System.out.print("a");
        System.out.print("\u001b[0;"+(32 + 1)+";40m");
        System.out.printf("%02d",2);
        System.out.print("\u001b[0m");
        System.out.print("a");
        System.out.format("\33[32;4m我是博主%n");//%n表示换行
    }
}
