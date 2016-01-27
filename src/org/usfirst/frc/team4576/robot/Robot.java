
package org.usfirst.frc.team4576.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4576.robot.commands.AutoEnableCompressor;
import org.usfirst.frc.team4576.robot.commands.Autonomous;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.OnboardAccel;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;

public class Robot extends IterativeRobot {

	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final OnboardAccel accel = new OnboardAccel();
	public static OI oi;
	
	public static Joystick leftstick = new Joystick(0);
	public static final String VERSION = "1.0.0 TEST";

    Command autonomousCommand;
    Command teleopCommand;
    Command compressorStart;
    CameraServer server;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		System.out.println("RNR 2016" + VERSION + "is loading.....");
		oi = new OI();
		autonomousCommand = new Autonomous();
		teleopCommand = new DriveWithJoysticks();
		compressorStart = new AutoEnableCompressor();
		
		server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        //the camera name (ex "cam0") can be found through the roborio web interface
        //autonomousCommand = new ExampleCommand();
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleopCommand.start();
        compressorStart.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
