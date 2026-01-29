// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.motorsids;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

//aca se pueden hacer de que los subsystemas para hacer mas legible el codigo como el chasis mecanismos y asi



public class drivetrain extends SubsystemBase {
  // Creates a new drivetrain  whit my motors

  //left motors
  private final SparkMax leftFrontMotor = new SparkMax(motorsids.frontleft, MotorType.kBrushed); //poner el id correcto
  private final SparkMax leftRearMotor = new SparkMax(motorsids.backleft, MotorType.kBrushed); //poner el id correcto

  //right motors
  private final SparkMax rightFrontMotor = new SparkMax(motorsids.frontright, MotorType.kBrushed); //poner el id correcto
  private final SparkMax rightRearMotor = new SparkMax(motorsids.backright,  MotorType.kBrushed); //poner el id correcto

  public drivetrain() {
    // 2. CONFIGURACIÓN DE MOTORES (ajustar según sea necesario)
    
  }

 public void driveTank(double speed, double turn ) {
    // Configura la velocidad de los motores para el control tipo tanque

    //speed = Math.abs(speed) < 0.05 ? 0 : speed;//deadzone
    speed = Math.abs(speed) < Math.abs(0.15) ? 0 : speed;
    turn = Math.abs(turn) < Math.abs(0.15) ? 0 : turn;

    double leftSpeed = MathUtil.clamp(speed + turn, -1.0, 1);//clamp limita el valor a 1, y -1
    double rightSpeed = MathUtil.clamp(speed - turn, -1.0, 1);//clamp limita el valor a 1 y -1


    leftFrontMotor.set(leftSpeed);
    leftRearMotor.set(leftSpeed);

    rightFrontMotor.set(rightSpeed);
    rightRearMotor.set(rightSpeed);
  }

  public void stop() {// detiene el robot
    driveTank(0, 0);
  }
}