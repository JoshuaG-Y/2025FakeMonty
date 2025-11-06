
package frc.robot.subsystems.drivetrain;

import java.util.function.DoubleSupplier;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drivetrain.DrivetrainIO.DrivetrainIOInputs;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private DrivetrainIO io;
    private DrivetrainIOInputs inputs;

    DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(new Rotation2d(), 0.0, 0.0);

    public DrivetrainSubsystem(DrivetrainIO io){
        this.io = io;
        inputs = new DrivetrainIOInputs();
    }

    // takes input from controller and sets the voltage for motors
    public Command setVoltagesArcadeCommand(DoubleSupplier speed, DoubleSupplier rotation){
        return new RunCommand(() -> {
            WheelSpeeds movement = DifferentialDrive.arcadeDriveIK(speed.getAsDouble(), rotation.getAsDouble(), false); //does calculations for us :)
            io.arcadeDrive(movement.left, movement.right);
        }, this);
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        odometry.update( //just a bunch of math stuff
        odometry.getPoseMeters().getRotation()
            .plus(Rotation2d.fromRadians((inputs.leftVelocity - inputs.rightVelocity)
                * 0.020 / Units.inchesToMeters(26))),
        inputs.leftPosM, inputs.rightPosM);
        Logger.recordOutput("Drivebase Pose", odometry.getPoseMeters());
    }

    @Override
    public void simulationPeriodic(){
        // Runs once per scheduler run DURING SIMULATION
    }
}
