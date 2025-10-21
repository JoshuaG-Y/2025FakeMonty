// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** Add your docs here. */
public class DrivetrainIOTalonSRX implements DrivetrainIO {
    TalonSRX fL; // each of the motors
    TalonSRX fR;
    TalonSRX bL;
    TalonSRX bR;

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {

    }

    @Override
    public void arcadeDrive(double left, double right) {

    }
}
