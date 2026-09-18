package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    private OpMode opMode;
    private Servo hood;
    public Shooter(LinearOpMode opmode) {
        opMode = opmode;

        hood = opMode.hardwareMap.get(Servo.class, "hood");

    }

    public void updateTelemetry()
    {
        opMode.telemetry.addData("Servo Position: ", hood.getPosition());
    }

}