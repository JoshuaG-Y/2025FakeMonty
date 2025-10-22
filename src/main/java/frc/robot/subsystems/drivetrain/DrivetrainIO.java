package frc.robot.subsystems.drivetrain;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Pose2d;

public interface DrivetrainIO {
    @AutoLog
    public static class DrivetrainIOInputs{
        public Pose2d pose = new Pose2d();
        public double leftOutputV = 0.0;
        public double rightOutputV = 0.0;

        // Both in meters per second
        public double leftVelocity = 0.0;
        public double rightVelocity = 0.0;

        // Both in meters
        public double leftPosM = 0.0;
        public double rightPosM = 0.0;

        public double[] leftCurrentAmps = new double[0];
        public double[] rightCurrentAmps = new double[0];
    }

    // Function to update inputs for class above. This will be put in periodic() function
    public void updateInputs(DrivetrainIOInputs inputs);
    public void arcadeDrive(double left, double right);
}
