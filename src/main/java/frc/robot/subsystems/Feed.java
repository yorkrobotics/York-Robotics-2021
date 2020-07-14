/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import static frc.robot.Constants.VictorConstants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feed extends SubsystemBase {
 //VictorSPX feed = new VictorSPX(FEEDER_MOTOR_ID);

  /**
   * Creates a new Feed.
   */
  public Feed() {

  }

  public void set(double speed)
  {
    //feed.set(ControlMode.PercentOutput, speed);
  }
}
