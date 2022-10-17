/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passmgr;
import java.awt.Robot;
import java.awt.event.*;
/**
 *
 * @author HP
 */
public class typ {
   public static void tpt(String s)
   {
       String symb1="&é\"'(-è_çà°+";
    String symb2="~#{[|`\\^@]}";
    String symb3="?./§µ£";
        
    try {
        Robot robot = new Robot();
        for(int i = 0; i< s.length() ; i++){
            robot.delay(100);
            if (Character.isUpperCase(s.charAt(i))||Character.isDigit(s.charAt(i))||"°+".contains(s.charAt(i)+"")||symb3.contains(s.charAt(i)+"")) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }else if(symb2.contains(s.charAt(i)+"")){
                robot.keyPress(KeyEvent.VK_ALT_GRAPH);
            }
            if(symb1.contains(s.charAt(i)+""))
            {
                String nums = "1234567890)=";
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(nums.charAt(symb1.indexOf(s.charAt(i)))));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(nums.charAt(symb1.indexOf(s.charAt(i)))));
            }else if(symb2.contains(s.charAt(i)+""))
            {
                String nums = "234567890)=";
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(nums.charAt(symb2.indexOf(s.charAt(i)))));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(nums.charAt(symb2.indexOf(s.charAt(i)))));
            }else if(symb3.contains(s.charAt(i)+""))
            {
                String nums = ",;:!*$";
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(nums.charAt(symb3.indexOf(s.charAt(i)))));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(nums.charAt(symb3.indexOf(s.charAt(i)))));
            }else {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(s.charAt(i)));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(s.charAt(i)));
            }
                if (Character.isUpperCase(s.charAt(i))||Character.isDigit(s.charAt(i))||symb3.contains(s.charAt(i)+"")||"°+".contains(s.charAt(i)+"")) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }else if(symb2.contains(s.charAt(i)+"")){
                    robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
                }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
   }
}
