package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.motorsids;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class intake extends SubsystemBase {
  
  // High-level motor controller definition
  private final SparkMax m_intakeMotor = new SparkMax(motorsids.inatke, MotorType.kBrushless);

  public intake() {
    // Factory default or specific configuration can go here
  }

  /**
   * Runs the intake at a specific speed.
   * @param speed Value from -1.0 to 1.0
   */
  public void setSpeed(double speed) {
    m_intakeMotor.set(speed);
  }

  /**
   * Toggles intake based on a boolean (full speed or stop).
   */
  public void setIntakeBoolean(boolean isOn) {
    m_intakeMotor.set(isOn ? 1.0 : 0.0);
  }

  public void stop() {
    m_intakeMotor.set(0.0);
  }
}