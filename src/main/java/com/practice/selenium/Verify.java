package com.practice.selenium;

import java.util.List;

import org.openqa.selenium.By;

public class Verify {
   public static boolean equalValues(String actual, String expect) {
	   if(actual.equals(expect)) {
		   System.out.println(actual +" equal to "+ expect);
		   return true;
	   }else {
		   System.out.println(actual +" is not equal "+ expect);
		   return false;
	   }
   }
   
   public static boolean containsValues(String actual, String expect) {
	   if(actual.contains(expect)) {
		   System.out.println(actual +" contains "+ expect + "PASS");
		   return true;
	   }else {
		   System.out.println(actual + " does not contains " + expect+ "FAIL");
		   return false;
	   }
   }
   
   public static boolean validateTitleText(String actual, String expect) {
	   if(actual.equals(expect)) {
		   System.out.println("The Validation is passed");
		   return true;
	   }else {
		   System.out.println("The Validation is not passed");
		   return false;
	   }
	   
   }

   public static boolean containsValues(List<String> actual, String expect) {
	 if(actual.contains(expect)) {
		   System.out.println(expect + " is in the list");
		   return true;
	   }else {
		   System.out.println(expect + " is not in the list");
		   return false;
	   }
	
}
   
   
}
