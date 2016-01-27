package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoEnableCompressor extends Command {

	public AutoEnableCompressor()
	{
		requires(Robot.pneumatics);
	}
	@Override
	protected void initialize() {
		Robot.pneumatics.setAutoEnabled();
	}
	@Override
	protected void execute() {
		
	}
	protected boolean isFinished() {
		
		return true;
	}
	
	@Override
	protected void end() {
		
	}
	
	protected void interrupted() {
		
	}

}