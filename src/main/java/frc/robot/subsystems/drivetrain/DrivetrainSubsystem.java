
package frc.robot.subsystems.drivetrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drivetrain.DrivetrainIO.DrivetrainIOInputs;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private DrivetrainIO io;
    private DrivetrainIOInputs inputs;

    public DrivetrainSubsystem(DrivetrainIO io){
        this.io = io;
        inputs = new DrivetrainIOInputs();
    }

    // takes input from controller and sets the voltage for motors
    public Command setVoltagesArcadeCommand(double speed, double rotation){
        return new RunCommand(() -> {
            WheelSpeeds movement = DifferentialDrive.arcadeDriveIK(speed, rotation, false); //does calculations for us :)
            io.arcadeDrive(movement.left, movement.right);
        }, this);
    }

    @Override
    public void periodic(){
        // Runs once per scheduler run
        io.updateInputs(inputs);
    }

    @Override
    public void simulationPeriodic(){
        // Runs once per scheduler run DURING SIMULATION

    }
}
