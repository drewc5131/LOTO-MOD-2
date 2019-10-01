package com.loto.lotomod.mob;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class OverlordMinionAttackGoal extends MeleeAttackGoal {
   private final EntityOverlordMinion minion;
   private int raiseArmTicks;

   public OverlordMinionAttackGoal(EntityOverlordMinion minionIn, double speedIn, boolean longMemoryIn) {
      super(minionIn, speedIn, longMemoryIn);
      this.minion = minionIn;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      super.startExecuting();
      this.raiseArmTicks = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      super.resetTask();
      this.minion.setAggroed(false);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
         this.minion.setAggroed(true);
      } else {
         this.minion.setAggroed(false);
      }

   }
}