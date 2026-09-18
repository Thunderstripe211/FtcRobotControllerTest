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
        intakeFront.setPower(0.5);
        intakeBack.setPower(0.5);
    }
    public void turnOnOutput()
    {
        intakeFront.setPower(-0.5);
        intakeBack.setPower(-0.5);
    }

    public void turnOffIntake()
    {
        intakeFront.setPower(0);
        intakeBack.setPower(0);

    }
    public DcMotor getIntakeFront()
    {
        return intakeFront;
    }
    public DcMotor getIntakeBack()
    {
        return intakeBack;
    }

}