package frc.robot.commands;
import java.util.function.BooleanSupplier;


import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.shooter_intake_climber;

public class mecanism_comand extends Command {

    private  shooter_intake_climber m_mecanism;
    private  BooleanSupplier m_intakeon, m_outtake, m_climberon, m_climberoff;
  

    

    public mecanism_comand(shooter_intake_climber mecanism, BooleanSupplier inatkeon, BooleanSupplier outtake, BooleanSupplier climberon, BooleanSupplier climberoff ) {
        
      //juntamos los datos del drivetrain con los del comando para que los reocnozca puede dar probelmas
        m_mecanism = mecanism;
        m_intakeon = inatkeon;
        m_outtake = outtake;
        m_climberon = climberon;
        m_climberoff = climberoff;

        addRequirements(m_mecanism);

  
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
        m_mecanism.mecanism_logic(

            m_intakeon.getAsBoolean(), 
            m_outtake.getAsBoolean(), 
            m_climberon.getAsBoolean(),
            m_climberoff.getAsBoolean()
        );

    //logica mecanismos

  }


  //cuando se acaba el comando
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    m_mecanism.stop();
    return false;
  }
}
