package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Drivetrain {

    private DcMotor backLeft;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor frontRight;
    private DcMotor intakeFront;
    private DcMotor intakeBack;
    private IMU imu;
    private double facing;

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
        imu = opMode.hardwareMap.get(IMU.class, "imu");


        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.FORWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        // actually set the parameters
        imu.initialize(parameters);
    }
    public void drive(double x, double y, double rightX, double rT, double lT)
    {//1
        double rotX = (x * Math.cos(-facing) - y * Math.sin(-facing)) * 1.1;
        double rotY = x * Math.sin(-facing) + y * Math.cos(-facing);

        double maxSpeed = 0.5;
        double maxSpeedMultiplier;
        maxSpeedMultiplier = maxSpeed + ((-rT * (maxSpeed * 0.5)) + (lT * maxSpeed));

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rightX), 1);
        double frontLeftPower = (rotY + rotX + rightX) / denominator;
        double backLeftPower = (rotY - rotX + rightX) / denominator;
        double frontRightPower = (rotY - rotX - rightX) / denominator;
        double backRightPower = (rotY + rotX - rightX) / denominator;

        backLeft.setPower(backLeftPower * maxSpeedMultiplier);
        backRight.setPower(backRightPower * maxSpeedMultiplier);
        frontLeft.setPower(frontLeftPower * maxSpeedMultiplier);
        frontRight.setPower(frontRightPower* maxSpeedMultiplier);
    }

    public DcMotor getBackLeftL()
    {
        return backLeft;
    }
    public void updateIMU() {
        facing = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }
    public DcMotor getBackRight()
    {
        return backRight;
    }
    public void resetYaw()
    {
        imu.resetYaw();
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