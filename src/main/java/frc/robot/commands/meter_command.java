package frc.robot.commands;

import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake; // Asegúrate de que la clase empiece con Mayúscula en su archivo
import frc.robot.subsystems.shooter;

public class meter_command extends Command {

    private final intake m_subsystem_Intake;
    private final shooter m_subsystem_shooter;


    private final BooleanSupplier m_intakeActive, m_outake;

    public meter_command(intake subsystem, shooter subsystem2, BooleanSupplier intakeActive, BooleanSupplier outake) {

        this.m_subsystem_Intake = subsystem;
        this.m_subsystem_shooter = subsystem2;
        this.m_intakeActive = intakeActive;
        this.m_outake = outake;

        // Es vital registrar el subsistema para que dos comandos no lo usen a la vez
        addRequirements(m_subsystem_Intake, m_subsystem_shooter);
    }

    @Override
    public void execute() {
        // Le pasamos el valor booleano del botón a la lógica del subsistema
        m_subsystem_Intake.setIntakeBoolean(m_intakeActive.getAsBoolean());
        m_subsystem_shooter.mecanism_logic_shooter_negative(m_outake.getAsBoolean());
    }

    @Override
    public void end(boolean interrupted) {
        // Cuando el comando se detiene o se interrumpe, apagamos el motor
        m_subsystem_Intake.stop();
        m_subsystem_shooter.stop();
    }

    @Override
    public boolean isFinished() {
        // Normalmente devuelve false para que el comando corra mientras el botón esté presionado
        return false;
    }
}