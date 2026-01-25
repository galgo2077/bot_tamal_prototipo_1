// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.mecanism_comand;
import frc.robot.commands.Drive_tank_command;

import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.shooter_intake_climber;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


//bindings entre controles y comandos y sequencias

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final drivetrain driveTank = new drivetrain();
  private final shooter_intake_climber mecanismos = new shooter_intake_climber();

  //controls
  private final CommandXboxController driverController = new CommandXboxController(0);

  // call bindings
  public RobotContainer() {

    // Configure the command bindings

    driveTank.setDefaultCommand(//default command da prioridad a lo que hagas en el comando
      new Drive_tank_command(//run command repite accion no soloi es un push to do
          driveTank,//define que quieres que mueva
          () -> -driverController.getLeftY(),//funcion lambda para obtener valor del joystick para primera posicion que en este caso es speed
          () -> -driverController.getLeftX()//aca es turn lo define el orden que definiste en subsystems y command
      )
    );

    mecanismos.setDefaultCommand(//default command da prioridad a lo que hagas en el comando
      new mecanism_comand(//run command repite accion no soloi es un push to do
          mecanismos,//define que quieres que mueva

          //tenemos que ponerlo como boolenao para que funcione
          () -> driverController.a().getAsBoolean(),
          () -> driverController.b().getAsBoolean(),
          () -> driverController.y().getAsBoolean(),
          () -> driverController.x().getAsBoolean()
      )
  );


    configureBindings();
  }
  private void configureBindings() {

    //bindings son secuencias de acciones no nescesariamente por defecto

  //que cuando presione el boton haga la accion   //que mecnaismo  //que valores***********************************
    driverController.a().onTrue(new mecanism_comand(mecanismos, () -> true, () -> false, () -> false, () -> false));
    driverController.b().onTrue(new mecanism_comand(mecanismos, () -> false, () -> true, () -> false, () -> false));
    driverController.y().onTrue(new mecanism_comand(mecanismos, () -> false, () -> false, () -> true, () -> false));
    driverController.x().onTrue(new mecanism_comand(mecanismos, () -> false, () -> false, () -> false, () -> true));

    
  }




}
