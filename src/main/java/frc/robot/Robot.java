package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;


public class Robot extends TimedRobot {
    private final XboxController xboxController = new XboxController(0);

    Drivetrain drivetrain = new Drivetrain();

    @Override
    public void teleopPeriodic() {
        drivetrain.arcadeDrive(xboxController.getLeftY(), xboxController.getRightX());
        //drivetrain.tankDrive(xboxController.getLeftY(), xboxController.getRightY());
    }
}
