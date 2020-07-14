/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrainCopy extends SubsystemBase {
  //private final SpeedControllerGroup leftMotors = new SpeedControllerGroup(new CANSparkMax(1, MotorType.kBrushless), new CANSparkMax(2, MotorType.kBrushless));
 // private final SpeedControllerGroup rightMotors = new SpeedControllerGroup(new CANSparkMax(3, MotorType.kBrushless), new CANSparkMax(4, MotorType.kBrushless));
 //private final DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  VictorSPX leftMotors = new VictorSPX(6);
  TalonSRX rightMotors = new TalonSRX(4);
  
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrainCopy() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setDriveSpeed(double fwdCmd, double rvsCmd, double turnCmd)
  {

  //  if (Math.abs(turnCmd) <0.13)
  //  {
  //    turnCmd = 0;
  //  }
    double speedScale = 0.67;
    double turnScale = 0.33;
    double leftWheelOrder = (fwdCmd - rvsCmd) * speedScale + 
                            turnCmd * turnScale;
    double rightWheelOrder = (fwdCmd - rvsCmd) * speedScale - 
                             turnCmd * turnScale;
    
    //Use this next line to use differential drive. Comment everything else when you use this
    //drive.arcadeDrive(fwdCmd-rvsCmd, turnCmd);
  
  
    //rightMotors.set(ControlMode.PercentOutput,rightWheelOrder);
   // leftMotors.set(ControlMode.PercentOutput, leftWheelOrder);
  }


}
