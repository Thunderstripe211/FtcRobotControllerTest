package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    private OpMode opMode;
    private Servo hood;
    private DcMotor leftShooterMotor;
    private DcMotor rightShooterMotor;

    private Gamepad currentGamepad = new Gamepad();
    private Gamepad previousGamepad = new Gamepad();

    private double hoodServoPosition = 0.0;
    private boolean isOn = false;

    public Shooter(LinearOpMode opmode) {
        opMode = opmode;

        hood = opMode.hardwareMap.get(Servo.class, "hood");
        leftShooterMotor = opMode.hardwareMap.get(DcMotor.class,"lshoot");
        rightShooterMotor = opMode.hardwareMap.get(DcMotor.class, "rshoot");
        leftShooterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightShooterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightShooterMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void updateTelemetry()
    {;
        opMode.telemetry.addData("Servo Position: ", hood.getPosition());
    }

    public void incrementUsingGamepad(){
        if (currentGamepad.right_bumper && !previousGamepad.right_bumper)
        {
            hoodServoPosition += 0.05;
        }
        else if (currentGamepad.left_bumper && !previousGamepad.left_bumper)
        {
            hoodServoPosition -= 0.05;
        }

        hoodServoPosition = Math.max(0, Math.min(hoodServoPosition, 0.35));

        hood.setPosition(hoodServoPosition);
    }

    public void updateGamepad(Gamepad gamepad){
        previousGamepad.copy(currentGamepad);
        currentGamepad.copy(gamepad);
    }

    //                         |
    // Shooter Motor controls  |
    //                        \ /

    public void toggleShooter(double rpm)
    {
        if (currentGamepad.y && !previousGamepad.y){
            isOn = !isOn;
        }

        if (isOn)
        {
            //rpm = 60, ticks per second = 28
            double targetSpeed = rpm * 28.0/60.0;
            ((DcMotorEx)leftShooterMotor).setVelocity(targetSpeed);
            ((DcMotorEx)rightShooterMotor).setVelocity(targetSpeed);
        }
        else
        {
            ((DcMotorEx)leftShooterMotor).setVelocity(0);
            ((DcMotorEx)rightShooterMotor).setVelocity(0);
        }
    }

}



































