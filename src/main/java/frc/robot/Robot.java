// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {

  private final RobotContainer m_robotContainer;// instancia de robot container


  public Robot() {//usado para cuando se inicia el robot
    m_robotContainer = new RobotContainer();
  }


  @Override
  public void robotPeriodic() {// put thibngs like console logs here
    CommandScheduler.getInstance().run();//this is what makes the commands work ot has to be on all peridic
  }

  
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    CommandScheduler.getInstance().run();//this is what makes the commands work
  }

  @Override
  public void teleopInit() {}//cancel autonomous command here if needed

  //llamas a tu oi robot container
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();//this is what makes the commands work

  }
}
