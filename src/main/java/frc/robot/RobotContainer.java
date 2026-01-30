// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.intake_command;
import frc.robot.commands.shooter_command;
import frc.robot.commands.Drive_tank_command;
import frc.robot.commands.disparar_command;
import frc.robot.commands.meter_command;

import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


//bindings entre controles y comandos y sequencias

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final drivetrain driveTank = new drivetrain();
  private final shooter shooter = new shooter();
  private final intake intake = new intake();
  

  

  //controls
  private final CommandXboxController driverController = new CommandXboxController(0);
  private final CommandXboxController driverController2 = new CommandXboxController(1);

  // call bindings
  public RobotContainer() {

    // Configure the command bindings

    driveTank.setDefaultCommand(//default command da prioridad a lo que hagas en el comando
      new Drive_tank_command(//run command repite accion no soloi es un push to do
          driveTank,//define que quieres que mueva
          () -> -driverController.getLeftY(),//funcion lambda para obtener valor del joystick para primera posicion que en este caso es speed
          () -> -driverController.getRightX()//aca es turn lo define el orden que definiste en subsystems y command
      )
    );
    configureBindings();
    
  }
  private void configureBindings() {

    //bindings son secuencias de acciones no nescesariamente por defecto

  //que cuando presione el boton haga la accion   //que mecnaismo  //que valores***********************************
    driverController.a().whileTrue(new intake_command(intake, () -> true));
    driverController.b().whileTrue(new shooter_command(shooter, () -> true, () -> false));

    driverController.leftBumper().whileTrue(
    new disparar_command(intake, shooter, () -> driverController.getRightTriggerAxis(), () -> true));
    driverController.leftBumper().whileTrue(new meter_command(intake, shooter, () -> true, () -> true));

  }




}
