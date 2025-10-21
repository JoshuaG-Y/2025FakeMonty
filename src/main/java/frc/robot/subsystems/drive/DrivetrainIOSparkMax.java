// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

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
        cL.inverted(true);

        fL.configure(cL, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        bL.configure(cL, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        
    }

    @Override
    public void arcadeDrive(double left, double right) {
        
    }
    
}
