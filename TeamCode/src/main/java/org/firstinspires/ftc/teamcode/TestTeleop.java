package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
public class TestTeleop extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "rightBack");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "rightFront");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor intakeFront = hardwareMap.get(DcMotor.class, "intakeFront");
        DcMotor intakeBack = hardwareMap.get(DcMotor.class, "intakeBack");

        intakeBack.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive())
        {
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            backLeft.setPower(backLeftPower);
            backRight.setPower(backRightPower);
            frontLeft.setPower(frontLeftPower);
            frontRight.setPower(frontRightPower);

            if (gamepad1.a)
            {
                intakeFront.setPower(0.5);
                intakeBack.setPower(0.5);
            }
            else if (gamepad1.b)
            {
                intakeFront.setPower(-0.5);
                intakeBack.setPower(-0.5);
            }
            else
            {
                intakeFront.setPower(0);
                intakeBack.setPower(0);
            }

        }
    }
}
