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

/** Add your docs here. */
public class DrivetrainIOSparkMax implements DrivetrainIO {
    SparkMax fL;
    SparkMax fR;
    SparkMax bL;
    SparkMax bR;

    public DrivetrainIOSparkMax(int fl, int fr, int bl, int br) {
        fL = new SparkMax(fl, MotorType.kBrushless);
        fR = new SparkMax(fr, MotorType.kBrushless);
        bL = new SparkMax(br, MotorType.kBrushless);
        bR = new SparkMax(bl, MotorType.kBrushless);

        SparkMaxConfig cL = new SparkMaxConfig();
        cL.idleMode(IdleMode.kCoast);
        cL.inverted(true);

        SparkMaxConfig cR = new SparkMaxConfig();
        cL.idleMode(IdleMode.kCoast);
        cR.inverted(false);

        fL.configure(cL, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        bL.configure(cL, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        fR.configure(cR, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        bR.configure(cR, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        cL.follow(fL);
        cR.follow(fR);
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.leftOutputV = fL.getBusVoltage() * fL.getAppliedOutput();
        inputs.rightOutputV = fR.getBusVoltage() * fR.getAppliedOutput();
    }

    @Override
    public void arcadeDrive(double left, double right) {
        fL.set(left);
        fR.set(right);
    }
    
}
