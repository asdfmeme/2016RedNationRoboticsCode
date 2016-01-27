
package org.usfirst.frc.team4576.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4576.robot.Robot;

public class DriveWithJoysticks extends Command {
	
	public DriveWithJoysticks() {
		
	requires(Robot.chassis);
	requires(Robot.accel);
	requires(Robot.pneumatics);
	Robot.chassis.initTeleop();

}

protected void initialize() {
	
}

protected void execute() {
	Robot.chassis.normalDrive();
	Robot.accel.refresh();
	
	SmartDashboard.putNumber("accelx: ", Robot.accel.getX());
	SmartDashboard.putNumber("accelY: ", Robot.accel.getY());
	SmartDashboard.putNumber("accelZ: ", Robot.accel.getZ());
}

protected boolean isFinished() {
	return false;
}

protected void end() {
	
}

protected void interrupted() {
	
	}
}
