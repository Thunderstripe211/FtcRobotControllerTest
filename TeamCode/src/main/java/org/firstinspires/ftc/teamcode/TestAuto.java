package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.pedropathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;

@Autonomous
public class TestAuto extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();

    private final Pose controlPose = p.of(36, 60, 45);
    private final Pose startPose = p.of(24, 24, 0);
    private final Pose park = p.of(48, 48, 90);
    // poses are entered as p.of(x, y, heading in degrees);
    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }
    private Path park() {
        // *FOR CURRVES* return curve(startPose, controlPose, park).linear(startPose, park);
        return line(startPose, park).linear(startPose, park);
    }
}