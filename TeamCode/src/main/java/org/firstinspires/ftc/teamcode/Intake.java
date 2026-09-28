package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Intake {

    private DcMotor intakeFront;
    private DcMotor intakeBack;

    private OpMode opMode;

    public Intake(LinearOpMode opmode)
    {
        opMode = opmode;

        intakeFront = opMode.hardwareMap.get(DcMotor.class, "intakeFront");
        intakeBack = opMode.hardwareMap.get(DcMotor.class, "intakeBack");

        intakeBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void turnOnInput()
    {
        //sets ball intake to half speed taking balls in
        intakeFront.setPower(0.5);
        intakeBack.setPower(0.5);
    }
    public void turnOnOutput()
    {
        //sets ball intake to negative half speed to eject balls though intake
        intakeFront.setPower(-0.5);
        intakeBack.setPower(-0.5);
    }
    public void turnOffIntake()
    {
        //sets ball intake power to zero
        intakeFront.setPower(0);
        intakeBack.setPower(0);

    }

}