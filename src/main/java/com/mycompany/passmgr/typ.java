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
        
    try {
        Robot robot = new Robot();
        for(int i = 0; i< s.length() ; i++){
            robot.delay(100);
                robot.keyPress(KeyEvent.VK_ALT);
                
                String numberString = Integer.toString((int)s.charAt(i));
                if(s.charAt(i)=='§') numberString = "21";
                
                for (char digitChar : numberString.toCharArray()) {
                    int digit = Character.getNumericValue(digitChar);
                    typeDigit(robot, digit);
                }
                
                robot.keyRelease(KeyEvent.VK_ALT);
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
   }
   private static void typeDigit(Robot robot, int digit) {
        
        if (digit >= 0 && digit <= 9) {
            int keyCode = KeyEvent.VK_NUMPAD0 + digit;
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
}
