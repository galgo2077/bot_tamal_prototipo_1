// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.motorsids;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

//aca se pueden hacer de que los subsystemas para hacer mas legible el codigo como el chasis mecanismos y asi



public class shooter extends SubsystemBase {

  //inatke-shooter motors
  private final SparkMax shooter = new SparkMax(motorsids.outake, MotorType.kBrushless); //poner el id correcto

  //climber motors
  //private final SparkMax climber = new SparkMax(motorsids.climber, MotorType.kBrushless); //poner el id correcto

  public shooter() {
    // 2. CONFIGURACIÓN DE MOTORES (ajustar según sea necesario)
  }

    public void mecanism_logic_shooter_positive(Boolean outake) {
 
        shooter.set(outake ? 1 : 0.0);

    }

    public void mecanism_logic_shooter_negative(Boolean outake2) {

        shooter.set(outake2 ? -0.67 : 0.0);
    
        }

  public void stop() {// detiene el robot
    mecanism_logic_shooter_positive(false);
    mecanism_logic_shooter_negative(false);
  }
}