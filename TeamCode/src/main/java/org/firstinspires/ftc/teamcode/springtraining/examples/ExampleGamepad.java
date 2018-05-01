package org.firstinspires.ftc.teamcode.springtraining.examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ExampleGamepad extends OpMode {

    DcMotor leftDrive, rightDrive;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            leftDrive.setPower(1);
            rightDrive.setPower(1);
        } else {
            leftDrive.setPower(0);
            rightDrive.setPower(0);
        }

        if (leftDrive.getPower() >= 0) {
            leftDrive.setPower(gamepad1.left_trigger);
        }
        if (rightDrive.getPower() >= 0) {
            rightDrive.setPower(gamepad1.right_trigger);
        }

    }
}
