// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.simulation.RoboRioSim;
import frc.robot.Constants.DrivetrainConstants;

/** Add your docs here. */
public class DrivetrainIOSim implements DrivetrainIO {
    TalonFX lM, rM;
    VoltageOut lV, rV;

    DifferentialDrivetrainSim sim;

    public DrivetrainIOSim() {
        lM = new TalonFX(DrivetrainConstants.sL);
        rM = new TalonFX(DrivetrainConstants.sR);

        lV = new VoltageOut(0.0);
        rV = new VoltageOut(0.0);

        sim = DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kDoubleFalcon500PerSide,
            KitbotGearing.k8p45,
            KitbotWheelSize.kSixInch,
            null
        );
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        sim.update(0.02);

        var lSS = lM.getSimState();
        lSS.setSupplyVoltage(RoboRioSim.getVInVoltage());

        var rSS = rM.getSimState();
        rSS.setSupplyVoltage(RoboRioSim.getVInVoltage());

        sim.setInputs(lSS.getMotorVoltage(), rSS.getMotorVoltage());
    
        inputs.leftOutputV = lSS.getMotorVoltage();
        inputs.rightOutputV = rSS.getMotorVoltage();

        inputs.leftVelocity = sim.getLeftVelocityMetersPerSecond();;
        inputs.rightVelocity = sim.getRightVelocityMetersPerSecond();;

        inputs.leftPosM = sim.getLeftPositionMeters();
        inputs.rightPosM = sim.getRightPositionMeters();
    }

    @Override
    public void arcadeDrive(double left, double right) {
        lM.setControl(lV.withOutput(left));
        rM.setControl(rV.withOutput(right));
    }

}
