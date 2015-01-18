 
package org.usfirst.frc.team811.robot;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    Joystick joy1 = new Joystick(1);
    Joystick joy2 = new Joystick(2);
    
    Encoder enc1;
    Encoder enc2;
    Encoder enc3;
    Encoder enc4;
    
    Talon rearright;
    Talon rearleft;
    Talon frontright;
    Talon frontleft;
    
    
    public void robotInit() {
        rearright = new Talon(1);
        rearleft = new Talon(4);
        frontright = new Talon(2);
        frontleft = new Talon(3);
        
        enc1 = new Encoder (6, 5, false, CounterBase.EncodingType.k4X);//rear right
        //enc2 = new Encoder (7, 8, false, CounterBase.EncodingType.k4X);//front right
        //enc3 = new Encoder (9, 10, false, CounterBase.EncodingType.k4X);//front left
        //enc4 = new Encoder (11, 12, false, CounterBase.EncodingType.k4X);//rear left
        
        enc1.setDistancePerPulse(.001);
        //enc2.setDistancePerPulse(.001);
        //enc3.setDistancePerPulse(.001);
        //enc4.setDistancePerPulse(.001);
        enc1.reset();
        //enc2.reset();
        //enc3.reset();
        //enc4.reset();
        
        
    }

    public void autonomousPeriodic() {
       
       rearright.set(1);
       rearleft.set(1);
       frontright.set(1);
       frontleft.set(1);
        
    }

    public void teleopPeriodic() {
        rearright.set(joy1.getRawAxis(2));
        rearleft.set(joy1.getRawAxis(5));
        frontright.set(joy2.getRawAxis(2));
        frontleft.set(joy2.getRawAxis(5));
        //System.out.println(encoder.getRate());
        
        //if(joy1.getRawButton(1)) {
        //    enc1.reset();
        //    enc2.reset();
        //    enc3.reset();
        //    enc4.reset();
        //}
        
        //SmartDashboard.putNumber("Rearright talon", joy1.getRawAxis(2));
        //SmartDashboard.putNumber("Rearleft talon", joy1.getRawAxis(5));
        //SmartDashboard.putNumber("Frontright talon", joy2.getRawAxis(2));
        //SmartDashboard.putNumber("Frontleft talon", joy2.getRawAxis(5));
        
        SmartDashboard.putNumber("RearLeft Encoder Rate", enc1.getRate());
        //SmartDashboard.putNumber("RearRight Encoder Rate", enc2.getRate());
        //SmartDashboard.putNumber("FrontLeft Encoder Rate", enc3.getRate());
        //SmartDashboard.putNumber("FrontRight Encoder Rate", enc4.getRate());
        
        //SmartDashboard.putNumber("RearLeft Encoder", enc1.get());
        //SmartDashboard.putNumber("RearRight Encoder", enc2.get());
        //SmartDashboard.putNumber("FrontLeft Encoder", enc3.get());
        //SmartDashboard.putNumber("FrontRight Encoder", enc4.get());
    }
    
    public void testPeriodic() {
    
    }
    
    public void log() {
        SmartDashboard.putNumber("Rearright talon", joy1.getRawAxis(2));
        SmartDashboard.putNumber("Rearleft talon", joy1.getRawAxis(5));
        SmartDashboard.putNumber("Frontright talon", joy2.getRawAxis(2));
        SmartDashboard.putNumber("Frontleft talon", joy2.getRawAxis(5));
        
        SmartDashboard.putNumber("RearLeft Encoder Rate", enc1.getRate());
        SmartDashboard.putNumber("RearRight Encoder Rate", enc2.getRate());
        SmartDashboard.putNumber("FrontLeft Encoder Rate", enc3.getRate());
        SmartDashboard.putNumber("FrontRight Encoder Rate", enc4.getRate());
        
        SmartDashboard.putNumber("RearLeft Encoder", enc1.get());
        SmartDashboard.putNumber("RearRight Encoder", enc2.get());
        SmartDashboard.putNumber("FrontLeft Encoder", enc3.get());
        SmartDashboard.putNumber("FrontRight Encoder", enc4.get());
    }
    
    
    
}
