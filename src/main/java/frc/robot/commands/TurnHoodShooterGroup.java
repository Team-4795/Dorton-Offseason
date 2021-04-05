// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TurnHoodShooterGroup extends ParallelCommandGroup {
  /** Creates a new TurnHoodShooterGroup.
   * @param drivebase
   * @param shooter
   * @param indexer
  */
  public TurnHoodShooterGroup(Drivebase drivebase, double turnSpeed, 
  Shooter shooter, double shooterSpeed, double hoodAngle, 
  Indexer indexer, double indexerDelay, double indexerSpeed, double selectorSpeed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveToAngle(drivebase, turnSpeed).withTimeout(0.75),
      new ShooterRPM(shooter, shooterSpeed),
      new SetHoodAngle(shooter, hoodAngle),
      new IndexerWithDelay(indexerDelay, indexer, indexerSpeed, selectorSpeed)
    );
  }
}
