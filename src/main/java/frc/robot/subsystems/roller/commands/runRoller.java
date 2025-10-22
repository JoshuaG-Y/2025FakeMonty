package frc.robot.subsystems.roller.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.roller.Roller;

public class runRoller extends Command {
    
    Roller roller;
    double volts;

    public runRoller(Roller roller, double volts){
        this.roller = roller;
        this.volts = volts;
    }

    @Override
    public void execute(){
        roller.setVoltage(volts);
    }

    @Override
    public void end(boolean interrupted){
        roller.setVoltage(0.0);
    }

}
