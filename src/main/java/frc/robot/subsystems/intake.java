// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.motorsids;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

//aca se pueden hacer de que los subsystemas para hacer mas legible el codigo como el chasis mecanismos y asi



public class intake extends SubsystemBase {
  // Creates a new shooter_intake_climber  whit my motors

  //inatke-shooter motors
  private final SparkMax intake = new SparkMax(motorsids.inatke, MotorType.kBrushless); //poner el id correcto
  //climber motors
  //private final SparkMax climber = new SparkMax(motorsids.climber, MotorType.kBrushless); //poner el id correcto

  public intake() {
    // 2. CONFIGURACIÓN DE MOTORES (ajustar según sea necesario)
  }

  public void mecanism_logic_intake(boolean intakeon) {
    // Configura la velocidad de los motores para el control tipo tanque

    intake.set(intakeon ? 1 : 0.0);

  }

  public void stop() {// detiene el robot
    mecanism_logic_intake(false);
  }
}