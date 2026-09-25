package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

public class Drivetrain {

    private DcMotor backLeft;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor frontRight;
    private DcMotor intakeFront;
    private DcMotor intakeBack;
    public IMU imu;

    private OpMode opMode;

    public Drivetrain(LinearOpMode opmode)
    {
        opMode = opmode;
        backLeft = opMode.hardwareMap.get(DcMotor.class, "leftBack");
        frontLeft = opMode.hardwareMap.get(DcMotor.class, "leftFront");
        backRight = opMode.hardwareMap.get(DcMotor.class, "rightBack");
        frontRight = opMode.hardwareMap.get(DcMotor.class, "rightFront");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        intakeFront = opMode.hardwareMap.get(DcMotor.class, "intakeFront");
        intakeBack = opMode.hardwareMap.get(DcMotor.class, "intakeBack");

        intakeBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void drive(double x, double y, double rx, double rT, double lT)
    {
        double maxSpeed = 0.5;
        double maxSpeedMultiplier;
        maxSpeedMultiplier = maxSpeed + ((-rT * (maxSpeed * 0.5)) + (lT * maxSpeed));

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        backLeft.setPower(backLeftPower * maxSpeedMultiplier);
        backRight.setPower(backRightPower * maxSpeedMultiplier);
        frontLeft.setPower(frontLeftPower * maxSpeedMultiplier);
        frontRight.setPower(frontRightPower* maxSpeedMultiplier);
    }

    public DcMotor getBackLeftL()
    {
        return backLeft;
    }
    public DcMotor getBackRight()
    {
        return backRight;
    }
    public DcMotor getFrontLeft()
    {
        return frontLeft;
    }
    public DcMotor getFrontRight()
    {
        return frontRight;
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