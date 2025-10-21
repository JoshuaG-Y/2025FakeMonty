
package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.DrivetrainIO.DrivetrainIOInputs;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private DrivetrainIO input;
    private DrivetrainIOInputs inputs;

    public DrivetrainSubsystem(DrivetrainIO _input){
        this.input = _input;
        inputs = new DrivetrainIOInputs();
    }

    // takes input from controller and sets the voltage for motors
    public Command setVoltagesArcadeCommand(double speed, double rotation){
        return new RunCommand(() -> {
            WheelSpeeds movement = DifferentialDrive.arcadeDriveIK(speed, rotation, false); //does calculations for us :)
            input.arcadeDrive(movement.left, movement.right);
        }, this);
    }

    @Override
    public void periodic(){
        // Runs once per scheduler run
        input.updateInputs(inputs);
    }

    @Override
    public void simulationPeriodic(){
        // Runs once per scheduler run DURING SIMULATION

    }
}
