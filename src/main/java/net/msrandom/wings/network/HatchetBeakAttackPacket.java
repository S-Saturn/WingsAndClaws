package net.msrandom.wings.network;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.msrandom.wings.entity.monster.HatchetBeakEntity;

public class HatchetBeakAttackPacket implements INetworkPacket {
    @Override
    public void handle(PlayerEntity player) {
        Entity ridingEntity = player.getRidingEntity();
        if (ridingEntity instanceof HatchetBeakEntity) {
            player.world.getEntitiesWithinAABBExcludingEntity(ridingEntity, ridingEntity.getBoundingBox().offset(ridingEntity.getLookVec()))
                    .stream()
                    .reduce((e1, e2) -> e1.getDistanceSq(ridingEntity) > e2.getDistanceSq(ridingEntity) ? e2 : e1)
                    .ifPresent(((HatchetBeakEntity) ridingEntity)::performAttack);
        }
    }
}
