// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.motorsids;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

//aca se pueden hacer de que los subsystemas para hacer mas legible el codigo como el chasis mecanismos y asi



public class shooter_intake_climber extends SubsystemBase {
  // Creates a new shooter_intake_climber  whit my motors

  //inatke-shooter motors
  private final SparkMax intake = new SparkMax(motorsids.inatke, MotorType.kBrushless); //poner el id correcto
  private final SparkMax shooter = new SparkMax(motorsids.outake, MotorType.kBrushless); //poner el id correcto

  //climber motors
  private final SparkMax climber = new SparkMax(motorsids.climber, MotorType.kBrushless); //poner el id correcto

  public shooter_intake_climber() {
    // 2. CONFIGURACIÓN DE MOTORES (ajustar según sea necesario)
  }

  public void mecanism_logic(boolean intakeon, boolean outake, boolean climberon, boolean climberoff) {
    // Configura la velocidad de los motores para el control tipo tanque

    intake.set(intakeon ? 1.0 : 0.0);
    shooter.set(outake ? 1.0 : 0.0);

    // escalador son if porque son dos botones diferentes uno para arriba y el otro para abajo

    if (climberon) {
        climber.set(1.0);
    } else if (climberoff) {
        climber.set(-1.0);
    } else {
        climber.set(0.0);
    }
  }

  public void stop() {// detiene el robot
    mecanism_logic(false, false, false, false);
  }
}