// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Constants.DriveConstants;

/** Add your docs here. */
public class DrivetrainIOTalonSRX implements DrivetrainIO {
    TalonSRX fL; // each of the motors
    TalonSRX fR;
    TalonSRX bL;
    TalonSRX bR;

    public DrivetrainIOTalonSRX() { //initialize
        fL = new TalonSRX(DriveConstants.frontLeftID); //set the motors with their IDs
        fR = new TalonSRX(DriveConstants.frontRightID);
        bL = new TalonSRX(DriveConstants.backLeftID);
        bR = new TalonSRX(DriveConstants.backRightID);

        fL.setInverted(true); //invert the left motors
        bL.setInverted(true);

        bL.follow(fL); //back motors follow front motors
        bR.follow(fR);
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.leftOutputV = fL.getMotorOutputVoltage();
        inputs.rightOutputV = fR.getMotorOutputVoltage();
    }

    @Override
    public void arcadeDrive(double left, double right) {
        fL.set(TalonSRXControlMode.PercentOutput, left);
        fR.set(TalonSRXControlMode.PercentOutput, right);
    }
}
