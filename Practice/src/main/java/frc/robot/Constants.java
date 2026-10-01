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
  public static final class DriveConstants { // Big area that contains all the constants in which stay the same at all times
    public static final int LEFT_LEADER = 3;
    public static final int LEFT_FOLLOWER = 4;
    public static final int RIGHT_LEADER = 2;
    public static final int RIGHT_FOLLOWER = 1;

    public static final int DRIVE_MOTOR_CURRENT_LIMIT = 60;
  }

  public static final class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;

    public static final int leftStickY = 1;
    public static final int leftStickX = 0;
    public static final int rightStickY = 5;
    public static final int rightStickX = 4;
    public static final int leftTrigger = 2;
    public static final int rightTrigger = 3;
    public static final int buttonA = 1;
    public static final int buttonB = 2;
    public static final int buttonX = 3;
    public static final int buttonY = 4;
    public static final int bumperLeft = 5;
    public static final int bumperRight = 6;

    public static final double kDriveDeadband = 0.1;

    public static final double DRIVE_SCALING = 0.7;
    public static final double ROTATION_SCALING = 0.8;
  }

}
