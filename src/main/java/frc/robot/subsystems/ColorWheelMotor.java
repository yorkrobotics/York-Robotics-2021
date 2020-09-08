/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//test
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import static frc.robot.Constants.*;
public class ColorWheelMotor extends SubsystemBase {
  TalonSRX greenWheel = new TalonSRX(4);
  //VictorSPX greenWheel = new VictorSPX(6);
  /**
   * Creates a new ColorWheelSpinner.
   */
  

  public ColorWheelMotor() {
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void set(double speed)
  {
    greenWheel.set(ControlMode.PercentOutput, speed);
  }
  public double getPosition()
  {
    return greenWheel.getSelectedSensorPosition();
  }

}
