package org.firstinspires.ftc.teamcode.springtraining.examples;
// Imports
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Steve on 4/26/2018.
 */

@Autonomous (name = "Forward", group = "Spring Training")
public class ExampleAutonomousForward extends LinearOpMode
{
    DcMotor rightDrive,leftDrive; // Declares leftDrive and rightDrive

    @Override
    public void runOpMode() throws InterruptedException {


        leftDrive = hardwareMap.dcMotor.get("leftDrive"); // Tells phones that leftDrive exists
        rightDrive = hardwareMap.dcMotor.get("rightDrive"); // Tells phones that rightDrive exists
        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Sets the direction of movements for leftDrive to clockwise
        rightDrive.setDirection(DcMotor.Direction.REVERSE); // Sets the direction of movement for rightDrive to counter-clockwise


        waitForStart(); // Waits until you start the program

        rightDrive.setPower(1); // Sets rightDrive to full power
        leftDrive.setPower(1); // Sets leftDrive to full power

        wait(3000); // Waits 3 seconds until continuing

        rightDrive.setPower(0); // Stops rightDrive
        leftDrive.setPower(0); // Stops leftDrive
    }
}
