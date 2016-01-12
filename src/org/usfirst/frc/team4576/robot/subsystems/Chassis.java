package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem{
	
	boolean manualOverride = false;
	
	CANTalon tsrxL = new CANTalon(0);
	CANTalon tsrxR = new CANTalon(1);
	CANTalon tsrxL2 = new CANTalon(2);
	CANTalon tsrxR2 = new CANTalon(3);
	//CANTalon tsrx__ = new CANTalon(4);
	//CANTalon tsrx__ = new CANTalon(5);
	
	RobotDrive drive = new RobotDrive(tsrxL, tsrxL2, tsrxR, tsrxR2);
	
	public static final int FORWARD_AXIS = 1;
	public static final int TURN_AXIS = 4;
	PowerDistributionPanel pdp = new PowerDistributionPanel();

	public void setLeftRight(double left, double right)
	{
		tsrxR.set(right);
		tsrxR2.set(right);
		tsrxL.set(left);
		tsrxL2.set(left);
		//tsrx__.set(right);
		//tsrx__.set(left);
	}
	public void disable()
	{
		tsrxR.disable();
		tsrxR2.disable();
		tsrxL.disable();
		tsrxL2.disable();
		//tsrx__.disable();
		//tsrx__.disable();
	}
	public void initAuto()
	{
		drive.setSafetyEnabled(false);
	}
	public void initTeleop()
	{
		drive.setSafetyEnabled(true);
	}
	public void normalDrive()
	{
		drive.arcadeDrive(Robot.leftstick.getRawAxis(FORWARD_AXIS), Robot.leftstick.getRawAxis(TURN_AXIS));
	}


	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
