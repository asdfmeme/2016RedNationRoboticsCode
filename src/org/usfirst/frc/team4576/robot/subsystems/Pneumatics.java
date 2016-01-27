package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	private Compressor c;
	Solenoid s0 = new Solenoid(0);
    Solenoid s1 = new Solenoid(1);
	DoubleSolenoid s2 = new DoubleSolenoid(2,3);
	
	@Override
	protected void initDefaultCommand() {
		c = new Compressor();
		//c = new compressor;
		
	}
	public void setAutoEnabled() {
		
		c.setClosedLoopControl(true);
	}

	public void setShift(boolean closed) {
		s0.set(closed);
		
	}
	
	public void shift() {
		s0.set(!s0.get());

	}

}