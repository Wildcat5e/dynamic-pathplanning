package frc.robot;

import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Robot extends TimedRobot {
    private final CommandXboxController xboxController = new CommandXboxController(0);

    private final Pigeon2 gyroscope = new Pigeon2(0, "rio");
    private final Drivetrain drivetrain = new Drivetrain();

    public Robot() {
        xboxController.a().whileTrue(Commands.runOnce(() -> System.out.println(debugInfo())));
    }

    @Override
    public void teleopPeriodic() {
        drivetrain.arcadeDrive(xboxController.getLeftY(), xboxController.getRightX());
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    String debugInfo() {
        return "Gyroscope Status:" +
               "\n  Rotation2d: " + gyroscope.getRotation2d() +
               "\n  AccumGyroX: " + gyroscope.getAccumGyroX() +
               "\n  AccumGyroY: " + gyroscope.getAccumGyroY() +
               "\n  Yaw       : " + gyroscope.getYaw().getValue();
    }
}
