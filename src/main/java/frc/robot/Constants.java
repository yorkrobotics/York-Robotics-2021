/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
	public static final class DriveConstants
	{
		public static final int MOTOR_LEFT_1_ID = 0;
		public static final int MOTOR_LEFT_2_ID = 1;
		public static final int MOTOR_RIGHT_1_ID = 2;
		public static final int MOTOR_RIGHT_2_ID = 3;
	}

	public static final class VictorConstants
	{
		public static final int FEEDER_MOTOR_ID = 1;
		public static final int TURRET_WHEEL_ID = 2;
	
	}
	public static final int INTAKE_WHEEL_ID = 4;
	public static final int ENCODER_PORT1 = 0;
	public static final int ENCODER_PORT2 = 1;
	public static final double whRevPerMotRev = 1;
	public static final double motRevPerCount = 1;	
	


 	public static final int CONTROLLER_1 = 0;
  	public static final int CONTROLLER_2 = 1;

  public static final boolean betaFeature = false;
	public static final boolean driveTestMode = false;
	public static final boolean liftTestMode = false;
	
	public static final int LEFT_X = 0;
	public static final int THROTTLE = 1;
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
	public static final int TURN = 4;
	public static final int RIGHT_Y = 5;
	public static final int MAX = 16;
	
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int LB = 5;
	public static final int RB = 6;
	
	public static final int INTAKE_POS_BUTTON = 1;
	public static final int SWITCH_POS_BUTTON = 2;
	public static final int SCALE_POS_BUTTON = 3;
	public static final int LIFT_RECENTER = 4;
	public static final int INTAKE_BUTTON = 0;
	public static final int SPIT_OUT_BUTTON = 0;
	
	public static final int encoderLeft = 0;
	public static final int encoderRight = 2;
	
	public static final double constkP = 2.4;
	public static final double constkI = 2;
	public static final double constkD = 0.24;
	
	public static final double joystickMultiplier = 3; //Robot rotation per time unit. //change back to 3.2
	
	public static final double wheelMultiplier = 4096;
	
	public static final double maxSpeed = 4; // m/s
	public static final double wheelCircumfrence = 0.47878; // meters
	public static final double revPer100ms = 1.0/wheelCircumfrence/10;
	public static final double maxRevPer100ms = maxSpeed/wheelCircumfrence/10; // revs
	public static final double maxForwardThrottleChange = 4.3; //units/s
	public static final double maxReverseThrottleChange = 6.8; //units/s
	
	public static final double liftHeightPerRev = 12.543; // cm/rev
	public static final double liftkP = 0.08;
	public static final double liftkI = 1;
	public static final double liftkD = 0.00008;
	public static final double liftMaxSpeed = 2;
	public static final double protectedLiftHeight = 140;
	public static final double liftHome = 0;
	public static final double liftSwitchHeight = 105;
	public static final double liftMaxHeight = 233.5;
	public static final double secondStageLanding = 134;
	
	public static final double recordTime = 15;
	
	public static final String SDcurAng = "DB/String 0";
	public static final String SDdesAng = "DB/String 1";
	public static final String SDAngErr = "DB/String 2";
	public static final String SDcurPos = "DB/String 3";
	public static final String SDdesPos = "DB/String 4";
	public static final String SDkP = "DB/String 5";
	public static final String SDkI = "DB/String 6";
	public static final String SDkD = "DB/String 7";
	public static final String SDLMotor = "DB/String 8";
	public static final String SDRMotor = "DB/String 9";
	
	public static final String switchFirst = "switchFirst";
	public static final String scaleFirst = "scaleFirst";
	public static final String leftStart = "L";
	public static final String middleStart = "M";
	public static final String rightStart = "R";
	public static final class ColorConstants
	{
		public static final Color blueTarg = ColorMatch.makeColor(0.143, 0.427, 0.429);
		public static final Color greenTarg = ColorMatch.makeColor(0.197, 0.561, 0.240);
		public static final Color redTarg = ColorMatch.makeColor(0.561, 0.232, 0.114);
		public static final Color yelTarg = ColorMatch.makeColor(0.361, 0.524, 0.113);
	}
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
