package frc.robot.commands;

import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake; // Asegúrate de que la clase empiece con Mayúscula en su archivo

public class intake_command extends Command {

    private final intake m_subsystem;
    private final BooleanSupplier m_intakeActive;

    public intake_command(intake subsystem, BooleanSupplier intakeActive) {
        m_subsystem = subsystem;
        m_intakeActive = intakeActive;

        // Es vital registrar el subsistema para que dos comandos no lo usen a la vez
        addRequirements(m_subsystem);
    }

    @Override
    public void execute() {
        // Le pasamos el valor booleano del botón a la lógica del subsistema
        m_subsystem.setIntakeBoolean(m_intakeActive.getAsBoolean());
    }

    @Override
    public void end(boolean interrupted) {
        // Cuando el comando se detiene o se interrumpe, apagamos el motor
        m_subsystem.stop();
    }

    @Override
    public boolean isFinished() {
        // Normalmente devuelve false para que el comando corra mientras el botón esté presionado
        return false;
    }
}