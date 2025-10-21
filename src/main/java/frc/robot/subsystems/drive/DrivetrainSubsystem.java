
package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.DrivetrainIO.DrivetrainIOInputs;

public class DrivetrainSubsystem extends SubsystemBase {
    
    private DrivetrainIO input;
    private DrivetrainIOInputs inputs;

    public DrivetrainSubsystem(DrivetrainIO _input){
        this.input = _input;
        inputs = new DrivetrainIOInputs();
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
