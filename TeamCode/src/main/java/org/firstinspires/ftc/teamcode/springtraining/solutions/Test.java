package org.firstinspires.ftc.teamcode.springtraining.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by zacha on 3/11/2018.
 */

@TeleOp(name = "Test", group = "Spring Training")
public class Test extends OpMode {

    DcMotor leftDrive, rightDrive;

    float powerLeft, powerRight, throttleDrive, directionDrive;


    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }


    @Override
    public void loop() {
        throttleDrive = -gamepad1.left_stick_y / 5;
        directionDrive = -gamepad1.right_stick_x / 10;

        powerLeft = throttleDrive + directionDrive;
        powerRight = throttleDrive - directionDrive;

        leftDrive.setPower(powerLeft);
        rightDrive.setPower(powerRight);
    }
}
