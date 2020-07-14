/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.TurretWheels;

public class SpinFeed extends CommandBase {
  Feed feed = new Feed();
  TurretWheels turretWheels = new TurretWheels();
  double ltrig;

  public SpinFeed(Feed _feed, TurretWheels tWheels, double _ltrig) {
    feed = _feed;
    turretWheels = tWheels;
    ltrig = _ltrig;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(feed);
    addRequirements(turretWheels);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feed.set(ltrig);
    turretWheels.set(ltrig);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
