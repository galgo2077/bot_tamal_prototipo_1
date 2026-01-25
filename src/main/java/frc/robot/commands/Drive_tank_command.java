package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain;

public class Drive_tank_command extends Command {

    private  drivetrain m_driveSubsystem;
    private  DoubleSupplier m_speed, m_turn;
  

    

    public Drive_tank_command(drivetrain driveSubsystem, DoubleSupplier speed, DoubleSupplier turn ) {
        
      //juntamos los datos del drivetrain con los del comando para que los reocnozca puede dar probelmas
        m_driveSubsystem = driveSubsystem;
        m_speed = speed;
        m_turn = turn;
        addRequirements(m_driveSubsystem);

  
    }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


  }

  //pasa de todo
  @Override
  public void execute() {

    //logica chasis

    // Llama a la lógica que creaste en tu subsistema
        m_driveSubsystem.driveTank(

            m_speed.getAsDouble(), 
            m_turn.getAsDouble()
        );

    //logica mecanismos

  }


  //cuando se acaba el comando
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    m_driveSubsystem.stop();
    return false;
  }
}
