/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.AlignToColor;
import frc.robot.commands.SpinFeed;
import frc.robot.subsystems.ColorWheelMotor;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.TurretWheels;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DriveRunCommand;
import frc.robot.commands.SpinColorWheel;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ColorWheelMotor colorWheelMotor = new ColorWheelMotor(); 
  private final DriveTrain driveTrain = new DriveTrain(); 
  private final Feed feed = new Feed();
  private final TurretWheels tWheel = new TurretWheels();
  TalonSRX colorTalon = new TalonSRX(4);
  
  //Testing Pneumatics
  DoubleSolenoid testSolenoid = new DoubleSolenoid(2,5);


  //private final VictorDrive m_victorDrive = new VictorDrive(m_victorMotor);

  public static XboxController controller_1 = new XboxController(Constants.CONTROLLER_1);
  public XboxController controller_2 = new XboxController(Constants.CONTROLLER_2);

  // private int dpad;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */

  public RobotContainer() {
    // Configure the button bindings

    configureButtonBindings();
    //dpad = controller_1.getPOV(0);
   // System.out.println(dpad); 
      
    //m_victorMotor.setVictorSpeed(controller_1.getRawAxis(Constants.LEFT_TRIGGER));
   // m_victorMotor.setVictorSpeed(-1* controller_1.getRawAxis(Constants.RIGHT_TRIGGER));
 
    //Set default commands:
     //driveTrain.setDefaultCommand(new DriveRunCommand(driveTrain, controller_1));
    //feed.setDefaultCommand(new RunCommand(() -> feed.set(controller_1.getRawAxis(Constants.RIGHT_TRIGGER)), feed));
    //tWheel.setDefaultCommand(new RunCommand(() -> tWheel.set(1), tWheel));


  
    
   // RunCommand cmd = 
    //  new RunCommand(() -> m_victorMotor.setVictorSpeed(controller_1.getY(GenericHID.Hand.kLeft)), m_victorMotor);
  //  m_victorMotor.setDefaultCommand(cmd);
  //m_victorMotor.setDefaultCommand(new VictorDrive(m_victorMotor, controller_1));
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   
    // new JoystickButton(controller_1, Button.kBumperLeft.value)
    //  .whenPressed(new SpinColorWheel(colorTalon));
//    new JoystickButton(controller_1, Button.kBumperRight.value)
//     .whenPressed(new AlignToColor(colorWheelMotor));
    new JoystickButton(controller_1, Button.kX.value)
    .whenPressed(()->{testSolenoid.set(kForward);});
    new JoystickButton(controller_1, Button.kA.value)
    .whenPressed(()->{testSolenoid.set(kReverse);});
/*
    new JoystickButton(controller_1, Button.kA.value)
    .whenPressed(new SpinFeed(feed, tWheel, .9))
    .whenReleased(new SpinFeed(feed, tWheel, 0));
*/
    new JoystickButton(controller_1, Button.kB.value)
    .whenPressed(new SpinFeed(feed, tWheel, .8))
    .whenReleased(new SpinFeed(feed, tWheel, 0));
/*
    new JoystickButton(controller_1, Button.kY.value)
    .whenPressed(new SpinFeed(feed, tWheel, .7))
    .whenReleased(new SpinFeed(feed, tWheel, 0));
    new JoystickButton(controller_1, Button.kX.value)
    .whenPressed(new SpinFeed(feed, tWheel, .85))
    .whenReleased(new SpinFeed(feed, tWheel, 0));
    new JoystickButton(controller_1, Button.kBumperLeft.value)
    .whenPressed(new SpinFeed(feed, tWheel, 1))
    .whenReleased(new SpinFeed(feed, tWheel, 0));
    new JoystickButton(controller_1, Button.kBumperRight.value)
    .whenPressed(new SpinFeed(feed, tWheel, .95))
    .whenReleased(new SpinFeed(feed, tWheel, 0));  
   */

  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
 /* public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
*/
  /*
  public double getCont1RawAxis(int axis)
  {
    return controller_1.getRawAxis(axis);
  }
  */

}
    