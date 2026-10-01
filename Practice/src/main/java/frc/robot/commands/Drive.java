package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.DriveSubsystem;

public class Drive extends Command {

    DriveSubsystem driveSubsystem; // Gets information from the driveSubsystem
    CommandJoystick controller; // Same with how the controller works

    public Drive(DriveSubsystem driveSystem, CommandJoystick driverController) {
        addRequirements(driveSystem); // Creates requirements so if nothing is there then nothing will happen
        driveSubsystem = driveSystem; // Makes it so your not changing the original variable
        controller = driverController;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        driveSubsystem.driveArcade( // Takes controller inputs and changes it into something the subsystem understands and limits valies
            -MathUtil.applyDeadband(controller.getRawAxis(OperatorConstants.leftStickY), kDriveDeadband) * DRIVE_SCALING,
            -MathUtil.applyDeadband(controller.getRawAxis(OperatorConstants.rightStickX), kDriveDeadband) * ROTATION_SCALING);
    }

    @Override
    public void end(boolean interrupted) { // If something doesn't turn out it stops everything in its tracks
        driveSubsystem.driveArcade(0, 0);
    }

    @Override
    public boolean isFinished() { // Says done when it's done
        return false;
    }

}
