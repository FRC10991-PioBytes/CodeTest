package frc.robot.subsystems;

import com.revrobotics.PersistMode; // These are all the libraries that will be used for the code
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;



public class DriveSubsystem extends SubsystemBase {

    private final SparkMax leftLeader; // Here are the motors
    private final SparkMax leftFollower;
    private final SparkMax rightLeader;
    private final SparkMax rightFollower;

    private final DifferentialDrive drive;

    public DriveSubsystem() {
        leftLeader = new SparkMax(LEFT_LEADER, MotorType.kBrushed); // You prepare the motor by saying who it is then what it is
        leftFollower = new SparkMax(LEFT_FOLLOWER, MotorType.kBrushed);
        rightLeader = new SparkMax(RIGHT_LEADER, MotorType.kBrushed);
        rightFollower = new SparkMax(RIGHT_FOLLOWER, MotorType.kBrushed);

        drive = new DifferentialDrive(leftLeader, rightLeader); // These motors are different from each other

        leftLeader.setCANTimeout(250); // This is to make sure it doesn't send constant checks that could fry the board
        leftFollower.setCANTimeout(250);
        rightLeader.setCANTimeout(250);
        rightFollower.setCANTimeout(250);

        SparkMaxConfig config = new SparkMaxConfig(); // Allows you to mess with the info of the sparkmax
        config.voltageCompensation(12); // For keeping checks on voltage
        config.smartCurrentLimit(DRIVE_MOTOR_CURRENT_LIMIT); // This limits the voltage
        config.idleMode(IdleMode.kBrake); // E-Brake

        config.follow(leftLeader); // Leader listens to configuration
        leftFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); // Follower does the same but with extra limits
        config.follow(rightLeader); // Ditto
        rightFollower.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); // Ditto

        config.disableFollowerMode(); // Keeps further code from previous
        rightLeader.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); // Configures

        config.inverted(true); // This inverts so that the motors won't follow each other to only spin in a circle
        leftLeader.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); // Configures

    }

    @Override
    public void periodic() {
    }

    public void driveArcade(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation); // Gets info from controller then starts to move
    }
    
}