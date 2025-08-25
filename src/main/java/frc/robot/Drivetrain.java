// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

/** Add your docs here. */
public class Drivetrain extends SubsystemBase {
    private final SparkMax leftLeader = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax leftFollower = new SparkMax(1, MotorType.kBrushed);
    private final SparkMax rightLeader = new SparkMax(3, MotorType.kBrushed);
    private final SparkMax rightFollower = new SparkMax(4, MotorType.kBrushed);
    private final DifferentialDrive drivetrain = new DifferentialDrive(leftLeader::set, rightLeader::set);

public Drivetrain() {

    System.out.println("in drivetrain constructor");

    SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
    leftFollowerConfig.follow(leftLeader.getDeviceId());

    SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();
    rightFollowerConfig.follow(rightLeader.getDeviceId());
    rightFollowerConfig.inverted(true);


    leftFollower.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    rightFollower.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

System.out.println("leaving drivetrain constructor");

}

public void drive(double xSpeed, double zRotation){
    drivetrain.arcadeDrive(xSpeed, zRotation);
}


}
