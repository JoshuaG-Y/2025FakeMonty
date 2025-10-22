// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import frc.robot.Constants.DriveConstants;

/** Add your docs here. */
public class DrivetrainIOSparkMax implements DrivetrainIO {
    SparkMax fL, fR, bL, bR;

    public DrivetrainIOSparkMax() { // initiate
        fL = new SparkMax(DriveConstants.frontLeftID, MotorType.kBrushless); // set the motors with their IDs
        fR = new SparkMax(DriveConstants.frontRightID, MotorType.kBrushless);
        bL = new SparkMax(DriveConstants.backLeftID, MotorType.kBrushless);
        bR = new SparkMax(DriveConstants.backRightID, MotorType.kBrushless);

        SparkMaxConfig cL = new SparkMaxConfig(); // left motor configs
        cL.idleMode(IdleMode.kCoast); // coast while idle
        cL.inverted(true); // invert the motors

        SparkMaxConfig cR = new SparkMaxConfig(); // right motor configs
        cL.idleMode(IdleMode.kCoast); // coast while idle
        cR.inverted(false); // do not invert the motors

        fL.configure(cL, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); // set each the motor configs on the motors
        bL.configure(cL, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        fR.configure(cR, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        bR.configure(cR, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        cL.follow(fL); // back motors follow the front ones
        cR.follow(fR); 
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) { // update what the volts of the motors are at
        inputs.leftOutputV = fL.getBusVoltage() * fL.getAppliedOutput();
        inputs.rightOutputV = fR.getBusVoltage() * fR.getAppliedOutput();
    }

    @Override
    public void arcadeDrive(double left, double right) { // set the volts for the motors
        fL.set(left);
        fR.set(right);
    }
    
}
