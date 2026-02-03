package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.shooter;
import frc.robot.subsystems.drivetrain;

public class autonomo_center extends Command {
    
    private final drivetrain m_drive;
    private final intake m_intake;
    private final shooter m_shooter;
    private final Timer m_timer = new Timer();

    public autonomo_center(drivetrain drive, intake intake, shooter shooter) {
        this.m_drive = drive;
        this.m_intake = intake;
        this.m_shooter = shooter;
        addRequirements(m_drive, m_intake, m_shooter);
    }

    @Override
    public void initialize() {
        m_timer.reset();
        m_timer.start();
        // Es mejor asegurar que los motores empiecen en 0
        m_drive.driveTank(0, 0);
    }

    @Override
    public void execute() {
        if (m_timer.get() < 3.0) {
            // CUIDADO: driveTank suele pedir (izquierdo, derecho)
            // Si pones (-0.5, 0), el robot va a girar en círculos.
            // Para ir recto hacia atrás sería:
            m_drive.driveTank(-0.5, -0.5); 
        } else {
            m_drive.driveTank(0, 0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.driveTank(0, 0);
        m_shooter.stop();
        m_timer.stop(); // Limpieza del timer
    }

    @Override
    public boolean isFinished() {
        // CAMBIO CLAVE: El comando termina oficialmente a los 3 segundos
        return m_timer.get() >= 3.0;
    }
}