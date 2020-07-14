/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
public class DriveRunCommand extends RunCommand {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  DriveTrain drivetrain;
  /**
   * Creates a new VictorDrive.
   * @param victorMotor
   * @param speed
   */
  public DriveRunCommand(DriveTrain _drivetrain, XboxController controller) {
    super(() -> _drivetrain.setDriveSpeed(controller.getTriggerAxis(GenericHID.Hand.kLeft), 
                                          controller.getTriggerAxis(GenericHID.Hand.kRight),
                                          controller.getRawAxis(Constants.LEFT_X)), _drivetrain);
    drivetrain = _drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }
}