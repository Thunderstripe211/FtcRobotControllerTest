package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
@Override
public abstract class InitializerTest extends LinearOpMode {

    private static DcMotor backLeft;
    private static DcMotor frontLeft;
    private static DcMotor backRight;
    private static DcMotor frontRight;
    private static DcMotor intakeFront;
    private static DcMotor intakeBack;

    public InitializerTest()
    {
        backLeft = hardwareMap.get(DcMotor.class, "leftBack");
        frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        backRight = hardwareMap.get(DcMotor.class, "rightBack");
        frontRight = hardwareMap.get(DcMotor.class, "rightFront");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        intakeFront = hardwareMap.get(DcMotor.class, "intakeFront");
        intakeBack = hardwareMap.get(DcMotor.class, "intakeBack");

        intakeBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public static DcMotor getBackLeftL()
    {
        return backLeft;
    }
    public static DcMotor getBackRight()
    {
        return backRight;
    }
    public static DcMotor getFrontLeft()
    {
        return frontLeft;
    }
    public static DcMotor getFrontRight()
    {
        return frontRight;
    }
    public static DcMotor getIntakeFront()
    {
        return intakeFront;
    }
    public static DcMotor getIntakeBack()
    {
        return intakeBack;
    }

}