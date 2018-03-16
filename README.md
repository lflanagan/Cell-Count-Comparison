# Cell-Count-Comparison
A Java Program that provides information about a user inputed motor and battery combination.

  Building and racing quadcopter drones is one of my hobbies. This racing season, MultiGP, the company that orgnizes drone races, changed their rules, allowing racers to use higher voltage batteires than they could previously. As a result, many pilots are switching to higher voltage battery packs, as they have the potential to provide pilots with many advantages. While an increase in voltage has the potential to make a our drones go faster, many pilots are opting to use higher voltage batteries to achive longer, and more efficent flights, while keeping their drone's speeds relatively similar. With the increase in voltage limits, pilots are exprimenting with different motor set ups that require less power (Wattage) to achive similar RPMs. This allows pilots to draw less amperage from their battereis, while keeping similar RPMs and overall speed of their aircraft, resulting in longer flight times. **The point of this program is to help pilots compare their existing motor and battery combonations with new potential cobonations, and aims to provide stastics about how two different setups wil theoritically compare.
  
If you're not firmilar with voltage, amperage, and RPM, this program may look intimidating. If you would still like to test it out, but are not sure what vaules to input for each question, I've devised a cheat-sheet that will allow you to expriment with the program while still giving you helpful information. **(The program does not rely on the user to follow the guidelines below - feel free to put in any values you want and see what happens!)**

Here are some basic explainations of what each value is.
Kv = Kv of the motor (Kv = RPM per Volt - A motor that's 2300 Kv would spin 2300 times per minute when given 1 volt, under no load.)
  When working with racing quads, the Kv of a motor is usually in between 1500 and 3000.
  
Cell Count = Number of cells in the battery
  When working with racing quads, the cell count of a battery is usually in between 4 and 6.

mAh = Miliamp hours (The capacity of the user's LiPo Battery)
  When working with racing quads, the mAh of a battery is usually in between 1000 and 2000.
  
Cell Voltage = The voltage of each cell (Multiply this value by the numeber of cells to get the overall voltage of the battery)
   When working with racing quads, the voltage of a fully charged cell is usually 4.20, but is higher on some batteries.
   
 
**DISCLAIMER**
This program is only useful for providing theoritical information, and fails to take into account many of the variables that affect a quad's performance. Here are some of the important variables that the user should to realize this program does not take into account:
  - The Propellors used on the quadcopteor (affects efficiency, motor load, amp draw, etc.)
  - Size of the motor (affects efficiency, amp draw, size of the prop the motor can spin, etc.)
  - Voltage sag and overall load on the battery (affects overall wattage output)
  

