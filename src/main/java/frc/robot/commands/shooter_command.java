package frc.robot.commands;

import java.util.function.BooleanSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter; // Mantén la minúscula si así se llama tu archivo

public class shooter_command extends Command {

    private final shooter m_subsystem;
    private final BooleanSupplier m_buttonPressed, m_buttonPressed2;

    // El constructor debe tener el MISMO nombre que la clase
    public shooter_command(shooter subsystem, BooleanSupplier buttonPressed, BooleanSupplier buttonPressed2) {
        this.m_subsystem = subsystem;
        this.m_buttonPressed = buttonPressed;
        this.m_buttonPressed2 = buttonPressed2;

        // Avisamos al Scheduler que este comando usa el shooter
        addRequirements(m_subsystem);
    }

    @Override
    public void execute() {
        // Usamos el nombre del método que definiste en tu subsistema
        m_subsystem.mecanism_logic_shooter(m_buttonPressed.getAsBoolean(),
        m_buttonPressed2.getAsBoolean());
    }

    @Override
    public void end(boolean interrupted) {
        // Apagamos el motor al soltar el botón o si el comando se interrumpe
        m_subsystem.stop();
    }

    @Override
    public boolean isFinished() {
        // Retornamos false para que el comando siga activo mientras se presiona el botón
        return false;
    }
}