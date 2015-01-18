package org.usfirst.frc.team811.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public abstract class Lift extends Subsystem {
	
	Talon leftT;
	Talon rightT;
	Encoder leftE;
	Encoder rightE;
	DigitalInput limitTop;
	DigitalInput limitBottom;
	Joystick joy1;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void init() {
    	
    	leftT = new Talon(1);
    	rightT = new Talon(2);
    	leftE = new Encoder(1, 2);
    	rightE = new Encoder(2, 3);
    	limitTop = new DigitalInput(3);
    	limitBottom = new DigitalInput(4);
    	joy1 = new Joystick(1);
    	
    	boolean hitBottom = limitBottom.get();
    	
    	if (!hitBottom) {
    		leftT.set(-1);
    		rightT.set(-1);
    	} else {
    		leftT.set(0);
    		rightT.set(0);
    		leftE.reset();
    		rightE.reset();
    	}
    	
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void run() {
    	
    	double countL = leftE.get();
    	double countR = rightE.get();
    	
    	double y1 = joy1.getRawAxis(2);
    	double y2 = joy1.getRawAxis(1);
    	
    	
		//this is assuming that the count value will go down if the encoder spins backwards
    	if (countL > 50 || countR > 50 ) {
    		if (y1 <= 0) {
    			leftT.set(y1);
    	    	rightT.set(y1);
    		} else {
    			leftT.set(0);
        		rightT.set(0);
    		}
    	} else if (countL < 10 || countR < 10) {
    		if (y1 >= 0) {
    			leftT.set(y1);
    	    	rightT.set(y1);
    		} else {
    			leftT.set(0);
        		rightT.set(0);
    		}
    	}
  
    	
    }
}

