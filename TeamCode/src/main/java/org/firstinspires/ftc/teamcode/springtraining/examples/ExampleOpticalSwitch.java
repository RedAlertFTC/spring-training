package org.firstinspires.ftc.teamcode.springtraining.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

@Autonomous(name = "ExampleOpticalSwitch", group = "Example")
public class ExampleOpticalSwitch extends OpMode {

    DcMotor leftDrive, rightDrive;

    OpticalDistanceSensor opticalDistanceSensor;


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
        telemetry.addData("ODS Value", opticalDistanceSensor.getLightDetected());
    }
}
