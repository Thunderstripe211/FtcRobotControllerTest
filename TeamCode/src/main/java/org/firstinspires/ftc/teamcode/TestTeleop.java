package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
public class TestTeleop extends LinearOpMode {
    @Override
    public void runOpMode() {
        
        Drivetrain drivetrain = new Drivetrain(this);
        Intake intake = new Intake(this);

        //DcMotor backLeft = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor backLeft = drivetrain.getBackLeftL();
        DcMotor frontLeft = drivetrain.getFrontLeft();
        DcMotor backRight = drivetrain.getBackRight();
        DcMotor frontRight = drivetrain.getFrontRight();
        DcMotor intakeFront = intake.getIntakeFront();
        DcMotor intakeBack = intake.getIntakeBack();

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive())
        {
            drivetrain.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

            if (gamepad1.a)
            {
                intake.turnOnInput();
            }
            else if (gamepad1.b)
            {
                intake.turnOnOutput();
            }
            else
            {
                intake.turnOffIntake();
            }

        }
    }
}