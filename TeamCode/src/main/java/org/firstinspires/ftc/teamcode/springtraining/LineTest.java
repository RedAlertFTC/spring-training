package org.firstinspires.ftc.teamcode.springtraining;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import static java.lang.Thread.sleep;
import static org.firstinspires.ftc.teamcode.springtraining.LineTest.direction.left;
import static org.firstinspires.ftc.teamcode.springtraining.LineTest.direction.right;

@Autonomous(name = "LineTest", group = "Spring Training")
public class LineTest extends OpMode {
    
    DcMotor rightDrive,leftDrive;

    OpticalDistanceSensor opticalDistanceSensor;

    double blackThreshold = 0.07, whiteThreshold = 0.07;

    direction movementDirection = left;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        opticalDistanceSensor = hardwareMap.opticalDistanceSensor.get("opticalDistanceSensor");
        opticalDistanceSensor.enableLed(true);
    }

    @Override
    public void loop() {

        double colorValue;
        colorValue = opticalDistanceSensor.getLightDetected();

        switch (movementDirection) {
            case left:
                if (colorValue > blackThreshold) {
                    rightDrive.setPower(0.15);
                    leftDrive.setPower(0);
                    movementDirection = right;
                }
            case right:
                 if (colorValue < whiteThreshold) {
                     rightDrive.setPower(0);
                     leftDrive.setPower(0.15);
                     movementDirection = left;
                 }
            }
    }

    enum direction {left, right}
}
