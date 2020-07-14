/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorWheelMotor;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class SpinColorWheel extends CommandBase {
  /**
   * Creates a new SpinColorWheel.
   */
  //private ColorWheelMotor colorMotor  = new ColorWheelMotor();
  private TalonSRX colorMotor;
  //This is probably the problem--motorrev
  private double wheelRevolution;
  private boolean isFinished = false;
  final double kP = 0.5; 
  double speed = 1;
  double init;
  double fin;
  double setPoint = 3;
  private int ctr  = 0;

  private double tickToWheelRev = motRevPerCount * whRevPerMotRev;;

  public SpinColorWheel(TalonSRX m_colorMotor) {
      colorMotor = m_colorMotor;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    colorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    init = colorMotor.getSelectedSensorPosition();
    System.out.println("Init" + init);
    ctr = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    fin = colorMotor.getSelectedSensorPosition();
    System.out.println("Fin " + fin + "test: " + ctr);
    ctr += 1;
    double encoderPos = fin - init;
    System.out.println("EncoderPos" + encoderPos);
    double wheelRev = encoderPos * tickToWheelRev;
    System.out.println("Wheel Rev: " + wheelRev);
    double error = 3-wheelRev;
    speed = kP * error;
    if (speed < 0.02)
    {
      isFinished = true;
    }
    // colorMotor.set(ControlMode.PercentOutput, speed);
 
    /*
    double encoderPos = colorMotor.getSelectedSensorPosition() * tickToWheelRev;
    double error = setPoint - encoderPos;
    double speed = kP *A;
    if (error <= 0.2)
    {
      isFinished = true;
    }
    colorMotor.set(ControlMode.Position, speed);
    */
   /*
    motorRevolution = colorMotor.getPosition() * motRevPerCount;
    wheelRevolution = motorRevolution * whRevPerMotRev;
    if(wheelRevolution== 3)
    {
      colorMotor.set(0);
      isFinished = true;
    }
    */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }

}
