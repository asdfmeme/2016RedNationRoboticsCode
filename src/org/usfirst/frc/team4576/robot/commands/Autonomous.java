package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;
//import org.usfirst.frc.team4576.robot.subsystems.Chassis;


import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends Command{

	@Override
	protected void initialize() {
				
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.chassis.setLeftRight(0, 0);
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}