// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.motorsids;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class drivetrain extends SubsystemBase {
  // Creates a new drivetrain with my motors

  //left motors
  private final SparkMax leftFrontMotor = new SparkMax(motorsids.frontleft, MotorType.kBrushed);
  private final SparkMax leftRearMotor = new SparkMax(motorsids.backleft, MotorType.kBrushed);

  //right motors
  private final SparkMax rightFrontMotor = new SparkMax(motorsids.frontright, MotorType.kBrushed);
  private final SparkMax rightRearMotor = new SparkMax(motorsids.backright, MotorType.kBrushed);

    public drivetrain() {
        // Invertir el lado derecho
        rightFrontMotor.setInverted(true);
        rightRearMotor.setInverted(true);
    }

    public void driveTank(double speed, double turn) {
        // Deadzone
        speed = Math.abs(speed) < 0.15 ? 0 : speed;
        turn = Math.abs(turn) < 0.15 ? 0 : turn;

        // Calcula velocidades
        double leftSpeed = MathUtil.clamp(speed + turn, -1.0, 1.0);
        double rightSpeed = MathUtil.clamp(speed - turn, -1.0, 1.0);

        // Setea TODOS los motores manualmente
        leftFrontMotor.set(leftSpeed);
        leftRearMotor.set(leftSpeed);
        
        rightFrontMotor.set(rightSpeed);
        rightRearMotor.set(rightSpeed);
    }

  public void stop() {
    driveTank(0, 0);
  }
}