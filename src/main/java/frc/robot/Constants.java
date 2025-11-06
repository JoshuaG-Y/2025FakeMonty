// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class DrivetrainConstants{
    public static final int frontLeftID = -1;
    public static final int frontRightID = -1;
    public static final int backLeftID = -1;
    public static final int backRightID = -1;

    public static final int sL = 0;
    public static final int sR = 1;
  }

  public static class PIDConstants {
    public static final int montyDriveKFF = 0;
    public static final int montyDriveKP = 0;
    public static final int montyDriveKI = 0;
    public static final int montyDriveKD = 0;
  }

  public static class RollerConstants{
    public static final int rID = -1;
    public static final double maxForwardSpeed = .4; // percentage
    public static final double maxReverseSpeed = -.4; // also a percentage
  }
}
