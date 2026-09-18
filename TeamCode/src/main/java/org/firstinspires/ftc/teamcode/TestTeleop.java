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
        Shooter shooter = new Shooter(this);

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive())
        {
            drivetrain.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

            if (gamepad1.a && !gamepad1.b)
            {
                intake.turnOnInput();
            }
            else if (gamepad1.b && !gamepad1.a)
            {
                intake.turnOnOutput();
            }
            else
            {
                intake.turnOffIntake();
            }

            boolean skip = false;
            if (gamepad1.right_bumper && skip == false)
            {
                shooter.increment();
                skip = true;
            }
            else if (gamepad1.left_bumper && skip == false)
            {
                shooter.decrement();
                skip = true;
            }
            else if (!gamepad1.left_bumper && !gamepad1.right_bumper)
            {
                skip = false;
            }

            shooter.updateTelemetry();
            telemetry.update();


        }
    }
}