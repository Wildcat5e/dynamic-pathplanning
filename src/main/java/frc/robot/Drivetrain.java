package frc.robot;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static com.revrobotics.spark.SparkBase.PersistMode.kPersistParameters;
import static com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters;
import static com.revrobotics.spark.SparkLowLevel.MotorType.kBrushed;

public class Drivetrain extends SubsystemBase {
    private final SparkMax leftLeader = new SparkMax(2, kBrushed);
    private final SparkMax leftFollower = new SparkMax(1, kBrushed);
    private final SparkMax rightLeader = new SparkMax(3, kBrushed);
    private final SparkMax rightFollower = new SparkMax(4, kBrushed);

    private final DifferentialDrive drivetrain = new DifferentialDrive(leftLeader::set, rightLeader::set);

    public Drivetrain() {
        leftLeader.configure(
                new SparkMaxConfig().inverted(false),
                kResetSafeParameters, kPersistParameters
        );
        leftFollower.configure(
                new SparkMaxConfig().inverted(false).follow(leftLeader.getDeviceId()),
                kResetSafeParameters, kPersistParameters
        );
        rightLeader.configure(
                new SparkMaxConfig().inverted(true),
                kResetSafeParameters, kPersistParameters
        );
        rightFollower.configure(
                new SparkMaxConfig().inverted(true).follow(rightLeader.getDeviceId()),
                kResetSafeParameters, kPersistParameters
        );
    }


    public void arcadeDrive(double xSpeed, double zRotation) {
        drivetrain.arcadeDrive(-xSpeed, zRotation);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drivetrain.tankDrive(-rightSpeed, -leftSpeed);
    }
}
