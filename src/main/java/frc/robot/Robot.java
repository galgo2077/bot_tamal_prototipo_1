// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.autonomo_center;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {

  private final RobotContainer m_robotContainer;// instancia de robot container

  //esto crea my autonomo y una ventana para selecionarlo
  private static final String kDefaultAuto = "Default";//para que no se rompa outofthezone
  private static final String k_auto_center = "automo_center";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();


  @Override
  public void robotInit() {
      } 

           


  public Robot() {//usado para cuando se inicia el robot
    m_robotContainer = new RobotContainer();

    //esto lo pone en el dashboard y agrega la opcion
    m_chooser.setDefaultOption("Default", kDefaultAuto);
    m_chooser.addOption("center", k_auto_center);
    SmartDashboard.putData("Auto choices", m_chooser);


  }

    @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    switch (m_autoSelected) {
      case k_auto_center:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }

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
  public void teleopInit() {


    
  }//cancel autonomous command here if needed

  //llamas a tu oi robot container
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();//this is what makes the commands work
    CameraServer.startAutomaticCapture(0);

  }
}
