package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
public class TestTeleop extends LinearOpMode {
    @Override
    public void runOpMode() {
        
        Drivetrain drivetrain = new Drivetrain(this);
        Intake intake = new Intake(this);
        Shooter shooter = new Shooter(this);

        waitForStart();

        // run until the end of the match (driver presses STOP)
        boolean skip = false;
        while (opModeIsActive())
        {
            //resets imu yaw when x is pressed
            if (gamepad1.x)
            {
                drivetrain.resetYaw();
            }

            //
            drivetrain.drive(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.right_trigger, gamepad1.left_trigger);

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

            if (gamepad1.y)
            {
                shooter.toggleShooter(3000.0);
            }

            drivetrain.updateIMU();

            shooter.incrementUsingGamepad();
            shooter.updateGamepad(gamepad1);

            shooter.updateTelemetry();
            telemetry.update();


        }
    }
}