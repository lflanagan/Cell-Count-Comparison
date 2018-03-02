//A program that calculates the theoretical RPM of a motor.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		  
		//Explanation of program to user
        System.out.println("Welcome to Liam's RPM Calculator. This Program helps find and compare the theroertical results of two different motor and battery combonatoins.");
        System.out.println("------");
        
        //Set Variables
		Scanner input = new Scanner(System.in);
		
		int Kv = 0, //Kv of the motor (Kv = RPM per Volt - A motor that's 2300 Kv would spin 2300 times per minute when given 1 volt, under no load.)
				CellCount = 0, //Cell count of the battery (The amount of cells in the user's LiPo battery.)
				mAh = 0; //Miliamp hours (The capacity of the user's LiPo Battery)
		
		double Amp = 0, //Current (Used in the program to provide theoretical battery life statistics to the user)
				Watts = 0, //Amps * Volts (A unit of power)
				PackVoltage = 0, //The voltage of the entire battery at full charge (The Voltage of each cell Multiplied by the cell count)
				NominalPackVoltage = 0, //The voltage of the entire battery once it's been discharged to a 'safe' level.
				MaxRPM = 0, //The RPM of the motor on a fully charged Battery
				MinRPM = 0, //The RPM of the motor once the battery reaches Nominal Voltage
				Wh = 0, //Watt Hours - Used to measure the amount of energy in a battery
				BatteryLife = 0, //The length the battery will last in hours when provided with a constant discharge rate
				CellVoltage = 0, //The voltage of each cell, usually 4.20, but is higher on some batteries.
				BatteryLifeMin = 0, //The length the battery will last in minutes when provided with a constant discharge rate.
				NominalCellVoltage = 3.70, //The voltage of each cell at nominal voltage.
				Wh80 = 0,
				mAh80 = 0;
		//Enter Values
		System.out.println("Enter the Kv of the motor: ");
        Kv = input.nextInt();
        System.out.println("Enter the cell count of the LiPo Battery: ");
        CellCount = input.nextInt();
        System.out.println("Is the charged voltage of each cell 4.20 volts? (yes/no)");
        String response = input.next();
        
        //Learned .equalsIgnoreCase from a friend.
        
        if(response.equalsIgnoreCase("yes")){
            CellVoltage = 4.20;
        }
        else if(response.equalsIgnoreCase("no")){
            System.out.println("Enter the voltage of the cells: ");
            CellVoltage = input.nextDouble();
        }
        System.out.println("Would you like to calculate the Watt Hours of your Battery? (yes/no)");
        String response1 = input.next();
        
        if(response1.equalsIgnoreCase("yes")){
        	System.out.println("Enter the number of miliamp hours in your battery: ");
        	  mAh = input.nextInt();
        	System.out.println("Would you like to calculate the estimated run time of your Battery? (yes/no)");
              String response2 = input.next();
            if(response2.equalsIgnoreCase("yes")){
            	Watts = 200;
            }
            else if(response2.equalsIgnoreCase("no")){
            	Watts  = 0;
            }
        }
        else if(response1.equalsIgnoreCase("no")){
             mAh = 0; 
        }
        //Do Math
        
        PackVoltage = (CellVoltage * CellCount);
        
        NominalPackVoltage = (NominalCellVoltage * CellCount);
        
        //Rounds to 10ths place (Was having some issues where it would print 25.2000000003 or similar)
        
        PackVoltage = (double)Math.round(PackVoltage*10)/10;
        
        NominalPackVoltage = (double)Math.round(NominalPackVoltage*10)/10;
        
        //Watt hours = miliamp hour x voltage/1000
        
        Wh = mAh * PackVoltage / 1000;
        
        Wh = (double)Math.round(Wh*10)/10;

        //RPM = Kv x Voltage
        
        MaxRPM = PackVoltage * Kv;
        MinRPM = NominalPackVoltage * Kv;        
        
        System.out.println("------");
        System.out.println("The theoretical RPM of your motors (" + Kv + " Kv) with a fully charged " + CellCount + " cell LiPo (" + PackVoltage + " Volts) is " + MaxRPM + " RPM");
        System.out.println("The theoretical RPM of your motors (" + Kv + " Kv) with a nominal voltage " + CellCount + " cell LiPo (" + NominalPackVoltage + " Volts) is " + MinRPM + " RPM");
        System.out.println("------");
        if(Wh > 0) {System.out.println("The Watt Hours of a Fully Charged " + mAh + "mAh, " + CellCount + " cell LiPo (" + PackVoltage + " Volts) is " + Wh + " Watt Hours");
        System.out.println("------");
        if(Watts > 0) {
        	System.out.println("A battery of " + Wh + " Watt hours that is drained of rougly 80% of it's full capacity should last...");
        	while (Watts <= 600)
             {
        		mAh80 = (int)(mAh*(80/100.0f)); //Learned how to write find % command from stack overflow
        		
        		Wh80 = mAh80 * PackVoltage / 1000;
      
        	    Wh80 = (double)Math.round(Wh80*10)/10;
        	    
        		Amp = Watts / PackVoltage;
        		BatteryLife = Wh80 / Watts;
        	    BatteryLifeMin = BatteryLife * 60; 
        	    Amp = (double)Math.round(Amp*10)/10;
        	    BatteryLifeMin = (double)Math.round(BatteryLifeMin*10)/10;

        	    System.out.println(BatteryLifeMin + " Minutes, at a constant discharge of " + Watts + " watts. (@" + PackVoltage + " volts and " + Amp + " Amps)" );
        	     
        	    Watts = Watts + 100;
        	     
             	}
        	 System.out.println("------");
        	 Watts = 200;
        	}
        }
      
        System.out.println("Would you like to compare these results with another Motor + Battery combonation? (yes/no)");
        String response3 = input.next();
        
        if(response3.equals("yes")){
        	Scanner input1 = new Scanner(System.in);
    		
    		int Kv1 = 0, //Kv of the motor (Kv = RPM per Volt - A motor that's 2300 Kv would spin 2300 times per minute when given 1 volt, under no load.)
    				CellCount1 = 0, //Cell count of the battery (The amount of cells in the user's LiPo battery.)
    				mAh1 = 0; //Miliamp hours (The capacity of the user's LiPo Battery)
    		
    		double Amp1 = 0, //Current (Used in the program to provide theoretical battery life statistics to the user)
    				Watts1 = 0, //Amps * Volts (A unit of power)
    				PackVoltage1 = 0, //The voltage of the entire battery at full charge (The Voltage of each cell Multiplied by the cell count)
    				NominalPackVoltage1 = 0, //The voltage of the entire battery once it's been discharged to a 'safe' level.
    				MaxRPM1 = 0, //The RPM of the motor on a fully charged Battery
    				MinRPM1 = 0, //The RPM of the motor once the battery reaches Nominal Voltage
    				Wh1 = 0, //Watt Hours - Used to measure the amount of energy in a battery
    				BatteryLife1 = 0, //The length the battery will last in hours when provided with a constant discharge rate
    				CellVoltage1 = 0, //The voltage of each cell, usually 4.20, but is higher on some batteries.
    				BatteryLifeMin1 = 0, //The length the battery will last in minutes when provided with a constant discharge rate.
    				NominalCellVoltage1 = 3.70, //The voltage of each cell at nominal voltage.
    				Wh801 = 0,
    				mAh801 = 0;
    		
    		//Enter Values
    		System.out.println("Enter the Kv of the motor: ");
            Kv1 = input1.nextInt();
            System.out.println("Enter the cell count of the LiPo Battery: ");
            CellCount1 = input1.nextInt();
            System.out.println("Is the charged voltage of each cell 4.20 volts? (yes/no)");
            String response4 = input1.next();
            
            //Learned .equalsIgnoreCase from a friend.
            
            if(response4.equalsIgnoreCase("yes")){
                CellVoltage1 = 4.20;
            }
            else if(response4.equalsIgnoreCase("no")){
                System.out.println("Enter the voltage of the cells: ");
                CellVoltage1 = input1.nextDouble();
            }
            System.out.println("Would you like to calculate the Watt Hours of your Battery? (yes/no)");
            String response5 = input1.next();
            
            if(response5.equalsIgnoreCase("yes")){
            	System.out.println("Enter the number of miliamp hours in your battery: ");
            	  mAh1 = input1.nextInt();
            	System.out.println("Would you like to calculate the estimated run time of your Battery? (yes/no)");
                  String response6 = input1.next();
                if(response6.equalsIgnoreCase("yes")){
                	Watts1 = 200;
                }
                else if(response6.equalsIgnoreCase("no")){
                	Watts = 0;
                }
            }
            else if(response5.equalsIgnoreCase("no")){
                 mAh1 = 0; 
            }
            //Do Math
            
            PackVoltage1 = (CellVoltage1 * CellCount1);
            
            NominalPackVoltage1 = (NominalCellVoltage1 * CellCount1);
            
            //Rounds to 10ths place (Was having some issues where it would print 25.2000000003 or similar) Learned from a friend.
            
            PackVoltage1 = (double)Math.round(PackVoltage1*10)/10;
            
            NominalPackVoltage1 = (double)Math.round(NominalPackVoltage1*10)/10;
            
            //Watt hours = miliamp hour x voltage/1000
            
            Wh1 = mAh1 * PackVoltage1 / 1000;
            
            Wh1 = (double)Math.round(Wh1*10)/10;

            //RPM = Kv x Voltage
            
            MaxRPM1 = PackVoltage1 * Kv1;
            MinRPM1 = NominalPackVoltage1 * Kv1;        
            
            System.out.println("------");
            System.out.println("The theoretical RPM of the first motor (" + Kv + " Kv) with a fully charged " + CellCount + " cell LiPo (" + PackVoltage + " Volts) is " + MaxRPM + " RPM");
            System.out.println("The theoretical RPM of the first motor (" + Kv + " Kv) with a nominal voltage " + CellCount + " cell LiPo (" + NominalPackVoltage + " Volts) is " + MinRPM + " RPM");
            System.out.println("------");
            if(Wh > 0) {System.out.println("The Watt Hours of the first battery with a fully charged " + mAh + "mAh, " + CellCount + " cell LiPo (" + PackVoltage + " Volts) is " + Wh + " Watt Hours");
            System.out.println("------");
            if(Watts > 0) {
            	System.out.println("The first battery of " + Wh + " Watt hours that is drained of rougly 80% of it's full capacity should last...");
            	while (Watts <= 600)
                 {
            		mAh80 = (int)(mAh*(80/100.0f)); //Learned how to write find % command from stack overflow
            		
            		Wh80 = mAh80 * PackVoltage / 1000;
          
            	    Wh80 = (double)Math.round(Wh80*10)/10;
            	    
            		Amp = Watts / PackVoltage;
            		BatteryLife = Wh80 / Watts;
            	    BatteryLifeMin = BatteryLife * 60; 
            	    Amp = (double)Math.round(Amp*10)/10;
            	    BatteryLifeMin = (double)Math.round(BatteryLifeMin*10)/10;

            	    System.out.println(BatteryLifeMin + " Minutes, at a constant discharge of " + Watts + " watts. (@" + PackVoltage + " volts and " + Amp + " Amps)" );
            	     
            	    Watts = Watts + 100;
            	     
                 	}
            	 System.out.println("------");
            	 Watts = 200;
            	}
            }
          
            System.out.println("The theoretical RPM of the seccond motor is (" + Kv1 + " Kv) with a fully charged " + CellCount1 + " cell LiPo (" + PackVoltage1 + " Volts) is " + MaxRPM1 + " RPM");
            System.out.println("The theoretical RPM of the seccond motor is (" + Kv1 + " Kv) with a nominal voltage " + CellCount1 + " cell LiPo (" + NominalPackVoltage1 + " Volts) is " + MinRPM1 + " RPM");
            System.out.println("------");
            if(Wh1 > 0) {System.out.println("The Watt Hours of the seccond battery with a fully charged  " + mAh1 + "mAh, " + CellCount1 + " cell LiPo (" + PackVoltage1 + " Volts) is " + Wh1 + " Watt Hours");
            System.out.println("------");
            if(Watts1 > 0) {
            	System.out.println("The first battery of " + Wh1 + " Watt hours that is drained of rougly 80% of it's full capacity should last...");
            	while (Watts1 <= 600)
                 {
            		mAh801 = (int)(mAh1*(80/100.0f)); //Learned how to write find % command from stack overflow
            		
            		Wh801 = mAh801 * PackVoltage1 / 1000;
          
            	    Wh801 = (double)Math.round(Wh801*10)/10;
            	    
            		Amp1 = Watts1 / PackVoltage1;
            		BatteryLife1 = Wh801 / Watts1;
            	    BatteryLifeMin1 = BatteryLife1 * 60; 
            	    Amp1 = (double)Math.round(Amp1*10)/10;
            	    BatteryLifeMin1 = (double)Math.round(BatteryLifeMin1*10)/10;

            	    System.out.println(BatteryLifeMin1 + " Minutes, at a constant discharge of " + Watts1 + " watts. (@" + PackVoltage1 + " volts and " + Amp1 + " Amps)" );
            	     
            	    Watts1 = Watts1 + 100;
            	     
                 	}
            	 Watts1 = 200;
            	}
            }
            System.out.println("------");
            System.out.println("Thanks for using my program.");
            }
            else if(response3.equals("no")){
            System.out.println("Thanks for using my program.");
              }      
         }
	}
