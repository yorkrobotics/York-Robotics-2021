/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.*;
import frc.robot.subsystems.ColorWheelMotor;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.DriverStation;



public class AlignToColor extends CommandBase {
  //Subsystem
  private final ColorWheelMotor colorMotor;
  //Color variables
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch colorMatcher = new ColorMatch();
  private Boolean targetDetected;
  private Color lookColor;


  //GameData

  /**
   * Creates a new SpinColorWheel.
   */
  public AlignToColor(final ColorWheelMotor m_colorMotor) {
    colorMotor = m_colorMotor;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(colorMotor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    colorMotor.set(1);
    colorMatcher.addColorMatch(ColorConstants.blueTarg);
    colorMatcher.addColorMatch(ColorConstants.greenTarg);
    colorMatcher.addColorMatch(ColorConstants.redTarg);
    colorMatcher.addColorMatch(ColorConstants.yelTarg);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    final Color detectedColor = colorSensor.getColor();
    final ColorMatchResult matchedColor = colorMatcher.matchClosestColor(detectedColor);
    //Getting Color From FMS
    
    if (gameData.length()>0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' : lookColor = ColorConstants.redTarg;
        break;
        case 'R' : lookColor = ColorConstants.blueTarg;
        break;
        case 'Y' : lookColor = ColorConstants.greenTarg;
        break;
        case 'G' : lookColor = ColorConstants.yelTarg;
        break; 
      }
    }
    //When color is matched, stop motor
    if (matchedColor.color == lookColor)
    {
      colorMotor.set(0);
      targetDetected = true;
    }
    else
    {
      targetDetected = false;
    }


    SmartDashboard.putNumber("red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.red);
    SmartDashboard.putNumber("Blue", detectedColor.red);
    SmartDashboard.putNumber("confidence", matchedColor.confidence);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return targetDetected;
  }
}
