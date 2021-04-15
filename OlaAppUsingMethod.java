package com.dharshini;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class OlaAppUsingMethod {
	static int rupeePerKm = 0;
	static 	int fare = 0;
	static float fareWithGst = 0f;
	static float peakCharge = 0f;
	static float gstAmount=0f;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter valid Nobile No. and Password");
		long MobileNo = sc.nextLong();
		String password = sc.next();
		logIn(MobileNo, password);
		
		System.out.println("Enter Cab Choice");
		String userCabChoice = sc.next();
		rupeePerKM (userCabChoice);
		
		System.out.println("Enter Km range");
		int km = sc.nextInt();
		fareEstimation(km,userCabChoice);
		
		System.out.println("Enter Journey date in YYYY-MM-DD Format");
		String journeyDate = sc.next();
		System.out.println("Enter Pickup Time in HH:MM Format");
		String pickupTime = sc.next();
		journeyDateMthd(journeyDate,pickupTime);
		sc.close();

	}

//Level 1 - login
	public static void logIn(long MobileNo, String password) {
		// Scanner sc = new Scanner(System.in);
//		System.out.println("Enter valid Mobile No. and Password");
		String mobStr = String.valueOf(MobileNo);
		if (mobStr.length() == 10 && password.length() >= 8) {
			System.out.println("Successfully logged in");
		} else {
			System.out.println("Invalid Mobile number or password");
			
		}
	}

//Level 2 - rupees per km for diff can type
	public static void rupeePerKM(String userCabChoice){
//		System.out.println("Enter Cab Choice");
//		String userCabChoice = sc.next();
//		int rupeePerKm = 0;
		if (userCabChoice.equalsIgnoreCase("Micro")) {
			rupeePerKm = 10;
		}
		if (userCabChoice.equalsIgnoreCase("Mini")) {
			rupeePerKm = 15;
		}
		if (userCabChoice.equalsIgnoreCase("Prime")) {
			rupeePerKm = 20;
		}
		//fareEstimation(rupeePerKm);
	}

//Level 3 - Fare Estimation
	// userCabChoice = sc.next();
	public static void fareEstimation(int km,String userCabChoice) {
	
//	int km = sc.nextInt();
//	int fare = 0;
	if(userCabChoice.equalsIgnoreCase("Micro"))
	{
		System.out.println("Your Cab Type: Micro");
		fare = rupeePerKm * km;
		System.out.println("Fare " + fare);
	}else if(userCabChoice.equalsIgnoreCase("Mini"))
	{
		System.out.println("Your Cab Type: Mini");
		fare = rupeePerKm * km;
		System.out.println("Fare " + fare);
	}else if(userCabChoice.equalsIgnoreCase("Prime"))
	{
		System.out.println("Your Cab Type: Prime");
		fare = rupeePerKm * km;
//		System.out.println("Fare: " + fare);
	}else
	{
		System.out.println("Invalid cab Choice");
	}
	gst(fare);
	//peakHourCalc(fare);
	}

//Level 4 - GST 7%
	public static void gst(int fare) {
	int gst = 7;
	gstAmount = (fare * gst) / 100;System.out.println("GST 7%");System.out.println("GST Amount: "+gstAmount);
	fareWithGst = fare + gstAmount;System.out.println("Total fare with GST: "+fareWithGst);
	}
	
//Level 5 - Journey Date
	// pickup date
	public static void journeyDateMthd(String journeyDate, String pickupTime) {
	LocalDate currentDate = LocalDate.now();
	LocalDate journeyDateObj = LocalDate.parse(journeyDate);
	if(journeyDateObj.isAfter(currentDate)||journeyDateObj.isEqual(currentDate))
	{
		System.out.println("Journey Date " + journeyDateObj);
	}else
	{
		System.out.println("Invalid Journey Date");
	}
	// pickuptime
	LocalTime CurrentTime = LocalTime.now();
	LocalTime pickupTimeObj = LocalTime.parse(pickupTime);
	System.out.println("PickUp Time: " + pickupTimeObj);
	
	peakHourCalc(pickupTimeObj);
	seniorCitizen(currentDate);
	}

//Level 6 - Peak Hour charge
	public static void peakHourCalc(LocalTime pickupTimeObj) {
	float peakHourPercent = 1.25f;	
	int peakHour = pickupTimeObj.getHour();
	if(peakHour>=17&&peakHour<=19)
	{
		System.out.println("17:00 To 19:00 is peakHour.So Peak Hour charge of 1.25% is applicable");
		peakCharge = (fare * peakHourPercent) / 100;
		System.out.println("PeakHour Charge " + peakCharge);
		System.out.println("Total fare with peakHour Charge: " + (fareWithGst + peakCharge));
	}
	}
//level 7 - Senior citizen
	public static void seniorCitizen(LocalDate currentDate) {
	System.out.println("Enter Date Of Birth");
	Scanner sc = new Scanner(System.in);
	String dOb = sc.next();
	LocalDate dObObj = LocalDate.parse(dOb);
	int currentYear = currentDate.getYear();
	int userYear = dObObj.getYear();
	int age = 0;
	float discountAmnt = 0f;if(dObObj.isBefore(currentDate))
	{
		age = currentYear - userYear;
		if (age >= 60) {
			System.out.println("50% discount for senior Citizen");
			discountAmnt = fare / 2;
			System.out.println("your final fare is " + (discountAmnt + peakCharge + gstAmount));
		}
	}else
	{
		System.out.println("Invalid DateOfBirth");
	}
	sc.close();
	
	System.out.println("Total fare: "+fareWithGst);

	}

}
////if login details & journey date is false/invalid, it shuld not proceed
